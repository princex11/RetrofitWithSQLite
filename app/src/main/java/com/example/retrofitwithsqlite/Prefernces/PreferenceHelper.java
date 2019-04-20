package com.example.retrofitwithsqlite.Prefernces;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {

    private static final String PREF_NAME = "com.example.retrofitwithsqlite.Prefernces";
    private static PreferenceHelper instance = null;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;
    public static final String KEY_TOKEN = "token";

    private PreferenceHelper() {

    }

    public static PreferenceHelper getInstance(Context context) {
        if (instance == null) {
            synchronized (PreferenceHelper.class) {
                if (instance == null) {
                    instance = new PreferenceHelper();
                    sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
                    editor = sharedPreferences.edit();
                }
            }
        }
        return instance;
    }

    public void setString(String key, String value){
        editor.putString(key, value).apply();
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

}
