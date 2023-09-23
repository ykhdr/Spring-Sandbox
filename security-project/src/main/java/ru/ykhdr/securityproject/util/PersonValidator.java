package ru.ykhdr.securityproject.util;

import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ykhdr.securityproject.models.Person;
import ru.ykhdr.securityproject.services.PeopleService;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class PersonValidator implements Validator {
    private final PeopleService peopleService;

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NotNull Object target,@NotNull Errors errors) {
        Person person = (Person) target;
        Optional<Person> loadedPerson = peopleService.findPersonByUsername(person.getUsername());

        if(loadedPerson.isPresent()){
            errors.rejectValue("username","","Человек с таким именем пользователя существует");
        }

    }
}
