package ru.ykhdr.crud.dao;

import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ykhdr.crud.models.Person;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class PersonDAO {
    private final SessionFactory sessionFactory;

    @Transactional
    public List<Person> index() {
        Session session = sessionFactory.getCurrentSession();

        return session.createQuery("select p from person p", Person.class).getResultList();
    }

    public Optional<Person> show(int id) {
        return null;
    }

    public Optional<Person> show(String email) {
        return null;
    }

    public void save(Person person) {
    }


    public void update(int id, Person updatedPerson) {
    }

    public void delete(int id) {
    }
}
