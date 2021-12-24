package com.xstudioo.android5;

import android.os.AsyncTask;
import android.util.Log;

import java.util.ArrayList;


public class DataLoader extends AsyncTask<String, Void, ArrayList<String>> { //klasė skirta asinchroniniam duomenų nuskaitymui iš interneto svetainės

    private static String TAG="Data Loader class";

    protected ArrayList<String> doInBackground( String... params){
        Log.i(TAG, "buvo iškviestas doInBackground metodas");
        try {
            return DataManager.getRateFromECB();
        } catch (Exception e){
            Log.e(TAG, "nepavyko atlikti doInBackground metodo");
            return null;
        }
    }

}

