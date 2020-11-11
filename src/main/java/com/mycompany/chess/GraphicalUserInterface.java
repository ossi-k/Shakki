package com.mycompany.chess;

import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GraphicalUserInterface extends Application {

    @Override
    public void start(Stage window) {
        GridPane chessBoard = new GridPane();

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                //Mustat namiskat
                if (rank == 0 && (file == 0 || file == 7)) {
                    chessBoard.add(new Button("br"), file, rank);
                } else if (rank == 0 && (file == 1 || file == 6)) {
                    chessBoard.add(new Button("bk"), file, rank);
                } else if (rank == 0 && (file == 2 || file == 5)) {
                    chessBoard.add(new Button("bb"), file, rank);
                } else if (rank == 0 && file == 3) {
                    chessBoard.add(new Button("bq"), file, rank);
                } else if (rank == 0 && file == 4) {
                    chessBoard.add(new Button("bK"), file, rank);
                } else if (rank == 1) {
                    chessBoard.add(new Button("bp"), file, rank);
                } //valkoiset namiskat
                else if (rank == 7 && (file == 0 || file == 7)) {
                    chessBoard.add(new Button("wr"), file, rank);
                } else if (rank == 7 && (file == 1 || file == 6)) {
                    chessBoard.add(new Button("wk"), file, rank);
                } else if (rank == 7 && (file == 2 || file == 5)) {
                    chessBoard.add(new Button("wb"), file, rank);
                } else if (rank == 7 && file == 3) {
                    chessBoard.add(new Button("wq"), file, rank);
                } else if (rank == 7 && file == 4) {
                    chessBoard.add(new Button("wK"), file, rank);
                } else if (rank == 6) {
                    chessBoard.add(new Button("wp"), file, rank);
                } else {
                    chessBoard.add(new Button("00"), file, rank);
                }
            }
        }

        Scene view = new Scene(chessBoard);

        window.setScene(view);
        window.show();
    }

    public static void start() {
        launch(GraphicalUserInterface.class);
    }

}
