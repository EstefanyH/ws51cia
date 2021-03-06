package com.hache.appentrepatas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hache.appentrepatas.util.Constants;
import com.hache.appentrepatas.util.General;

import kotlinx.coroutines.scheduling.Task;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    TextView register_txt;
    Button login_btn;
    EditText user_txt, pass_txt;

    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        register_txt = (TextView) findViewById(R.id.lbl_login_register);
        login_btn = (Button) findViewById(R.id.btn_login);
        user_txt = (EditText)  findViewById(R.id.login_userTxt);
        pass_txt = (EditText) findViewById(R.id.login_passTxt);
        login_btn.setOnClickListener(this);
        register_txt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lbl_login_register:
                intent = new Intent(this, SingupActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_login:
                if (validarLogin()){

                    Toast.makeText(this, getString(R.string.msg_login_exito), Toast.LENGTH_LONG).show();

                    Constants.user = user_txt.getText().toString().trim().toUpperCase();
                    intent = new Intent(this, MainActivity.class);
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }

    boolean validarLogin() {
        if(user_txt.getText().toString().length() == 0){
            Toast.makeText(this, getString(R.string.msg_login_user), Toast.LENGTH_LONG).show();
            return false;
        }

        /* if(!General.validarMail(user_txt.getText().toString())){
            Toast.makeText(this, getString(R.string.msg_registro_valMail),Toast.LENGTH_LONG).show();
            return false;
        }*/

        if(pass_txt.getText().toString().length() == 0){
            Toast.makeText(this, getString(R.string.msg_login_pass), Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}