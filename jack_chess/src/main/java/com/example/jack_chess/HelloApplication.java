package com.example.jack_chess;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    public static final int SIZE = 8;
    public static final int TILE_SIZE = 60;
    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();



        for (int y = 0; y < SIZE; y++) {
            for (int x = 0; x < SIZE; x++) {
                Rectangle rectangle = new Rectangle(TILE_SIZE, TILE_SIZE);
                rectangle.setFill((x + y) % 2 == 0 ? Color.WHITE : Color.BLACK);

                StackPane stackPane = new StackPane();
                if (x == 0 && y == 0) { // to add an image at the position (0, 0) or any position you want
                    Image queenPiece = new Image("file:C:\\Users\\8jkan\\Documents\\GitHub\\jack_chess_application\\jack_chess\\src\\main\\java\\com\\example\\jack_chess\\queenPiece.png");
                    ImageView imageView = new ImageView(queenPiece);
                    imageView.setFitHeight(TILE_SIZE);
                    imageView.setFitWidth(TILE_SIZE);
                    stackPane.getChildren().addAll(rectangle, imageView);
                } else {
                    stackPane.getChildren().add(rectangle);
                }

                gridPane.add(stackPane, x, y);
            }
        }
        Image queenPiece = new Image("file:/queenPiece.png");
        ImageView imageView = new ImageView(queenPiece);
        imageView.setFitHeight(TILE_SIZE);
        imageView.setFitWidth(TILE_SIZE);
        gridPane.add(imageView, 4, 4);
        Scene scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}