package com.company;

import java.util.Random;

/**
 * Created by Camille on 26/05/2017.
 */
public class Food {

    private int size;

    private Point point = null;

    Food(int limit) {
        Random randGene = new Random();

        point = new Point(randGene.nextInt(limit - 10) + 10, randGene.nextInt(limit - 10) + 10);
        size = randGene.nextInt(10 - 1) + 5;
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

    public void takeNourriture(){
        size--;
    }
}
