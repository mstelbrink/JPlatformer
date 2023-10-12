package entity;

import main.Entity;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Spring extends Entity {
    private int WIDTH;
    private int HEIGHT;
    private Rectangle hitBox;
    private ImageIcon imageIcon;

    public Spring(int posX, int posY, final int WIDTH, final int HEIGHT) {
        this.WIDTH = WIDTH;
        this.HEIGHT = HEIGHT;
        imageIcon = new ImageIcon("resources/spring.png");
        Image image = imageIcon.getImage();
        Image temp = image.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        imageIcon = new ImageIcon(temp);
        hitBox = new Rectangle(posX, posY, WIDTH, HEIGHT);
    }

    @Override
    public Rectangle getHitBox() {
        return hitBox;
    }

    @Override
    public void setPos(Graphics g, ArrayList<Entity> entities) {
        g.drawImage(imageIcon.getImage(), hitBox.x, hitBox.y, null);
    }
}
