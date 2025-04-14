import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends JFrame {
    private JButton[][] cells = new JButton[3][3];
    private boolean isPlayerX = true;

    public TicTacToe() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Tic-Tac-Toe");

        JPanel gamePanel = new JPanel(new GridLayout(3, 3));

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = new JButton();
                cells[row][col].setFont(new Font("Arial", Font.PLAIN, 40));
                gamePanel.add(cells[row][col]);
                int finalRow = row;
                int finalCol = col;
                cells[row][col].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (cells[finalRow][finalCol].getText().isEmpty()) {
                            if (isPlayerX) {
                                cells[finalRow][finalCol].setText("X");
                            } else {
                                cells[finalRow][finalCol].setText("O");
                            }
                            isPlayerX = !isPlayerX; // switch turns between X and O...
                            int result = 3;
                            int matchResult;
                            matchResult = winChecker(); //store result of the game in matchResult as an integer.
                            // where 0 = tie, 1 = X won, 2 = O won, and 3 means the game is still ongoing.
                            if (matchResult == 0) {
                                result = JOptionPane.showConfirmDialog(
                                        null,
                                        "The game ended in a tie... do you want to play again?",
                                        "Play Again?",
                                        JOptionPane.YES_NO_OPTION
                                );
                            } else if (matchResult == 1) {
                                result = JOptionPane.showConfirmDialog(
                                        null,
                                        "The game ended in a Win for X... do you want to play again?",
                                        "Play Again?",
                                        JOptionPane.YES_NO_OPTION
                                );
                            } else if (matchResult == 2) {
                                result = JOptionPane.showConfirmDialog(
                                        null,
                                        "The game ended in a Win for O... do you want to play again?",
                                        "Play Again?",
                                        JOptionPane.YES_NO_OPTION
                                );
                            }

                            if (result == JOptionPane.YES_OPTION) {
                                for (int i = 0; i < 3; i++) {
                                    for (int j = 0; j < 3; j++) {
                                        cells[i][j].setText("");
                                    }
                                }
                                isPlayerX = true; //always start the next round with X
                            } else if (result == JOptionPane.NO_OPTION) {
                                System.exit(0);
                            }

                        } // end of last if statement
                    } //end of function for action
                }); //end of action listener

            }   //end of the loops for each cell in grid
        }       // ``

        add(gamePanel);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }

    public int winChecker() {
        for (int i = 0; i < 3; i++) {
            if (!cells[i][0].getText().isEmpty()
                    && cells[i][0].getText().equals(cells[i][1].getText())
                    && cells[i][0].getText().equals(cells[i][2].getText())) {
                System.out.println("horizontal line win condition");

                if (cells[i][0].getText().equals("X")) {
                    return 1;   // Winner = X
                } else {
                    return 2;   // Winner = O
                }
            }
            if (!cells[0][i].getText().isEmpty()
                    && cells[0][i].getText().equals(cells[1][i].getText())
                    && cells[0][i].getText().equals(cells[2][i].getText())) {

                System.out.println("vertical line win condition");

                if (cells[0][i].getText().equals("X")) {
                    return 1;
                } else {
                    return 2;
                }
            }
        }

        if (!cells[0][0].getText().isEmpty()
                && cells[0][0].getText().equals(cells[1][1].getText())
                && cells[0][0].getText().equals(cells[2][2].getText())) {

            System.out.println("top left to bottom right diagonal win condition");

            if (cells[0][0].getText().equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }
        if (!cells[0][2].getText().isEmpty()
                && cells[0][2].getText().equals(cells[1][1].getText())
                && cells[0][2].getText().equals(cells[2][0].getText())) {

            System.out.println("top right to bottom left diagonal win condition");

            if (cells[0][2].getText().equals("X")) {
                return 1;
            } else {
                return 2;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getText().isEmpty()) {
                    return 3; // no winner yet.
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.setVisible(true);
    }
}
