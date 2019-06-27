package com.example.leprogeaaaaaiiit.ihmUtil;

import android.widget.EditText;

import java.util.List;

public class LoginForm {

    private boolean isCheck = false;
    private EditText login;
    private EditText mdp;

    public boolean checkForm(List<String> errors){
        isCheck = false;

        String login =  this.login.getText().toString();
        String mdp = this.mdp.getText().toString();

        if(login.trim().length() == 0){
            errors.add("Le login ne peut être vide");
        }

        if(mdp.trim().length() == 0){
            errors.add("Le mot de passe ne peut être vide");
        }

        isCheck = errors.size() == 0;

        return isCheck;
    }
}
