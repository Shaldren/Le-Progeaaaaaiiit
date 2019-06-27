package com.example.leprogeaaaaaiiit;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.leprogeaaaaaiiit.application.CustomApplication;
import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;

public class VehiculeDetailActivity extends AppCompatActivity {

    private final static String TAG = "TAG_VEHICULE";
    private Vehicule vehicule;
    private View mLayout;
    private final static int RESULT_UPDATE = 1201;
    private final static int PERMISSION_READ_CONTACTS = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_detail);

        ActionBar actionBar = getSupportActionBar();

        mLayout = findViewById(R.id.layout_detail);

        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Intent i = getIntent();

        this.vehicule = i.getParcelableExtra(LeProgeaaaaaiiitApplication.INTENT_VEHICULE);

        chargerVehicule();

    }

    private void chargerVehicule(){

        TextView marque = findViewById(R.id.txtMarque);
        TextView modele = findViewById(R.id.txtModele);
        TextView prix = findViewById(R.id.txtPrix);
        TextView type = findViewById(R.id.txtType);
        Switch loue = findViewById(R.id.switchdetail);

        marque.setText(vehicule.getMarque());
        modele.setText(vehicule.getModele());
        //Paramètre dans le fichier strings.xml pour "symbole_euro_prix"
        prix.setText(String.valueOf(vehicule.getPrixParJour()));

        type.setText(vehicule.getTypeEnvironnement());
        loue.setChecked(vehicule.isLoue());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home :
                finish();
                return true;
            case R.id.item_modifier :
                Intent i = new Intent(VehiculeDetailActivity.this, VehiculeUpdateActivity.class);
                i.putExtra(LeProgeaaaaaiiitApplication.INTENT_VEHICULE, vehicule);
                startActivityForResult(i, RESULT_UPDATE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
