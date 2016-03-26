package model.input.handlers;

import model.player.Direction;

import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;

/**
 * Created by mhatina on 3/23/16.
 */
public class PlayerMouseHandler implements IPlayerInputHandler {

    public Direction changeDirection(InputEvent inputEvent, Direction direction) {
        if (inputEvent instanceof MouseEvent == false)
            return direction;

        MouseEvent mouseEvent = ((MouseEvent) inputEvent);
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) {
            return direction.left();
        } else if (mouseEvent.getButton() == MouseEvent.BUTTON3) {
            return direction.right();
        }

        return direction;
    }
}
