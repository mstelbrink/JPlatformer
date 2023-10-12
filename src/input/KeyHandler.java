package input;

import entity.Player;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

    private Player player;

    public void initialise(Player player) {
        this.player = player;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
        if (e.getKeyChar() == 'w') player.setKeyUp(true);
        if (e.getKeyChar() == 'a') player.setKeyLeft(true);
        if (e.getKeyChar() == 's') player.setKeyDown(true);
        if (e.getKeyChar() == 'd') player.setKeyRight(true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
        if (e.getKeyChar() == 'w') player.setKeyUp(false);
        if (e.getKeyChar() == 'a') player.setKeyLeft(false);
        if (e.getKeyChar() == 's') player.setKeyDown(false);
        if (e.getKeyChar() == 'd') player.setKeyRight(false);
    }
}
