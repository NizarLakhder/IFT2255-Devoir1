package prototype;

import prototype.models.*;
import prototype.services.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AuthService authService = new AuthService();
        CoursService coursService = new CoursService();
        ProfilService profilService = new ProfilService();

        System.out.println("=== Plateforme Choix de Cours UdeM ===");

        System.out.print("Avez-vous un compte ? (oui/non): ");
        String reponse = sc.nextLine();

        if (reponse.equalsIgnoreCase("non")) {
            System.out.print("Entrez votre nom: ");
            String nom = sc.nextLine();
            System.out.print("Entrez votre email: ");
            String email = sc.nextLine();
            System.out.print("Entrez un mot de passe: ");
            String mdp = sc.nextLine();

            if (authService.creerCompte(nom, email, mdp)) {
                System.out.println("Compte créé avec succès.");
            } else {
                System.out.println("Un compte existe déjà avec cet email.");
            }
        }

        System.out.print("\nEmail: ");
        String email = sc.nextLine();
        System.out.print("Mot de passe: ");
        String mdp = sc.nextLine();

        Etudiant etudiant = authService.authentifier(email, mdp);

        if (etudiant == null) {
            System.out.println("Échec de connexion. Fin du programme.");
            sc.close();
            return;
        }

        System.out.println("\nBienvenue, " + etudiant.getNom() + " !");

        int choix = 0;
        while (choix != 3) {
            System.out.println("\n=== Menu principal ===");
            System.out.println("1. Consulter le catalogue de cours");
            System.out.println("2. Consulter ou modifier votre profil");
            System.out.println("3. Quitter");
            System.out.print("Votre choix : ");
            choix = sc.nextInt();
            sc.nextLine(); // vider le buffer

            switch (choix) {
                case 1:
                    System.out.println("\nCatalogue de cours :");
                    for (Cours c : coursService.getCoursDisponibles()) {
                        System.out.println("- " + c.getNom());
                    }
                    System.out.println("\nAppuyez sur Entrée pour revenir au menu...");
                    sc.nextLine();
                    break;

                case 2:
                    profilService.gererProfil(etudiant, sc);
                    break;

                case 3:
                    System.out.println("Fin du programme.");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        }

        sc.close();
    }
}
