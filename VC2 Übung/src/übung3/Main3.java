package übung3;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main3 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Malprogramm");

        Group root = new Group();
        HBox hb = new HBox();

        ObservableList<String> shapes = FXCollections.observableArrayList(
                "Linie",
                "Kreis",
                "Kreisbogen",
                "Ellipse",
                "Quadrat",
                "Dreieck"
        );
        ObservableList<String> color = FXCollections.observableArrayList(
                "rot",
                "orange",
                "gelb",
                "grün",
                "hellblau",
                "dunkelblau",
                "lila"
        );

        final ComboBox comboShape = new ComboBox(shapes);
            comboShape.setPromptText("Formauswahl");
        final ComboBox comboFarbe = new ComboBox(color);
            comboFarbe.setPromptText("Farbauswahl");

        Button clear = new Button("Zurücksetzen");

        hb.getChildren().addAll(comboShape,comboFarbe,clear);

        Canvas canvas = new Canvas(500, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        root.getChildren().addAll(canvas,hb);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
