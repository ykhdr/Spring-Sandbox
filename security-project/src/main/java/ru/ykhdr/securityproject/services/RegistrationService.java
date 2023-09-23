package ru.ykhdr.securityproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ykhdr.securityproject.models.Person;
import ru.ykhdr.securityproject.repositories.PeopleRepository;

@RequiredArgsConstructor
@Service
public class RegistrationService {
    private final PeopleRepository peopleRepository;

    @Transactional
    public void register(Person person){
        peopleRepository.save(person);
    }
}
