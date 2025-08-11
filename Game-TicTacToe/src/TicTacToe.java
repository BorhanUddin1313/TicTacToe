import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        char[] board = {'0', '1', '2', '3', '4', '5', '6', '7', '8'};
        System.out.println("Play TICTACTOE");
        printBoard(board);
        System.out.println();

        //Chooses the Turn randomly
        Random random = new Random();
        boolean chooseTrun = random.nextBoolean();
        char currentPlayer;
        if (chooseTrun) {
            currentPlayer = 'x';
        } else {
            currentPlayer = 'o';
        }

        /**
         * Keeps the game running until there is a winner or draw
         */
        Scanner sc = new Scanner(System.in);
        while (!winner(board)) {
            if (currentPlayer == 'x') {
                System.out.println("Its X's turn to play");
                System.out.print("choose a Number between 0-8: ");
            } else {
                System.out.println("Its O's turn to play");
                System.out.print("choose a Number between 0-8: ");
            }
            int posiBoard = sc.nextInt();

            //Checks for the Valid input
            if(!validateMove(board,posiBoard)){
                continue;
            }
            //switches to the next player
            board[posiBoard] = currentPlayer;
            currentPlayer = switchTurn(currentPlayer);

            //prints the updated board
            printBoard(board);
            System.out.println();
        }
        //winner announced when the while loop is true
        System.out.println( switchTurn(currentPlayer) +" Won the game ");
    }

    /**
     * flips the currentPlayer to the next player
     * @param currentPlayer
     * @return the next Player
     */

    static char switchTurn(char currentPlayer) {
        if (currentPlayer == 'x') {
            return 'o';
        } else {
            return 'x';
        }
    }

    /**
     * Validates the move of the Current-Player
     * @param board
     * @param position
     * @return true only if the move is valid
     */
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

    /**
     * checks if there is a winner
     * @param board
     * @return
     */
    static boolean winner(char[] board) {
        return winner('x', board) || winner('o', board);
    }

    /**
     *checks the condition for winning
     * @param Player
     * @param board
     * @return
     */
    static boolean winner(char Player, char[] board) {
        if(board[0] == Player && board[1] == Player && board[2] == Player ||
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

    /**
     *Prints a 3x3 board
     */
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