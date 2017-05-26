package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Camille on 26/05/2017.
 */
public class Fourmi extends JPanel{

    private int posX = 0;
    private int posY = 0;

    public void paintComponent(Graphics g) {

        // On décide d'une couleur de fond pour notre rectangle

        g.setColor(Color.white);

        // On dessine celui-ci afin qu'il prenne tout la surface

        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        // On redéfinit une couleur pour notre rond

        g.setColor(Color.blue);

        // On le dessine aux coordonnées souhaitées

        g.fillRect(posX, posY, 2, 2);

    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }
}
