package com.example.mateu.reflexchecker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void startChallange(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,ReflexActivity.class);
        startActivity(intent);
    }
    public void checkScore(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,ListBasedFragment.class);
        startActivity(intent);
    }
    public void goToMap(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,MapsActivity.class);
        startActivity(intent);
    }
    public void goToRegister(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,RegisterActivity.class);
        startActivity(intent);


    }




}
