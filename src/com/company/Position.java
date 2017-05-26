package com.company;


/**
 * Created by Camille on 26/05/2017.
 */
public class Position {

    private int score = 0;

    private String name;

    private int y;
    private int x;

    Position(String name, int y, int x){

        this.name = name;
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
