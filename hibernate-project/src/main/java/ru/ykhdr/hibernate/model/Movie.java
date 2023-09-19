package ru.ykhdr.hibernate.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "year_of_production")
    private int yearOfProduction;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

    public void setActors(List<Actor> actors) {
        this.actors = actors;
        actors.forEach(actor -> {
            if (actor.getMovies() == null) {
                actor.setMovies(new ArrayList<>());
            }

            actor.getMovies().add(this);
        });
    }

    public Movie(String name, int yearOfProduction) {
        this.name = name;
        this.yearOfProduction = yearOfProduction;
    }
}

