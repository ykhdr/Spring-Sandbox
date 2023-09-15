package ru.ykhdr.library.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ykhdr.library.message.ValidationErrorMessage;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    private int id;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @Size(min = 2, max = 30, message = ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_30)
    private String name;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @Size(min = 2, max = 100, message = ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_100)
    private String surname;

    @Size(min = 2, max = 100, message = ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_100)
    private String fatherName;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private Date birthday;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @Email(message = ValidationErrorMessage.FIELD_VALID)
    @Size(min = 2, max = 100, message =  ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_100)
    private String email;
}