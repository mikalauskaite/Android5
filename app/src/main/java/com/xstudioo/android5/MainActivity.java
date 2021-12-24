package com.xstudioo.android5;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView currency;
    private static String TAG = "Activity";

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        Log.i(TAG, "onCreate method was called");
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        currency=findViewById ( R.id.currency );

    }
    @SuppressLint( "StaticFieldLeak" )
    @Override
    protected void onStart ( ) {
        Log.i(TAG, "onStart method was called");
        super.onStart ( );

        new DataLoader (){
            @Override
            public void onPostExecute( ArrayList<String> result){
                Log.i("DataLoader class", "onPostExecute method was called");
                ArrayAdapter<String> adapter = new ArrayAdapter <> ( getApplicationContext (), android.R.layout.simple_list_item_1, result );
                currency.setAdapter ( adapter );

            }
        }.execute("USD");

    }

}
