package com.company;

import java.util.Random;

/**
 * Created by Camille on 26/05/2017.
 */
public class Food {

    private int size;

    private Point point = null;

    Food(Point point, int size) {
        this.point = point;
        this.size = size;
    }

    public int getX() {
        return point.getX();
    }

    public int getY() {
        return point.getY();
    }

    public int getSize() {
        return size;
    }

    public boolean noEmpty(){
        return this.size > 0;
    }

    public void takeNourriture(){
        size--;
    }
}
