package com.company;

import java.awt.Graphics;
import javax.swing.*;


public class Rendu extends JFrame {

    Panel panel = new Panel();

    Rendu(int taille){

        this.setTitle("Simulation fourmis");
        this.setSize(taille, taille);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setContentPane(panel);
        this.setVisible(true);
    }

    public void paint(Simulation sim) {
        panel.paint(sim);
    }

}
