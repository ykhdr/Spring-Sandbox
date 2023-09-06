package ru.ykhdr.crud.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Accessors(fluent = false)
public class Person {
    private int id;
    private String name;
}
