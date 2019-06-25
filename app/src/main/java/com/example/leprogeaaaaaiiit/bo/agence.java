package com.example.leprogeaaaaaiiit.bo;

import java.util.List;

public class agence {
    private int id;
    private String nom;
    private gerant gerant;
    private List<vehicule> vehicules;

    public agence() {
    }

    public agence(int id, String nom, com.example.leprogeaaaaaiiit.bo.gerant gerant, List<vehicule> vehicules) {
        this.id = id;
        this.nom = nom;
        this.gerant = gerant;
        this.vehicules = vehicules;
    }

    @Override
    public String toString() {
        return "agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", gerant=" + gerant +
                ", vehicules=" + vehicules +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public com.example.leprogeaaaaaiiit.bo.gerant getGerant() {
        return gerant;
    }

    public void setGerant(com.example.leprogeaaaaaiiit.bo.gerant gerant) {
        this.gerant = gerant;
    }

    public List<vehicule> getVehicules() {
        return vehicules;
    }

    public void setVehicules(List<vehicule> vehicules) {
        this.vehicules = vehicules;
    }
}
