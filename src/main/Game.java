package main;

public class Game {

    private GameWindow gameWindow;
    private GamePanel gamePanel;

    public Game(){
        //instantiate objects gamePanel
        gamePanel = new GamePanel();
        //instantiate objects gameWindow
        gameWindow = new GameWindow(gamePanel);
    }
}
