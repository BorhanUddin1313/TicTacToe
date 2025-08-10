import java.util.Random;
import java.util.Scanner;

public class tickToe {
    public static void main(String[] args){
        char [] board ={'0','1','2','3','4','5','6','7','8'};

        System.out.println("Play TICTACTOE");
        printBoard(board);
        System.out.println();

        /** Chooses the Turn randomly
         * Either X or O
         */
        Random random = new Random();
        boolean chooseTrun =random.nextBoolean();




        char currentPlayer;
        if(chooseTrun){
            currentPlayer='X';
        }else {
            currentPlayer='O';
        }

        Scanner sc = new Scanner(System.in);





        /**
         * Keeps the game running until there is a winner or draw
         */

        while (winner();){
            if(currentPlayer=='X'){
                System.out.println("Its X's turn to play");
                System.out.print("choose a Number between 0-8: ");
            }else{
                System.out.println("Its O's turn to play");
                System.out.print("choose a Number between 0-8: ");
            }

            int posiBoard= sc.nextInt();
            board[posiBoard]=currentPlayer;
            currentPlayer=switchTurn(currentPlayer);
            printBoard(board);
            System.out.println();

        }



    }




    static char switchTurn(char currentPlayer){
        if (currentPlayer=='X'){
            return 'O';
        }else {
            return 'X';
        }

    }

    static void validateMove(){}
    static void winner(){

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