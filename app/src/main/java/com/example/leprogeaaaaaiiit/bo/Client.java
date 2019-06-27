package com.example.leprogeaaaaaiiit.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Client extends Personne implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private long idClient;
    private long idVoiture;

    public Client() {
    }

    public Client(long id, String nom, String prenom, String adresse, String ville, String codePostal, long idClient, long idVoiture) {
        super(id, nom, prenom, adresse, ville, codePostal);
        this.idClient = idClient;
        this.idVoiture = idVoiture;
    }

    protected Client(Parcel in) {
        idClient = in.readLong();
        idVoiture = in.readLong();

    }

    public static final Creator<Client> CREATOR = new Creator<Client>() {
        @Override
        public Client createFromParcel(Parcel in) {
            return new Client(in);
        }

        @Override
        public Client[] newArray(int size) {
            return new Client[size];
        }
    };

    public long getIdClient() {
        return idClient;
    }

    public void setIdClient(long idClient) {
        this.idClient = idClient;
    }

    public long getIdVoiture() {
        return idVoiture;
    }

    public void setIdVoiture(long idVoiture) {
        this.idVoiture = idVoiture;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idClient);
        dest.writeLong(idVoiture);
    }
}