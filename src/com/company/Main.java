package com.company;

import java.awt.*;

public class Main {

    public static void main(String[] args) {

        int taille = 500;
        int sleepDuration = 1;
        int vitessePheromone = 4;
        int nbFourmis = 10000;
        int nbFood = 5;
        new Controleur(taille, sleepDuration, vitessePheromone, nbFourmis, nbFood);


        //fen.setVisible(true);
        //FenetreMenu fen = new FenetreMenu();



    }
}
