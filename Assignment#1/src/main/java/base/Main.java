package base;

import model.Core;
import model.input.handlers.InputHandler;
import model.input.handlers.PlayerKeyHandler;
import model.input.handlers.PlayerMouseHandler;
import model.player.Direction;
import model.player.Player;
import model.player.PlayerManager;
import model.player.Position;
import presentation.Draw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.function.Function;

public class Main {
    PlayerManager manager;
    Core gameCore;

    public static final int MOVE_AMOUNT = 5;

    public void init() {
        manager = new PlayerManager();
        gameCore = new Core();
        gameCore.init();

        gameCore.setUpdateFunction(new Update());
        setListeners();
        createPlayers();
    }

    private void setListeners() {
        InputHandler inputHandler = new InputHandler(manager);
        gameCore.setKeyListener(inputHandler);
        gameCore.setMouseListener(inputHandler);
    }

    private void createPlayers() {
        manager.addPlayer(
                new Player(new Position(40,  40),
                           Direction.RIGHT,
                           new PlayerKeyHandler(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT),
                           Color.green));
        manager.addPlayer(
                new Player(new Position(300, 220),
                           Direction.LEFT,
                           new PlayerMouseHandler(),
                           Color.yellow));
    }

    public void run() throws Exception {
        gameCore.run();
    }

    private void actualizePathOfPlayers() {
        for (Player player : manager.getPlayers()) {
            player.actualizePath();
        }
    }

    private void checkPlayersCollision() {
        for (Player player : manager.getPlayers()) {
            for (Player opponent : manager.getPlayers()) {
                if (player != opponent && player.hasCollided(opponent))
                    gameCore.stop();
            }
        }
    }

    private void movePlayers() {
        for (Player player : manager.getPlayers()) {
            player.moveInDirection(gameCore.getFullScreenWindow());
        }
    }

    public static void main(String[] args) {
        try {
            Main tron = new Main();
            tron.init();
            tron.run();
            tron.exit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void exit() {
        System.exit(0);
    }

    public class Update implements Function<Long, Void> {

        public Void apply(Long aLong) {
            movePlayers();
            checkPlayersCollision();
            actualizePathOfPlayers();

            Draw.drawPlayground(gameCore.getFullScreenWindow(), manager.getPlayers());

            return null;
        }
    }
}
