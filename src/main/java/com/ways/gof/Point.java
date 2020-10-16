package com.ways.gof;

public class Point implements Comparable<Point> {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    // for display only (start printing grid from top left)
    @Override
    public int compareTo(Point o) {
        int yDiff = this.getY() - o.getY();
        int xDiff = o.getX() - this.getX();
        return (yDiff != 0) ? yDiff : xDiff;
    }
}
