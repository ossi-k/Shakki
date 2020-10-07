package com.mycompany.shakki;

public class Shakki {

    public static void main(String[] args) {
        Board board = new Board();

        //System.out.println(board.printBoard());
        //System.out.println(board.selectPiece(7, 2).getNameAndColor());
        /*board.movePiece(1, 0, 2, 0);
        System.out.println(board.printBoard());
        board.movePiece(2, 0, 3, 0);
        System.out.println(board.printBoard());
        board.movePiece(3, 0, 4, 0);
        System.out.println(board.printBoard());
        board.movePiece(4, 0, 5, 0);
        System.out.println(board.printBoard());
        board.movePiece(5, 0, 6, 0);
        System.out.println(board.printBoard());*/
        //board.movePiece(1, 0, 5, 0);
        //System.out.println(board.printBoard());
        /*board.movePiece(6, 0, 5, 0);
        System.out.println(board.printBoard());
        board.movePiece(1, 0, 2, 0);
        System.out.println(board.printBoard());
        board.movePiece(5, 0, 4, 0);
        System.out.println(board.printBoard());
        board.movePiece(2, 0, 3, 0);
        System.out.println(board.printBoard());
        //illegal move
        board.movePiece(4, 0, 3, 0);
        System.out.println(board.printBoard());*/
        //bishop testing
        board.movePiece(6, 3, 5, 3);
        System.out.println(board.printBoard());
        board.movePiece(1, 3, 2, 3);
        System.out.println(board.printBoard());
        board.movePiece(7, 2, 5, 4);
        System.out.println(board.printBoard());
        board.movePiece(1, 2, 2, 2);
        System.out.println(board.printBoard());
        board.movePiece(6, 6, 5, 6);
        System.out.println(board.printBoard());
        board.movePiece(2, 2, 3, 2);
        System.out.println(board.printBoard());
        //fail?
        board.movePiece(5, 4, 2, 7);
        System.out.println(board.printBoard());
        board.movePiece(0, 6, 2, 5);
        System.out.println(board.printBoard());
        board.movePiece(7, 3, 6, 3);
        System.out.println(board.printBoard());
        board.movePiece(1, 0, 2, 0);
        System.out.println(board.printBoard());
        //board.movePiece(7, 1, 5, 2);
        //System.out.println(board.printBoard());
        board.movePiece(6, 0, 5, 0);
        System.out.println(board.printBoard());
        board.movePiece(2, 0, 3, 0);
        System.out.println(board.printBoard());
        board.movePiece(7, 0, 6, 0);
        System.out.println(board.printBoard());
        board.movePiece(0, 2, 2, 4);
        System.out.println(board.printBoard());
        board.movePiece(6, 3, 7, 4);
        System.out.println(board.printBoard());
        System.out.println("Kumman vuoro " + board.isWhiteToMove());

    }

}
