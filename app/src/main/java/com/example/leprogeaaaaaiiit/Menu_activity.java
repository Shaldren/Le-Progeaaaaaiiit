package com.example.leprogeaaaaaiiit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class Menu_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_activity);
    }

    public void viewVehiculeClick(View view){

        this.startActivity(new Intent(this, VehiculeListActivity.class));

    }

    public void viewLocationVehiculeClick(View view){

        this.startActivity(new Intent(this, LocationActivity.class));

    }
}
