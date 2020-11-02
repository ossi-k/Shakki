/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.chess;

public class Piece {

    private String name;
    private String color;
    private int rank;
    private int file;
    private int value;

    public Piece(String name, String color, int rank, int file, int value) {
        this.name = name;
        this.color = color;
        this.rank = rank;
        this.file = file;
        this.value = value;
    }

    public String getNameAndColor() {
        return color + " " + name + " ";
    }

    public int getRank() {
        return rank;
    }

    public int getFile() {
        return file;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setFile(int file) {
        this.file = file;
    }

    
    public void deletePiece(Piece piece) {
        piece = null;
    }

    public Boolean legalMoveCheck(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //Check that a piece is actually moved
        if (startRank == endRank && startFile == endFile) {
            System.out.println("Piece must be moved");
            return false;
        }
        //pawn rules check, moving two squares as first move currently not possible
        if (piece.getName().equals("pawn")) {
            return legalMoveCheckPawn(piece, startRank, startFile, endRank, endFile);
        }

        //rook rules check
        if (piece.getName().equals("rook")) {
            return legalMoveCheckRook(piece, startRank, startFile, endRank, endFile);
        }

        //bishop rules check
        if (piece.getName().equals("bishop")) {
            return legalMoveCheckBishop(piece, startRank, startFile, endRank, endFile);
        }

        //knight rules check
        if (piece.getName().equals("knight")) {
            return legalMoveCheckKnight(piece, startRank, startFile, endRank, endFile);
        }
        //queen rules check
        if (piece.getName().equals("queen")) {
            return legalMoveCheckQueen(piece, startRank, startFile, endRank, endFile);
        }

        //king rules check
        if (piece.getName().toLowerCase().equals("king")) {
            return legalMoveCheckKing(piece, startRank, startFile, endRank, endFile);
        }
        return true;
    }

    public Boolean legalMoveCheckPawn(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //pawn rules check, moving two squares as first move currently not possible
        if (piece.getColor().equals("black")) {
            if ((endRank <= startRank || endFile != startFile) || Math.abs(endRank - startRank) > 1) {
                return false;
            }
        }
        if (piece.getColor().equals("white")) {
            if ((endRank >= startRank || endFile != startFile) || Math.abs(endRank - startRank) > 1) {
                return false;
            }
        }
        return true;
    }

    public Boolean legalMoveCheckRook(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //rook rules check
        if (endRank != startRank && endFile != startFile) {
            return false;
        }
        return true;
    }

    public Boolean legalMoveCheckBishop(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //bishop rules check
        if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
            return false;
        }
        return true;
    }

    public Boolean legalMoveCheckKnight(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //knight rules check
        if (Math.abs(endRank - startRank) > 2 || (Math.abs(endFile - startFile) > 2)) {
            return false;
        }
        if ((Math.abs(endRank - startRank) == 2 && (Math.abs(endFile - startFile) != 1))
                || ((Math.abs(endFile - startFile) == 2) && (Math.abs(endRank - startRank) != 1))
                || startRank == endRank || startFile == endFile) {
            return false;
        }
        return true;
    }

    public Boolean legalMoveCheckQueen(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //queen rules check
        if (endRank != startRank && endFile != startFile) {
            if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
                return false;
            }
        }
        return true;
    }

    public Boolean legalMoveCheckKing(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //king rules check
        if (Math.abs(endRank - startRank) > 1 || Math.abs(endFile - startFile) > 1) {
            return false;
        }
        return true;
    }
}
