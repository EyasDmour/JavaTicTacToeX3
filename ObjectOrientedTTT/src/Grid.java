import java.util.Scanner;

class Grid {
    Scanner scan = new Scanner(System.in);
    private char[] cells = new char[9];

    Grid() {
        int num = 1;
        for (int i = 0; i < 9; i++) {
            cells[i] = (char) (num + '0');
            num++;
        }
    }

    public void playX() {   //setter
        while (true) {
            int index = scan.nextInt() - 1;
            try {
                if (cells[index] != 'X' && cells[index] != 'O') {
                    cells[index] = 'X';
                    break;
                } else {
                    System.out.print("Invalid choice... choose again\n>");
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Please choose a number between and including 1 and 9");
            }
        }
        drawGrid(cells);
    }

    public void playO() {   //setter
        while (true) {
            int index = scan.nextInt() - 1;
            try {
                if (cells[index] != 'X' && cells[index] != 'O') {
                    cells[index] = 'O';
                    break;
                } else {
                    System.out.print("Invalid choice... choose again\n>");
                }
            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println("Please choose a number between and including 1 and 9");
            }
        }
        drawGrid(cells);
    }
    public void playX(int index) {   //overloaded setter for playX()
        try {
            if (cells[index] != 'X' && cells[index] != 'O') {
                cells[index] = 'X';
            } else {
                System.out.print("Invalid choice... choose again\n>");
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Please choose a number between and including 1 and 9");
        }
        drawGrid(cells);
    }
    public void play0(int index) {   //overloaded setter for playO()
        try {
            if (cells[index] != 'X' && cells[index] != 'O') {
                cells[index] = 'O';
            } else {
                System.out.print("Invalid choice... choose again\n>");
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("Please choose a number between and including 1 and 9");
        }
        drawGrid(cells);
    }


        void drawGrid(char[] cells) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println(" " + cells[0] + " | " + cells[1] + " | " + cells[2] + "\n" +
                "-----------\n" +
                " " + cells[3] + " | " + cells[4] + " | " + cells[5] + "\n" +
                "-----------\n" +
                " " + cells[6] + " | " + cells[7] + " | " + cells[8] + "\n");
    }

    int checkWin() {
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
