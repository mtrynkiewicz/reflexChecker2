package com.example.mateu.reflexchecker;

import android.widget.ImageView;

import java.util.List;
import java.util.Random;

/**
 * Created by Mateu on 28.06.2017.
 */

public interface IBuilderManger {


    public void setBuilder(IChallangeBuilder b);
    public void prepareForChallange(int currentLevel, Random rnd, List<ImageView> arrowList,double timeCounter);


}
