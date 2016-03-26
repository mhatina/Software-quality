package presentation;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by mhatina on 3/23/16.
 */
public class FullScreenWindow extends Bounds {
    private GraphicsDevice graphicsDevice;

    public FullScreenWindow(GraphicsDevice graphicsDevice) {
        this.graphicsDevice = graphicsDevice;
    }

    public void setFullScreen(DisplayMode dm) {
        JFrame f = new JFrame();
        f.setUndecorated(true);
        f.setIgnoreRepaint(true);
        f.setResizable(false);
        graphicsDevice.setFullScreenWindow(f);
        width = graphicsDevice.getFullScreenWindow().getWidth();
        height = graphicsDevice.getFullScreenWindow().getHeight();

        if (dm != null && graphicsDevice.isDisplayChangeSupported()) {
            try {
                graphicsDevice.setDisplayMode(dm);
            } catch (Exception ex) {
            }
            f.createBufferStrategy(2);
        }
    }

    public Graphics2D getGraphics() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            return (Graphics2D) bs.getDrawGraphics();
        } else {
            return null;
        }
    }

    public void update() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            BufferStrategy bs = w.getBufferStrategy();
            if (!bs.contentsLost()) {
                bs.show();
            }
        }
    }

    public Window getInstance() {
        return graphicsDevice.getFullScreenWindow();
    }

    public void restoreScreen() {
        Window w = graphicsDevice.getFullScreenWindow();
        if (w != null) {
            w.dispose();
        }
        graphicsDevice.setFullScreenWindow(null);
    }

    public GraphicsDevice getGraphicsDevice() {
        return graphicsDevice;
    }
}
