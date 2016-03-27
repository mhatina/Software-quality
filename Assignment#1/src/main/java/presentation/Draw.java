package presentation;

import model.player.Player;

import java.awt.*;
import java.util.List;

/**
 * Created by mhatina on 3/26/16.
 */
public class Draw {
    private static void drawPlayerPath(Player player, Graphics2D graphics) {
        for (int i = 0; i < player.getPath().size(); i++) {
            graphics.setColor(player.getColor());
            graphics.fillRect(player.getPath().get(i).getX(), player.getPath().get(i).getY(), 10, 10);
        }
    }

    private static void erasePlayground(Graphics2D graphics, Bounds bounds) {
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, bounds.getWidth(), bounds.getHeight());
    }

    public static void drawPlayground(FullScreenWindow window, List<Player> players) {
        Graphics2D graphics = window.getGraphics();
        Draw.erasePlayground(graphics, window);
        for (Player player : players) {
            Draw.drawPlayerPath(player, graphics);
        }
        graphics.dispose();
    }
}
