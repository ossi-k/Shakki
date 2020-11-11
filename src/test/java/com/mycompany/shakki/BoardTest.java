package com.mycompany.shakki;

import com.mycompany.chess.Board;
import com.mycompany.chess.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void deleteAllPiecesWorks() {
        Board board = new Board();
        board.deletAllPieces();
        Boolean noPieces = true;
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board.selectPiece(rank, file) != null) {
                    noPieces = false;
                    break;
                }
            }
        }
        assertEquals(true, noPieces);
    }

    //No need to test white and black pawns separately when checking for collisions (right???)
    @Test
    public void collisionCheckBlackPawn() {
        Board board = new Board();
        board.deletAllPieces();

        board.addNewPiece("pawn", "black", 4, 3, -1);
        board.addNewPiece("pawn", "black", 2, 7, -1);
        board.addNewPiece("pawn", "white", 5, 3, 1);
        board.addNewPiece("pawn", "white", 6, 0, 1);

        assertEquals(false, board.collisionCheck(board.selectPiece(5, 3), 5, 3, 4, 3));
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 5, 3));
        assertEquals(true, board.collisionCheck(board.selectPiece(2, 7), 2, 7, 3, 7));
        assertEquals(true, board.collisionCheck(board.selectPiece(6, 0), 6, 0, 5, 0));
    }

    @Test
    public void collisionCheckKing() {
        Board board = new Board();
        board.deletAllPieces();

        board.addNewPiece("King", "black", 4, 3, 0);
        board.addNewPiece("pawn", "black", 4, 4, -1);
        board.addNewPiece("pawn", "white", 4, 2, 1);
        board.addNewPiece("pawn", "black", 3, 3, -11);

        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 4, 4));
        //technically the move below this line should be a piece capture
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 4, 2));
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 3, 3));
    }

    @Test
    public void collisionCheckRook() {
        Board board = new Board();
        board.deletAllPieces();

        board.addNewPiece("rook", "black", 4, 3, -5);
        board.addNewPiece("rook", "black", 5, 0, -5);
        board.addNewPiece("pawn", "black", 4, 1, -1);
        board.addNewPiece("pawn", "white", 4, 6, 1);
        board.addNewPiece("pawn", "black", 1, 3, -1);
        board.addNewPiece("pawn", "black", 6, 3, -1);

        //Left
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 4, 0));
        //Right
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 4, 7));
        //Up
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 0, 3));
        //Down
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 7, 3));

        assertEquals(true, board.collisionCheck(board.selectPiece(5, 0), 5, 0, 5, 7));

    }

    @Test
    public void collisionCheckBishop() {
        Board board = new Board();
        board.deletAllPieces();
        board.addNewPiece("bishop", "black", 4, 3, -3);
        board.addNewPiece("pawn", "black", 2, 1, -1);
        board.addNewPiece("pawn", "black", 2, 5, -1);
        board.addNewPiece("pawn", "black", 6, 1, -1);
        board.addNewPiece("pawn", "black", 6, 5, -1);

        //up and left
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 1, 0));
        //up and right
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 1, 6));
        //down and left
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 7, 0));
        //down and right
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 7, 6));

        board.addNewPiece("bishop", "black", 4, 5, -3);
        //up and right
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 2, 7));
        //up and left
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 0, 1));
        //down and left
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 7, 2));
        //down and right
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 6, 7));

    }

    @Test
    public void collisionCheckQueen() {
        Board board = new Board();
        board.deletAllPieces();
        board.addNewPiece("queen", "black", 4, 3, -9);
        board.addNewPiece("pawn", "black", 2, 1, -1);
        board.addNewPiece("pawn", "black", 2, 5, -1);
        board.addNewPiece("pawn", "black", 6, 1, -1);
        board.addNewPiece("pawn", "black", 6, 5, -1);

        //up and left
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 1, 0));
        //up and right
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 1, 6));
        //down and left
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 7, 0));
        //down and right
        assertEquals(false, board.collisionCheck(board.selectPiece(4, 3), 4, 3, 7, 6));

        board.addNewPiece("queen", "black", 4, 5, -3);
        //up and right
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 2, 7));
        //up and left
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 0, 1));
        //down and left
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 7, 2));
        //down and right
        assertEquals(true, board.collisionCheck(board.selectPiece(4, 5), 4, 5, 6, 7));

        board.addNewPiece("queen", "black", 5, 6, -9);
        //up
        assertEquals(true, board.collisionCheck(board.selectPiece(5, 6), 5, 6, 0, 6));
        //down
        assertEquals(true, board.collisionCheck(board.selectPiece(5, 6), 5, 6, 7, 6));
        //left
        assertEquals(true, board.collisionCheck(board.selectPiece(5, 6), 5, 6, 5, 0));
        //right
        assertEquals(true, board.collisionCheck(board.selectPiece(5, 6), 5, 6, 5, 7));

        board.addNewPiece("queen", "black", 5, 5, -9);
        board.addNewPiece("pawn", "black", 5, 4, -1);
        //up
        assertEquals(false, board.collisionCheck(board.selectPiece(5, 5), 5, 5, 3, 5));
        //down
        assertEquals(false, board.collisionCheck(board.selectPiece(5, 5), 5, 5, 7, 5));
        //left
        assertEquals(false, board.collisionCheck(board.selectPiece(5, 5), 5, 5, 5, 0));
        //right
        assertEquals(false, board.collisionCheck(board.selectPiece(5, 5), 5, 5, 5, 7));

    }

}
