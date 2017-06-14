package com.company;

import java.util.Random;

/**
 * Created by Camille on 26/05/2017.
 */
public class Food {

    private int size;

    private int x;
    private int y;

    private Pheromone pheromone = null;

    Food(int limit) {
        Random randomGenerator = new Random();

        this.x = randomGenerator.nextInt(limit - 10) + 10;
        this.y = randomGenerator.nextInt(limit - 10) + 10;
        size = randomGenerator.nextInt(10 - 1) + 5;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void takeNourriture(){
        size--;
    }

    public Pheromone getPheromone() {
        return pheromone;
    }

    public void setPheromone(Pheromone pheromone) {
        this.pheromone = pheromone;
    }
}
