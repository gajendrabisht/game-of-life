package com.ways.gof;

import org.junit.jupiter.api.Test;
import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CellTest {

    @Test
    public void shouldDieWhenOnlyOneNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0)));

        Cell cell = new Cell(new Point(1, 1), true);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(false, evolvedCell.getAlive());
    }

    @Test
    public void shouldStayAliveWhenTwoNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1)));

        Cell cell = new Cell(new Point(1, 1), true);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(true, evolvedCell.getAlive());
    }

    @Test
    public void shouldStayAliveWhenThreeNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1), new Point(1, 0)));

        Cell cell = new Cell(new Point(1, 1), true);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(true, evolvedCell.getAlive());
    }

    @Test
    public void shouldDieWhenFourNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(2, 2)));

        Cell cell = new Cell(new Point(1, 1), true);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(false, evolvedCell.getAlive());
    }

    @Test
    public void shouldStayDeadWhenTwoNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1)));

        Cell cell = new Cell(new Point(1, 1), false);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(false, evolvedCell.getAlive());
    }

    @Test
    public void shouldComeAliveWhenThreeNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1), new Point(1, 0)));

        Cell cell = new Cell(new Point(1, 1), false);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(true, evolvedCell.getAlive());
    }

    @Test
    public void shouldStayDeadWhenFourNeighboursAlive() {
        Board board = new Board(3, 3, asList(new Point(0, 0), new Point(0, 1), new Point(1, 0), new Point(2, 2)));

        Cell cell = new Cell(new Point(1, 1), false);
        Cell evolvedCell = cell.evolve(board);

        assertEquals(false, evolvedCell.getAlive());
    }

}