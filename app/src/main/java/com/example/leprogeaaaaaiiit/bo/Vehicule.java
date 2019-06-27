package com.example.leprogeaaaaaiiit.bo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class Vehicule implements Parcelable
{

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String typeEnvironnement;
    private String marque;
    private String modele;
    private double prixParJour;
    private String immatriculation;
    private String image;
    private long idAgence;
    private boolean loue;

    public Vehicule() {
    }

    /**
     *
     * @param typeEnvironnement
     * @param marque
     * @param modele
     * @param prixParJour
     * @param immatriculation
     * @param image
     */
    @Ignore
    public Vehicule(String typeEnvironnement, String marque, String modele, double prixParJour, String immatriculation, String image, long idAgence, boolean loue) {
        this.typeEnvironnement = typeEnvironnement;
        this.marque = marque;
        this.modele = modele;
        this.prixParJour = prixParJour;
        this.immatriculation = immatriculation;
        this.image = image;
        this.idAgence = idAgence;
        this.loue = loue;
    }

    /**
     *
     * @param id
     * @param typeEnvironnement
     * @param marque
     * @param modele
     * @param prixParJour
     * @param immatriculation
     * @param image
     */
    @Ignore
    public Vehicule(long id, String typeEnvironnement, String marque, String modele, double prixParJour, String immatriculation, String image, long idAgence, boolean loue) {
        this(typeEnvironnement,marque,modele,prixParJour,immatriculation,image,idAgence,loue);
        this.id = id;
    }


    protected Vehicule(Parcel in) {
        id = in.readLong();
        typeEnvironnement = in.readString();
        marque = in.readString();
        modele = in.readString();
        prixParJour = in.readDouble();
        immatriculation = in.readString();
        image = in.readString();
        idAgence = in.readLong();
        loue = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(typeEnvironnement);
        dest.writeString(marque);
        dest.writeString(modele);
        dest.writeDouble(prixParJour);
        dest.writeString(immatriculation);
        dest.writeString(image);
        dest.writeLong(idAgence);
        dest.writeByte((byte) (loue ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Vehicule> CREATOR = new Creator<Vehicule>() {
        @Override
        public Vehicule createFromParcel(Parcel in) {
            return new Vehicule(in);
        }

        @Override
        public Vehicule[] newArray(int size) {
            return new Vehicule[size];
        }
    };

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
                ", agence='" + idAgence + '\'' +
                ", loue='" + loue + '\'' +
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

    public long getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(long idAgence) {
        this.idAgence = idAgence;
    }

    public boolean isLoue() {
        return loue;
    }

    public void setLoue(boolean loue) {
        this.loue = loue;
    }
}
