package org.example.controller;

import org.example.entities.Produit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import java.util.Iterator;
import java.util.List;

public class MainExo2 {
    public static void main(String[] args) {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        Session session = sf.openSession();

        //Récuperer tous les produits
        Query<Produit> produitQuery1 = session.createQuery("FROM Produit");

        /*Iterator<Produit> produitIterator = produitQuery1.iterate();
        while (produitIterator.hasNext()){
            Produit p = produitIterator.next();
            System.out.println(p);
        }*/
        List<Produit> produits = produitQuery1.list();
        for (Produit p : produits) {
            System.out.println(p);
        }
        //Récuperer les produits aynt un prix supérieur à 100€
        Query<Produit> produitQuery2 = session.createQuery("FROM Produit WHERE prix > 100");
        List<Produit> produits1 = produitQuery2.list();
        for (Produit p: produits1 ) {
            System.out.println(p);
        }

        //Récuperer les produits achetés entre deux dates
        Query<Produit> produitQuery3 = session.createQuery("FROM Produit WHERE dateAchat BETWEEN '2023-08-26' AND '2023-08-29'");
        List<Produit> produits2 = produitQuery3.list();
        for (Produit p: produits2 ) {
            System.out.println(p);
        }
        session.close();
        sf.close();
    }
}
