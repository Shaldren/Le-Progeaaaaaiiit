package com.example.leprogeaaaaaiiit;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.ihmUtil.VehiculeForm;

import java.util.ArrayList;
import java.util.List;

public class VehiculeInsertActivity extends AppCompatActivity {

    private VehiculeForm form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_insert);

        Vehicule vehicule = new Vehicule();

        vehicule.setPrixParJour(getSharedPreferences(LeProgeaaaaaiiitApplication.CONFIGURATION_PREF,MODE_PRIVATE).getFloat("defaultPrix",50));

        this.form = new VehiculeForm(VehiculeInsertActivity.this,vehicule);
        this.form.chargeVehicule();
    }

    public void insertVehiculeClick(View view){
        List<String> errors = new ArrayList<>();

        if(this.form.checkForm(errors)){
            this.form.saveOrUpdate(new InsertHandler());
        }
    }

    /**
     * Pour les messages du Handler
     * @param ok
     */
    private void insertMsg(boolean ok){
        if(ok){
            Toast.makeText(VehiculeInsertActivity.this,"Insertion nouveau véhicule",Toast.LENGTH_LONG).show();
            setResult(RESULT_OK);
            finish();

        }
        else{
            Toast.makeText(VehiculeInsertActivity.this, "Impossible de sauvegarder le véhicule !!", Toast.LENGTH_LONG).show();
        }
    }

    private class InsertHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.i("TAG_AND", "msg : " + msg.what);
            switch (msg.what){
                case 1 :
                    VehiculeInsertActivity.this.insertMsg(true);
                    break;
                case 2 :
                    VehiculeInsertActivity.this.insertMsg(false);
                    break;
            }
        }
    }
}
