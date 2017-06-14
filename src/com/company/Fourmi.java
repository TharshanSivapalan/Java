package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Camille on 26/05/2017.
 */
public class Fourmi{

    private int posX = 50;
    private int posY = 50;

    private int witdh = 4;
    private int height = 4;

    private int nourriture = 0;
    private int direction;

    private Fourmiliere fourmiliere;

    private Pheromone pheromone = null;

    Fourmi (Fourmiliere fourmiliere){
        this.fourmiliere = fourmiliere;
    }


    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getWitdh() {
        return witdh;
    }

    public void setWitdh(int witdh) {
        this.witdh = witdh;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNourriture(int nourriture) {
        this.nourriture = nourriture;
    }


    public int getNourriture() {
        return nourriture;
    }

    public Pheromone getPheromone() {
        return pheromone;
    }

    public void setPheromone(Pheromone pheromone) {
        this.pheromone = pheromone;
    }

    public int getDirection() {
        return direction;
    }

    public void choiceDirection(){
        Random randomGenerator = new Random();
        direction = randomGenerator.nextInt(2);
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void followPheromone(){
        Point pointFourmi = new Point(posX, posY);
        int index = 0;

        for (Point point: pheromone.getPoints()) {
            if (point.same(pointFourmi)){
                index = pheromone.getPoints().indexOf(point);
            }
        }

        if (direction == 1 && index > 0){
            index--;
        } else if(direction == 0 && pheromone.getPoints().size() > index + 1) {
            index++;
        } else {
            choiceDirection();
        }

        posX = pheromone.getPoints().get(index).getX();
        posY = pheromone.getPoints().get(index).getY();

        if (isFourmiliere()){
         nourriture = 0;
         fourmiliere.addNourriture();
        }
    }

    public boolean isFourmiliere(){
        return fourmiliere.getX() == posX && fourmiliere.getY() == posY;

    }
}
