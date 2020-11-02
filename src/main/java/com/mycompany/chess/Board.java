package com.mycompany.chess;

import java.util.ArrayList;
import java.util.HashSet;

public class Board {

    private Piece[][] board;
    private HashSet<Piece> piecesOnBoard;
    private boolean whiteToMove;
    private int moveNumber;
    private String winningSide;

    public Board() {
        board = new Piece[8][8];
        piecesOnBoard = new HashSet<>();
        whiteToMove = true;
        moveNumber = 0;
        winningSide = "";

        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                //Mustat namiskat
                if (rank == 0 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "black", rank, file, -5);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 0 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "black", rank, file, -3);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 0 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "black", rank, file, -3);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 0 && file == 3) {
                    board[rank][file] = new Piece("queen", "black", rank, file, -9);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 0 && file == 4) {
                    board[rank][file] = new Piece("King", "black", rank, file, 0);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 1) {
                    board[rank][file] = new Piece("pawn", "black", rank, file, -1);
                    piecesOnBoard.add(board[rank][file]);
                }
                //valkoiset namiskat
                if (rank == 7 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "white", rank, file, 5);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 7 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "white", rank, file, 3);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 7 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "white", rank, file, 3);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 7 && file == 3) {
                    board[rank][file] = new Piece("queen", "white", rank, file, 9);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 7 && file == 4) {
                    board[rank][file] = new Piece("King", "white", rank, file, 0);
                    piecesOnBoard.add(board[rank][file]);
                }
                if (rank == 6) {
                    board[rank][file] = new Piece("pawn", "white", rank, file, 1);
                    piecesOnBoard.add(board[rank][file]);
                }
            }
        }
    }

    public boolean isWhiteToMove() {
        return whiteToMove;
    }

    public void deletAllPieces() {
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board[rank][file] != null) {
                    Piece piece = board[rank][file];
                    piece.deletePiece(piece);
                    board[rank][file] = null;
                    piecesOnBoard.remove(piece);
                }
            }
        }
    }

    public void addNewPiece(String name, String color, int rank, int file, int value) {
        board[rank][file] = new Piece(name, color, rank, file, value);
    }

    public String printBoard() {
        String position = "";
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board[rank][file] != null) {
                    position += board[rank][file].getNameAndColor().substring(0, 1) + board[rank][file].getNameAndColor().substring(6, 7) + " ";
                } else {
                    position += " 0 ";
                }
            }
            position += "\n";
        }
        return position;
    }

    public int evaluateSituation() {
        int sum = 0;
        for (Piece piece : piecesOnBoard) {
            sum += piece.getValue();
        }
        return sum;
    }

    public Piece selectPiece(int rank, int file) {
        return board[rank][file];
    }

    public String gameOver() {
        String endGameMessage = "Total moves left before game ends " + (50-moveNumber);
        if (moveNumber == 50) {
            int endResult = evaluateSituation();
            if (endResult < 0) {
                endGameMessage = "Black wins";
                winningSide = "'Black'";
            }
            if (endResult > 0) {
                endGameMessage = "White wins";
                winningSide = "'White'";
            } else {
                endGameMessage = "Game is a tie";
                winningSide = "'Tie'";
            }
            return endGameMessage;
        }
        return endGameMessage;
    }

    public void movePiece(int startRank, int startFile, int endRank, int endFile) {
        Piece piece = board[startRank][startFile];
        if ((piece.getColor().equals("white") && whiteToMove) || (piece.getColor().equals("black") && !whiteToMove)) {
            if (board[endRank][endFile] == null && piece.legalMoveCheck(piece, startRank, startFile, endRank, endFile) && collisionCheck(piece, startRank, startFile, endRank, endFile)) {
                piece.setFile(endFile);
                piece.setRank(endRank);
                board[startRank][startFile] = null;
                board[endRank][endFile] = piece;
                whiteToMove = !whiteToMove;
                moveNumber += 1;
                System.out.println(gameOver());
            } else if (board[endRank][endFile] != null && piece.legalMoveCheck(piece, startRank, startFile, endRank, endFile) && collisionCheck(piece, startRank, startFile, endRank, endFile)) {
                if (board[endRank][endFile].getColor() != piece.getColor()) {
                    board[endRank][endFile].deletePiece(board[endRank][endFile]);
                    piecesOnBoard.remove(board[endRank][endFile]);
                    piece.setFile(endFile);
                    piece.setRank(endRank);
                    board[startRank][startFile] = null;
                    board[endRank][endFile] = piece;
                    whiteToMove = !whiteToMove;
                    moveNumber += 1;
                    System.out.println(gameOver());
                }
            } else {
                System.out.println("illegal move");
            }
        }
    }

    public boolean collisionCheck(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        if (piece.getName().equals("pawn")) {
            return collisionCheckPawn(piece, startRank, startFile, endRank, endFile);
        }
        if (piece.getName().equals("bishop")) {
            return collisionCheckBishop(piece, startRank, startFile, endRank, endFile);
        }
        if (piece.getName().equals("rook")) {
            return collisionCheckRook(piece, startRank, startFile, endRank, endFile);
        }
        if (piece.getName().equals("queen")) {
            return collissionCheckQueen(piece, startRank, startFile, endRank, endFile);
        }
        if (piece.getName().equals("king")) {
            return collisionCheckKing(piece, startRank, startFile, endRank, endFile);
        }
        return true;
    }

    public boolean collisionCheckPawn(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        if (piece.getColor().equals("black")) {
            if (board[piece.getRank() + 1][piece.getFile()] != null) {
                return false;
            }
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        if (piece.getColor().equals("white")) {
            if (board[piece.getRank() - 1][piece.getFile()] != null) {
                return false;
            }
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean collisionCheckBishop(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //moving down and right
        if (endRank > startRank && endFile > startFile) {
            int file = piece.getFile() + 1;
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][file] != null) {
                    return false;
                }
                file += 1;
            }
        }
        //moving up and right
        if (endRank < startRank && endFile > startFile) {
            int file = piece.getFile() + 1;
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][file] != null) {
                    return false;
                }
                file += 1;
            }
        }
        //moving left and down
        if (endRank > startRank && endFile < startFile) {
            int file = piece.getFile() - 1;
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][file] != null) {
                    return false;
                }
                file -= 1;
            }
        }
        //moving left and up
        if (endRank < startRank && endFile < startFile) {
            int file = piece.getFile() - 1;
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][file] != null) {
                    return false;
                }
                file -= 1;
            }
        }
        return true;
    }

    public boolean collisionCheckRook(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //moving up
        if (endRank < startRank) {
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        //moving down
        if (endRank > startRank) {
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        //moving left
        if (endFile < startFile) {
            for (int file = piece.getFile() - 1; file >= endFile; file--) {
                if (board[piece.getRank()][file] != null) {
                    return false;
                }
            }
        }
        //moving right
        if (endFile > startFile) {
            for (int file = piece.getFile() + 1; file <= endFile; file++) {
                if (board[piece.getRank()][file] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean collissionCheckQueen(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //moving down and right
        if (endRank > startRank && endFile > startFile) {
            int file = piece.getFile() + 1;
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][file] != null) {
                    return false;
                }
                file += 1;
            }
        }
        //moving up and right
        if (endRank < startRank && endFile > startFile) {
            int file = piece.getFile() + 1;
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][file] != null) {
                    return false;
                }
                file += 1;
            }
        }
        //moving left and down
        if (endRank > startRank && endFile < startFile) {
            int file = piece.getFile() - 1;
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][file] != null) {
                    return false;
                }
                file -= 1;
            }
        }
        //moving left and up
        if (endRank < startRank && endFile < startFile) {
            int file = piece.getFile() - 1;
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][file] != null) {
                    return false;
                }
                file -= 1;
            }
        }
        if (endRank < startRank && endFile == startFile) {
            for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        //moving down
        if (endRank > startRank && endFile == startFile) {
            for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                if (board[rank][piece.getFile()] != null) {
                    return false;
                }
            }
        }
        //moving left
        if (endFile < startFile && endRank == startRank) {
            for (int file = piece.getFile() - 1; file >= endFile; file--) {
                if (board[piece.getRank()][file] != null) {
                    return false;
                }
            }
        }
        //moving right
        if (endFile > startFile && endRank == startRank) {
            for (int file = piece.getFile() + 1; file <= endFile; file++) {
                if (board[piece.getRank()][file] != null) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean collisionCheckKing(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        if (board[endRank][endFile] != null && board[endRank][endFile].getColor() == piece.getColor()) {
            return false;
        }
        return true;
    }

    public int getMoveNumber() {
        return moveNumber;
    }

    public String getWinningSide() {
        return winningSide;
    }
}
