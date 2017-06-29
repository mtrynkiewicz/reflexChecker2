package com.example.mateu.reflexchecker;

import android.os.Build;
import android.widget.ImageView;

import java.util.List;
import java.util.Random;

/**
 * Created by Mateu on 28.06.2017.
 */

public class BuilderManager implements IBuilderManger {
    private IChallangeBuilder builder;
    public BuilderManager()
    {

    }
    public void setBuilder(IChallangeBuilder b)
    {
        builder =b;
    }
    public void prepareForChallange(int currentLevel,Random rnd,List<ImageView> arrowList,double timeCounter)
    {
        builder.setTimeCounterZero(timeCounter);
        builder.prepareMoveChallange(currentLevel,rnd);
        if (currentLevel==1)
        {
            builder.setArrowsNotColor(arrowList);
        }
    }
}
