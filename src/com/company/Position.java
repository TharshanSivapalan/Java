package com.company;


import java.util.ArrayList;

/**
 * Created by Camille on 26/05/2017.
 */
public class Position {

    private int score = 0;

    private String name;
    private int limit;

    private Point point;
    private Pheromone pheromone;

    Position(String name, int y, int x, int limit, ArrayList<Pheromone> pheromones){

        this.name = name;
        point = new Point(x, y);
        this.limit = limit;
        this.checkLimit();
        this.checkPheromone(pheromones);
    }

    private void checkPheromone(ArrayList<Pheromone> pheromones){
        for (Pheromone pheromone : pheromones) {
            for (Point point : pheromone.getPoints()) {
                if (point.same(getPoint())){
                    score = pheromone.getScore();
                    setPheromone(pheromone);
                }
            }
        }
    }

    private void checkLimit(){
        if (getX() <= 0 || getY() <= 0 || (getY() + 4) >= limit || (getX() + 4) >= limit) {
            score = -1;
        }
    }

    public int compareTo(Position p2){
        if (score > p2.getScore()){
            return -1;
        } else if (score < p2.getScore()){
            return 1;
        }
        return 0;
    }

    public int getY() {
        return point.getY();
    }

    public int getX() {
        return point.getX();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Point getPoint() {
        return point;
    }

    public void setPheromone(Pheromone pheromone) {
        this.pheromone = pheromone;
    }

    public Pheromone getPheromone() {
        return pheromone;
    }
}
