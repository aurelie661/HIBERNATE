package org.example;

import org.example.entities.Personne;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Demo1 {
    public static void main(String[] args) {
        // Création d'un registre pour charger la configuration à partir de notre fichier de configuration
        StandardServiceRegistry registre = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sessionFactory = new MetadataSources(registre).buildMetadata().buildSessionFactory();

        // Création de la session
        Session session = sessionFactory.openSession();
        // Dés l'ouverture de la session, et en fonction de la propriété hibernate.hbm2ddl.auto hibernate va agir sur la base de donnée

        // Ajout d'une personne
        /*
        session.getTransaction().begin();
        Personne pe = new Personne();
        pe.setNom("toto");
        pe.setPrenom("tata");
        session.save(pe);
        System.out.println("ID de la personne : " + pe.getId());

        session.getTransaction().commit();

         */

        // Récupérer une personne
        session.getTransaction().begin();
        Personne p = session.load(Personne.class,1L);
        System.out.println(p.getNom());

        // Modification
        // Attention il est important d'être dans la même transaction si on souhaite modifier ou supprimer
        // on met à jour avec la methode update
        p.setPrenom("titi");
        session.update(p);

        //On supprimme avec la methode delete
        session.delete(p);

        session.getTransaction().commit();
        //Fermeture de la session et la sessionfactory
        session.close();
        sessionFactory.close();
    }
}
