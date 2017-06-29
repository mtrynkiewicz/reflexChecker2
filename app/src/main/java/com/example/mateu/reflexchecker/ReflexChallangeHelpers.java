package com.example.mateu.reflexchecker;

import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mateu on 28.06.2017.
 */

public class ReflexChallangeHelpers {
    private SimpleDateFormat sdf ;
    public ReflexChallangeHelpers()
    {
        sdf= new SimpleDateFormat("HH:mm:ss.SSS");
    }
    public void setProperlyArrowColorfull(Integer whichOne, List<ImageView>arrayList)
    {
        ImageView arrow;
        arrow=arrayList.get(whichOne);
        arrow.setImageResource(R.drawable.arrow_right);
        //arrow.setVisibility(View.INVISIBLE);



    }
    public void setProperlyArrowNotColourfull(Integer whichOne, List<ImageView>arrayList)
    {
        ImageView arrow;
        arrow=arrayList.get(whichOne);
        arrow.setImageResource(R.drawable.arrow_contur);
    }
    public void setColourfullArrow(List<ImageView> arrowList)
    {
        for (ImageView arrow:arrowList)
        {
            arrow.setImageResource(R.drawable.arrow_right);
        }
    }
    public void setNotColourfullArrow(List<ImageView> arrowList)
    {
        for (ImageView arrow:arrowList)
        {
            arrow.setImageResource(R.drawable.arrow_contur);
        }
    }
    public long setTimeZero()
    {
       Calendar currentDate = Calendar.getInstance();
        long currentTime=currentDate.getTimeInMillis();
        return currentTime;
    }
}
