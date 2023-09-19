package ru.ykhdr.hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.PERSIST)
    private List<Item> items;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void addItem(Item item) {
        if (items == null) {
            items = new ArrayList<>();
        }

        items.add(item);
        item.setOwner(this);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}


