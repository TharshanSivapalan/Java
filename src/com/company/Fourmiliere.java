package com.company;

/**
 * Created by Camille on 27/05/2017.
 */
public class Fourmiliere {

    private int x;
    private int y;

    private int size;
    private int nourriture = 0;

    Fourmiliere(int limit){
        size = 30;
        x = y = limit - (20 + size);
    }

    public int getSize() {
        return size;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void addNourriture(){
        nourriture++;
    }
}
