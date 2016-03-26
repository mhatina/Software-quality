package model.input.handlers;

import model.player.Player;
import model.player.PlayerManager;

import java.awt.event.*;

/**
 * Created by mhatina on 3/16/16.
 */
public class InputHandler extends AInputHandler {

    PlayerManager manager;

    public InputHandler(PlayerManager manager) {
        this.manager = manager;
    }

    public void keyPressed(KeyEvent e) {
        for (Player player : manager.getPlayers())
            player.setDirection(player.getInputHandler().changeDirection(e, player.getDirection()));
    }

    public void mouseClicked(MouseEvent e) {
        Player player = manager.getPlayerWithMouseHandler();
        player.setDirection(player.getInputHandler().changeDirection(e, player.getDirection()));
    }
}
