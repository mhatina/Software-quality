package Model.InputHandlers;

import Model.PlayerBase.Player;
import Model.PlayerBase.PlayerManager;

import java.awt.event.*;

/**
 * Created by mhatina on 3/16/16.
 */
public class InputHandler extends AInputHandler {

    public void keyPressed(KeyEvent e) {
        for (Player player : PlayerManager.getInstance().getPlayers())
            player.setDirection(player.getInputHandler().changeDirection(e, player.getDirection()));
    }

    public void mouseClicked(MouseEvent e) {
        Player player = PlayerManager.getInstance().getPlayerWithMouseHandler();
        player.setDirection(player.getInputHandler().changeDirection(e, player.getDirection()));
    }
}
