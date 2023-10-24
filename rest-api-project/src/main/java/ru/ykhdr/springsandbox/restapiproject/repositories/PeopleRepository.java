package ru.ykhdr.springsandbox.restapiproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ykhdr.springsandbox.restapiproject.models.Person;

@Repository
public interface PeopleRepository extends JpaRepository<Person, Integer> {
}
