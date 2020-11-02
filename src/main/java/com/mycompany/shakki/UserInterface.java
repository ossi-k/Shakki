package com.mycompany.shakki;

import java.util.Scanner;

public class UserInterface {

    private Board board;
    private Scanner scanner;
    private Database database;

    public UserInterface(Board board, Scanner scanner, Database database) {
        this.board = board;
        this.scanner = scanner;
        this.database = database;
    }

    public void launch() {
        while (true) {
            System.out.println("Select option");
            System.out.println("1 - Print board");
            System.out.println("2 - Move piece");
            System.out.println("3 - Evaluate current situation");
            System.out.println("4 - Quit");
            System.out.println("99 - Delete all pieces");

            int input = Integer.valueOf(scanner.nextLine());

            if (input == 99) {
                board.deletAllPieces();
            }

            if (input == 1) {
                System.out.println(board.printBoard());
            }

            if (input == 2) {
                System.out.println("Select rank of the piece to be moved");
                int startRank = Integer.valueOf(scanner.nextLine());
                if (startRank > 7 || startRank < 0) {
                    System.out.println("Pieces cannot move out of bounds");
                    continue;
                }

                System.out.println("Select file  of the piece to be moved");
                int startFile = Integer.valueOf(scanner.nextLine());
                if (startFile > 7 || startFile < 0) {
                    System.out.println("Pieces cannot move out of bounds");
                    continue;
                }

                if (board.selectPiece(startRank, startFile) == null) {
                    System.out.println("There is no piece in that square.");
                    System.out.println("Please select a proper piece.");
                    continue;
                }

                System.out.println("Select rank of the end square");
                int endRank = Integer.valueOf(scanner.nextLine());
                if (endRank > 7 || endRank < 0) {
                    System.out.println("Pieces cannot move out of bounds");
                    continue;
                }

                System.out.println("Select file of the end square");
                int endFile = Integer.valueOf(scanner.nextLine());
                if (endFile > 7 || endFile < 0) {
                    System.out.println("Pieces cannot move out of bounds");
                    continue;
                }

                board.movePiece(startRank, startFile, endRank, endFile);
                System.out.println(board.printBoard());
                
                if (board.getMoveNumber() == 50) {
                    System.out.println(board.gameOver());
                    database.insertWinner(board.getWinningSide());
                    break;
                }
            }

            if (input == 3) {
                int score = board.evaluateSituation();

                if (score < 0) {
                    System.out.println("Black is winning, current situation " + score);
                }
                if (score > 0) {
                    System.out.println("White is winning, current situation " + score);
                } else {
                    System.out.println("Game is tied");
                }
            }

            if (input == 4) {
                break;
            }
        }
    }

}
