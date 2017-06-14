package com.company;
import java.awt.*;
import javax.swing.JPanel;


public class Panel extends JPanel {

    Simulation sim;

    int taille;

    Panel(int taille) {
        this.taille = taille;
    }

    public void paint(Simulation sim){
        this.sim = sim;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, this.taille, this.taille);

        g.setColor(Color.green);
        for (Food food : this.sim.getFoods()) {
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
        for (Pheromone pheromone : this.sim.getPheromones()) {
            int x = pheromone.firstPoint().getX();
            int y = pheromone.firstPoint().getY();
            for (Point point : pheromone.getPoints()) {
                g.drawLine(x, y, point.getX(), point.getY());
                x = point.getX();
                y = point.getY();
            }
        }
    }


}
