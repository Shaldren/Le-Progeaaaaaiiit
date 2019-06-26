package com.example.leprogeaaaaaiiit.ihmUtil;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.leprogeaaaaaiiit.R;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.manager.VehiculeManager;

import java.security.InvalidParameterException;
import java.util.Date;
import java.util.List;

public class VehiculeForm {

    private Context context;
    private Vehicule vehicule;
    private EditText marque;
    private EditText modele;
    private EditText type;
    private EditText prixParJour;
    private EditText immatriculation;
    private ImageView image;
    private boolean isCheck = false;

    public VehiculeForm(Context context, Vehicule vehicule) {
        this.context = context;
        this.vehicule = vehicule;
        Activity activity = ((Activity) context);
        marque = activity.findViewById(R.id.edtMarque);
        modele = activity.findViewById(R.id.edtModel);
        type = activity.findViewById(R.id.edtType);
        prixParJour = activity.findViewById(R.id.edtPrix);
        immatriculation = activity.findViewById(R.id.edtMatricul);
        image = activity.findViewById(R.id.imageView);
    }

    public void chargeVehicule(){
        marque.setText(vehicule.getMarque());
        modele.setText(vehicule.getModele());
        type.setText(vehicule.getTypeEnvironnement());
        prixParJour.setText(String.valueOf(vehicule.getPrixParJour()));
        immatriculation.setText(vehicule.getImmatriculation());

    }

    public boolean checkForm(List<String> errors){
        isCheck = false;

        String marque =  this.marque.getText().toString();
        String model = this.modele.getText().toString();
        double prix = Double.parseDouble(prixParJour.getText().toString());

        if(marque.trim().length() == 0){
            errors.add("Lm marque du vehicule ne peut être vide");
        }

        if(model.trim().length() == 0){
            errors.add("Le modele du vehicule ne peut être vide");
        }

        if(prix < 0){
            errors.add("Le prix du vehicule ne peut être vide");
        }

        isCheck = errors.size() == 0;

        return isCheck;
    }

    public Vehicule getVehicule(){

        if(!this.isCheck){
            throw new InvalidParameterException(context.getString(R.string.exception_vehicule_form_get));
        }

        this.vehicule.setMarque(marque.getText().toString());
        this.vehicule.setModele(modele.getText().toString());
        this.vehicule.setPrixParJour(Double.parseDouble(prixParJour.getText().toString()));
        this.vehicule.setImmatriculation(immatriculation.getText().toString());
        this.vehicule.setTypeEnvironnement(type.getText().toString());
        this.vehicule.setImage(image.toString());

        return this.vehicule;
    }

    public boolean saveOrUpdate(){
        boolean r = false;
        try {
            Vehicule v = this.getVehicule();

            if(v.getId() > 0){
                r = VehiculeManager.update(v);
            }
        }
        catch (InvalidParameterException e){
            Log.e("ERROR_PROGEAIT", e.getMessage());
        }

        return r;
    }


    public void saveOrUpdate(Handler handler){

        try {
            Vehicule a = this.getVehicule();
            Log.i("TAG_AND", "saveOrUpdate : " + a.toString());
            InsertOrUpdateTask task = new InsertOrUpdateTask();
            task.setHandler(handler);
            task.execute(a);

        }
        catch (InvalidParameterException e) {
            Log.e("ERROR_PROGEAIT", e.getMessage());
        }
    }

    private static class InsertOrUpdateTask
            extends AsyncTask<Vehicule, Void, Boolean> {

        private Handler handler;

        @Override
        protected Boolean doInBackground(Vehicule... vehicules) {

            boolean r;

            Vehicule v = vehicules[0];
            Log.i("TAG_AND", v.toString());
            if(v.getId() > 0){
                r = VehiculeManager.update(v);
            }
            else{
                r = VehiculeManager.insert(v);
            }

            return r;

        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            if(this.handler != null) {
                Message msg = new Message();

                if (aBoolean) {
                    msg.what = 1;
                } else {
                    msg.what = 2;
                }

                this.handler.sendMessage(msg);
            }
        }

        //Peut être remplacer par un constructeur
        public void setHandler(Handler handler){
            this.handler = handler;
        }
    }
}
