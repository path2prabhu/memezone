package com.nautanki.memezone;

import android.content.Context;

/**
 * Created by Prabhu on 04-02-17.
 */

public class Settings {
    private static Settings instance;





    private static String USER_EMAIL_NAME = "Email";
    private static String USER_PASSWORD = "SimSim";

    private Context context;

    private Settings(Context ctx){
        context = ctx;
        initialize("","");
    }


    private String email;
    private String password;

    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setEmail(String value) {
        email = value;
        Database.writeString(USER_EMAIL_NAME, email, context);
    }

    public void setPassword(String value) {
        password = value;
        Database.writeString(USER_PASSWORD, password, context);
    }

    private void initialize( String mail,String nick) {
        email = mail;
        password = nick;
    }

    public static Settings getDefault(Context context) {
        if (instance == null) {
            instance = new Settings(context);
            instance.hydrate();
        }
        return instance;
    }

    private void hydrate() {
        initialize(Database.readString(USER_EMAIL_NAME, context),Database.readString(USER_PASSWORD, context));
    }

}
