package ru.ykhdr.securityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ykhdr.securityproject.models.Person;
import ru.ykhdr.securityproject.repositories.PeopleRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public Optional<Person> findPersonByUsername(String username){
        return peopleRepository.findByUsername(username);
    }
}
