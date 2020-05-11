package balldrop;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.geometry.Point2D;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;

public class Main extends Application {

    double vx = 0;
    double vy = 1;

    double ax= 0.1;
    double ay=0;

        @Override
        public void start(Stage stage) {

            Pane canvas = new Pane();
            Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);

            Point2D location= new Point2D(scene.getWidth()/2,scene.getHeight()/2);
            Circle ball = new Circle(10, Color.CADETBLUE);
            ball.relocate(location.getX()-ball.getRadius(),location.getY()-ball.getRadius());

            canvas.getChildren().add(ball);

            //Handling of interactions on the UI is not done in the animation, but in the scenes with scene.addEventFilter(...)

            stage.setTitle("Dropping Ball");
            stage.setScene(scene);
            stage.show();


            //Animation part
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                    new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent t) {
                            //move the ball
                            Point2D velocity = new Point2D(0,1);
                            Point2D acceleration = new Point2D(4,0);

                            vx += ax;
                            vy+=ay;

                            ball.setLayoutX(ball.getLayoutX() + vx);
                            ball.setLayoutY(ball.getLayoutY() + vy);

                            Bounds bounds = canvas.getBoundsInLocal();

                            //If the ball reaches the left or right border make the step negative
                            if(ball.getLayoutX() == (bounds.getMinX() + ball.getRadius()) ||
                                    ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){
                                ball.setLayoutX(0+ball.getRadius());
                            }

                            //If the ball reaches the bottom or top border make the step negative
                            if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                                    (ball.getLayoutY() == (bounds.getMinY() + ball.getRadius()))){

                                ball.setLayoutY(0+ball.getRadius());
                            }
                        }
                    }));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
        }

        public static void main(String[] args) {
            launch();
        }
    }
