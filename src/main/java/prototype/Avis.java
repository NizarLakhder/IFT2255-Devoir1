package prototype;

public class Avis {
    private String cours;
    private String difficulte;
    private String charge;
    private String commentaire;
    private String auteur;

   
    public String getCours() { return cours; }
    public void setCours(String cours) { this.cours = cours; }

    public String getDifficulte() { return difficulte; }
    public void setDifficulte(String difficulte) { this.difficulte = difficulte; }

    public String getCharge() { return charge; }
    public void setCharge(String charge) { this.charge = charge; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }

    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

    @Override
    public String toString() {
        return "Avis{" +
                "cours='" + cours + '\'' +
                ", difficulte='" + difficulte + '\'' +
                ", charge='" + charge + '\'' +
                ", commentaire='" + commentaire + '\'' +
                ", auteur='" + auteur + '\'' +
                '}';
    }
}