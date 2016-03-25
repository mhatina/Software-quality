package Model.PlayerBase;

/**
 * Created by mhatina on 3/23/16.
 */
public enum Direction {
    UP(0),
    DOWN(2),
    LEFT(3),
    RIGHT(1);

    private int numericDirection;

    Direction(int numeric_direction) {
        this.numericDirection = numeric_direction;
    }

    public int getNumericDirection() {
        return numericDirection;
    }

    public static Direction getValue(int id)
    {
        for(Direction direction : Direction.values())
        {
            if (direction.numericDirection == id)
                return direction;
        }
        return Direction.UP;
    }
}
