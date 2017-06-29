package com.example.mateu.reflexchecker;

import android.app.Activity;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;






/**
 * Created by Mateu on 27.06.2017.
 */

public class ReflexActivity extends Activity implements SensorEventListener   {

    private IBuilderManger builderManger;
    private IChallangeBuilder challangeBuilder;
    private ReflexChallangeHelpers reflexHelper;
    private CoordinateSystem coordinateSystem;
    private SingleMove singleMove;


    private boolean isAlreadyRunning;
    private int currentLevelValue=1;
    private double timeCounter=0;


    private Random rnd ;

    private Button manageButton;
    private TextView timeValue;
    private TextView levelValue;
    long startTime;
    long stopTime;
    double timeReflex;

    private Sensor mySensor;
    private SensorManager SM;



    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reflex_activity);
        rnd =new Random();
        setBuilderAndManager();
        onFirstNavigate();
        isAlreadyRunning=true;
        //dla czujnika
        SM=(SensorManager)getSystemService(SENSOR_SERVICE);
        mySensor=SM.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SM.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);


    }

    @Override
    public void onSensorChanged(SensorEvent event) {
            if(Math.abs(event.values[0])>9 || Math.abs(event.values[1])>9)
            {
                coordinateSystem.setCoordinateX(event.values[0]);
                coordinateSystem.setCoordinateZ(event.values[2]);
                reactForMove();
            }

    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
    void userMadeGoodMove()
    {
        reflexHelper.setNotColourfullArrow(singleMove.getWholeArrowsList());

        //singleMove.moveIsCompleted();
        stopTime=reflexHelper.setTimeZero();
        timeReflex=stopTime-startTime;
        timeCounter+=((double)timeReflex)/100+00;

        timeValue.setText(Double.toString(timeCounter));
        currentLevelValue++;
        levelValue.setText(Integer.toString(currentLevelValue));


    }
    void reactForMove()
    {

        if (!isAlreadyRunning)
        {

            if(singleMove.getArrowTarget()==0)
            {
                if (coordinateSystem.getCoordinateZ() >= singleMove.shouldBeZ) {
                    userMadeGoodMove();
                    if (runStepChallange())
                    {
                        runNextLevel();
                    }
                }
            }
            if(singleMove.getArrowTarget()==1)
                {
                    if (coordinateSystem.getCoordinateX() <= singleMove.shouldBeX) {
                        userMadeGoodMove();
                        if (runStepChallange())
                        {
                            runNextLevel();
                        }
                    }
                }
            if(singleMove.getArrowTarget()==2)
            {
                if (coordinateSystem.getCoordinateZ() <= singleMove.shouldBeZ)
                {
                    userMadeGoodMove();
                    if (runStepChallange())
                    {
                        runNextLevel();
                    }
                }

            }

            if(singleMove.getArrowTarget()==3)
            {
                if (coordinateSystem.getCoordinateX() >= singleMove.shouldBeX) {
                    userMadeGoodMove();

                    if (runStepChallange())
                    {

                        runNextLevel();
                    }
                }
            }
        }

    }

    public void breakeChallange()
    {
        reflexHelper.setColourfullArrow(singleMove.getWholeArrowsList());

    }


    public void runNextLevel()
    {
        builderManger.prepareForChallange(currentLevelValue, rnd, singleMove.getWholeArrowsList(), timeCounter);
        singleMove.setMoveList( challangeBuilder.getMoveList());
        runStepChallange();
    }
    public boolean runStepChallange()
    {

        reflexHelper.setNotColourfullArrow(singleMove.getWholeArrowsList());

        if (!singleMove.roundComplited()) {
            singleMove.giveMeAppropriateArrow().setImageResource(R.drawable.arrow_right);
            startTime = reflexHelper.setTimeZero();
        }
        return (!singleMove.roundComplited());
    }


    public void onEveryClick(View v) throws ExecutionException, InterruptedException {
        levelValue.setText(Integer.toString(currentLevelValue));
        timeValue.setText(Double.toString(timeReflex));

        if (isAlreadyRunning)
        {

            manageButton.setText("Break");
            manageButton.setTextColor(Color.parseColor("#ff0000"));
            runNextLevel();
        }
        else
        {
            manageButton.setText("Run");
            manageButton.setTextColor(Color.parseColor("#000000"));
            breakeChallange();

            //wyslij wyniki do bazy

        }
        isAlreadyRunning=!isAlreadyRunning;

    }

    private List<ImageView> addAllImagesArrowToList()
    {
        ImageView arrow;
        List<ImageView> arrowList=new ArrayList<ImageView>();
        arrowList=new ArrayList<ImageView>();
        arrow=(ImageView)findViewById(R.id.arrowTop);
        arrowList.add(arrow);
        arrow=(ImageView)findViewById(R.id.arrowRight);
        arrowList.add(arrow);
        arrow=(ImageView)findViewById(R.id.arrowBottom);
        arrowList.add(arrow);
        arrow=(ImageView)findViewById(R.id.arrowLeft);
        arrowList.add(arrow);
        return arrowList;

    }
    private void setBuilderAndManager()
    {
        builderManger=new BuilderManager();
        challangeBuilder =new ChallangeBuilder();
        builderManger.setBuilder(challangeBuilder);
    }
    private void onFirstNavigate()
    {
        reflexHelper=new ReflexChallangeHelpers();
        singleMove= new SingleMove(addAllImagesArrowToList());//cała lista siedzi w single move

        reflexHelper.setColourfullArrow(singleMove.getWholeArrowsList());

        coordinateSystem=new CoordinateSystem();
        coordinateSystem.setZeros();

        timeValue=(TextView)findViewById(R.id.CurrentTimeValue);
        levelValue=(TextView)findViewById(R.id.CurrentlevelValue);

        manageButton=(Button)findViewById(R.id.challagneManage);
        manageButton.setText("Run");
        manageButton.setTextColor(Color.parseColor("#000000"));





    }
    public void NavigateBack(View v)
    {
        finish();
    }


}
