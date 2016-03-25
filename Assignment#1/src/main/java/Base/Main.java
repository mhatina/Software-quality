package Base;

import Model.Core;
import Model.InputHandlers.InputHandler;
import Model.InputHandlers.PlayerKeyHandler;
import Model.InputHandlers.PlayerMouseHandler;
import Model.PlayerBase.Center;
import Model.PlayerBase.Direction;
import Model.PlayerBase.Player;
import Model.PlayerBase.PlayerManager;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main extends Core {
    PlayerManager manager = PlayerManager.getInstance();

    public static final int MOVE_AMOUNT = 5;

    public void init() {
        super.init();

        createWindow();
        createPlayers();
    }

    private void createPlayers() {
        manager.addPlayer(
                new Player(new Center(40,  40),
                           Direction.RIGHT,
                           new PlayerKeyHandler(KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT),
                           Color.green));
        manager.addPlayer(
                new Player(new Center(300, 220),
                           Direction.LEFT,
                           new PlayerMouseHandler(),
                           Color.yellow));
    }

    private void createWindow() {
        InputHandler inputHandler = new InputHandler();
        Window w = screenManager.getFullScreenWindow().getInstance();
        w.addKeyListener(inputHandler);
        w.addMouseListener(inputHandler);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    @Override
    public void update(long timePassed) {
        updateBorderPositionForPlayers();
        checkPlayersCollision();
        actualizePathOfPlayers();

        draw();
    }

    private void draw() {
        Graphics2D g = screenManager.getFullScreenWindow().getGraphics();
        draw(g);
        g.dispose();
        screenManager.update();
    }

    public void draw(Graphics2D g) {
        erasePlayground(g);
        drawPathOfPlayers(g);
    }

    private void drawPathOfPlayers(Graphics2D g) {
        for (Player player : manager.getPlayers()) {
            player.drawPath(g);
        }
    }

    private void erasePlayground(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, screenManager.getFullScreenWindow().getWidth(), screenManager.getFullScreenWindow().getHeight());
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
                    stop();
            }
        }
    }

    private void updateBorderPositionForPlayers() {
        for (Player player : manager.getPlayers()) {
            player.getCenter().setBorderPosition(screenManager, player.getDirection());
        }
    }
}
