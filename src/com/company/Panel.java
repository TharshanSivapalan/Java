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

        for (Fourmi fourmi : this.sim.getFourmis()) {
            g.drawRect(fourmi.getPosX(), fourmi.getPosY(), fourmi.getWitdh(), fourmi.getHeight());
        }
    }


}
