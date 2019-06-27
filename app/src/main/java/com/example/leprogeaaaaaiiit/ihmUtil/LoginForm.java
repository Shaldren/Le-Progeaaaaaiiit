package com.example.leprogeaaaaaiiit.ihmUtil;

import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public abstract  class LoginForm {


    public static boolean checkForm(EditText login , EditText mdp){
        boolean isCheck = false;
        List<String> errors = new ArrayList<>();

        String loginS =  login.getText().toString();
        String mdpS = mdp.getText().toString();

        if(loginS.trim().length() == 0){
            errors.add("Le login ne peut être vide");
        }

        if(mdpS.trim().length() == 0){
            errors.add("Le mot de passe ne peut être vide");
        }

        return errors.size() == 0;


    }
}
