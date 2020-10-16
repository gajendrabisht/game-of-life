package com.ways.gof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cell implements Comparable<Cell> {

    private Point point;
    private Boolean isAlive;

    public Cell(Point point, Boolean isAlive) {
        this.point = point;
        this.isAlive = isAlive;
    }

    public Point getPoint() {
        return point;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    // Rules of Evolution
    // Rule (1) Any live cell with two or three live neighbours survives.
    // Rule (2) Any dead cell with three live neighbours becomes a live cell.
    // Rule (3) All other live cells die in the next generation. Similarly, all other dead cells stay dead.
    public Cell evolve(Board board) {
        Boolean newState = isAlive;
        long neighboursAlive = board.getNeighboursOnBoard(this).stream().filter(i -> i.isAlive).count();
        if (isAlive && (neighboursAlive < 2 || neighboursAlive > 3)) {
            newState = false;
        } else if (!isAlive && (neighboursAlive == 3)) {
            newState = true;
        }
        return new Cell(point, newState);
    }

    // get all possible neighbours
    public List<Point> getPossibleNeighbours() {
        List<Point> points = new ArrayList<>();
        int x = point.getX();
        int y = point.getY();
        Arrays.asList(x - 1, x, x + 1).forEach(i -> {
            Arrays.asList(y - 1, y, y + 1).forEach(j -> {
                points.add(new Point(i, j));
            });
        });
        // remove self
        points.remove(new Point(x, y));
        return points;
    }

    // for display only (start from top left)
    @Override
    public int compareTo(Cell o) {
        return this.getPoint().compareTo(o.getPoint());
    }
}
