package com.example.newslist;

import android.app.Application;

/*une classe qui represente le context de
* l'application elle permet de stocker une information
* globale et de faire passer l'information d'une activité
*  à l'autre
* */
public class NewsListApplication extends Application {
    private String userId;

    @Override
    public void onCreate() {
        super.onCreate();
        this.userId=null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
