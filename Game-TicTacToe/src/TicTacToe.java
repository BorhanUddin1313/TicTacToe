import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};

        System.out.println("Play TICTACTOE");
        printBoard(board);
        System.out.println();

        /** Chooses the Turn randomly
         * Either X or O
         */
        Random random = new Random();
        boolean chooseTrun = random.nextBoolean();


        char currentPlayer;
        if (chooseTrun) {
            currentPlayer = 'x';
        } else {
            currentPlayer = 'o';
        }

        Scanner sc = new Scanner(System.in);


        /**
         * Keeps the game running until there is a winner or draw
         */

        while (!winner(board)) {
            if (currentPlayer == 'x') {
                System.out.println("Its X's turn to play");
                System.out.print("choose a Number between 0-8: ");
            } else {
                System.out.println("Its O's turn to play");
                System.out.print("choose a Number between 0-8: ");
            }

            int posiBoard = sc.nextInt();

            if(!validateMove(board,posiBoard)){
                continue;
            }
            board[posiBoard] = currentPlayer;
            currentPlayer = switchTurn(currentPlayer);




            printBoard(board);
            System.out.println();

        }


        System.out.println("\n We have a winner");

    }


    static char switchTurn(char currentPlayer) {
        if (currentPlayer == 'x') {
            return 'o';
        } else {
            return 'x';
        }

    }

    static boolean validateMove(char[] board, int position) {
        if(position<0 || position>8) {
            System.out.println("Invalid Input,\n try again");
            return false;

        }
        if(board[position]=='x' || board[position]=='o'){
            System.out.println("Spot taken, Choose again");
            return false;

        }
        return true;
    }



    static boolean winner(char[] board) {
        return winner('x', board) || winner('o', board);
    }


    static boolean winner(char Player, char[] board) {

        if (board[0] == Player && board[1] == Player && board[2] == Player ||
                board[3] == Player && board[4] == Player && board[5] == Player ||
                board[6] == Player && board[7] == Player && board[8] == Player ||
                board[0] == Player && board[3] == Player && board[6] == Player ||
                board[1] == Player && board[4] == Player && board[7] == Player ||
                board[2] == Player && board[5] == Player && board[8] == Player ||
                board[0] == Player && board[4] == Player && board[8] == Player ||
                board[2] == Player && board[4] == Player && board[6] == Player) {

            return true;
        }
        return false;

    }






    static void printBoard(char[] board) {

        for(int i=0; i<board.length;i++) {
            if (i != 0 && i % 3 == 0) {
                System.out.println();

                if (i < board.length) {
                    System.out.println("---------");
                }
            }
            System.out.print(board[i]);
            if((i+1)%3!=0){
                System.out.print(" | ");
            }
        }
    }
}