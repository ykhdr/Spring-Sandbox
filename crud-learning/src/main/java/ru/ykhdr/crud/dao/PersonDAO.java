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
        people.add(new Person(++PEOPLE_COUNT, "Ivan", 52, "ivan@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Yan", 21, "yan@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Kate", 63, "kate@email.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Maks", 13, "maks@email.ru"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personToBeUpdated = show(id);

        personToBeUpdated.setName(updatedPerson.getName());
        personToBeUpdated.setAge(updatedPerson.getAge());
        personToBeUpdated.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(p -> p.getId() == id);
    }
}
