package Presentation;

import Model.PlayerManager;
import Model.InputHandler;
import Model.Player;
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
        manager.addPlayer(new Player( 40,  40, 1, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, Color.green));
        manager.addPlayer(new Player(600, 440, 3, KeyEvent.VK_W,  KeyEvent.VK_S,    KeyEvent.VK_A,    KeyEvent.VK_D,     Color.red));
        manager.addPlayer(new Player(300, 220, 3, Color.yellow));
    }

    private void createWindow() {
        InputHandler inputHandler = new InputHandler();
        Window w = sm.getFullScreenWindow();
        w.addKeyListener(inputHandler);
        w.addMouseListener(inputHandler);
    }

    public static void main(String[] args) {
        new Main().run();
    }

    public void draw(Graphics2D g) {
        for (Player player : manager.getPlayers()) {
            setBorderPosition(sm, player);
        }

        for (Player player : manager.getPlayers()) {
            for (Player opponent : manager.getPlayers()) {
                if (player != opponent && player.hasCollided(opponent))
                    stop();
            }
        }

        for (Player player : manager.getPlayers()) {
            player.actualizePath();
        }

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, sm.getWidth(), sm.getHeight());

        for (Player player : manager.getPlayers()) {
            player.drawPath(g);
        }
    }

    public void setBorderPosition(ScreenManager sm, Player player) {
        switch (player.getCurrentDirection()) {
            case 0:
                if (player.getCenterY() > 0) {
                    player.subtractFromCenterY(Main.MOVE_AMOUNT);
                } else {
                    player.setCenterY(sm.getHeight());
                }
                break;
            case 1:
                if (player.getCenterX() < sm.getWidth()) {
                    player.addToCenterX(Main.MOVE_AMOUNT);
                } else {
                    player.setCenterX(0);
                }
                break;
            case 2:
                if (player.getCenterY() < sm.getHeight()) {
                    player.addToCenterY(Main.MOVE_AMOUNT);
                } else {
                    player.setCenterY(0);
                }
                break;
            case 3:
                if (player.getCenterX() > 0) {
                    player.subtractFromCenterX(Main.MOVE_AMOUNT);
                } else {
                    player.setCenterX(sm.getWidth());
                }
                break;
        }
    }
}
