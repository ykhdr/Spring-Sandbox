package ru.ykhdr.springsandbox.restapiproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ykhdr.springsandbox.restapiproject.models.Person;
import ru.ykhdr.springsandbox.restapiproject.repositories.PeopleRepository;
import ru.ykhdr.springsandbox.restapiproject.exceptions.PersonNotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElseThrow(PersonNotFoundException::new);

    }

    @Transactional
    public void save(Person person){
        enrichPerson(person);
        peopleRepository.save(person);
    }

    private void enrichPerson(Person person) {
        person.setCreated_at(LocalDateTime.now());
        person.setUpdated_at(LocalDateTime.now());
        person.setCreated_who("ADMIN");
    }
}
