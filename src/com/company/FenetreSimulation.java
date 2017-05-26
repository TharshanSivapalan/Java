package com.company;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;


public class FenetreSimulation extends JFrame {

    private ArrayList<Fourmi> fourmis;

    int limit = 0;

    int vitesseExploration = 3;

    int vitessePheromone = 3;

    int nbFourmis = 3;

    int nbFood = 3;

    public FenetreSimulation(int taille, int nbFourmis, int nbFood, int vitesseExploration) {

        this.limit = taille;
        this.setTitle("Simulation fourmis");
        this.setSize(taille, taille);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        // Generate list of fourmis
        this.generateFourmis(nbFourmis);

        this.setVisible(true);

        this.run();
    }

    private void generateFourmis(int nbFourmis){
        for (int i = 0; i < nbFourmis; i++) {
            Fourmi fourm = new Fourmi();
            this.setContentPane(fourm);
            fourmis.add(fourm);
        }
    }


    public void run() {

        int x = pan.getPosX(), y = pan.getPosY();

        boolean backX = false;

        boolean backY = false;

        int rand = (int)( Math.random()*( 8 - 1 + 1 ) ) + 1;

        while (true) {

            pan.repaint();

            try {
                Thread.sleep(vitesseExploration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }


    private void deplacement (ArrayList<Fourmi> fourmis) {
        if (x < 1)
            backX = false;

        if (x > pan.getWidth() - 2)
            backX = true;

        if (y < 1)
            backY = false;
        if (y > pan.getHeight() - 2)
            backY = true;

        if (!backX)
            pan.setPosX(++x);
        else
            pan.setPosX(--x);

        if (!backY)
            pan.setPosY(++y);
        else
            pan.setPosY(--y);
    }

}