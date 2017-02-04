package com.nautanki.memezone;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

/**
 * Created by Prabhu on 04-02-17.
 */

public class Controller {

    private Settings settings;
    private Context context;



    public Controller(Context ctx){
        settings = Settings.getDefault(ctx);
        context = ctx;
    }


    public  boolean isValidEmail(CharSequence target) {
        if (TextUtils.isEmpty(target)) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
    public  boolean login(String e, String p) {

        if(settings.getEmail().equals( e)  && settings.getPassword().equals(p)){
           return true;

        }
        return false ;

    }
    public Boolean saveParameters(String e, String p)
    {
        if(isValidEmail(e)){
            saveEmail(e);
            savePassword(p);
            return true;
        } else {
            showToast("Type in a valid email u idiot!");
            return false;
        }



    }

    public void saveEmail(String email){
        settings.setEmail(email);
    }

    public void savePassword (String password){

        settings.setPassword(password);
    }
    public void showToast(String text) {
        Toast toast = Toast.makeText(context.getApplicationContext(), text, Toast.LENGTH_SHORT);
        toast.show();
    }
}
