package model.player;

import base.Main;
import presentation.Bounds;

/**
 * Created by mhatina on 3/23/16.
 */
public class Position {
    int x;
    int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void moveInDirection(Direction direction, Bounds bounds) {
        direction.alterPosition(this, bounds);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (Math.abs(x - position.x) >= Main.MOVE_AMOUNT) return false;
        return Math.abs(y - position.y) < Main.MOVE_AMOUNT;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
