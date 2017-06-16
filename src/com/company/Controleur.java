package com.company;

/**
 * Created by Camille on 26/05/2017.
 */
public class Controleur {

    Controleur(int taille, int sleepDuration, int vitessePheromone, int nbFourmis, int nbFood) {

        Simulation sim = new Simulation(taille, nbFourmis, nbFood, vitessePheromone);

        Rendu rendu = new Rendu(taille);

        boolean execute = true;

        while (execute) {

            sim.nextStep();

            if (!sim.hasFood()){
                execute = false;
            }

            rendu.paint(sim);

            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}


