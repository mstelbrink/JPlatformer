package main;

import entity.*;
import entity.Spring;
import input.KeyHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    private Player player;
    private Floor floor;
    private Wall wall;
    private entity.Spring spring;
    private Turbine turbine;
    private Goal goal;
    private ArrayList<Entity> entities;

    public GamePanel() {
        setLevel1();
        KeyHandler keyHandler = new KeyHandler();
        keyHandler.initialise(player);
        addKeyListener(keyHandler);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawLevel1(g);
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        revalidate();
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }

    private void setLevel1() {
        entities = new ArrayList<>();
        player = new Player(300, 200);
        floor = new Floor(100, 500, 600, 50);
        wall = new Wall(150, 350, 50, 150);
        spring = new Spring(500, 450, 50, 50);
        turbine = new Turbine(600, 450, 50, 50);
        goal = new Goal(200, 450);

        entities.add(floor);
        entities.add(wall);
        entities.add(spring);
        entities.add(turbine);
        entities.add(goal);
    }

    private void drawLevel1(Graphics g) {
        player.setPos(g, entities);
        floor.setPos(g, entities);
        wall.setPos(g, entities);
        spring.setPos(g, entities);
        turbine.setPos(g, entities);
        goal.setPos(g, entities);
    }
}
