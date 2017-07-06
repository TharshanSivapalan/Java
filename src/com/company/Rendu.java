package com.company;

import java.awt.*;
import java.util.Map;
import javax.swing.*;


public class Rendu extends JPanel {

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
        //this.panel = new Panneau();
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
        for (int i = 0; this.sim.getFoods().size() > i ; i++){
            Food food = this.sim.getFoods().get(i);
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
                g.drawOval(pheromone.getPoint().getX(), pheromone.getPoint().getY(), pheromone.getSize(), pheromone.getSize());
            }
        }

    }

}
