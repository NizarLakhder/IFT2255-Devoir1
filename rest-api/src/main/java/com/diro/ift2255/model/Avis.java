package com.diro.ift2255.model;

public class Avis {
    private String cours;
    private int difficulte;
    private int charge;
    private String commentaire;
    private String auteur;
    public Avis() {}

    public Avis(String cours, int difficulte, int charge, String commentaire , String auteur) {
        this.cours = cours;
        this.difficulte = difficulte;
        this.charge = charge;
        this.commentaire = commentaire;
        this.auteur = auteur;
    }

    public String getCours() { return cours; }
    public void setCours(String cours) { this.cours = cours; }

    public int getDifficulte() { return difficulte; }
    public void setDifficulte(int difficulte) { this.difficulte = difficulte; }

    public int getCharge() { return charge; }
    public void setCharge(int charge) { this.charge = charge; }

    public String getCommentaire() { return commentaire; }
    public void setCommentaire(String commentaire) { this.commentaire = commentaire; }
    
    public String getAuteur() { return auteur; }
    public void setAuteur(String auteur) { this.auteur = auteur; }

}
