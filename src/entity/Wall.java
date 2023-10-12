package entity;

import main.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Wall extends Entity {
    private int WIDTH;
    private int HEIGHT;
    private Rectangle hitBox;

    private Color borderColor;
    private Color color;

    public Wall(int posX, int posY, final int WIDTH, final int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        borderColor = new Color(50, 30, 0);
        color = new Color(70, 50, 0);
        hitBox = new Rectangle(posX, posY, WIDTH, HEIGHT);
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

    @Override
    public void setPos(Graphics g, ArrayList<Entity> entities) {
//        g.setColor(borderColor);
//        g.drawRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
        g.setColor(color);
//        g.fillRect(hitBox.x + 1, hitBox.y + 1, WIDTH - 1, HEIGHT - 1);
        g.fillRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
    }
}
