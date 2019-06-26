package com.example.leprogeaaaaaiiit.bo;

import java.util.List;

public class Agence {
    private int id;
    private String nom;
    private Gerant gerant;
    private List<Vehicule> Vehicules;

    public Agence() {
    }

    public Agence(int id, String nom, Gerant gerant, List<Vehicule> Vehicules) {
        this.id = id;
        this.nom = nom;
        this.gerant = gerant;
        this.Vehicules = Vehicules;
    }

    @Override
    public String toString() {
        return "Agence{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", Gerant=" + gerant +
                ", Vehicules=" + Vehicules +
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

    public Gerant getGerant() {
        return gerant;
    }

    public void setGerant(Gerant gerant) {
        this.gerant = gerant;
    }

    public List<Vehicule> getVehicules() {
        return Vehicules;
    }

    public void setVehicules(List<Vehicule> Vehicules) {
        this.Vehicules = Vehicules;
    }
}
