package com.example.leprogeaaaaaiiit;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.leprogeaaaaaiiit.bo.Vehicule;
import com.example.leprogeaaaaaiiit.ihmUtil.LoginForm;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private LoginForm form;

    

    public void LoginClick(View view){
        List<String> errors = new ArrayList<>();
        String error = null;

        if(this.form.checkForm(errors)){
            this.startActivity(new Intent(this, VehiculeListActivity.class));
        }
    }

    private class InsertHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Log.i("TAG_AND", "msg : " + msg.what);
            switch (msg.what){
                case 1 :
                    LoginActivity.this.insertMsg(true);
                    break;
                case 2 :
                    LoginActivity.this.insertMsg(false);
                    break;
            }
        }
    }

    /**
     * Pour les messages du Handler
     * @param ok
     */
    private void insertMsg(boolean ok){
        if(ok){
            Toast.makeText(LoginActivity.this,"Connexion autorisée",Toast.LENGTH_LONG).show();
            setResult(RESULT_OK);
            finish();

        }
        else{
            Toast.makeText(LoginActivity.this, "Login ou mot de passe incorrect", Toast.LENGTH_LONG).show();
        }
    }
}
