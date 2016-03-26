package model.player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhatina on 3/23/16.
 */
public class Path {
    private List<Position> path;

    public Path() {
        this.path = new ArrayList<Position>();
    }

    public Position get(int index) {
        return path.get(index);
    }

    public int size() {
        return path.size();
    }

    public void add(Position position) {
        path.add(position);
    }
}
