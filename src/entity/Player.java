package entity;

import main.Entity;

import java.awt.*;
import java.util.ArrayList;

public class Player extends Entity {

    private final Rectangle hitBox;

    private int posX;
    private int posY;
    private final int WIDTH = 50;
    private final int HEIGHT = 100;
    private final int X_SPAWN = 300;
    private final int Y_SPAWN = 200;
    private boolean keyUp;
    private boolean keyDown;
    private boolean keyRight;
    private boolean keyLeft;
    private double xspeed;
    private double yspeed;

    public Player(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        hitBox = new Rectangle(this.posX, this.posY, this.WIDTH, this.HEIGHT);
    }

    public void setKeyUp(boolean keyUp) {
        this.keyUp = keyUp;
    }

    public void setKeyDown(boolean keyDown) {
        this.keyDown = keyDown;
    }

    public void setKeyRight(boolean keyRight) {
        this.keyRight = keyRight;
    }

    public void setKeyLeft(boolean keyLeft) {
        this.keyLeft = keyLeft;
    }

    public void setYspeed(double yspeed) {
        this.yspeed = yspeed;
    }

    @Override
    public void setPos(Graphics g, ArrayList<Entity> entities) {

        if (!keyLeft && !keyRight || keyLeft && keyRight) {
            xspeed *= 0.8;
        } else if (keyLeft) {
            xspeed--;
        } else if (keyRight) {
            xspeed++;
        }

        if (-0.75 < xspeed && xspeed < 0.75) {
            xspeed = 0;
        }

        if (xspeed > 7) {
            xspeed = 7;
        }

        if (xspeed < -7) {
            xspeed = -7;
        }

        if (keyUp) {
            hitBox.y++;
            for (Entity entity : entities) {
                if (entity.getHitBox().intersects(hitBox)) {
                    yspeed = -10;
                }
            }
            hitBox.y--;
        }

        yspeed += 0.6;

        // Horizontal collision

        hitBox.x += xspeed;
        for (Entity entity : entities) {
            if (hitBox.intersects(entity.getHitBox())) {
                hitBox.x -= xspeed;
                while (!entity.getHitBox().intersects(hitBox)) {
                    hitBox.x += Math.signum(xspeed);
                }
                hitBox.x -= Math.signum(xspeed);
                xspeed = 0;
                posX = hitBox.x;
            }
        }

        // Vertical collision

        hitBox.y += yspeed;
        for (Entity entity : entities) {
            if (hitBox.intersects(entity.getHitBox())) {
                hitBox.y -= yspeed;
                while (!entity.getHitBox().intersects(hitBox)) {
                    hitBox.y += Math.signum(yspeed);
                }
                hitBox.y -= Math.signum(yspeed);
                yspeed = 0;
                posY = hitBox.y;
            }
        }



        for (Entity entity : entities) {

            // Respawn

            if (entity.getClass() == Floor.class && hitBox.y > entity.getHitBox().y + entity.getHeight()) {
                posX = X_SPAWN;
                posY = Y_SPAWN;
            }

            // Turbine

            if (entity.getClass() == Turbine.class
                    && hitBox.y < entity.getHitBox().y
                    && hitBox.x + WIDTH > entity.getHitBox().x
                    && hitBox.x < entity.getHitBox().x + entity.getHitBox().width
            ) {
                yspeed = -10;
                if (hitBox.y < 0) {
                    yspeed = 0.6;
                }
            }

            hitBox.y += yspeed;
            if (hitBox.intersects(entity.getHitBox())) {
                hitBox.y -= yspeed;
                while (!entity.getHitBox().intersects(hitBox)) {
                    hitBox.y += Math.signum(yspeed);
                }

                // Spring

                if (entity.getClass() == Spring.class
                        && hitBox.y < entity.getHitBox().y
                        && hitBox.x + WIDTH > entity.getHitBox().x
                        && hitBox.x < entity.getHitBox().x + entity.getHitBox().width
                ) {
                    hitBox.y += yspeed;
                    if (hitBox.intersects(entity.getHitBox())) {
                        hitBox.y -= yspeed;
                        while (!entity.getHitBox().intersects(hitBox)) {
                            hitBox.y += Math.signum(yspeed);
                        }
                        hitBox.y -= Math.signum(yspeed);
                        yspeed = -17;
                        posY = hitBox.y;
                    }
                    if (hitBox.y < 0) {
                        yspeed = 0.6;
                    }
                }
            }
        }

        posX += xspeed;
        posY += yspeed;

        hitBox.x = posX;
        hitBox.y = posY;

//        g.setColor(Color.PINK);
//        g.drawRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
        g.setColor(Color.ORANGE);
//        g.fillRect(hitBox.x + 1, hitBox.y + 1, WIDTH - 1, HEIGHT - 1);
        g.fillRect(hitBox.x, hitBox.y, WIDTH, HEIGHT);
    }
}
