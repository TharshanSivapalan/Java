package com.company;

public class Main {

    public static void main(String[] args) {

        int taille = 1000;
        int sleepDuration = 3;
        int vitessePheromone = 10;
        int nbFourmis = 1000;
        int nbFood = 10;

        Controleur contro = new Controleur(taille, sleepDuration, vitessePheromone, nbFourmis, nbFood);

    }
}
