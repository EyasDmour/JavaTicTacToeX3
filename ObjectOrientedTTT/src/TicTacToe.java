import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isPlayerX = true; // start as player X
        Grid myGame = new Grid();

        System.out.println("""
                1 | 2 | 3
                -----------
                4 | 5 | 6
                -----------
                7 | 8 | 9
                """);


        Player currentPlayer = new PlayerX(); // Start with player X

        while (true) {

            if (isPlayerX) {
                System.out.println("Player X's turn: ");
                currentPlayer = new PlayerX();
            } else {
                System.out.println("Player O's turn: ");
                currentPlayer = new PlayerO();
            }

            currentPlayer.play(myGame);

            isPlayerX = !isPlayerX;

            int result = myGame.checkWin();
            if (result != 0) {
                if (result == 1) {
                    System.out.println("The winner is X!!!");
                } else if (result == 2) {
                    System.out.println("The winner is O!!!");
                } else if (result == 3) {
                    System.out.println("Game ended in a Tie!!!");
                }
                System.out.println("Do you want to play again? [1= yes | 2= no]");
                int choice = scan.nextInt();
                if (choice == 1) {
                    myGame = new Grid();
                    isPlayerX = true;
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice... playing again anyway.");
                    myGame = new Grid();
                    isPlayerX = true;
                }
                System.out.println("""
                1 | 2 | 3
                -----------
                4 | 5 | 6
                -----------
                7 | 8 | 9
                """);

            }
        }
    }
}
