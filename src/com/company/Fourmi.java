package com.company;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Camille on 26/05/2017.
 */
public class Fourmi{

    private Point point = null;

    private int witdh = 4;
    private int height = 4;

    private int nourriture = 0;

    private Fourmiliere fourmiliere;

    Fourmi (Fourmiliere fourmiliere, int limit){
        this.fourmiliere = fourmiliere;
        Random randGene = new Random();

        this.point = new Point(randGene.nextInt(limit - 10) + 10, randGene.nextInt(limit - 10) + 10);
    }


    public int getPosX() {
        return point.getX();
    }

    public void setPosX(int posX) {
        this.point.setX(posX);
    }

    public int getPosY() {
        return point.getY();
    }

    public void setPosY(int posY) {
        this.point.setY(posY);
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

    public boolean isFourmiliere(){
        return (getPosX() == fourmiliere.getX() || getPosX() + 4 == fourmiliere.getX() || (getPosX() < fourmiliere.getX() && getPosX() + 4 > fourmiliere.getX())) &&
                (getPosY() == fourmiliere.getY() || getPosY() + 4 == fourmiliere.getY() || (getPosY() < fourmiliere.getY() && getPosY() + 4 > fourmiliere.getY()));
    }
}
