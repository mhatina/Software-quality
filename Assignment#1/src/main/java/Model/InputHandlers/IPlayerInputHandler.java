package Model.InputHandlers;

import Model.PlayerBase.Direction;

import java.awt.event.InputEvent;

/**
 * Created by mhatina on 3/17/16.
 */
public interface IPlayerInputHandler {
    Direction changeDirection(InputEvent inputEvent, Direction direction);
}

