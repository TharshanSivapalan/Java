package com.company;

import java.util.*;
import javax.swing.JFrame;


public class Simulation extends JFrame {

    private ArrayList<Fourmi> fourmis = new ArrayList<Fourmi>();
    private Map<String, Food> foods = new HashMap<>();
    private Map<String, Pheromone> pheromones = new HashMap<>();
    private Fourmiliere fourmiliere;

    int limit = 0;
    int vitessePheromone = 1;
    int nbFourmi = 1;
    int nbFood = 1;
    int scoreFood = 0;
    Food food;

    public Simulation(int taille, int nbFourmis, int nbFood, int vitessePheromone) {
        this.nbFourmi = nbFourmis;
        this.nbFood = nbFood;
        this.vitessePheromone = vitessePheromone;
        this.limit = taille;
        fourmiliere = new Fourmiliere(limit);
        this.fillFourmisList(nbFourmis);
        this.fillFoodsList(nbFood);
        this.initPheromone();
    }

    public void nextStep() {
        this.deplacement();
    }

    /**
     * init fourmis list
     * @param nbFourmis
     */
    private void fillFourmisList(int nbFourmis){
        for (int i = 0; i < nbFourmis; i++) {
            fourmis.add(new Fourmi(limit));
        }
    }

    /**
     * init foods list
     * @param nbFood
     */
    private void fillFoodsList(int nbFood){
        Random randGene = new Random();
        int x = 0;
        int y = 0;
        int score = 0;
        for (int i = 0; i < nbFood; i++) {
            x = randGene.nextInt(limit - 10) + 10;
            y = randGene.nextInt(limit - 10) + 10;
            score = randGene.nextInt(10 - 1) + 5;
            this.scoreFood += score;
            foods.put("x:"+x+"|y:"+y, new Food(new Point(x, y), score));
        }
    }

    /**
     * init pheromone
     */
    private void initPheromone(){
        for (int i = 0; i <= limit; i++){
            for (int j = 0; j <= limit; j++){
                pheromones.put("x:"+i+"|y:"+j, new Pheromone(i, j));
            }
        }
    }

    /**********************    ***********************/

    private ArrayList<Position> allPositions(Fourmi fourmi){
        ArrayList<Position> positions = new ArrayList<Position>();

        // Nord
        positions.add(new Position("N", fourmi.getPosY() - 1, fourmi.getPosX(), limit, pheromones));

        // Nord-Ouest
        positions.add(new Position("NO", fourmi.getPosY() - 1, fourmi.getPosX() + 1, limit, pheromones));

        // Ouest
        positions.add(new Position("O", fourmi.getPosY(), fourmi.getPosX() + 1, limit, pheromones));

        // Sud-Ouest
        positions.add(new Position("SO", fourmi.getPosY() + 1, fourmi.getPosX() + 1, limit, pheromones));

        // Sud
        positions.add(new Position("S", fourmi.getPosY() + 1, fourmi.getPosX(), limit, pheromones));

        // Sud-Est
        positions.add(new Position("SE", fourmi.getPosY() + 1, fourmi.getPosX() - 1, limit, pheromones));

        // Est
        positions.add(new Position("E", fourmi.getPosY(), fourmi.getPosX() - 1, limit, pheromones));

        // Nord-Est
        positions.add(new Position("NE", fourmi.getPosY() - 1, fourmi.getPosX() - 1, limit, pheromones));

        Collections.sort(positions, new Comparator<Position>() {
            @Override
            public int compare(Position p1, Position p2) {
                    return p1.compareTo(p2);
            }
        });

        int score = positions.get(0).getScore();

        Iterator<Position> i = positions.iterator();
        while (i.hasNext()) {
            Position pos = i.next();
            if(score >= 1 && pos.getScore() == 0 || pos.getScore() < 0){
                i.remove();
            }
        }

        return positions;
    }

    public boolean finishScript(){
        if (fourmiliere.getNourriture() == this.scoreFood){
            return true;
        }
        return false;
    }

