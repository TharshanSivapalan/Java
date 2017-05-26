package com.company;

public class Main {

    public static void main(String[] args) {

        int taille = 400;
        int sleepDuration = 3;
        int vitessePheromone = 3;
        int nbFourmis = 10;
        int nbFood = 3;

        Controleur contro = new Controleur(taille, sleepDuration, vitessePheromone, nbFourmis, nbFood);

    }
}
