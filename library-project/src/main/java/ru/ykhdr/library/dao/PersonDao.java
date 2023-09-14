package ru.ykhdr.library.dao;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ru.ykhdr.library.models.Person;

import java.util.List;


@AllArgsConstructor
@Component
public class PersonDao {
    private final JdbcTemplate jdbcTemplate;

    public  List<Person> index(){
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }


}



