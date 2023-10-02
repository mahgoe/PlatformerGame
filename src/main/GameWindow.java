package main;

import javax.swing.*;

public class GameWindow {

    private JFrame jframe;

    /**
     * Main Frame/Window for the game
     *
     * @param gamePanel Adding the GamePanel to the GameWindow to assemble them
     *
     */
    public GameWindow (GamePanel gamePanel){
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding the gamePanel
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        //set the window in the center of the screen
        jframe.setLocationRelativeTo(null);
        //is by default == false and put it everytime on bottom --> or you get always black screens
        jframe.setVisible(true);
    }
}
