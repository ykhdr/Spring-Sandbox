package ru.ykhdr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ykhdr.hibernate.model.Actor;
import ru.ykhdr.hibernate.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Actor.class)
                .addAnnotatedClass(Movie.class);


        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Movie movie = session.get(Movie.class, 2);
            System.out.println(movie.getActors());

            session.getTransaction().commit();
        }
    }
}
