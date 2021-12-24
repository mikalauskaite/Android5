package com.xstudioo.android5;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class DataManager {

    private static String TAG="DataManager class";

    public static ArrayList<String> getRateFromECB() throws IOException {
        Log.i(TAG, "getRateFromECM method was called");
        ArrayList<String> rate;
        InputStream stream=downloadUrl ( Constants.RATES_URL);
        try {
            rate= Parser.getRateFromECB ( stream );
        }
        finally {
            if(stream!=null){
                stream.close();
            }
        }
        return rate;
    }

    private static InputStream downloadUrl( String urlString) throws IOException {
        Log.i(TAG, "buvo iškviestas downloadUrl metodas");
        URL url = new URL (urlString);
        HttpURLConnection conn = ( HttpURLConnection ) url.openConnection ();
        conn.setReadTimeout(1000);
        conn.setConnectTimeout(500);
        conn.setRequestMethod("GET");
        conn.setDoInput(true);
        conn.connect();
        return conn.getInputStream();
    }

}
