package ballanimaton;

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


public class Main extends Application {

    @Override
    public void start(Stage stage) {

        Pane canvas = new Pane();
        Scene scene = new Scene(canvas, 300, 300, Color.ALICEBLUE);
        Circle ball = new Circle(10, Color.CADETBLUE);
        double posx = scene.getWidth()/2;
        double posy = scene.getHeight()/2;
        ball.relocate(posx,posy);

        canvas.getChildren().add(ball);

        //Handling of interactions on the UI is not done in the animation, but in the scenes with scene.addEventFilter(...)

        stage.setTitle("Animated Ball");
        stage.setScene(scene);
        stage.show();


        //Animation part

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

            //2D vectors

        Point2D location = new Point2D(posx,posy);
        Point2D velocity = new Point2D(0,0);
        Point2D acceleration =  new Point2D(0,0);





            double dx = 5; //(velocity)Step on x, the higher the value the faster and sharper the ball bounces left and right
            double dy = 1; //(velocity)Step on y, the higher the value the fasterand sharper the ball bounces up and down

            double accx = 3;
            double accy = 3;

            @Override
            public void handle(ActionEvent t) {
                //move the ball
                ball.setLayoutX(ball.getLayoutX() + dx);
                ball.setLayoutY(ball.getLayoutY() + dy);

                Bounds bounds = canvas.getBoundsInLocal();

                //If the ball reaches the left or right border make the step negative
                if(ball.getLayoutX() == (bounds.getMinX() + ball.getRadius()) ||
                        ball.getLayoutX() >= (bounds.getMaxX() - ball.getRadius()) ){

                    dx = -dx;
                }

                //If the ball reaches the bottom or top border make the step negative
                if((ball.getLayoutY() >= (bounds.getMaxY() - ball.getRadius())) ||
                        (ball.getLayoutY() == (bounds.getMinY() + ball.getRadius()))){

                    dy = -dy;
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