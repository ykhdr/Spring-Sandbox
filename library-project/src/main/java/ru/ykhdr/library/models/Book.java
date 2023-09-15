package ru.ykhdr.library.models;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ru.ykhdr.library.message.ValidationErrorMessage;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Book {
    private int id;

    private int holderId;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @Size(min = 2, max = 100, message = ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_100)
    private String name;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @Size(min = 2, max = 100, message = ValidationErrorMessage.FIELD_LENGTH_BETWEEN_2_AND_100)
    private String author;

    @NotEmpty(message = ValidationErrorMessage.FIELD_NOT_EMPTY)
    @DateTimeFormat(pattern = "dd.MM.yyyy")
    private int releaseYear;
}
