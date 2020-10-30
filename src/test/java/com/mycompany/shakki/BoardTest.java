package com.mycompany.shakki;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void deletAllPiecesWoks() {
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

}
