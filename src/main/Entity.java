package main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Entity extends JPanel {

    private Rectangle hitBox;

    public Rectangle getHitBox() {
        return hitBox;
    }

    public abstract void setPos(Graphics g, ArrayList<Entity> entities);
}
