package tictactoe;

import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static char[][] table = new char[3][3];
    public static char humanChar;

    public static void main(String[] args) {
        fillTheTable();
        printTable();
        play();
    }

    private static void play() {
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
        printTable();
        checkTable();
    }

    private static void checkTable() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (table[row][0] == ' ' || table[row][1] != table[row][0] || table[row][2] != table[row][0])
                continue;
            System.out.println(table[row][0] + " wins");
            return;
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (table[0][col] == ' ' || table[1][col] != table[0][col] || table[2][col] != table[0][col])
                continue;
            System.out.println(table[0][col] + " wins");
            return;
        }

        // Check diagonal
        if (table[0][0] != ' ' && table[1][1] == table[0][0] && table[2][2] == table[0][0]) {
            System.out.println(table[0][0] + " wins");
            return;
        }

        // Check other diagonal
        if (table[0][2] != ' ' && table[1][1] == table[0][2] && table[2][0] == table[0][2]) {
            System.out.println(table[0][2] + " wins");
            return;
        }

        // Check draw
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col ++) {
                if (table[row][col] == ' ') {
                    System.out.println("Game not finished");
                    return;
                }
            }
        }

        System.out.println("Draw");
    }

    private static void fillTheTable() {
//        String input;
//
//        while (true) {
//            System.out.print("Enter the cells: ");
//            input = scanner.nextLine();
//
//            if (input.matches("[_XO]{9}")) break;
//            System.out.println("Wrong input!");
//        }
//
//        int numMoves = 0;
        for (int i = 0; i < 9; i++) {
            table[i / 3][i % 3] = /*input.charAt(i) == '_' ?*/ ' ' /*: input.charAt(i)*/;
//            if (input.charAt(i) == 'X') numMoves++;
//            if (input.charAt(i) == 'O') numMoves--;
        }
        humanChar = /*numMoves == 0 ?*/ 'X' /*: 'O'*/;
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
