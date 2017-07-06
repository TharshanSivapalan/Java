package com.company;

/**
 * Created by Camille on 26/05/2017.
 */
public class Controleur {

    boolean execute = true;
    Simulation sim = null;
    Rendu rendu = null;
    int sleepDuration;
    int taille;
    int vitessePheromone;
    int nbFourmis;
    int nbFood;

    Controleur(int taille, int sleepDuration, int vitessePheromone, int nbFourmis, int nbFood) {

        long startTime = System.currentTimeMillis();
        this.taille = taille;
        this.vitessePheromone = vitessePheromone;
        this.nbFourmis = nbFourmis;
        this.nbFood = nbFood;
        this.sleepDuration = sleepDuration;

        this.sim = new Simulation(taille, nbFourmis, nbFood, vitessePheromone);
        this.rendu = new Rendu(taille);

        while (execute) {

            sim.nextStep();

            if (sim.finishScript()){
                execute = false;
            }

            rendu.updatePaint(sim);

            try {
                Thread.sleep(sleepDuration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        new Resume(sim, (System.currentTimeMillis() - startTime));

    }
}


