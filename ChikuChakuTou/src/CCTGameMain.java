import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CCTGameMain extends JFrame implements ActionListener {
    private JButton[][] buttons = new JButton[3][3];
    private boolean xTurn = true;

    public CCTGameMain() {
        super("Chiku Chaku Tou");

        JPanel gameBoard = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].addActionListener(this);
                gameBoard.add(buttons[i][j]);
            }
        }

        getContentPane().add(gameBoard);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        JButton buttonClicked = (JButton) e.getSource();
        if (buttonClicked.getText().equals("")) {
            if (xTurn) {
                buttonClicked.setText("X");
                buttonClicked.setFont(new Font(buttonClicked.getFont().getName(), Font.BOLD, 30));
            } else {
                buttonClicked.setText("O");
                buttonClicked.setFont(new Font(buttonClicked.getFont().getName(), Font.BOLD, 30));
            }
            xTurn = !xTurn;

            if (checkForWinner()) {
                JOptionPane.showMessageDialog(this, (xTurn ? "O" : "X") + " wins!");
                resetGame();
            } else if (checkForTie()) {
                JOptionPane.showMessageDialog(this, "It's a tie!");
                resetGame();
            }
        }
    }

    private boolean checkForWinner() {
        String symbol;
        for (int i = 0; i < buttons.length; i++) {
            symbol = buttons[i][0].getText();
            if (!symbol.isEmpty() && buttons[i][1].getText().equals(symbol) && buttons[i][2].getText().equals(symbol)) {
                return true;
            }
            symbol = buttons[0][i].getText();
            if (!symbol.isEmpty() && buttons[1][i].getText().equals(symbol) && buttons[2][i].getText().equals(symbol)) {
                return true;
            }
        }
        // check diagonals
        symbol = buttons[1][1].getText();
        if (!symbol.isEmpty() && ((buttons[0][0].getText().equals(symbol) && buttons[2][2].getText().equals(symbol)) ||
                (buttons[0][2].getText().equals(symbol) && buttons[2][0].getText().equals(symbol)))) {
            return true;
        }

        return false;
    }

    private boolean checkForTie() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                if (buttons[i][j].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }

    private void resetGame() {
        for (int i = 0; i < buttons.length; i++) {
            for (int j = 0; j < buttons[i].length; j++) {
                buttons[i][j].setText("");
            }
        }
        xTurn = true;
    }

    public static void main(String[] args) {
        new CCTGameMain();
    }
}
