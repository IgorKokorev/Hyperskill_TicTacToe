package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] table = new char[3][3];
    public static final char humanChar = 'X';
    public static final char compChar = 'O';
    public static final char emptyChar = ' ';


    public static void main(String[] args) {
        fillTheTable();
        printTable();
        play();
    }

    private static void play() {
        int numEmptyCells = 9;
        do {
            humanMove();
            printTable();
            if (checkTable()) break;
            numEmptyCells--;
            computerMove(numEmptyCells--);
            printTable();
        } while(!checkTable());
    }

    private static void computerMove(int numEmptyCells) {
        System.out.println("Making move level \"easy\"");
        Random rng = new Random();

        int n = rng.nextInt(numEmptyCells);

        for (int i = 0; i < 9; i++) {
            if (table[i / 3][i % 3] == emptyChar) {
                if (n == 0) {
                    table[i / 3][i % 3] = compChar;
                    break;
                } else n--;
            }
        }
    }

    private static void humanMove() {
        String input;
        int row;
        int col;
        while (true) {
            System.out.print("Enter the coordinates: ");
            input = scanner.nextLine();
            if (!input.matches("\\d \\d")) {
                System.out.println("You should enter numbers!");
            } else {
                String[] splittedInput = input.split(" ");
                row = Integer.parseInt(splittedInput[0]);
                col = Integer.parseInt(splittedInput[1]);

                if (row == 0 || row > 3 || col == 0 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (table[row - 1][col - 1] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else break;
            }
        }

        table[row - 1][col - 1] = humanChar;
    }

    private static boolean checkTable() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (table[row][0] == ' ' || table[row][1] != table[row][0] || table[row][2] != table[row][0])
                continue;
            System.out.println(table[row][0] + " wins");
            return true;
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (table[0][col] == ' ' || table[1][col] != table[0][col] || table[2][col] != table[0][col])
                continue;
            System.out.println(table[0][col] + " wins");
            return true;
        }

        // Check diagonal
        if (table[0][0] != ' ' && table[1][1] == table[0][0] && table[2][2] == table[0][0]) {
            System.out.println(table[0][0] + " wins");
            return true;
        }

        // Check other diagonal
        if (table[0][2] != ' ' && table[1][1] == table[0][2] && table[2][0] == table[0][2]) {
            System.out.println(table[0][2] + " wins");
            return true;
        }

        // Check draw
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col ++) {
                if (table[row][col] == ' ') {
                    return false;
                }
            }
        }

        System.out.println("Draw");
        return true;
    }

    private static void fillTheTable() {
        for (int i = 0; i < 9; i++) {
            table[i / 3][i % 3] = emptyChar;
        }
    }

    private static void printTable() {
        System.out.println("---------");
        for (int row = 0; row < 3; row++) {
            System.out.print("| ");
            for (int col = 0; col < 3; col++) {
                System.out.print(table[row][col] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
