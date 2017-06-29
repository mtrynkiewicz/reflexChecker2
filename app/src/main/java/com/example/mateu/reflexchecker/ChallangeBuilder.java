package com.example.mateu.reflexchecker;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by Mateu on 28.06.2017.
 */

public class ChallangeBuilder implements IChallangeBuilder {

    private List<Integer> moveList;
    public ChallangeBuilder()
    {

    }
    public void prepareMoveChallange(int currentLevelValue,Random rnd)
    {
        List<Integer> challangeMove = new ArrayList<Integer>();
        for (int i = 0; i < currentLevelValue; i++)
        {
            challangeMove.add(rnd.nextInt(4));
        }
        moveList= challangeMove;
    }
    public void setTimeCounterZero(double counter)
    {
        counter=0;
    }
    public void setArrowsNotColor(List<ImageView> arrowList)
    {
        for (ImageView arrow:arrowList)
        {
            arrow.setImageResource(R.drawable.arrow_contur);
        }
    }
    @Override
    public List<Integer> getMoveList() {
        return moveList;
    }
}
