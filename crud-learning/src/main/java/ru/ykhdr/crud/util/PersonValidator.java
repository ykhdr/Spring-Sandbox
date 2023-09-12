package ru.ykhdr.crud.util;

import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.ykhdr.crud.dao.PersonDAO;
import ru.ykhdr.crud.models.Person;

@AllArgsConstructor
@Component
public class PersonValidator implements Validator {
    private final PersonDAO personDAO;

    @Override
    public boolean supports(@NotNull Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(@NotNull Object target, @NotNull Errors errors) {
        Person person = (Person) target;

        if (personDAO.show(person.getEmail()).isPresent()) {
            errors.rejectValue("email", "", "This email is already taken");
        }
    }
}
