package Model.PlayerBase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mhatina on 3/23/16.
 */
public class Path {
    private List<Integer> pathX;
    private List<Integer> pathY;

    public Path() {
        this.pathX = new ArrayList<Integer>();
        this.pathY = new ArrayList<Integer>();
    }

    public List<Integer> getPathX() {
        return pathX;
    }

    public List<Integer> getPathY() {
        return pathY;
    }

    public void add(Center center) {
        pathX.add(center.getX());
        pathY.add(center.getY());
    }
}
