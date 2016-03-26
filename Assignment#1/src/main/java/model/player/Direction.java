package model.player;

import base.Main;
import presentation.Bounds;

/**
 * Created by mhatina on 3/23/16.
 */
public enum Direction {
    UP {
        @Override
        public void alterPosition(Position position, Bounds bounds) {
            if (position.getY() > 0) {
                position.setY(position.getY() - Main.MOVE_AMOUNT);
            } else {
                position.setY(bounds.getHeight());
            }
        }

        @Override
        public Direction left() {
            return LEFT;
        }

        @Override
        public Direction right() {
            return RIGHT;
        }
    },
    DOWN {
        @Override
        public void alterPosition(Position position, Bounds bounds) {
            if (position.getY() < bounds.getHeight()) {
                position.setY(position.getY() + Main.MOVE_AMOUNT);
            } else {
                position.setY(0);
            }
        }

        @Override
        public Direction left() {
            return RIGHT;
        }

        @Override
        public Direction right() {
            return LEFT;
        }
    },
    LEFT {
        @Override
        public void alterPosition(Position position, Bounds bounds) {
            if (position.getX() > 0) {
                position.setX(position.getX() - Main.MOVE_AMOUNT);
            } else {
                position.setX(bounds.getWidth());
            }
        }

        @Override
        public Direction left() {
            return DOWN;
        }

        @Override
        public Direction right() {
            return UP;
        }
    },
    RIGHT {
        @Override
        public void alterPosition(Position position, Bounds bounds) {
            if (position.getX() < bounds.getWidth()) {
                position.setX(position.getX() + Main.MOVE_AMOUNT);
            } else {
                position.setX(0);
            }
        }

        @Override
        public Direction left() {
            return UP;
        }

        @Override
        public Direction right() {
            return DOWN;
        }
    };

    public abstract void alterPosition(Position position, Bounds bounds);
    public abstract Direction left();
    public abstract Direction right();
}
