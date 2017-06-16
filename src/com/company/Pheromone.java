package com.company;

import java.util.ArrayList;

/**
 * Created by Camille on 29/05/2017.
 */
public class Pheromone {
    Point point = null;

    private int score = 3000;

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
        score += 3000;
    }

    public void decreaseScore(){
        score -= 1;
    }

    public int getSize(){
        return score / 300;
    }
}
