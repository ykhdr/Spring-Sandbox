package ru.ykhdr.springsandbox.restapiproject.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ykhdr.springsandbox.restapiproject.models.Person;
import ru.ykhdr.springsandbox.restapiproject.services.PeopleService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    @GetMapping()
    public List<Person> getPeople(){
        return peopleService.findAll();
    }

    @GetMapping("/{id}")
    public Person findOne(@PathVariable("id") int id){
        return peopleService.findOne(id);
    }
}
