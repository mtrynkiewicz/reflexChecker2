package com.example.mateu.reflexchecker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mateu.reflexchecker.R;

/**
 * Created by Mateu on 21.06.2017.
 */

public class ScoreMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_main_activity);
    }
    public void NavigateBack(View v)
    {
        finish();
    }
    public void navigateToDailyScore(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,DailyScoreActivity.class);
        startActivity(intent);
    }
    public void navigateToOverallScore(View v)
    {
        Context context=getApplicationContext();
        Intent intent =new Intent(context,OverallScoreActivity.class);
        startActivity(intent);
    }


}
