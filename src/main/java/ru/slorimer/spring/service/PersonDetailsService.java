package ru.slorimer.spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.slorimer.spring.Repositories.PeopleRepository;
import ru.slorimer.spring.models.Person;
import ru.slorimer.spring.security.PersonDetails;


import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private PeopleRepository peopleRepository;

    public PersonDetailsService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         Optional<Person> person = peopleRepository.findByName(username);
         if (person.isEmpty()){
             throw new UsernameNotFoundException("user not found");
         }
         return new PersonDetails(person.get());
    }
}
