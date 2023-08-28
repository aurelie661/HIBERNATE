package org.example.controller;

import org.example.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Date;

public class MainExo1 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        //Creation
        Session session = sf.openSession();
        session.getTransaction().begin();
        Produit p1 = new Produit("Findus","1254df",new Date("2023/08/28"),3.99,5);
        Produit p2 = new Produit("Lessieur","2654dz",new Date("2023/08/28"),4.99,5);
        Produit p3 = new Produit("Kinder","879hth",new Date("2023/08/28"),5.99,5);
        Produit p4 = new Produit("Dop","68478fds",new Date("2023/08/28"),6.99,5);
        Produit p5 = new Produit("Nivea","8647zegr",new Date("2023/08/28"),7.99,5);

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);
        session.getTransaction().commit();
        //Lire
        Produit produit = session.get(Produit.class,2L);
        System.out.println(produit);

        //Supprimer
        session.getTransaction().begin();
        Produit produit1 = session.get(Produit.class, 3L);
        session.delete(produit1);
        session.getTransaction().commit();

        //Modifier
        session.getTransaction().begin();
        Produit produit3 = session.get(Produit.class, 1L);
        produit3.setMarque("Croustibat");
        produit3.setReference("12346azerty");
        produit3.setPrix(15.20);
        produit3.setStock(15);
        produit3.setDateAchat(new Date("2023/08/29"));
        session.update(produit3);
        session.getTransaction().commit();

        session.close();
        sf.close();
    }
}