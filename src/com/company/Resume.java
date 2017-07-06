package com.company;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.* ;
import javax.swing.*;


public class Resume extends JPanel {

    private JFrame frame;
    Simulation sim;
    int taille;
    private Container contenu;

    Resume(Simulation sim, Long time){

        this.sim = sim;
        this.taille = 500;

        this.frame = new JFrame();
        this.frame.setTitle("La fourmilière");
        this.frame.setSize(this.taille, this.taille);

        this.contenu = this.frame.getContentPane();
        contenu.add(this);

        JLabel jlabel = new JLabel("Taille fenêtre : " + this.sim.limit);
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel("Nombre de fourmis : " + this.sim.nbFourmi );
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel("Nombre de nourriture : " + this.sim.nbFood );
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel("Total score food : " + this.sim.scoreFood );
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel("Vitesse de propagation : " + this.sim.vitessePheromone );
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel("Temps total d'execution : ");
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);

        jlabel = new JLabel( (time / 1000 / 60) + " Min   " +(time / 1000 % 60)+ " Sec ");
        jlabel.setFont(new Font("Verdana",1,20));
        this.add(jlabel);


        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.frame.setVisible(true);
    }

}