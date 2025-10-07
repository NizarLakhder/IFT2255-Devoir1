package prototype.services;

import prototype.models.*;
import java.util.Scanner;

public class ProfilService {

    public void gererProfil(Etudiant etudiant, Scanner sc) {
        if (etudiant.getProfil() == null) {
            System.out.println("Aucun profil trouvé. Créons-en un !");
            creerOuModifierProfil(etudiant, sc);
        } else {
            Profil p = etudiant.getProfil();
            System.out.println("\n=== Votre profil actuel ===");
            System.out.println("Programme : " + p.getProgramme());
            System.out.println("Théorie : " + p.isPrefereTheorie());
            System.out.println("Pratique : " + p.isPreferePratique());
            System.out.println("Centres d'intérêt : " + p.getInterets());

            System.out.print("\nSouhaitez-vous modifier votre profil ? (oui/non) : ");
            String rep = sc.nextLine();

            if (rep.equalsIgnoreCase("oui")) {
                creerOuModifierProfil(etudiant, sc);
            } else {
                System.out.println("Retour au menu principal...");
                System.out.println("\nAppuyez sur Entrée pour revenir au menu...");
                sc.nextLine();
            }
        }
    }

    private void creerOuModifierProfil(Etudiant etudiant, Scanner sc) {
        System.out.println("\n=== Modification du profil ===");
        System.out.print("Programme : ");
        String programme = sc.nextLine();
        System.out.print("Préférence théorie (true/false): ");
        boolean theorie = sc.nextBoolean();
        System.out.print("Préférence pratique (true/false): ");
        boolean pratique = sc.nextBoolean();
        sc.nextLine(); 
        System.out.print("Centres d'intérêt : ");
        String interets = sc.nextLine();

        Profil nouveauProfil = new Profil(programme, theorie, pratique, interets);
        etudiant.setProfil(nouveauProfil);

        System.out.println(" Profil enregistré ou mis à jour avec succès !");
        System.out.println("\nAppuyez sur Entrée pour revenir au menu...");
        sc.nextLine();
    }
}
