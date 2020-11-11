package com.mycompany.chess;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class GraphicalUserInterface extends Application {

    private Board board;

    @Override
    public void start(Stage window) {
        GridPane chessBoard = new GridPane();

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                //Mustat namiskat
                if (rank == 0 && (file == 0 || file == 7)) {
                    Image image = new Image("file:black_rook.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 0 && (file == 1 || file == 6)) {
                    Image image = new Image("file:black_knight.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 0 && (file == 2 || file == 5)) {
                    Image image = new Image("file:black_bishop.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 0 && file == 3) {
                    Image image = new Image("file:black_queen.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 0 && file == 4) {
                    Image image = new Image("file:black_king.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 1) {
                    Image image = new Image("file:black_pawn.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } //valkoiset namiskat
                else if (rank == 7 && (file == 0 || file == 7)) {
                    Image image = new Image("file:white_rook.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 7 && (file == 1 || file == 6)) {
                    Image image = new Image("file:white_knight.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 7 && (file == 2 || file == 5)) {
                    Image image = new Image("file:white_bishop.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 7 && file == 3) {
                    Image image = new Image("file:white_queen.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 7 && file == 4) {
                    Image image = new Image("file:white_King.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else if (rank == 6) {
                    Image image = new Image("file:white_pawn.png");
                    ImageView imageview = new ImageView(image);
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    button.setGraphic(imageview);
                    chessBoard.add(button, file, rank);
                } else {
                    Button button = new Button();
                    button.setPrefSize(80, 80);
                    chessBoard.add(button, file, rank);
                }
            }
        }

        Scene view = new Scene(chessBoard);

        window.setScene(view);
        window.show();
    }

    public static void launcUi() {
        launch(GraphicalUserInterface.class);
    }

}
