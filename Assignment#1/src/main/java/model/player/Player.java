package model.player;

import model.input.handlers.IPlayerInputHandler;
import presentation.Bounds;

import java.awt.*;

/**
 * Created by mhatina on 3/16/16.
 */
public class Player {
    private Position position;
    private Direction direction;
    private Path path;
    private Color color;

    private IPlayerInputHandler inputHandler;

    public Player(Position position, Direction currentDirection, IPlayerInputHandler playerInputHandler, Color color) {
        this.position = position;
        path = new Path();
        this.direction = currentDirection;
        this.color = color;

        inputHandler = playerInputHandler;
    }

    public boolean hasCollided(Player player) {
        for (int i = 0; i < path.size(); i++) {
            if (position.equals(path.get(i)) || position.equals(player.getPath().get(i))) {
                return true;
            }
        }

        return false;
    }

    public void moveInDirection(Bounds bounds) {
        position.moveInDirection(direction, bounds);
    }

    public void drawPath(Graphics2D g) {
        for (int i = 0; i < path.size(); i++) {
            g.setColor(color);
            g.fillRect(path.get(i).getX(), path.get(i).getY(), 10, 10);
        }
    }

    public void actualizePath() {
        path.add(new Position(position.getX(), position.getY()));
    }

    public Direction getDirection() {
        return direction;
    }

    public Path getPath() {
        return path;
    }

    public IPlayerInputHandler getInputHandler() {
        return inputHandler;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
