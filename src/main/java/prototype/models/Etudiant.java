package prototype.models;

import java.util.ArrayList;
import java.util.List;

public class Etudiant {
    private String nom;
    private List<Cours> coursChoisis;

    public Etudiant(String nom) {
        this.nom = nom;
        this.coursChoisis = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void ajouterCours(Cours c) {
        coursChoisis.add(c);
    }

    public List<Cours> getCoursChoisis() {
        return coursChoisis;
    }
}
