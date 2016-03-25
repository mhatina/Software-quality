package Model.PlayerBase;

import Base.Main;
import Presentation.ScreenManager;

/**
 * Created by mhatina on 3/23/16.
 */
public class Center {
    int x;
    int y;

    public Center(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addToX(int amount) {
        x += amount;
    }

    public void addToY(int amount) {
        y += amount;
    }

    public void subtractFromX(int amount) {
        x -= amount;
    }

    public void subtractFromY(int amount) {
        y -= amount;
    }

    public void setBorderPosition(ScreenManager sm, Direction direction) {
        switch (direction) {
            case UP:
                if (getY() > 0) {
                    subtractFromY(Main.MOVE_AMOUNT);
                } else {
                    setY(sm.getFullScreenWindow().getHeight());
                }
                break;
            case RIGHT:
                if (getX() < sm.getFullScreenWindow().getWidth()) {
                    addToX(Main.MOVE_AMOUNT);
                } else {
                    setX(0);
                }
                break;
            case DOWN:
                if (getY() < sm.getFullScreenWindow().getHeight()) {
                    addToY(Main.MOVE_AMOUNT);
                } else {
                    setY(0);
                }
                break;
            case LEFT:
                if (getX() > 0) {
                    subtractFromX(Main.MOVE_AMOUNT);
                } else {
                    setX(sm.getFullScreenWindow().getWidth());
                }
                break;
        }
    }
}
