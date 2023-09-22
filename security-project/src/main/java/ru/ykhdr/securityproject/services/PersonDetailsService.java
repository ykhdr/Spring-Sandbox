package ru.ykhdr.securityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.ykhdr.securityproject.models.Person;
import ru.ykhdr.securityproject.repositories.PeopleRepository;
import ru.ykhdr.securityproject.security.PersonDetails;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PersonDetailsService implements UserDetailsService {

    private final PeopleRepository peopleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person = peopleRepository.findByUsername(username);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return new PersonDetails(person.get());
    }
}
