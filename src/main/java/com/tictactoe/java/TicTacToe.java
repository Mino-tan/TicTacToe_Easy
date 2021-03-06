package com.tictactoe.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TicTacToe {

    static char[] squares = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static int turn = 1;
    static char index;

    public static void board() {
        System.out.println("P1 = O\nP2 = X\n");
        System.out.println(squares[0] + " " + squares[1] + " " + squares[2]);
        System.out.println(squares[3] + " " + squares[4] + " " + squares[5]);
        System.out.println(squares[6] + " " + squares[7] + " " + squares[8]);
    }

    public static boolean check() {

        for (int i = 0; i < 7; i += 3) {
            if (squares[i] == squares[i + 1] && squares[i + 1] == squares[i + 2]) {
                System.out.println(turn % 2 != 0?"P1 wins YAY!":"P2 wins YAY!");
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (squares[i] == squares[i + 3] && squares[i + 3] == squares[i + 6]) {
                System.out.println(turn % 2 != 0?"P1 wins YAY!":"P2 wins YAY!");
                return true;
            }
        }
        for (int i = 0; i < 3; i += 2) {
            if (squares[i] == squares[4] && squares[4] == squares[i + (8 - 2 * i)]) {
                System.out.println(turn % 2 != 0?"P1 wins YAY!":"P2 wins YAY!");
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (turn != 10) {
                board();
                try {
                    System.out.print(turn % 2 != 0?"\nP1 move (enter cell index): ":"\nP2 move (enter cell index): ");
                    index = (char) ('0' + Integer.parseInt(br.readLine()));
                    while (index < '1' || index > '9' || squares[(index - '0') - 1] != index) {
                       
                        System.out.print(turn % 2 != 0 ? "Invalid cell! P1 move: " : "Invalid cell! P2 move: ");
                        index = (char) ('0' + Integer.parseInt(br.readLine()));

                    }
                    squares[(index - '0') - 1] = turn % 2 != 0?'O':'X';

                    if (check()) {
                        board();
                        break;
                    }
                    turn += 1;
                    if (turn == 10) {
                        board();
                        System.out.println("DRAW");
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("This is not a number");
                }
            }
        } catch (IOException ignored) {
        }
    }
}

