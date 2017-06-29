package com.example.mateu.reflexchecker;

import android.widget.ImageView;

import java.util.List;

/**
 * Created by Mateu on 29.06.2017.
 */

public class SingleMove {
    private ImageView singleArrow;
    private Integer moveIndeks;
    private List <ImageView> arrowList;
    private List<Integer> moveList;
    public Integer shouldBeX;
    public Integer shouldBeZ;

    public SingleMove(List<ImageView> list)
    {
        moveIndeks=0;
        arrowList=list;
    }

    public void setSingleArrow(ImageView singleArrow) {
        this.singleArrow = singleArrow;
    }
    public Integer getArrowTarget()
    {
        return moveList.get(moveIndeks);

    }
    public ImageView giveMeAppropriateArrow()
    {
        if (moveList.get(moveIndeks)==0)
        {
            shouldBeZ=3;
            shouldBeX=0;

        }
        if (moveList.get(moveIndeks)==1)
        {
            shouldBeZ=0;
            shouldBeX=-3;
        }
        if (moveList.get(moveIndeks)==2)
        {
            shouldBeZ=-3;
            shouldBeX=0;


        }
        if (moveList.get(moveIndeks)==3)
        {
            shouldBeZ=0;
            shouldBeX=3;

        }
        return arrowList.get(moveList.get(moveIndeks));
    }
    public void setMoveList(List<Integer> list)
    {
        moveList=list;
        moveIndeks=0;
    }

    public void moveIsCompleted()
    {
        moveIndeks++;
    }
    public boolean roundComplited()
    {
        if (moveIndeks<moveList.size())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    List <ImageView> getWholeArrowsList()
    {
        return arrowList;
    }
}
