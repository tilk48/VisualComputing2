package übung2;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.time.LocalDate;

import static javafx.geometry.Pos.*;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Neuer Eintrag");

        Text aufgabe = new Text();
            aufgabe.setId("titel");
        VBox aufgabeB = new VBox();
        aufgabe.setTextAlignment(TextAlignment.CENTER);
        aufgabeB.setPadding(new Insets(0, 10, 10, 10));
        aufgabe.setText("Bitte neues Buch eintragen");
        aufgabe.setFont(Font.font("Arial", 20));
        aufgabeB.getChildren().add(aufgabe);

        //Text für Textfelder
        Text titel = new Text();
        titel.setText("Titel:");
        Text autor = new Text();
        autor.setText("Autor:");
        Text pages = new Text();
        pages.setText("Anz. Seiten:");
        Text isbn = new Text();
        isbn.setText("ISBN Nummer:");
        Text genre = new Text();
        genre.setText("Genre:");
        Text published = new Text();
        published.setText("Erschienen:");


        Button btn = new Button();
        btn.setText("Datensatz anlegen");

        //andersfarbiger Text
        Text gespeichert = new Text();
        gespeichert.setText("Daten gespeichert.");
        gespeichert.setFill(Color.RED);
        VBox bottom2 = new VBox();
        bottom2.getChildren().add(gespeichert);
        bottom2.setAlignment(CENTER);
        bottom2.setPadding(new Insets(10, 0, 0, 50));

        bottom2.setVisible(false);

        VBox bottomB = new VBox();
        bottomB.setAlignment(BASELINE_RIGHT);
        bottomB.setPadding(new Insets(10, 0, 10, 0));
        bottomB.setPrefHeight(100);

        bottomB.getChildren().addAll(btn, bottom2);

        //all textfields
        TextField titelF = new TextField();
        TextField autorF = new TextField();
        TextField pagesF = new TextField();
        TextField isbnF = new TextField();
        TextField genreF = new TextField();
        DatePicker publishedF = new DatePicker();

        //Text Boxes
        VBox leftB = new VBox();
        leftB.getChildren().addAll(titel, autor, pages, isbn, genre, published);
        leftB.setSpacing(25);

        VBox rightB = new VBox();
        rightB.getChildren().addAll(titelF, autorF, pagesF, isbnF, genreF, publishedF);
        rightB.setSpacing(15);

        Controller2 controller2 = new Controller2();
        controller2.checkTextfield(btn,titelF,autorF,isbnF);

        btn.setOnAction(new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                LocalDate date = publishedF.getValue();
                System.out.println(
                                "Titel: "+ titelF.getText() + "\n" +
                                "Autor: "+ autorF.getText() + "\n" +
                                "Anzahl Seiten: "+ pagesF.getText() + "\n" +
                                "ISBN Nummer: "+ isbnF.getText()+ "\n" +
                                "Genre: "+ genreF.getText() + "\n" +
                                "Erschienen: " + date
                );

                Controller2 controller2 = new Controller2();
                controller2.checkNumbers(pagesF.getText());
                controller2.checkISBN(isbnF.getText());

                bottom2.setVisible(true);

            }
        });

        BorderPane root = new BorderPane();
        root.setLeft(leftB);
        root.setRight(rightB);
        root.setTop(aufgabeB);
        root.setBottom(bottomB);
        root.setPadding(new Insets(10, 20, 20, 20));
        root.setId("root");
        root.getStylesheets().add("übung2/style.css");
        primaryStage.setScene(new Scene(root, 300, 350));
        primaryStage.show();
    }
}
