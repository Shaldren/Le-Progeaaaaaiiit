package com.example.leprogeaaaaaiiit.bo;

public class client extends personne
{
    private int idClient;

    public client() {
    }

    public client(int id, String nom, String prenom, String adresse, String ville, int codePostal, int idClient) {
        super(id, nom, prenom, adresse, ville, codePostal);
        this.idClient = idClient;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }
}
