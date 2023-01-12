package ru.slorimer.spring.util;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.slorimer.spring.models.Person;
import ru.slorimer.spring.service.PersonDetailsService;

@Component
public class PersonValidator implements Validator {

    private PersonDetailsService personDetailsService;

    public PersonValidator(PersonDetailsService personDetailsService) {
        this.personDetailsService = personDetailsService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Person person = (Person)o;

        try {
            personDetailsService.loadUserByUsername(person.getName());
        }catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("name", "", "user with this name already exists");
    }
}
