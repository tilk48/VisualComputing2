package ballanimaton;

import java.awt.geom.Point2D;

public class Calculations {

    public double x;
    public double y;

    public Calculations(double x, double y){
        this.x =x;
        this.y=y;
    }

    public double magnitude(){
        return (double) Math.sqrt(x*x+y*y);
    }

    public void add(javafx.geometry.Point2D v){
        x+= v.getX();
        y+= v.getY();
    }

    public void add(double x, double y){
        this.x  += x;
        this.y += y;
    }

    public void div(double n){
        x/= n;
        y/= n;
    }

    public void multi(double n){
        y*=n;
        x*=n;
    }

    public void norm(){
        double m = magnitude();
        if (m!= 0 &&m!=1){
            div(m);
        }
    }
    public void limit (double max){
        if (magnitude()>max){
            norm();
            multi(max);
        }
    }



}
