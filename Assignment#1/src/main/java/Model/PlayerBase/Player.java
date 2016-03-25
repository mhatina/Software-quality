package Model.PlayerBase;

import Model.InputHandlers.IPlayerInputHandler;

import java.awt.*;

/**
 * Created by mhatina on 3/16/16.
 */
public class Player {
    private Center center;
    private Direction direction;
    private Path path;
    private Color color;

    private IPlayerInputHandler inputHandler;

    public Player(Center center, Direction currentDirection, IPlayerInputHandler playerInputHandler, Color color) {
        this.center = center;
        path = new Path();
        this.direction = currentDirection;
        this.color = color;

        inputHandler = playerInputHandler;
    }

    public boolean hasCollided(Player player) {
        for (int x = 0; x < path.getPathX().size(); x++) {
            if (((center.getX() == path.getPathX().get(x)) && (center.getY() == path.getPathY().get(x)))
                    || ((player.getCenter().getX() == player.getPath().getPathX().get(x))
                        && (player.getCenter().getY() == player.getPath().getPathY().get(x)))
                    || ((center.getX() == player.getPath().getPathX().get(x))
                        && (center.getY() == player.getPath().getPathY().get(x)))
                    || ((player.getCenter().getX() == path.getPathX().get(x))
                        && (player.getCenter().getY() == path.getPathY().get(x)))) {
                return true;
            }
        }

        return false;
    }

    public void drawPath(Graphics2D g) {
        for (int x = 0; x < path.getPathX().size(); x++) {
            g.setColor(color);
            g.fillRect(path.getPathX().get(x), path.getPathY().get(x), 10, 10);
        }
    }

    public void actualizePath() {
        path.add(center);
    }

    public Center getCenter() {
        return center;
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
