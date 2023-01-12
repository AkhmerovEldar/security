package ru.slorimer.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.slorimer.spring.models.Person;
import ru.slorimer.spring.service.RegistrationService;
import ru.slorimer.spring.util.PersonValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class authController {

    private PersonValidator personValidator;
    private RegistrationService registrationService;

    public authController(PersonValidator personValidator, RegistrationService registrationService) {
        this.personValidator = personValidator;
        this.registrationService = registrationService;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("person")Person person){
        return "auth/registration";
    }
    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("person") @Valid Person person,
                                      BindingResult bindingResult){

        personValidator.validate(person, bindingResult);
        if (bindingResult.hasErrors())
            return "/auth/registration";

        registrationService.save(person);
        return "redirect:/auth/login";
    }
}
