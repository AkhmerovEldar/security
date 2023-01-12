package ru.slorimer.spring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.slorimer.spring.Repositories.PeopleRepository;
import ru.slorimer.spring.models.Person;

@Service
public class RegistrationService {

    private PeopleRepository peopleRepository;

    public RegistrationService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Transactional
    public void save(Person person){
        peopleRepository.save(person);
    }
}
