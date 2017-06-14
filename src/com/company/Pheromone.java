package com.company;

import java.util.ArrayList;

/**
 * Created by Camille on 29/05/2017.
 */
public class Pheromone {
    Point point = null;

    private int score = 1;

    Pheromone (int x, int y){
        point = new Point(x, y);
    }

    public Point getPoint() {
        return point;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void increaseScore(){
        score++;
    }
}
