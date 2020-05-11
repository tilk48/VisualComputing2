package übung3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.awt.*;

public class Main2 extends Application {
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Shapes");

        Group root = new Group();
        Canvas canvas = new Canvas(200, 800);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawCircle(gc);
        drawCircleBow(gc);
        drawEllipse(gc);
        drawQuad(gc);
        drawRondQuad(gc);
        drawTrian(gc);
        drawPoly(gc);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void drawCircle(GraphicsContext gc) {
        gc.setFill(Color.RED);
        gc.fillOval(0, 0, 100, 100);
    }

    private void drawCircleBow(GraphicsContext gc) {
        gc.setFill(Color.LIMEGREEN);
        gc.fillArc(0, 110, 100, 100, 45, 270, ArcType.ROUND);
    }

    private void drawEllipse(GraphicsContext gc) {
        gc.setFill(Color.ORANGE);
        gc.fillOval(0, 220, 150, 80);
        gc.setLineWidth(3);
        gc.strokeOval(0, 220, 150, 80);
    }

    private void drawQuad(GraphicsContext gc) {
        gc.setFill(Color.CORNFLOWERBLUE);
        gc.fillRect(0, 320, 100, 100);
    }

    private void drawRondQuad(GraphicsContext gc) {
        gc.setFill(Color.CADETBLUE);
        gc.fillRoundRect(0, 430, 100, 100, 20, 20);
    }

    private void drawTrian(GraphicsContext gc) {
        gc.setFill(Color.DARKBLUE);
        gc.fillPolygon(new double[]{75, 150, 0}, new double[]{540, 620, 620}, 3);
    }

    private void drawPoly(GraphicsContext gc) {
        gc.setFill(Color.DARKRED);
        gc.fillPolygon(new double[]{20, 130, 150, 130, 20, 0}, new double[]{640, 640, 690, 740, 740, 690}, 6);
    }
}
