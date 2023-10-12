package main;

import javax.swing.*;

public class Game {

    private Timer timer;
    private final int FPS = 60;
    private final int DELAY = 1000 / FPS;

    private GameWindow gameWindow;

    private GamePanel gamePanel;

    public Game() {

        gamePanel = new GamePanel();
        gameWindow = new GameWindow();
        gameWindow.add(gamePanel);
        gamePanel.requestFocus();
        timer = new Timer(DELAY, gamePanel);
        timer.start();
    }
}
