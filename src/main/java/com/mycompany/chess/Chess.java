package com.mycompany.chess;

import java.util.Scanner;
import java.sql.*;

public class Chess {

    public static void main(String[] args) {

        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        UserInterface ui = new UserInterface(board, scanner, database);

        ui.launch();

    }

}
