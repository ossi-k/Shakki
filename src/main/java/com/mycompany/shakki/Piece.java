/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shakki;

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
        return color + " " +  name + " ";
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
}
