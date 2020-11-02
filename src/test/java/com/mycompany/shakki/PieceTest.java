package com.mycompany.shakki;

import com.mycompany.chess.Piece;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceTest {

    /*Piece whitePawn;
    Piece blackPawn;

    @Before
    public void setUp() {
        whitePawn = new Piece("pawn", "white", 6, 4, 1);
        blackPawn = new Piece("pawn", "black", 1, 4, -1);
    }*/
    @Test
    public void illegalMoveTestWhitePawn() {
        //pawn
        Piece whitePawn = new Piece("pawn", "white", 6, 4, 1);
        assertEquals(true, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 3, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 3));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 7, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 2));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 6, 4));
    }

    @Test
    public void illegalMoveTestBlackPawn() {
        //pawn
        Piece blackPawn = new Piece("pawn", "black", 1, 4, -1);
        assertEquals(true, blackPawn.legalMoveCheck(blackPawn, 1, 4, 2, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 4, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 0, 3));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 0, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 2, 2));
    }

    @Test
    public void illegalMoveTestKnight() {
        //knight
        Piece whiteKnight = new Piece("knight", "white", 4, 3, 3);
        //Up two squares and left
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 2, 2));
        //Up two squares and right
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 2, 4));
        //Down two squares and left
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 6, 2));
        //Down two squares and right
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 6, 4));
        //Up one square and right 
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 5, 5));
        //Up one square and left
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 5, 1));
        //Down one square and right
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 3, 5));
        //Down one square and left
        assertEquals(true, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 3, 1));

        assertEquals(false, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 4, 4));
        assertEquals(false, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 0, 3));
        assertEquals(false, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 0, 4));
        assertEquals(false, whiteKnight.legalMoveCheck(whiteKnight, 4, 3, 0, 2));
    }

    @Test
    public void illegalMoveTestBishop() {
        //knight
        Piece whiteBishop = new Piece("bishop", "white", 4, 3, 3);
        //Up and right and left
        assertEquals(true, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 2, 5));
        assertEquals(true, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 1, 0));
        //Down and right and left
        assertEquals(true, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 7, 6));
        assertEquals(true, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 7, 0));

        assertEquals(false, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 4, 0));
        assertEquals(false, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 7, 1));
        assertEquals(false, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 2, 4));
        assertEquals(false, whiteBishop.legalMoveCheck(whiteBishop, 4, 3, 4, 3));
    }

    @Test
    public void illegalMoveTestRook() {
        //Rook
        Piece whiteRook = new Piece("rook", "white", 4, 3, 5);
        //up
        assertEquals(true, whiteRook.legalMoveCheck(whiteRook, 4, 3, 0, 3));
        //down
        assertEquals(true, whiteRook.legalMoveCheck(whiteRook, 4, 3, 7, 3));
        //left
        assertEquals(true, whiteRook.legalMoveCheck(whiteRook, 4, 3, 4, 0));
        //right
        assertEquals(true, whiteRook.legalMoveCheck(whiteRook, 4, 3, 4, 7));

        assertEquals(false, whiteRook.legalMoveCheck(whiteRook, 4, 3, 3, 2));
        assertEquals(false, whiteRook.legalMoveCheck(whiteRook, 4, 3, 3, 6));
        assertEquals(false, whiteRook.legalMoveCheck(whiteRook, 4, 3, 5, 2));
        assertEquals(false, whiteRook.legalMoveCheck(whiteRook, 4, 3, 5, 4));
    }

    @Test
    public void illegalMoveTestQueen() {
        //Queen
        Piece whiteQueen = new Piece("queen", "white", 4, 3, 9);
        //up
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 0, 3));
        //down
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 7, 3));
        //left
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 4, 0));
        //right
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 4, 7));
        //Up and right and left
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 2, 5));
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 1, 0));
        //Down and right and left
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 7, 6));
        assertEquals(true, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 7, 0));

        //Up two squares and left
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 2, 2));
        //Up two squares and right
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 2, 4));
        //Down two squares and left
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 6, 2));
        //Down two squares and right
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 6, 4));
        //Up one square and right 
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 5, 5));
        //Up one square and left
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 5, 1));
        //Down one square and right
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 3, 5));
        //Down one square and left
        assertEquals(false, whiteQueen.legalMoveCheck(whiteQueen, 4, 3, 3, 1));

    }

    @Test
    public void illegalMoveTestKing() {
        Piece whiteKing = new Piece("King", "white", 4, 3, 0);
        //Up
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 3, 3));
        //Down
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 5, 3));
        //Left
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 4, 2));
        //Right
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 4, 4));
        //Up and right
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 3, 4));
        //Up and left
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 3, 2));
        //Down and right
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 5, 4));
        //Down and left
        assertEquals(true, whiteKing.legalMoveCheck(whiteKing, 4, 3, 3, 2));
        
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 1, 2));
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 1, 4));
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 4, 1));
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 4, 7));
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 1, 3));
        assertEquals(false, whiteKing.legalMoveCheck(whiteKing, 4, 3, 7, 3));
    }
}
