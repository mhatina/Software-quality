package presentation;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScreenManager {

    private static final DisplayMode modes[] =
    {
            //new DisplayMode(1920,1080,32,0),
            new DisplayMode(1680, 1050, 32, 0),
            //new DisplayMode(1280,1024,32,0),
            new DisplayMode(800, 600, 32, 0),
            new DisplayMode(800, 600, 24, 0),
            new DisplayMode(800, 600, 16, 0),
            new DisplayMode(640, 480, 32, 0),
            new DisplayMode(640, 480, 24, 0),
            new DisplayMode(640, 480, 16, 0),
    };

    FullScreenWindow window;

    public ScreenManager() {
        GraphicsEnvironment localGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        window = new FullScreenWindow(localGraphicsEnvironment.getDefaultScreenDevice());
    }

    public void hideCursor() {
        window.getInstance().setCursor(
                window.getInstance().getToolkit().createCustomCursor(
                        new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB), new Point(0, 0), "null"));
    }

    public void toggleFullScreen() {
        window.setFullScreen(findFirstCompatibleMode(modes));
    }

    public DisplayMode findFirstCompatibleMode(DisplayMode[] modes) {

        DisplayMode goodModes[] = window.getGraphicsDevice().getDisplayModes();
        for (int x = 0; x < modes.length; x++) {
            for (int y = 0; y < goodModes.length; y++) {
                if (displayModesMatch(modes[x], goodModes[y])) {
                    return modes[x];
                }
            }
        }
        return null;
    }

    public boolean displayModesMatch(DisplayMode m1, DisplayMode m2) {
        if (m1.getWidth() != m2.getWidth()
                || m1.getHeight() != m2.getHeight()) {
            return false;
        } else if (m1.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                        && m2.getBitDepth() != DisplayMode.BIT_DEPTH_MULTI
                        && m1.getBitDepth() != m2.getBitDepth()) {
            return false;
        } else if (m1.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
                        && m2.getRefreshRate() != DisplayMode.REFRESH_RATE_UNKNOWN
                        && m1.getRefreshRate() != m2.getRefreshRate()) {
            return false;
        }
        return true;
    }

    public void update() {
        window.update();
    }

    public FullScreenWindow getFullScreenWindow() {
        return window;
    }
}
