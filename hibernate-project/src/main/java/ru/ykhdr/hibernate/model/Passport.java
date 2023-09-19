package ru.ykhdr.hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "passport")
public class Passport{

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    public Passport(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    @Column(name = "passport_number")
    private int passportNumber;
}
