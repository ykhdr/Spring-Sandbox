package ru.ykhdr.library.dao;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ykhdr.library.models.Person;

import java.util.List;
import java.util.Optional;


@AllArgsConstructor
@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public void save(@NotNull Person person) {
        jdbcTemplate.update("INSERT INTO Person(name, surname, father_name, email, birthday_year) VALUES (?,?,?,?,?)",
                person.getName(), person.getSurname(), person.getFatherName(), person.getEmail(), person.getBirthdayYear());
    }

    public Optional<Person> show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny();
    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
    }

    public void update(int id, Person person){
        jdbcTemplate.update("UPDATE Person SET name=?,surname=?,father_name=?,email=?,birthday_year=? WHERE id = ?",
                person.getName(),person.getSurname(),person.getFatherName(),person.getEmail(),person.getBirthdayYear(), id);
    }


}



