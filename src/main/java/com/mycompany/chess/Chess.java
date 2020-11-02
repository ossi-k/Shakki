package com.mycompany.chess;

import java.util.Scanner;
import java.sql.*;

public class Chess {

    public static void main(String[] args) {
        /*Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:chess.db");

            System.out.println("Opened database successfully");

            stmt = c.createStatement();

            //Create a new victory book keeping table, if it doesn't exist
            String query = "CREATE TABLE IF NOT EXISTS WINHISTORY "
                    + "(GAME INT PRIMARY KEY NOT NULL,"
                    + "WINNER CHAR(50));";
            stmt.executeUpdate(query);

            //Select the max game number, increment it by one and insert the
            //incremented value into the table
            String select = "SELECT MAX(GAME)AS GAME FROM WINHISTORY;";
            ResultSet maxGame = stmt.executeQuery(select);
            int nextGameNumber = maxGame.getInt("GAME") + 1;
            String newGame = "INSERT INTO WINHISTORY (GAME) "
                    + "VALUES (" + nextGameNumber + ");";
            stmt.executeUpdate(newGame);

            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }

        System.out.println("Table created successfully");*/
        
        Database database = new Database();
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        UserInterface ui = new UserInterface(board, scanner, database);

        ui.launch();

    }

}
