package com.example.leprogeaaaaaiiit.bo;

public class gerant extends personne
{
    private int idGerant;
    private agence agence;

    public gerant() {
    }

    public gerant(int id, String nom, String prenom, String adresse, String ville, int codePostal, int idGerant, com.example.leprogeaaaaaiiit.bo.agence agence) {
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

    public com.example.leprogeaaaaaiiit.bo.agence getAgence() {
        return agence;
    }

    public void setAgence(com.example.leprogeaaaaaiiit.bo.agence agence) {
        this.agence = agence;
    }
}
