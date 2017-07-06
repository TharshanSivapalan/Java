package com.company;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.*;
import javax.swing.*;


public class Rendu extends JPanel{

    private JFrame frame;
    Simulation sim;
    int taille;
    private Container contenu;

    Rendu(int taille){

        this.taille = taille;

        this.frame = new JFrame();
        this.frame.setTitle("La fourmilière");
        this.frame.setSize(this.taille, this.taille);

        this.contenu = this.frame.getContentPane();
        contenu.add(this);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setVisible(true);
    }

    public void updatePaint(Simulation sim){
        this.sim = sim;
        this.repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0, 0, this.taille, this.taille);

        g.setColor(Color.green);
        for(Map.Entry<String, Food> entry : this.sim.getFoods().entrySet()) {
            Food food = entry.getValue();
            g.drawOval(food.getX(), food.getY(), food.getSize(), food.getSize());
        }

        g.setColor(Color.black);
        Fourmiliere fourmiliere= this.sim.getFourmiliere();
        g.drawRect(fourmiliere.getX(), fourmiliere.getY(), fourmiliere.getSize(), fourmiliere.getSize());

        g.setColor(Color.blue);
        for (Fourmi fourmi : this.sim.getFourmis()) {
            g.drawRect(fourmi.getPosX(), fourmi.getPosY(), fourmi.getWitdh(), fourmi.getHeight());
        }

        g.setColor(Color.red);
        for(Map.Entry<String, Pheromone> entry : this.sim.getPheromones().entrySet()) {
            Pheromone pheromone = entry.getValue();

            if (pheromone.isDisplay()){
                pheromone.decreaseScore( this.sim.vitessePheromone);
                g.drawOval(pheromone.getPoint().getX(), pheromone.getPoint().getY(), pheromone.getSize(), pheromone.getSize());
            }
        }

    }

}
