package übung3;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Image image = new Image("übung2/bitchpls.png");

        ImageView view1 = new ImageView();
        view1.setImage(image);

        ImageView view2 = new ImageView();
        view2.setImage(image);
        view2.setFitWidth(100);
        view2.setPreserveRatio(true);
        view2.setSmooth(true);
        view2.setCache(true);

        ImageView view3 = new ImageView();
        view3.setImage(image);
        Rectangle2D viewPort = new Rectangle2D(40,35,110,110);
        view3.setViewport(viewPort);
        view3.setRotate(90);

        Group root = new Group();
        Scene scene = new Scene(root);
        scene.setFill(Color.BLACK);
        HBox box = new HBox();
        box.getChildren().addAll(view1,view2,view3);
        root.getChildren().add(box);

        primaryStage.setTitle("ImageView");
        primaryStage.setWidth(415);
        primaryStage.setHeight(200);
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
