package com.example.leprogeaaaaaiiit;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.leprogeaaaaaiiit.adapter.VehiculeAdapter;
import com.example.leprogeaaaaaiiit.application.CustomApplication;
import com.example.leprogeaaaaaiiit.application.LeProgeaaaaaiiitApplication;
import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.manager.VehiculeManager;

import java.util.ArrayList;
import java.util.List;

public class VehiculeListActivity extends AppCompatActivity {

    private final static int RESULT_CODE_INSERT = 10001;
    //private final static int RESULT_CODE_CONFIG = 10002;
    private static List<Vehicule> vehicules;
    private static VehiculeAdapter adapter;
    VehiculeManager vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_list);

        RecyclerView liste = findViewById(R.id.listVehicules);

        LinearLayoutManager manager = new LinearLayoutManager(VehiculeListActivity.this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        liste.setLayoutManager(manager);

        VehiculeListActivity.vehicules = new ArrayList<Vehicule>();

        VehiculeListActivity.adapter = new VehiculeAdapter(vehicules, new VehiculeAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, Vehicule vehicule) {
                Intent i = new Intent(VehiculeListActivity.this,VehiculeDetailActivity.class);
                i.putExtra(LeProgeaaaaaiiitApplication.INTENT_VEHICULE,vehicule);
                startActivity(i);
            }
        });
        liste.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListTask listTask = new ListTask();
        listTask.execute(new VehiculeHandler(),this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_liste,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent i = null;
        switch (item.getItemId()){
            case R.id.item_ajout :
                i = new Intent(VehiculeListActivity.this, VehiculeInsertActivity.class);
                startActivityForResult(i, RESULT_CODE_INSERT);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    private static void updateList(List<Vehicule> art){
        Log.i("TAG_AND", "update list");
        vehicules.clear();
        vehicules.addAll(art);
        adapter.notifyDataSetChanged();
    }

    /**
     * Click sur le retour physique ou autre
     */
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //désactive la fermeture si clic à côté de l'AlertDialog
        builder.setCancelable(false);
        builder.setTitle(R.string.title_alert_quit)
                .setMessage(R.string.msg_alert_quit)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(R.string.nok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //on ne fait rien
                    }
                }).show();

        //Supprime l'action par défaut
        //super.onBackPressed();
    }

    private static class ListTask extends AsyncTask<Object,Void, List<Vehicule>> {

        private Handler handler;
        private Context context;


        @Override
        protected List<Vehicule> doInBackground(Object... objects) {
            this.handler =(Handler) objects[0];
            this.context =(Context) objects[1];

            List<Vehicule> art = ((CustomApplication)context.getApplicationContext()).db.getVehiculeDAO().getAll();
            return art;
        }

        @Override
        protected void onPostExecute(List<Vehicule> vehicules) {
            super.onPostExecute(vehicules);
            Message msg = new Message();
            msg.what = 1;
            msg.obj = vehicules;
            handler.sendMessage(msg);
        }
    }

    private static class VehiculeHandler extends Handler{

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if(msg.what == 1){
                List<Vehicule> a = (List<Vehicule>) msg.obj;
                if(a != null) {
                    updateList(a);
                }
            }
        }
    }
}
