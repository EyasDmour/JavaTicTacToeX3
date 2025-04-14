import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean isPlayerX = true; //start as player X
        char[] cells = new char[9];

        initGrid(cells);
        drawGrid(cells);

        while (true) {
            if (isPlayerX) {
                System.out.println("which index do you want to play?  (X)");
                int index = scan.nextInt() - 1;
                playX(index, cells);
                isPlayerX = false;
            } else {
                System.out.println("which index do you want to play?  (O)");
                int index = scan.nextInt() - 1;
                playO(index, cells);
                isPlayerX = true;
            }
            int result = checkWin(cells);
            if (result != 0) {

                if (result == 1) {
                    System.out.println("The winner is X!!!" +
                            "\ndo you want to play again?  [ 1= yes | 2= no ]");
                } else if (result == 2) {
                    System.out.println("The winner is O!!!" +
                            "\ndo you want to play again?  [ 1= yes | 2= no ]");
                } else if (result == 3) {
                    System.out.println("Game ended in a Tie!!!" +
                            "\ndo you want to play again?  [ 1= yes | 2= no ]");
                }
                int choice = scan.nextInt();
                if (choice == 1) {
                    initGrid(cells);
                    System.out.println("""
                             1 | 2 | 3
                            -----------
                             4 | 5 | 6
                            -----------
                             7 | 8 | 9
                            """);
                    isPlayerX = true;
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("invalid choice... playing again anyway.");
                    initGrid(cells);
                    System.out.println("""
                             1 | 2 | 3
                            -----------
                             4 | 5 | 6
                            -----------
                             7 | 8 | 9
                            """);
                    isPlayerX = true;
                }
            }
        }
    }

    private static void initGrid(char[] cells) {
        int num = 1;
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) (num + '0');
            num++;
        }
    }

    static void playX(int index, char[] cells) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                if (cells[index] != 'X' && cells[index] != 'O') {
                    cells[index] = 'X';
                    break;
                } else {
                    System.out.print("invalid choice... choose again\n>");
                    index = scan.nextInt() - 1;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("please choose a number between and including 1 and 9");
                index = scan.nextInt() - 1;
            }
        }
        drawGrid(cells);
    }

    static void playO(int index, char[] cells) {
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                if (cells[index] != 'X' && cells[index] != 'O') {
                    cells[index] = 'O';
                    break;
                } else {
                    System.out.print("invalid choice... choose again\n>");
                    index = scan.nextInt() - 1;
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("please choose a number between and including 1 and 9");
                index = scan.nextInt() - 1;
            }
        }
        drawGrid(cells);
    }

    static void drawGrid(char[] cells) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + "\n" +
                "-----------\n" +
                " " + cells[3] + " | " + cells[4] + " | " + cells[5] + "\n" +
                "-----------\n" +
                " " + cells[6] + " | " + cells[7] + " | " + cells[8] + "\n");

    }

    static int checkWin(char[] cells) {
        // Checking rows for winner
        for (int i = 0; i < 3; i++) {
            int rowStart = i * 3;
            if (cells[rowStart] != ' '
                    && cells[rowStart] == cells[rowStart + 1]
                    && cells[rowStart] == cells[rowStart + 2]) {
                if (cells[rowStart] == 'X') {
                    return 1; // Winner = X
                } else {
                    return 2; // Winner = O
                }
            }
        }

        // Checking columns for winner
        for (int i = 0; i < 3; i++) {
            if (cells[i] != ' '
                    && cells[i] == cells[i + 3]
                    && cells[i] == cells[i + 6]) {
                if (cells[i] == 'X') {
                    return 1; // Winner = X
                } else {
                    return 2; // Winner = O
                }
            }
        }

        // Checking diagonals for winner
        if (cells[0] != ' '
                && cells[0] == cells[4]
                && cells[0] == cells[8]) {
            if (cells[0] == 'X') {
                return 1; // Winner = X
            } else {
                return 2; // Winner = O
            }
        }

        if (cells[2] != ' '
                && cells[2] == cells[4]
                && cells[2] == cells[6]) {
            if (cells[2] == 'X') {
                return 1; // Winner = X
            } else {
                return 2; // Winner = O
            }
        }

        for (char cell : cells) {
            if (cell != 'X' && cell != 'O') {
                return 0; // No winner yet
            }
        }

        return 3; // It's a tie
    }
}
