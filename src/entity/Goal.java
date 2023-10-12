package entity;

import main.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Goal extends Entity {

    private final int WIDTH = 50;
    private final int HEIGHT = 50;

    private Rectangle hitBox;

    public Rectangle getHitBox() {
        return hitBox;
    }

    public Goal(int posX, int posY) {
        hitBox = new Rectangle(posX, posY, WIDTH, HEIGHT);
    }

    @Override
    public void setPos(Graphics g, ArrayList<Entity> entities) {
        g.setColor(Color.BLUE);
        g.fillRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
    }
}
