package ru.ykhdr.crud.models;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.validation.annotation.Validated;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Person {
    private int id;

    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name shoud be between 2 and 30 chars")
    private String name;

    @Min(value = 0, message = "Age should be greater than zero")
    private int age;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
}
