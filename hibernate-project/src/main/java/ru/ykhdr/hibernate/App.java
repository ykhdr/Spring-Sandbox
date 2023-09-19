package ru.ykhdr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ykhdr.hibernate.model.Passport;
import ru.ykhdr.hibernate.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class);


        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            session.getTransaction().commit();
        }
    }
}
