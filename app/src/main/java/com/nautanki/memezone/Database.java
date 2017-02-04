package com.nautanki.memezone;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Prabhu on 04-02-17.
 */

public class Database {
    public static void writeBoolean(String key, boolean value, Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean readBoolean(String key, Context context) {
        SharedPreferences settings = getSettings(context);
        return settings.getBoolean(key, false);
    }

    public static void writeString(String key, String value, Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static String readString(String key, Context context) {
        SharedPreferences settings = getSettings(context);
        return settings.getString(key, "");
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences settings = getSettings(context);
        return settings.edit();
    }

    private static SharedPreferences getSettings(Context context) {

        return context.getApplicationContext().getSharedPreferences("MyApp", Context.MODE_PRIVATE);
    }

}
