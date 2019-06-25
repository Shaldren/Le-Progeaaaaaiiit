package com.example.leprogeaaaaaiiit.bo;

public class Client extends personne {
    private int idClient;

    public Client() {
    }

    public Client(int id, String nom, String prenom, String adresse, String ville, int codePostal, int idClient) {
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