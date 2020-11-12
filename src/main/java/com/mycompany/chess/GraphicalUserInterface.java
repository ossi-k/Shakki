package com.mycompany.chess;

import java.awt.event.MouseEvent;
import javafx.scene.control.Button;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javax.swing.text.Position;

public class GraphicalUserInterface extends Application {

    GridPane chessBoard = new GridPane();
    Database database;
    private Board board;
    private int clickcounter;
    private int startRank;
    private int startFile;
    private int endRank;
    private int endFile;

    public GraphicalUserInterface() {
        this.board = new Board();
        this.database = new Database();
        this.clickcounter = 0;
        this.startRank = 0;
        this.startFile = 0;
        this.endRank = 0;
        this.endFile = 0;
    }

    @Override
    public void start(Stage window) {
        //test
        drawChessBoard(chessBoard);

        Scene view = new Scene(chessBoard);

        window.setScene(view);
        window.show();
    }

    public void launchUi() {
        launch(GraphicalUserInterface.class);
    }

    public void coordinates(MouseEvent e) {
        Button button = (Button) e.getSource();
        int file = GridPane.getColumnIndex(button);
        int rank = GridPane.getRowIndex(button);
        System.out.println("rank: " + rank + "file: " + file);
    }

    public void getCoordinates(Button button) {
        button.setOnAction((event) -> {
            if (clickcounter == 0) {
                startRank = GridPane.getRowIndex(button);
                startFile = GridPane.getColumnIndex(button);
                if (board.selectPiece(startRank, startFile) == null) {
                    System.out.println("There is no piece in that square.");
                    System.out.println("Please select a proper piece.");
                } else {
                    clickcounter += 1;
                }
            } else if (clickcounter == 1) {
                endRank = GridPane.getRowIndex(button);
                endFile = GridPane.getColumnIndex(button);
                board.movePiece(startRank, startFile, endRank, endFile);
                if (board.getMoveNumber() == 50 || board.isBlackKingOnBoard() == false || board.isWhiteKingOnBoard() == false) {
                    System.out.println(board.gameOver());
                    database.insertWinner(board.getWinningSide());
                    System.exit(0);
                } else {
                    drawChessBoard(chessBoard);
                    clickcounter = 0;
                }
            }
        });
    }

    public void drawChessBoard(GridPane chessBoard) {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board.selectPiece(rank, file) != null) {
                    Piece piece = board.selectPiece(rank, file);
                    if (piece.getColor().toLowerCase().equals("white")) {
                        if (piece.getName().toLowerCase().equals("pawn")) {
                            Image image = new Image("file:white_pawn.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("rook")) {
                            Image image = new Image("file:white_rook.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("knight")) {
                            Image image = new Image("file:white_knight.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("bishop")) {
                            Image image = new Image("file:white_bishop.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("queen")) {
                            Image image = new Image("file:white_queen.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("king")) {
                            Image image = new Image("file:white_king.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                    }
                    if (piece.getColor().toLowerCase().equals("black")) {
                        if (piece.getName().toLowerCase().equals("pawn")) {
                            Image image = new Image("file:black_pawn.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("rook")) {
                            Image image = new Image("file:black_rook.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("knight")) {
                            Image image = new Image("file:black_knight.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("bishop")) {
                            Image image = new Image("file:black_bishop.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("queen")) {
                            Image image = new Image("file:black_queen.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                        if (piece.getName().toLowerCase().equals("king")) {
                            Image image = new Image("file:black_king.png");
                            ImageView imageview = new ImageView(image);
                            Button button = new Button();
                            getCoordinates(button);
                            button.setPrefSize(80, 80);
                            button.setGraphic(imageview);
                            chessBoard.add(button, file, rank);
                        }
                    }
                } else {
                    Button button = new Button();
                    getCoordinates(button);
                    button.setPrefSize(80, 80);
                    chessBoard.add(button, file, rank);
                }
            }
        }
    }

}
