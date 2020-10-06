package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    /*Declaration d'une instance statique*/
    public static LoginActivity instance = null;
    public static  NewsListApplication newsListApplication=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        newsListApplication= new NewsListApplication();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle(getLocalClassName());
        instance=this;
        Button login=(Button)findViewById(R.id.loginButton);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*recuperation de l'identifiant de l'utilisateur pour
                * pouvoir l'envoyer là bas*/
                EditText editText =(EditText)findViewById(R.id.userId);
                String userId = (String)editText.getText().toString();

                newsListApplication.setUserId(userId);
                Intent intent = new Intent(LoginActivity.this,NewsActivity.class);
                //intent.putExtra("userId",userId);
                startActivity(intent);
            };
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.finish();
    }

}