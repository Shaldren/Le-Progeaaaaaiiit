package com.example.leprogeaaaaaiiit.bo;

public class Location {

    private int idLocation;

    private int idClient;

    private int idVehicule;

    public Location() {
    }

    public Location(int idLocation, int idClient, int idVehicule) {
        this.idLocation = idLocation;
        this.idClient = idClient;
        this.idVehicule = idVehicule;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }
}
