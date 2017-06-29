package com.example.mateu.reflexchecker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mateu.reflexchecker.R;

/**
 * Created by Mateu on 21.06.2017.
 */

public class DailyScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daily_score_activity);
    }
    public void NavigateBack(View v)
    {
        finish();
    }
}