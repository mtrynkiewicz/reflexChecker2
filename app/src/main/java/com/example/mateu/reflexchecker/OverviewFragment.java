package com.example.mateu.reflexchecker;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;

/**
 * Created by Mateu on 29.06.2017.
 */

public class OverviewFragment extends Fragment {

    private OverviewFragmentActivityListener listener;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private String FirstName ;
    String level;
    String time;
    FirebaseDatabase database = FirebaseDatabase.getInstance();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_overview,container,false);
        firebaseAuth= FirebaseAuth.getInstance();
        user=firebaseAuth.getCurrentUser();
        FirstName="Użytkownik jest nie zalogowany";
        time="-";
        level="-";
        if (user!=null)
        {
            FirstName=user.getEmail();
            time="0.0";
            level="1";
        }
        View.OnClickListener clickListener = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.button1:
                        updateDetail(" Szczegółowe informacje o użytkowniku \n email:" + FirstName);
                        break;
                    case R.id.button2:
                        updateDetail(" Szczegółowe informacje o wyniku : \n time: " + time +"\n level: "+ level );
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
