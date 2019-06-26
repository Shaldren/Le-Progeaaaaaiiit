package com.example.leprogeaaaaaiiit.bo;

public class Vehicule
{
    private long id;
    private String typeEnvironnement;
    private String marque;
    private String modele;
    private double prixParJour;
    private String immatriculation;
    private String image;

    public Vehicule() {
    }

    public Vehicule(int id, String typeEnvironnement, String marque, String modele, double prixParJour, String immatriculation, String image) {
        this.id = id;
        this.typeEnvironnement = typeEnvironnement;
        this.marque = marque;
        this.modele = modele;
        this.prixParJour = prixParJour;
        this.immatriculation = immatriculation;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Vehicule{" +
                "id=" + id +
                ", typeEnvironnement='" + typeEnvironnement + '\'' +
                ", marque='" + marque + '\'' +
                ", modele='" + modele + '\'' +
                ", prixParJour=" + prixParJour +
                ", immatriculation='" + immatriculation + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypeEnvironnement() {
        return typeEnvironnement;
    }

    public void setTypeEnvironnement(String typeEnvironnement) {
        this.typeEnvironnement = typeEnvironnement;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public double getPrixParJour() {
        return prixParJour;
    }

    public void setPrixParJour(double prixParJour) {
        this.prixParJour = prixParJour;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
