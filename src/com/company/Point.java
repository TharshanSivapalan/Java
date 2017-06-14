package com.company;

/**
 * Created by Camille on 29/05/2017.
 */
public class Point {

    private int x;
    private int y;


    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean same(Point e){
        return (e.getX() == x && e.getY() == y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }
}
