import java.util.Scanner;

public class ConnectFour {
    public static void printBoard(char[][]array){//First Commit
int i = 0;
        for(int v = array.length - 1; v >= 0; v--){// Prints the board in reverse and makes the bottom row 0
    for(i=0;i < array[v].length;i++){
        System.out.print(array[v][i]+ " ");
    }
            System.out.println("");
}

    }
    public static void initializeBoard(char[][]array){ //adds '-' to fill array to make board
        for(int v = 0; v < array.length; v++){
            for(int i=0;i < array[v].length;i++){
                array[v][i] = '-';
                int count=0;
                count++;
            }
        }


    }
    public static int insertChip(char[][]array, int col, char chipType){
        int i = 0;

        for(i = array.length-1; i >=0; i--) { //scans through board inserting chips one above the last user input

            if (array[i][col] == 'x' || array[i][col] == 'o') {
                array[i+1][col] = chipType;
                i= i +1;
            break;
            }
                else if (i == 0) {
                    array[i][col] = chipType;
                    break;
                }
        }
        return i;
    }
    public static boolean checkIfWinner(char[][] array, int col, int row, char chipType){
        int i = 0;
        if(row >=3) { //checks vertically
            if (array[row][col] == 'x') {
                if (array[row-1][col] == 'x') {
                    if (array[row-2][col] == 'x') {
                        if (array[row-3][col] == 'x') {
                            System.out.println("Player 1 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        i = 0;
        if(row >=3) {
            if (array[row][col] == 'o') {
                if (array[row-1][col] == 'o') {
                    if (array[row-2][col] == 'o') {
                        if (array[row-3][col] == 'o') {
                            System.out.println("Player 2 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        if(col <= array[0].length - 4) {//checks to the right horizontally
            if (array[row][col] == 'o') {
                if (array[row][col+1] == 'o') {
                    if (array[row][col+2] == 'o') {
                        if (array[row][col+3] == 'o') {
                            System.out.println("Player 2 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        if(col <= array.length - 4) {
            if (array[row][col] == 'x') {
                if (array[row][col+1] == 'x') {
                    if (array[row][col+2] == 'x') {
                        if (array[row][col+3] == 'x') {
                            System.out.println("Player 1 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        if(col >= 3) {//checks them to the left horizontally
            if (array[row][col] == 'x') {
                if (array[row][col-1] == 'x') {
                    if (array[row][col-2] == 'x') {
                        if (array[row][col-3] == 'x') {
                            System.out.println("Player 1 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        if(col >= 4) {
            if (array[row][col] == 'o') {
                if (array[row][col-1] == 'o') {
                    if (array[row][col-2] == 'o') {
                        if (array[row][col-3] == 'o') {
                            System.out.println("Player 2 won the game!");
                            return true;
                        }
                    }
                }

            }
        }
        for(i=1;i <= array[0].length;i++){// checks to see if the whole board is filled
            if((array[array.length-1][array[0].length-i]) == 'x' || (array[array.length-1][array[0].length-i]) == 'o'){
                if(i == array[0].length){
                    System.out.println("");
                    System.out.println("Draw. Nobody wins.");
                    return true;
                }
            }
            else break;
        }


            return false;
    }


    public static void main(String[] args) {
	Scanner scan =new Scanner(System.in);

        System.out.println("What would you like the height of the board to be? "); // gives options for the start of the game
	int X;
	X = scan.nextInt();
        System.out.println("What would you like the length of the board to be? ");
	int Y;
	Y = scan.nextInt();
	char [][] connectFour = new char[X][Y];//creates an array of size dependant on user input
        initializeBoard(connectFour);// calls method to initialize the board with '-'

        printBoard(connectFour);
        System.out.println("");
        System.out.println("Player 1: x");
        System.out.println("Player 2: o");
        for (;;) { // takes input from users and allows them to play their tokens by calling the insertChip method
            System.out.println("");
            System.out.print("Player 1: Which column would you like to choose? ");
            int token = scan.nextInt();
            char playerShape = 'x';
            int row1 = insertChip(connectFour,token,playerShape);// inserts the user input of 'x' or 'o'
            printBoard(connectFour); //printst the board with the user input in it
            boolean check1 = checkIfWinner(connectFour,token,row1,'o'); //check if there is a connect 4
            if(check1){
                break;
            }
            System.out.println("");
            System.out.print("Player 2: Which column would you like to choose? ");

        token = scan.nextInt();
            playerShape = 'o';
            int row2 = insertChip(connectFour,token,playerShape);
            printBoard(connectFour);
            boolean check2 = checkIfWinner(connectFour,token,row2,'o');
            if(check2){
                break;
            }
        }

    }

}
