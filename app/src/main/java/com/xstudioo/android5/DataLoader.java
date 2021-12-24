package com.xstudioo.android5;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;


public class DataLoader extends AsyncTask<String, Void, ArrayList<String>> {

    private static String TAG="Data Loader class";

    protected ArrayList<String> doInBackground( String... params){
        Log.i(TAG, "doInBackground method was called");
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e){
            Log.e(TAG, "doInBackground method failed");
            return null;
        }
    }

}

