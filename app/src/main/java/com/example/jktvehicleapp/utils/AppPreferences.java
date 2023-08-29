package com.example.jktvehicleapp.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppPreferences {
    private static final  String USER_ID="ID";
    private static final  String USER_NAME="name";
    private static final  String USER_MOB="mob";
    private static final  String USER_EMAIL="email";


    public static void PutBoolean(Context context, String key, boolean val){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key,val);
        editor.commit();
    }
    public static boolean GetBoolean(Context context,String key){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        return preferences.getBoolean(key,false);
    }

    public static void PutInteger(Context context, String key, int val){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key,val);
        editor.commit();
    }
    public static int GetInteger(Context context, String key){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        return preferences.getInt(key,0);
    }

    public static void PutString(Context context,String key,String val){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key,val);
        editor.commit();
    }

    public static String GetString(Context context,String key){
        SharedPreferences preferences=context.getSharedPreferences("SharedPrefarence",Context.MODE_PRIVATE);
        return preferences.getString(key,"");
    }

    public static void setUserName(Context context,String name){
        PutString(context,USER_NAME,name);
    }

    public static String getUserName(Context context){
        return GetString(context,USER_NAME);
    }

    public static void setUserMob(Context context,String name){
        PutString(context,USER_MOB,name);
    }

    public static String getUserMob(Context context){
        return GetString(context,USER_MOB);
    }


    public static void setUSER_ID(Context context,String name){
        PutString(context,USER_ID,name);
    }

    public static String getUSER_ID(Context context){
        return GetString(context,USER_ID);
    }


}
