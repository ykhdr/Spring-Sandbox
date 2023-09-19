package ru.ykhdr.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.ykhdr.hibernate.model.Item;
import ru.ykhdr.hibernate.model.Person;

public class App {
    public static void main(String[] args) {
        Configuration configuration = new Configuration()
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Item.class);


        try (SessionFactory factory = configuration.buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Person person = new Person("New new  cascading person", 30);
            Item item1 = new Item("testttt cascading item");
            Item item2 = new Item("testttt2 cascading item");
            Item item3 = new Item("testttt3 cascading item");

            person.addItem(item1);
            person.addItem(item2);
            person.addItem(item3);

            session.persist(person);

            session.getTransaction().commit();
        }
    }
}
