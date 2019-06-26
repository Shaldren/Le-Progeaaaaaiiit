package com.example.leprogeaaaaaiiit.bo;

public class Gerant extends Personne
{
    private int idGerant;
    private Agence agence;

    public Gerant() {
    }

    public Gerant(int id, String nom, String prenom, String adresse, String ville, int codePostal, int idGerant, Agence agence) {
        super(id, nom, prenom, adresse, ville, codePostal);
        this.idGerant = idGerant;
        this.agence = agence;
    }

    public int getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(int idGerant) {
        this.idGerant = idGerant;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}
