package com.example.mateu.reflexchecker;

/**
 * Created by Mateu on 28.06.2017.
 */

public class CoordinateSystem {
    private double coordinateX;
    private double coordinateY;
    private double coordinateZ;
    CoordinateSystem()
    {
        coordinateX=0;
        coordinateY=0;
        coordinateZ=0;
    }
    public void setCoordinateX(double x)
    {
        coordinateX=x;
    }
    public void setCoordinateY(double y)
    {
        coordinateY=y;
    }
    public void setCoordinateZ(double z)
    {
        coordinateZ=z;
    }
    public double getCoordinateX()
    {
        return coordinateX;
    }
    public double getCoordinateY()
    {
        return coordinateY;
    }
    public double getCoordinateZ()
    {
        return coordinateZ;
    }
    public void setZeros()
    {
        coordinateX=0;
        coordinateY=0;
        coordinateZ=0;
    }




}
