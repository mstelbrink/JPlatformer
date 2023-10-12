package entity;

import main.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Floor extends Entity {

    private final int WIDTH;
    private final int HEIGHT;
    private final Color color;

    public Rectangle getHitBox() {
        return hitBox;
    }

    private final Rectangle hitBox;

    public Floor(int posX, int posY, final int WIDTH, final int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        hitBox = new Rectangle(posX, posY, WIDTH, HEIGHT);
        color = new Color(0, 80, 0);
    }

    public void setPos(Graphics g, ArrayList<Entity> entities) {
        g.setColor(color);
        g.fillRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
    }
}
