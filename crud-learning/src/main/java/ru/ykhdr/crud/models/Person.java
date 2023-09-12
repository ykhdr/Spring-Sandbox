package ru.ykhdr.crud.models;


import lombok.*;

import javax.validation.constraints.*;

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

    // Страна, Город, Индекс (6 цифр) - регулярное выражение
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}",
            message = "Your address should be in this format: Country, City, Postal Code (6 digits)")
    private String address;
}
