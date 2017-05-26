package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import javax.swing.JFrame;


public class Simulation extends JFrame {

    private ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();

    int limit = 0;

    int vitessePheromone = 3;

    int nbFourmis = 5;

    int nbFood = 3;

    public Simulation(int taille, int nbFourmis, int nbFood, int vitesseExploration) {

        this.limit = taille;
        this.fillFourmisList(nbFourmis);
    }

    public void nextStep() {
        this.deplacement();
    }

    private void fillFourmisList(int nbFourmis){
        for (int i = 0; i < nbFourmis; i++) {
            Fourmi fourm = new Fourmi();
            fourmis.add(fourm);
        }
    }

    private boolean positionIsGood(Position position){
        if (    position.getX() <= 0 ||
                position.getY() <= 0 ||
                (position.getY() + 4) >= limit ||
                (position.getX() + 4) >= limit) {
            return false;
        }
        return true;
    }

    private ArrayList<Position> allPositions(Fourmi fourmi){
        ArrayList<Position> positions = new ArrayList<Position>();

        Position position;

        // Nord
        position = new Position("N", fourmi.getPosY() - 1, fourmi.getPosX());
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Nord-Ouest
        position = new Position("NO", fourmi.getPosY() - 1, fourmi.getPosX() + 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Ouest
        position = new Position("O", fourmi.getPosY(), fourmi.getPosX() + 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Sud-Ouest
        position = new Position("SO", fourmi.getPosY() + 1, fourmi.getPosX() + 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Sud
        position = new Position("S", fourmi.getPosY() + 1, fourmi.getPosX());
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Sud-Est
        position = new Position("SE", fourmi.getPosY() + 1, fourmi.getPosX() - 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Est
        position = new Position("E", fourmi.getPosY(), fourmi.getPosX() - 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }
        // Nord-Est
        position = new Position("NE", fourmi.getPosY() - 1, fourmi.getPosX() - 1);
        if (positionIsGood(position)) {
            positions.add(position);
        }

        return positions;
    }


    private void deplacement () {

        for (Fourmi fourmi : this.fourmis) {

            ArrayList<Position> positions = allPositions(fourmi);

            // il faut shuffle avant car l'aleatoire pas suffisant
            Collections.shuffle(positions);
            Random randomGenerator = new Random();
            int rnd = randomGenerator.nextInt(positions.size() - 1);

            Position newPosition = positions.get(rnd);

            System.out.println(rnd);
            System.out.println(newPosition.getX());
            System.out.println(newPosition.getY());

            fourmi.setPosX(newPosition.getX());
            fourmi.setPosY(newPosition.getY());

        }

    }

    public ArrayList<Fourmi> getFourmis() {
        return fourmis;
    }

}