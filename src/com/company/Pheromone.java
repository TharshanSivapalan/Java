package com.company;

import java.util.ArrayList;

/**
 * Created by Camille on 29/05/2017.
 */
public class Pheromone {
    ArrayList<Point> points = new ArrayList<Point>();

    private boolean gone = false;
    private int score = 1;

    Pheromone (int x, int y){
        addPoint(x, y);
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public Point firstPoint(){
        return points.get(0);
    }

    public void addPoint(int x, int y){
        points.add(new Point(x, y));
    }

    public void setGone(boolean gone) {
        this.gone = gone;
    }

    public boolean isGone() {
        return gone;
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
