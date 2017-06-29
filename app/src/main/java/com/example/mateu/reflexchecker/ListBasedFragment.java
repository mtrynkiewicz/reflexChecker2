package com.example.mateu.reflexchecker;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by Mateu on 29.06.2017.
 */

public class ListBasedFragment extends Activity implements OverviewFragment.OverviewFragmentActivityListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_based_fragment);
    }

    @Override
    public void onItemSelected(String msg) {
        DetailFragment fragment = (DetailFragment)getFragmentManager().findFragmentById(R.id.detailFragment);

        if(fragment!=null && fragment.isInLayout())
        {
            fragment.setText(msg);
        }


    }
}
