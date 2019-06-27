package com.example.leprogeaaaaaiiit;

import android.content.Intent;
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

public class VehiculeUpdateActivity extends AppCompatActivity {

    private VehiculeForm form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_update);

        Intent i = getIntent();

        Vehicule vehicule = i.getParcelableExtra(LeProgeaaaaaiiitApplication.INTENT_VEHICULE);

        this.form = new VehiculeForm(VehiculeUpdateActivity.this, vehicule);

        this.form.chargeVehicule();
    }

    public void updateVehiculeClick(View view){
        List<String> errors = new ArrayList<>();
        String error = null;

        if(this.form.checkForm(errors)){
            this.form.saveOrUpdate(new UpdateHandler());
        }
    }

    private void updateMsg(boolean ok){
        if(ok){
            Toast.makeText(VehiculeUpdateActivity.this,R.string.msg_update_vehicule,Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.putExtra("vehicule", this.form.getVehicule());
            setResult(RESULT_OK, i);
            finish();

        }
        else{
            Toast.makeText(VehiculeUpdateActivity.this, R.string.msg_update_vehicule, Toast.LENGTH_LONG).show();
        }
    }

    private class UpdateHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.i("TAG_AND", "msg : " + msg.what);
            switch (msg.what){
                case 1 :
                    VehiculeUpdateActivity.this.updateMsg(true);
                    break;
                case 2 :
                    VehiculeUpdateActivity.this.updateMsg(false);
                    break;
            }
        }
    }
}
