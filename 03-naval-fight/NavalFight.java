// Given a matrix of 10 by 10, ask the user for 10 ships.
// 1 x ship with 4 squares
// 2 x ship with 3 squares
// 3 x ship with 2 squares
// 4 x ship with 1 square
// For each ship, the user should input one or two coordinates, the beggining of the ship, and the end of the ship.
// At the end print the board, and then, continuously ask the user for coordinates, as if bombs. The program should terminate hence all ships are sunken.

import java.util.Scanner;

public class NavalFight {
    public static boolean debug = true;
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        char[][] board = new char[10][10];

        initBoard(board);
        printBoard(board);

        // 1 x ship with 4 squares
        askShip(board, 4);
        printBoard(board);
        // 2 x ship with 3 squares
        askShip(board, 3);
        printBoard(board);
        askShip(board, 3);
        printBoard(board);
        // 3 x ship with 2 squares
        askShip(board, 2);
        printBoard(board);
        askShip(board, 2);
        printBoard(board);
        askShip(board, 2);
        printBoard(board);
        // 4 x ship with 1 square
        askShip(board, 1);
        printBoard(board);
        askShip(board, 1);
        printBoard(board);
        askShip(board, 1);
        printBoard(board);
        askShip(board, 1);
        printBoard(board);

        while(shipSquaresLeft(board) > 0) {
            askBomb(board);
            printBoard(board);
        }
    }

    public static int shipSquaresLeft(char[][] board) {
        int countSquareShips = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 'V') {
                    countSquareShips++;
                }
            }
        }

        if(debug) {
            System.out.printf("DEBUG: %d square ships left\n", countSquareShips);
        }

        return countSquareShips;
    }

    public static void askBomb(char[][] board) {
        System.out.print("Line: ");
        int line = sc.nextInt();

        System.out.print("Column: ");
        int column = sc.nextInt();

        if(board[line][column] == '_') {
            System.out.println("WATER!!!!!");
            board[line][column] = 'O';
        } else {
            System.out.println("HIT!!!!!");
            board[line][column] = '\u2718';
        }

    }

    public static void initBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = '_';
            }
        }
    }

    public static void askShipV2(char[][] board, int numberOfSquares) {
        System.out.printf("Start of ship with %d squares\n", numberOfSquares);

        System.out.print("coordinate: ");
        String coordinate = sc.nextLine(); // XN

        if(debug) {
            System.out.println("DEBUG: coordinate: " + coordinate);
            System.out.println("line: " + coordinate.charAt(1));
            System.out.println("column: " + coordinate.charAt(0));
        }

        int startLine = Integer.valueOf(coordinate.charAt(1) + ""); // N
        char column = coordinate.charAt(0); // X

        int startColumn = 0;
        switch(column) {
            case 'A':
            case 'a':
                startColumn = 0;
                break;
            case 'B':
            case 'b':
                startColumn = 1;
                break;
            case 'C':
            case 'c':
                startColumn = 2;
                break;
            case 'D':
            case 'd':
                startColumn = 3;
                break;
            case 'E':
            case 'e':
                startColumn = 4;
                break;
            case 'F':
            case 'f':
                startColumn = 5;
                break;
            case 'G':
            case 'g':
                startColumn = 6;
                break;
            case 'H':
            case 'h':
                startColumn = 7;
                break;
            case 'I':
            case 'i':
                startColumn = 8;
                break;
            case 'J':
            case 'j':
                startColumn = 9;
                break;
        }

        int option = 2;
        System.out.println("Hello");
        if(numberOfSquares != 1) {
            System.out.println("Orientation of ship");
            System.out.println("1 - vertical");
            System.out.println("2 - horizontal");
            sc.nextInt();
        }
        System.out.println("goodbye");

        int endLine;
        int endColumn;

        switch(option) {
            case 1:
                endLine = startLine + numberOfSquares - 1;
                endColumn = startColumn;
                break;
            case 2:
            default:
                endLine = startLine;
                endColumn = startColumn + numberOfSquares - 1;
                break;
        }

        if(debug) {
            System.out.printf("DEBUG: startLine: %d\n", startLine);
            System.out.printf("DEBUG: startColumn: %d\n", startColumn);
            System.out.printf("DEBUG: endLine: %d\n", endLine);
            System.out.printf("DEBUG: endColumn: %d\n", endColumn);
        }

        // board[startLine][startColumn] = '\u2718';
        // fill middle
        // board[endLine][endColumn] = '\u2718';
        for(int i = startLine; i <= endLine; i++) {
            for(int j = startColumn; j <= endColumn; j++) {
                if(debug) {
                    System.out.printf("DEBUG: board[%d][%d] = V\n", i, j);
                }
                board[i][j] = 'V';
            }
        }

    }


    public static void askShip(char[][] board, int numberOfSquares) {
        System.out.printf("Start of ship with %d squares\n", numberOfSquares);

        System.out.print("line: ");
        int startLine = sc.nextInt();

        System.out.print("column: ");
        int startColumn = sc.nextInt();

        int option = 2;
        if(numberOfSquares != 1) {
            System.out.println("Orientation of ship");
            System.out.println("1 - vertical");
            System.out.println("2 - horizontal");
            sc.nextInt();
        }

        int endLine;
        int endColumn;

        switch(option) {
            case 1:
                endLine = startLine + numberOfSquares - 1;
                endColumn = startColumn;
                break;
            case 2:
            default:
                endLine = startLine;
                endColumn = startColumn + numberOfSquares - 1;
                break;
        }

        if(debug) {
            System.out.printf("DEBUG: startLine: %d\n", startLine);
            System.out.printf("DEBUG: startColumn: %d\n", startColumn);
            System.out.printf("DEBUG: endLine: %d\n", endLine);
            System.out.printf("DEBUG: endColumn: %d\n", endColumn);
        }

        // board[startLine][startColumn] = '\u2718';
        // fill middle
        // board[endLine][endColumn] = '\u2718';
        for(int i = startLine; i <= endLine; i++) {
            for(int j = startColumn; j <= endColumn; j++) {
                if(debug) {
                    System.out.printf("DEBUG: board[%d][%d] = V\n", i, j);
                }
                board[i][j] = 'V';
            }
        }

    }

    public static void printBoard(char[][] array) {
        System.out.println("  A B C D E F G H I J");
        for(int i = 0; i < array.length; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}

