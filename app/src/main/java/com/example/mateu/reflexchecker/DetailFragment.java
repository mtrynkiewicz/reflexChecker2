package com.example.mateu.reflexchecker;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Mateu on 29.06.2017.
 */

public class DetailFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail,container,false);
        return view;
    }
    public void setText(String txt)
    {
        TextView view =(TextView)getView().findViewById(R.id.detailsText);
        view.setText(txt);
    }

}
