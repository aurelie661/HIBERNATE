package org.example.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.Scanner;

public class Exo3 {
    public  static  void startIhm(){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure().build();
        SessionFactory sf = new MetadataSources(ssr).buildMetadata().buildSessionFactory();
        Session session = sf.openSession();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\t#~#~#~# Console #~#~#~#");
            System.out.println("1. Afficher la liste des produits commandés entre deux dates");
            System.out.println("2. Afficher les numéros et reference des articles dont le stock est inférieur à une valeur");
            System.out.println("3. Quitter");
            System.out.print("Votre choix :");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> displayProductsToBuyBetween2date();
                case 2 -> displayNumberAndRefOfProductsWhoseInventoryIsLessThenAValue();
                case 3 -> choice = 3;
                default -> System.out.println("Veuillez entrer un choix valide");

            }
        } while (choice != 3);

    }

    private static void displayProductsToBuyBetween2date() {

    }

    private static void displayNumberAndRefOfProductsWhoseInventoryIsLessThenAValue() {

    }
}
