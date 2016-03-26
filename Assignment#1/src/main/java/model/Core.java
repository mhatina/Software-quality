package model;

import presentation.ScreenManager;

public abstract class Core {

    private boolean running;
    protected ScreenManager screenManager;

    public void stop() {
        running = false;
    }

    public void run() {
        try {
            running = true;

            init();
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

    public void gameLoop() {
        long startTime = System.currentTimeMillis();
        long cumulativeTime = startTime;

        while (running) {
            long timePassed = System.currentTimeMillis() - cumulativeTime;
            cumulativeTime += timePassed;
            update(timePassed);
            screenManager.update();
            try {
                Thread.sleep(20);
            } catch (Exception ex) {
            }
        }
    }

    public abstract void update(long timePassed);

}