    private void deplacement () {

        for (Fourmi fourmi : this.fourmis) {

            if (fourmi.getNourriture() == 0) {

                ArrayList<Position> positions = allPositions(fourmi);
                // il faut shuffle avant car l'aleatoire pas suffisant

                Random randomGenerator = new Random();
                Position newPosition = null;

                Iterator<Position> i = positions.iterator();
                while (i.hasNext()) {
                    Position pos = i.next();
                    if(pos.getName() == fourmi.getNameExPosition()){
                        newPosition = pos;
                    }
                }

                int rnd = randomGenerator.nextInt(10);

                if (rnd > 7 || newPosition == null) {
                    Collections.shuffle(positions);
                    rnd = randomGenerator.nextInt(positions.size());
                    newPosition = positions.get(rnd);
                }


                fourmi.setNameExPosition(newPosition.getName());
                fourmi.setPosX(newPosition.getX());
                fourmi.setPosY(newPosition.getY());

                checkFood(fourmi);

            } else {
                goToFourmilliere(fourmi);
            }
        }

    }

    public void checkFood(Fourmi fourmi){

        if (foods.containsKey("x:"+fourmi.getPosX()+"|y:"+fourmi.getPosY())){
            if (foods.get("x:"+fourmi.getPosX()+"|y:"+fourmi.getPosY()).noEmpty()){
                foods.get("x:"+fourmi.getPosX()+"|y:"+fourmi.getPosY()).takeNourriture();
                fourmi.setNourriture(1);
                posePheromone(fourmi);
            }
        }
    }

    public void goToFourmilliere(Fourmi fourmi) {

        if ((fourmi.getPosX() == fourmiliere.getX() || fourmi.getPosX() + 4 == fourmiliere.getX() || (fourmi.getPosX() < fourmiliere.getX() && fourmi.getPosX() + 4 > fourmiliere.getX())) &&
                (fourmi.getPosY() == fourmiliere.getY() || fourmi.getPosY() + 4 == fourmiliere.getY() || (fourmi.getPosY() < fourmiliere.getY() && fourmi.getPosY() + 4 > fourmiliere.getY()))){
            fourmiliere.addNourriture();
            fourmi.setNourriture(0);
        } else {

            // rand pour un retour moin parfait

            if (fourmiliere.getX() == fourmi.getPosX()){

                if (fourmiliere.getY() > fourmi.getPosY()){
                    fourmi.setPosY(fourmi.getPosY() + 1);
                } else if (fourmiliere.getY() < fourmi.getPosY()) {
                    fourmi.setPosY(fourmi.getPosY() - 1);
                }

            } else if (fourmiliere.getY() == fourmi.getPosY()) {

                if (fourmiliere.getX() > fourmi.getPosX()){
                    fourmi.setPosX(fourmi.getPosX() + 1);
                } else if (fourmiliere.getX() < fourmi.getPosX()) {
                    fourmi.setPosX(fourmi.getPosX() - 1);
                }

            } else {

                Random randomGenerator = new Random();
                int rnd = randomGenerator.nextInt(10);

                if (rnd >= 5){
                    if (fourmiliere.getX() > fourmi.getPosX()){
                        fourmi.setPosX(fourmi.getPosX() + 1);
                    } else if (fourmiliere.getX() < fourmi.getPosX()) {
                        fourmi.setPosX(fourmi.getPosX() - 1);
                    }
                }

                if (rnd <= 5){
                    if (fourmiliere.getY() > fourmi.getPosY()){
                        fourmi.setPosY(fourmi.getPosY() + 1);
                    } else if (fourmiliere.getY() < fourmi.getPosY()) {
                        fourmi.setPosY(fourmi.getPosY() - 1);
                    }
                }

            }


            posePheromone(fourmi);
        }
    }

    public void posePheromone(Fourmi fourmi){
        pheromones.get("x:"+fourmi.getPosX()+"|y:"+fourmi.getPosY()).increaseScore();
    }

    public ArrayList<Fourmi> getFourmis() {
        return fourmis;
    }

    public Map<String, Food> getFoods() {
        return foods;
    }

    public Fourmiliere getFourmiliere() {
        return fourmiliere;
    }

    public Map<String, Pheromone> getPheromones() {
        return pheromones;
    }
}