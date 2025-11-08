package prototype;

import prototype.models.Cours;
import prototype.services.CoursService;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CoursService coursService = new CoursService();

        System.out.println("=== Plateforme Choix de Cours UdeM (API Planificateur académique) ===");

        int choix = 0;
        while (choix != 4) {
            System.out.println("\n=== Menu principal ===");
            System.out.println("1. Rechercher un cours");
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
            sc.nextLine(); // clear buffer

            switch (choix) {

                // --- CU1: Search courses ---
                case 1 -> {
                    while (true) {
                        System.out.println("\n=== Recherche de cours ===");
                        System.out.print("Entrez le sigle ex:IFT2255 ou 'retour' pour revenir : ");
                        String keyword = sc.nextLine().trim();

                        if (keyword.equalsIgnoreCase("retour")) break;

                        List<Cours> resultats = coursService.rechercherCours(keyword);

                        if (resultats.isEmpty()) {
                            System.out.println("Aucun cours trouvé.");
                        } else {
                            System.out.println("\nRésultats :");
                            for (Cours c : resultats) {
                                String id = (c.getId() != null ? c.getId() : "(aucun id)");
                                String name = (c.getName() != null ? c.getName() : "(nom manquant)");
                                System.out.printf("- %s | %s (%.1f crédits)\n", id, name, c.getCredits());
                            }
                        }

                        System.out.println("\nAppuyez sur Entrée pour effectuer une autre recherche...");
                        sc.nextLine();
                    }
                }

                // --- CU2: Course details ---
                case 2 -> {
                    while (true) {
                        System.out.println("\n=== Détails d’un cours ===");
                        System.out.print("Entrez le sigle du cours (ex: IFT2255) ou 'retour' pour revenir : ");
                        String sigle = sc.nextLine().trim();

                        if (sigle.equalsIgnoreCase("retour")) break;

                        Cours cours = coursService.getCoursParCode(sigle);

                        if (cours == null) {
                            System.out.println("Cours introuvable.");
                        } else {
                            System.out.println("\n--- Informations du cours ---");
                            System.out.println("Sigle : " + cours.getId());
                            System.out.println("Nom : " + cours.getName());
                            System.out.println("Crédits : " + cours.getCredits());
                            System.out.println("\nDescription : " +
                                    (cours.getDescription() != null ? cours.getDescription() : "Aucune description disponible."));

                            

                            if (cours.getPrerequisite_courses() != null && cours.getPrerequisite_courses().length > 0) {
                                System.out.println("Cours prérequis : " + String.join(", ", cours.getPrerequisite_courses()));
                            }

                            if (cours.getEquivalent_courses() != null && cours.getEquivalent_courses().length > 0) {
                                System.out.println("Cours équivalents : " + String.join(", ", cours.getEquivalent_courses()));
                            }
                        }

                        System.out.println("\nAppuyez sur Entrée pour continuer...");
                        sc.nextLine();
                    }
                }

                // --- CU3: Compare courses ---
                case 3 -> {
                    while (true) {
                        System.out.println("\n=== Comparer des cours ===");
                        System.out.print("Entrez les sigles des cours à comparer (séparés par des virgules) EEX IFT2255,MAT1400 ou 'retour' : ");
                        String input = sc.nextLine().trim();

                        if (input.equalsIgnoreCase("retour")) break;

                        String[] sigles = input.split(",");
                        for (int i = 0; i < sigles.length; i++) sigles[i] = sigles[i].trim();

                        List<Cours> coursList = coursService.getCoursParCodes(sigles);

                        if (coursList.size() < 2) {
                            System.out.println("Veuillez entrer au moins deux cours valides.");
                        } else {
                            coursService.comparerCours(coursList);
                        }

                        System.out.println("\nAppuyez sur Entrée pour une autre comparaison...");
                        sc.nextLine();
                    }
                }

                // --- Quit ---
                case 4 -> {
                    System.out.println("\nMerci d’avoir utilisé la plateforme. À bientôt !");
                }

                // --- Invalid choice ---
                default -> {
                    System.out.println("Choix invalide, veuillez réessayer.");
                }
            }
        }

        sc.close();
    }
}
