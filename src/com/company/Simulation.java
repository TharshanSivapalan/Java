package com.company;
import java.util.ArrayList;
import javax.swing.JFrame;


public class Simulation extends JFrame {

    private ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();

    int limit = 0;

    int vitessePheromone = 3;

    int nbFourmis = 3;

    int nbFood = 3;

    public Simulation(int taille, int nbFourmis, int nbFood, int vitesseExploration) {

        this.limit = taille;
        this.fillFourmisList(nbFourmis);
    }

    public void nextStep() {

    }

    private void fillFourmisList(int nbFourmis){
        for (int i = 0; i < nbFourmis; i++) {
            Fourmi fourm = new Fourmi();
            fourmis.add(fourm);
        }
    }


    private void deplacement (ArrayList<Fourmi> fourmis) {

    }

}