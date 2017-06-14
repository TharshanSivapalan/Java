package com.company;

public class Main {

    public static void main(String[] args) {

        int taille = 700;
        int sleepDuration = 3;
        int vitessePheromone = 3;
        int nbFourmis = 10;
        int nbFood = 7;

        Controleur contro = new Controleur(taille, sleepDuration, vitessePheromone, nbFourmis, nbFood);

    }
}
