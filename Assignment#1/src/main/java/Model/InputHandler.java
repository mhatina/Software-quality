package Model;

import java.awt.event.*;

/**
 * Created by mhatina on 3/16/16.
 */
public class InputHandler implements KeyListener, MouseListener {

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        for (Player player : PlayerManager.getInstance().getPlayers())
            player.getInputHandler().handle(e);
    }

    public void keyReleased(KeyEvent e) {

    }

    public void mouseClicked(MouseEvent e) {
        PlayerManager.getInstance().getPlayerWithMouseHandler().getInputHandler().handle(e);
    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {

    }

    public void mouseExited(MouseEvent e) {

    }
}
