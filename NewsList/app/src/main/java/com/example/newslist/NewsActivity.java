package com.example.newslist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import static com.example.newslist.LoginActivity.newsListApplication;

public class NewsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //pour changer le titre de l'activité
        setTitle(getLocalClassName());

        //Intent intent = getIntent();
        String userId=LoginActivity.newsListApplication.getUserId();


       /* if(intent.hasExtra("userId")){
            userId=intent.getStringExtra("userId");
        }else{
            userId="";
        }*/

        /*affichage de l'identifiant de l'utilisateur*/
        TextView textView = (TextView)findViewById(R.id.userIdAtNewsActivity);
        textView.setText(userId);

        Button detail = (Button)findViewById(R.id.details);
        detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewsActivity.this,DetailsActivity.class);
                startActivity(intent);
            }
        });

        /*on recupere le bouton pour lancer la page de google*/
        Button about = (Button)findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri lien = Uri.parse("https://news.google.com/");
                Intent intent = new Intent(Intent.ACTION_VIEW,lien);
                startActivity(intent);
            }
        });
    }

    /*pour finir l'activité login(c'est à dire quand on click sur le bouton
    back on quitte sur l'application)*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        LoginActivity.instance.finish();
        this.finish();
    }
}