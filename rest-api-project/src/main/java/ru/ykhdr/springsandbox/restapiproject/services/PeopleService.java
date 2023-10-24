package ru.ykhdr.springsandbox.restapiproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ykhdr.springsandbox.restapiproject.models.Person;
import ru.ykhdr.springsandbox.restapiproject.repositories.PeopleRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public List<Person> findAll(){
        return peopleRepository.findAll();
    }

    public Person findOne(int id){
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }
}
