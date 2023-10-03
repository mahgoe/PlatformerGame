package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;
import static utilz.Constants.Directions.*;

public class GamePanel extends JPanel {

    /*
    Section for class fields/attributes
     */
    private MouseInputs mouseInputs;
    private Game game;

    public GamePanel(Game game) {
        mouseInputs = new MouseInputs(this);
        this.game = game;

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    /**
     * Function to set the panel size
     */
    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
    }

    /**
     * Function Update for Game.java
     */
    public void updateGame(){

    }

    /**
     * paintComponent
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g){
        //calling super class
        super.paintComponent(g);
        game.render(g);
    }

    public Game getGame(){
        return game;
    }
}
