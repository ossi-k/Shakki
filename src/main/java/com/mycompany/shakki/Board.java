package com.mycompany.shakki;

public class Board {

    private Piece[][] board;
    private boolean whiteToMove;

    public Board() {
        board = new Piece[8][8];
        whiteToMove = true;
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                //Mustat namiskat
                if (rank == 0 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "black", rank, file, -5);
                }
                if (rank == 0 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "black", rank, file, -3);
                }
                if (rank == 0 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "black", rank, file, -3);
                }
                if (rank == 0 && file == 3) {
                    board[rank][file] = new Piece("queen", "black", rank, file, -9);
                }
                if (rank == 0 && file == 4) {
                    board[rank][file] = new Piece("King", "black", rank, file, 0);
                }
                if (rank == 1) {
                    board[rank][file] = new Piece("pawn", "black", rank, file, -1);
                }
                //valkoiset namiskat
                if (rank == 7 && (file == 0 || file == 7)) {
                    board[rank][file] = new Piece("rook", "white", rank, file, 5);
                }
                if (rank == 7 && (file == 1 || file == 6)) {
                    board[rank][file] = new Piece("knight", "white", rank, file, 3);
                }
                if (rank == 7 && (file == 2 || file == 5)) {
                    board[rank][file] = new Piece("bishop", "white", rank, file, 3);
                }
                if (rank == 7 && file == 3) {
                    board[rank][file] = new Piece("queen", "white", rank, file, 9);
                }
                if (rank == 7 && file == 4) {
                    board[rank][file] = new Piece("King", "white", rank, file, 0);
                }
                if (rank == 6) {
                    board[rank][file] = new Piece("pawn", "white", rank, file, 1);
                }
            }
        }
    }

    public String printBoard() {
        String tilanne = "";
        for (int rank = 0; rank < 8; rank++) {
            for (int file = 0; file < 8; file++) {
                if (board[rank][file] != null) {
                    tilanne += board[rank][file].getNameAndColor().substring(0, 1) + board[rank][file].getNameAndColor().substring(6, 7) + " ";
                } else {
                    tilanne += " 0 ";
                }
            }
            tilanne += "\n";
        }
        return tilanne;
    }

    public Piece selectPiece(int rank, int file) {
        return board[rank][file];
    }

    public void movePiece(int startRank, int startFile, int endRank, int endFile) {
        Piece piece = board[startRank][startFile];
        if ((piece.getColor().equals("white") && whiteToMove) || (piece.getColor().equals("black") && !whiteToMove)) {
            if (board[endRank][endFile] == null && legalMoveCheck(piece, startRank, startFile, endRank, endFile) && collisionCheck(piece, startRank, startFile, endRank, endFile)) {
                piece.setFile(endFile);
                piece.setRank(endRank);
                board[startRank][startFile] = null;
                board[endRank][endFile] = piece;
                whiteToMove = !whiteToMove;
            } else {
                System.out.println("illegal move");
            }
        }
    }

    public Boolean legalMoveCheck(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        //pawn rules check, moving two squares as first move currently not possible
        if (piece.getName().equals("pawn")) {
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
        }
        //rook rules check
        if (piece.getName().equals("rook")) {
            if (endRank != startRank && endFile != startFile) {
                return false;
            }
        }
        //bishop rules check
        if (piece.getName().equals("bishop")) {
            if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
                return false;
            }
        }
        //knight rules check
        if (piece.getName().equals("knight")) {
            if (Math.abs(endRank - startRank) > 2 || (Math.abs(endFile - startFile) > 2)) {
                return false;
            }
            if ((Math.abs(endRank - startRank) == 2 && (Math.abs(endFile - startFile) != 1))
                    || (Math.abs(endFile - startFile) == 2) && (Math.abs(endRank - startRank) != 1)) {
                return false;
            }
        }
        //queen rules check
        if (piece.getName().equals("queen")) {
            if (endRank != startRank && endFile != startFile) {
                if ((Math.abs(endRank - startRank) - Math.abs(endFile - startFile) != 0)) {
                    return false;
                }
            }
            if ((endRank == startRank && endFile != startFile) || (endRank != startRank && endFile == startFile)) {
                if (endRank != startRank && endFile != startFile) {
                    return false;
                }
            }
        }
        //king rules check
        if (piece.getName().toLowerCase().equals("king")) {
            if (Math.abs(endRank - startRank) > 1 || Math.abs(endFile - startFile) > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean collisionCheck(Piece piece, int startRank, int startFile, int endRank, int endFile) {
        if (piece.getName().equals("pawn")) {
            if (piece.getColor().equals("black")) {
                for (int rank = piece.getRank() + 1; rank <= endRank; rank++) {
                    if (board[rank][piece.getFile()] != null) {
                        return false;
                    }
                }
            }
            if (piece.getColor().equals("white")) {
                for (int rank = piece.getRank() - 1; rank >= endRank; rank--) {
                    if (board[rank][piece.getFile()] != null) {
                        return false;
                    }
                }
            }
        }
        if (piece.getName().equals("bishop")) {
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
        }
        return true;
    }
}
