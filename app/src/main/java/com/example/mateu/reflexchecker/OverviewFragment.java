package com.example.mateu.reflexchecker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Mateu on 29.06.2017.
 */

public class OverviewFragment extends Fragment {

    private OverviewFragmentActivityListener listener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_overview,container,false);

        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button1:
                        updateDetail("Szczegółowe informacje o elemencie pierwszym.");
                        break;
                    case R.id.button2:
                        updateDetail("Szczegółowe informacje o elemencie drugim.");
                        break;
                    default:
                        break;

                }
            }
        };

        Button button1=(Button)view.findViewById(R.id.button1);
        Button button2=(Button)view.findViewById(R.id.button2);
        button1.setOnClickListener(clickListener);
        button2.setOnClickListener(clickListener);
        return view;
    }
    public interface OverviewFragmentActivityListener{
        public void onItemSelected(String msg);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        //pobrał dane z bazy i wepchnął to do stringa
        if(activity instanceof OverviewFragmentActivityListener)
        {
            listener=(OverviewFragmentActivityListener) activity;
        }
        else
        {
            throw new ClassCastException(activity.toString() + "no nie iwem ale zaimplementuj  OverviewFragment.OverviewFragmentActivityListener");
        }
    }
    public void updateDetail(String msg)
    {
        listener.onItemSelected(msg);
    }


}
