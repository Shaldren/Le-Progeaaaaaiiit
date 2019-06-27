package com.example.leprogeaaaaaiiit.bo;

public class Gerant extends Personne
{
    private long idGerant;
    private long idAgence;

    public Gerant() {
    }

    public Gerant(long id, String nom, String prenom, String adresse, String ville, String codePostal, long idGerant, long idAgence) {
        super(id, nom, prenom, adresse, ville, codePostal);
        this.idGerant = idGerant;
        this.idAgence = idAgence;
    }

    public long getIdGerant() {
        return idGerant;
    }

    public void setIdGerant(long idGerant) {
        this.idGerant = idGerant;
    }

    public long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(long idAgence) {
        this.idAgence = idAgence;
    }
}
