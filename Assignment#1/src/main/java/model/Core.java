package model;

import presentation.FullScreenWindow;
import presentation.ScreenManager;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.function.Function;

public class Core {
    private Function<Long, Void> updateFunction;
    private boolean running;
    protected ScreenManager screenManager;

    public void stop() {
        running = false;
    }

    public void run() throws Exception {
        try {
            running = true;

            getFullScreenWindow().getInstance().requestFocusInWindow();
            gameLoop();
        } finally {
            screenManager.getFullScreenWindow().restoreScreen();
        }
    }

    public void init() {
        screenManager = new ScreenManager();
        screenManager.toggleFullScreen();
        screenManager.hideCursor();
    }

    public void gameLoop() throws Exception {
        long startTime = System.currentTimeMillis();
        long cumulativeTime = startTime;

        while (running) {
            long timePassed = System.currentTimeMillis() - cumulativeTime;
            cumulativeTime += timePassed;
            updateFunction.apply(timePassed);
            screenManager.update();
            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }

    public FullScreenWindow getFullScreenWindow() {
        return screenManager.getFullScreenWindow();
    }

    public void setKeyListener(KeyListener keyListener) {
        Window window = screenManager.getFullScreenWindow().getInstance();
        window.addKeyListener(keyListener);
    }

    public void setMouseListener(MouseListener mouseListener) {
        Window window = screenManager.getFullScreenWindow().getInstance();
        window.addMouseListener(mouseListener);
    }

    public void setUpdateFunction(Function<Long, Void> updateFunction) {
        this.updateFunction = updateFunction;
    }
}
