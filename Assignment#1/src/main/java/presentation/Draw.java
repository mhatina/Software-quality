package presentation;

import model.player.Player;

import java.awt.*;
import java.util.List;

/**
 * Created by mhatina on 3/26/16.
 */
public class Draw {
    private static void drawPlayerPath(Player player, Graphics2D g) {
        for (int i = 0; i < player.getPath().size(); i++) {
            g.setColor(player.getColor());
            g.fillRect(player.getPath().get(i).getX(), player.getPath().get(i).getY(), 10, 10);
        }
    }

    private static void erasePlayground(Graphics2D g, Bounds bounds) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, bounds.getWidth(), bounds.getHeight());
    }

    public static void drawPlayground(FullScreenWindow window, List<Player> players) {
        Graphics2D g = window.getGraphics();
        Draw.erasePlayground(g, window);
        for (Player player : players) {
            Draw.drawPlayerPath(player, g);
        }
        g.dispose();
    }
}
