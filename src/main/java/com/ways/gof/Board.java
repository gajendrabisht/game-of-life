package com.ways.gof;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Board {

    private List<Cell> cells = new ArrayList<>();

    // initialize Board
    public Board(int x, int y, List<Point> aliveCells) {
        IntStream.range(0, x).forEach(i -> {
            IntStream.range(0, y).forEach(j -> {
                Point point = new Point(i, j);
                cells.add(new Cell(point, aliveCells.contains(point)));
            });
        });
    }

    // get neighbouring cells on board
    public List<Cell> getNeighboursOnBoard(Cell cell) {
        List<Point> possibleNeighbours = cell.getPossibleNeighbours();
        return cells.stream().filter(i -> possibleNeighbours.contains(i.getPoint())).collect(Collectors.toList());
    }

    // evolve every cell to create a new board
    public void evolve() {
        cells = cells.stream().map(cell -> cell.evolve(this)).collect(Collectors.toList());
    }

    // display board
    public void display() {
        cells.stream().sorted().forEachOrdered(cell -> {
            // create new line
            if (cell.getPoint().getX() == 0) {
                System.out.printf("\n");
            }
            char display = cell.getAlive() ? '█' : ' ';
            System.out.print(display);
        });
    }

}
