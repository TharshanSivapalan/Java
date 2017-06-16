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
    private String nameExPosition = "";

    Fourmi (int limit){
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

    public Point getPoint() {
        return point;
    }

    public String getNameExPosition(){
        return nameExPosition;
    }

    public void setNameExPosition(String nameExPosition){
        this.nameExPosition = nameExPosition;
    }


}
