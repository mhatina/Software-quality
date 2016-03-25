package Model.InputHandlers;

import Model.PlayerBase.Direction;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Created by mhatina on 3/23/16.
 */
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

    public Direction changeDirection(InputEvent inputEvent, Direction direction) {
        if (inputEvent instanceof KeyEvent == false)
            return direction;

        KeyEvent keyEvent = ((KeyEvent) inputEvent);
        if (keyEvent.getKeyCode() == upKey) {
            if (direction != Direction.DOWN) {
                return Direction.UP;
            }
        } else if (keyEvent.getKeyCode() == downKey) {
            if (direction != Direction.UP) {
                return Direction.DOWN;
            }
        } else if (keyEvent.getKeyCode() == rightKey) {
            if (direction != Direction.LEFT) {
                return Direction.RIGHT;
            }
        } else if (keyEvent.getKeyCode() == leftKey) {
            if (direction != Direction.RIGHT) {
                return Direction.LEFT;
            }
        }

        return direction;
    }
}