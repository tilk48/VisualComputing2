package ballanimaton;

import javafx.geometry.Point2D;

public abstract class Form {

    Calculations calc;

    //2D vectors
    Point2D location;
    Point2D velocity;
    Point2D acceleration;
    //max settings, not really necessary
    double maxForce = 0.1;
    double maxSpeed = 2;
    //dimensions of a form
    double width, height, centerX, centerY, radius;

    public Form(Point2D location, Point2D velocity, Point2D acceleration, double width, double height){

        this.location = location;
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.width = width;
        this.height = height;
    }

    public void move(){
        velocity.add(acceleration);
        location.add(velocity);
    }
}
