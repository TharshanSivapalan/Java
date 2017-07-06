package com.company;

import java.util.ArrayList;

/**
 * Created by Camille on 29/05/2017.
 */
public class Pheromone {
    Point point = null;

    private int score = 1000;
    private boolean display = true;

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
        if (score < 5000) {
            score += 1000;
        }
    }

    public void decreaseScore(int vitessePheromone){
        score -= vitessePheromone;
    }

    public int getSize(){
        return score / 100;
    }

    public boolean isDisplay() {
        return display;
    }

    public void display(){
        display = true;
    }

    public void displayNone(){
        display = false;
    }
}
