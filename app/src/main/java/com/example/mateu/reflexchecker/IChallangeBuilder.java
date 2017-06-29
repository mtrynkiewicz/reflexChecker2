package com.example.mateu.reflexchecker;

import android.widget.ImageView;

import java.util.List;
import java.util.Random;

/**
 * Created by Mateu on 28.06.2017.
 */

public interface IChallangeBuilder {
    public void prepareMoveChallange(int currentLevelValue,Random rnd);
    public void setTimeCounterZero(double counter);
    public void setArrowsNotColor(List<ImageView> arrowList);
    public List<Integer> getMoveList();



}
