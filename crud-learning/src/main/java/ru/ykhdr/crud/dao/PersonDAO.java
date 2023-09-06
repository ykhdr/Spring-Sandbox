package ru.ykhdr.crud.dao;

import org.springframework.stereotype.Component;
import ru.ykhdr.crud.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people = new ArrayList<>();

    {
        people.add(new Person(++PEOPLE_COUNT, "Ivan"));
        people.add(new Person(++PEOPLE_COUNT, "Yan"));
        people.add(new Person(++PEOPLE_COUNT, "Kate"));
        people.add(new Person(++PEOPLE_COUNT, "Maks"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void save(Person person){
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }
}
