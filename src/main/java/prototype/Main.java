package prototype;

import java.util.Scanner;
import prototype.models.Etudiant;
import prototype.models.Cours;
import prototype.services.CoursService;


public class Main {
    public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

       
        CoursService service = new CoursService();

      
        System.out.print("Entrez votre nom : ");
        String nom = sc.nextLine();
        Etudiant etu = new Etudiant(nom);

       
        System.out.println("\nCours disponibles :");
        int index = 1;
        for (Cours c : service.getCoursDisponibles()) {
            System.out.println(index + ". " + c.getNom());
            index++;
        }

        
        System.out.print("\nEntrez le numéro du cours à ajouter : ");
        int choix = sc.nextInt();
        sc.nextLine(); // consommer le retour à la ligne

        if (choix > 0 && choix <= service.getCoursDisponibles().size()) {
            Cours coursChoisi = service.getCoursDisponibles().get(choix - 1);
            etu.ajouterCours(coursChoisi);
            System.out.println("\n✅ Cours ajouté avec succès !");
        } else {
            System.out.println("\n⚠️ Choix invalide.");
        }

        // Afficher les cours choisis par l'étudiant
        System.out.println("\nCours choisis par " + etu.getNom() + " :");
        for (Cours c : etu.getCoursChoisis()) {
            System.out.println("- " + c.getNom());
        }

        sc.close();
        
    }
}
