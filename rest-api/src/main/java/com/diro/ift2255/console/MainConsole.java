

package com.diro.ift2255.console;

import com.diro.ift2255.model.Course;
import com.diro.ift2255.service.CourseService;
import com.diro.ift2255.util.HttpClientApi;

import java.util.List;
import java.util.Scanner;

public class MainConsole {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CourseService courseService = new CourseService(new HttpClientApi());

        System.out.println("=== Plateforme Choix de Cours UdeM (API Planifium) ===");

        int choix = 0;

        while (choix != 4) {

            System.out.println("\n=== Menu principal ===");
            System.out.println("1. Rechercher un cours par sigle");
            System.out.println("2. Voir les détails d’un cours");
            System.out.println("3. Comparer des cours");
            System.out.println("4. Quitter");
            System.out.print("Votre choix : ");

            if (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.println("Veuillez entrer un nombre valide.");
                continue;
            }

            choix = sc.nextInt();
            sc.nextLine(); // vider le buffer

            switch (choix) {

                // 🔹 Recherche de cours
                case 1 -> {
                    System.out.print("\nEntrez le sigle (ex: IFT2255) : ");
                    String sigle = sc.nextLine();

                    List<Course> resultats = courseService.fetchCourses(
                            sigle,        // ids
                            null,         // name
                            null,         // description
                            false,        // includeSchedule
                            null,         // semester
                            "reg"         // level
                    );

                    if (resultats.isEmpty()) {
                        System.out.println("Aucun cours trouvé.");
                    } else {
                        System.out.println("\nRésultats :");
                        for (Course c : resultats) {
                            System.out.printf(
                                    "- %s | %s (%.1f crédits)\n",
                                    c.getId(),
                                    c.getName(),
                                    c.getCredits()
                            );
                        }
                    }
                }

                // 🔹 Détails d’un cours
                case 2 -> {
                    System.out.print("\nEntrez le sigle du cours (ex: IFT2255) : ");
                    String sigle = sc.nextLine();

                    Course cours = courseService.fetchCourseById(
                            sigle,
                            false,   // includeSchedule
                            null,    // semester
                            "reg"    // level
                    );

                    if (cours == null) {
                        System.out.println("Cours introuvable.");
                    } else {
                        System.out.println("\n--- Informations du cours ---");
                        System.out.println("Sigle : " + cours.getId());
                        System.out.println("Nom : " + cours.getName());
                        System.out.println("Crédits : " + cours.getCredits());
                        System.out.println(
                                "Description : " +
                                (cours.getDescription() != null
                                        ? cours.getDescription()
                                        : "Aucune description disponible.")
                        );
                    }
                }

                // 🔹 Comparaison de cours
                case 3 -> {
                    System.out.print("\nEntrez les sigles à comparer (séparés par virgule) : ");
                    String input = sc.nextLine();
                    String[] sigles = input.split(",");

                    List<Course> list = courseService.getCoursParCodes(sigles);

                    if (list.size() < 2) {
                        System.out.println("Veuillez entrer au moins deux cours valides.");
                    } else {
                        System.out.println("\n=== Comparaison des cours ===");
                        for (Course c : list) {
                            System.out.printf(
                                    "%s : %s (%.1f crédits)\n%s\n\n",
                                    c.getId(),
                                    c.getName(),
                                    c.getCredits(),
                                    c.getDescription()
                            );
                        }
                    }
                }

                case 4 ->
                        System.out.println("\nMerci d’avoir utilisé la plateforme. À bientôt !");

                default ->
                        System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        sc.close();
    }
}