package Model;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhatina on 3/16/16.
 */
public class Player {
    // TODO: extract center to new class (maybe)
    private int centerX;
    private int centerY;
    // TODO: change to enum
    private int currentDirection;
    // TODO: extract path to new class (maybe)
    private List<Integer> pathX;
    private List<Integer> pathY;
    private Color color;

    private IPlayerInputHandler inputHandler;

    public Player(int centerX, int centerY, int currentDirection,
                  int upKey, int downKey, int leftKey, int rightKey,
                  Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.pathX = new ArrayList<Integer>();
        this.pathY = new ArrayList<Integer>();
        this.currentDirection = currentDirection;
        this.color = color;

        inputHandler = new PlayerKeyHandler(upKey, downKey, leftKey, rightKey);
    }

    public Player(int centerX, int centerY, int currentDirection,
                  Color color) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.pathX = new ArrayList<Integer>();
        this.pathY = new ArrayList<Integer>();
        this.currentDirection = currentDirection;
        this.color = color;

        inputHandler = new PlayerMouseHandler();
    }


    public boolean hasCollided(Player player) {
        for (int x = 0; x < pathX.size(); x++) {
            if (((centerX == pathX.get(x)) && (centerY == pathY.get(x)))
                    || ((player.getCenterX() == player.getPathX().get(x)) && (player.getCenterY() == player.getPathY().get(x)))
                    || ((centerX == player.getPathX().get(x)) && (centerY == player.getPathY().get(x)))
                    || ((player.getCenterX() == pathX.get(x)) && (player.getCenterY() == pathY.get(x)))) {
                return true;
            }
        }

        return false;
    }

    public void drawPath(Graphics2D g) {
        for (int x = 0; x < pathX.size(); x++) {
            g.setColor(color);
            g.fillRect(pathX.get(x), pathY.get(x), 10, 10);
        }
    }

    public void actualizePath() {
        pathX.add(centerX);
        pathY.add(centerY);
    }

    public int getCenterX() {
        return centerX;
    }

    public int getCenterY() {
        return centerY;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public List<Integer> getPathX() {
        return pathX;
    }

    public List<Integer> getPathY() {
        return pathY;
    }

    public IPlayerInputHandler getInputHandler() {
        return inputHandler;
    }

    public void setCenterX(int centerX) {
        this.centerX = centerX;
    }

    public void setCenterY(int centerY) {
        this.centerY = centerY;
    }

    public void addToCenterX(int amount) {
        centerX += amount;
    }

    public void addToCenterY(int amount) {
        centerY += amount;
    }

    public void subtractFromCenterX(int amount) {
        centerX -= amount;
    }

    public void subtractFromCenterY(int amount) {
        centerY -= amount;
    }

    public class PlayerKeyHandler implements IPlayerInputHandler {

        private int upKey;
        private int downKey;
        private int leftKey;
        private int rightKey;

        public PlayerKeyHandler(int upKey, int downKey, int leftKey, int rightKey) {
            this.upKey = upKey;
            this.downKey = downKey;
            this.leftKey = leftKey;
            this.rightKey = rightKey;
        }

        public void handle(InputEvent inputEvent) {
            if (inputEvent instanceof KeyEvent == false)
                return;

            KeyEvent keyEvent = ((KeyEvent) inputEvent);
            if (keyEvent.getKeyCode() == upKey) {
                if (currentDirection != 2) {
                    currentDirection = 0;
                }
            } else if (keyEvent.getKeyCode() == downKey) {
                if (currentDirection != 0) {
                    currentDirection = 2;
                }
            } else if (keyEvent.getKeyCode() == rightKey) {
                if (currentDirection != 3) {
                    currentDirection = 1;
                }
            } else if (keyEvent.getKeyCode() == leftKey) {
                if (currentDirection != 1) {
                    currentDirection = 3;
                }
            }
        }
    }

    public class PlayerMouseHandler implements IPlayerInputHandler {

        public void handle(InputEvent inputEvent) {
            if (inputEvent instanceof MouseEvent == false)
                return;

            MouseEvent mouseEvent = ((MouseEvent) inputEvent);
            if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
                currentDirection = (currentDirection - 1) % 4;
            } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
                currentDirection = (currentDirection + 1) % 4;
            }
        }
    }
}
