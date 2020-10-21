package com.mycompany.shakki;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PieceTest {

    Piece whitePawn;
    Piece blackPawn;

    @Before
    public void setUp() {
        whitePawn = new Piece("pawn", "white", 6, 4, 1);
        blackPawn = new Piece("pawn", "black", 1, 4, -1);
    }

    @Test
    public void illegalMoveTestWhite() {
        //pawn´
        assertEquals(true, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 3, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 3));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 7, 4));
        assertEquals(false, whitePawn.legalMoveCheck(whitePawn, 6, 4, 5, 2));
    }

    @Test
    public void illegalMoveTestBlack() {
        //pawn
        assertEquals(true, blackPawn.legalMoveCheck(blackPawn, 1, 4, 2, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 4, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 0, 3));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 0, 4));
        assertEquals(false, blackPawn.legalMoveCheck(blackPawn, 1, 4, 2, 2));
    }

}
