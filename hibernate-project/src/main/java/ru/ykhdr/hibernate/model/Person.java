package ru.ykhdr.hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "Person")
public class Person {


    @Id
    @Setter
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Setter
    @Column(name = "name")
    private String name;

    @Setter
    @Column(name = "age")
    private int age;

    @OneToOne(mappedBy = "person", cascade = CascadeType.PERSIST)
    private Passport passport;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
        passport.setPerson(this);
    }
}


