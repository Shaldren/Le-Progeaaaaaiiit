package com.example.leprogeaaaaaiiit.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Client extends Personne implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    private int idClient;

    public Client() {
    }

    public Client(int id, String nom, String prenom, String adresse, String ville, int codePostal, int idClient) {
        super(id, nom, prenom, adresse, ville, codePostal);
        this.idClient = idClient;
    }

    protected Client(Parcel in) {
        idClient = in.readInt();
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

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idClient);
    }
}