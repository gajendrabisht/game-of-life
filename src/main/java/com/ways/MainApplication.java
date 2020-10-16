package com.ways;

import com.ways.gof.Board;
import com.ways.gof.Point;
import java.util.Scanner;
import java.util.stream.IntStream;
import static java.util.Arrays.asList;

public class MainApplication {

    public static void main(String[] args) {
        // display Menu
        asList("Please choose a pattern:", "Press (1) for Blinker", "Press (2) for Toad", "Press (3) for Glider")
                .forEach(i -> System.out.println(i));

        // get User Input
        int choice = new Scanner(System.in).nextInt();


        // Create Board
        Board board = null;
        switch (choice) {
            case 1: board = getBlinkerBoard(); break;
            case 2: board = getToadBoard(); break;
            case 3: board = getGliderBoard(); break;
        }

        // Display 10 evolutions
        displayBoardEvolution(board);
    }

    private static Board getBlinkerBoard() {
        return new Board(5, 5, asList(new Point(1, 2), new Point(2, 2), new Point(3, 2)));
    }

    private static Board getToadBoard() {
        return new Board(6, 6, asList(
                new Point(1, 2), new Point(2, 2), new Point(3, 2),
                new Point(2, 3), new Point(3, 3), new Point(4, 3)));
    }

    private static Board getGliderBoard() {
        return new Board(20, 20, asList(
                new Point(1, 1), new Point(2, 1), new Point(3, 1),
                new Point(3, 2), new Point(2, 3)));
    }


    private static void displayBoardEvolution(Board board) {
        IntStream.range(0, 10).forEach(i -> {
            board.display();
            board.evolve();
            sleep();
        });
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
