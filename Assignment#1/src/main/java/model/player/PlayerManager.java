package model.player;

import model.input.handlers.PlayerMouseHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by mhatina on 3/16/16.
 */
public class PlayerManager {

    private List<Player> players;
    private Player playerWithMouseHandler;

    public PlayerManager() {
        players = new ArrayList<Player>();
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public void addPlayer(Player player) throws IllegalArgumentException {
        if (player.getInputHandler() instanceof PlayerMouseHandler) {
            if (playerWithMouseHandler == null)
                playerWithMouseHandler = player;
            else
                throw new IllegalArgumentException("Only one player can be controlled by mouse");
        }

        players.add(player);
    }

    public Player getPlayerWithMouseHandler() {
        return playerWithMouseHandler;
    }
}
