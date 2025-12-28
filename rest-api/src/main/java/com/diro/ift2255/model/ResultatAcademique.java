package com.diro.ift2255.model;

public class ResultatAcademique {

    private String sigle;
    private String nom;
    private String moyenne;
    private double score;
    private int participants;
    private int trimestres;

    public ResultatAcademique() {}

    public String getSigle() { return sigle; }
    public void setSigle(String sigle) { this.sigle = sigle; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getMoyenne() { return moyenne; }
    public void setMoyenne(String moyenne) { this.moyenne = moyenne; }

    public double getScore() { return score; }
    public void setScore(double score) { this.score = score; }

    public int getParticipants() { return participants; }
    public void setParticipants(int participants) { this.participants = participants; }

    public int getTrimestres() { return trimestres; }
    public void setTrimestres(int trimestres) { this.trimestres = trimestres; }
}