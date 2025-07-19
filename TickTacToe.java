import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TickTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JPanel bPanel = new JPanel();
    JLabel label = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TickTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(150, 220, 225));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setBackground(new Color(180, 240, 160));
        label.setForeground(new Color(225, 68, 68));
        label.setFont(new Font("Ink free", Font.BOLD, 77));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("TIC-TAc-TOE");
        label.setOpaque(true);
        panel.setLayout(new BorderLayout());
        panel.setBounds(0, 0, 800, 100);
        bPanel.setLayout(new GridLayout(3, 3));
        bPanel.setBackground(new Color(150, 220, 225));
        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            bPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MN Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);

        }

        panel.add(label);
        frame.add(panel);
        frame.add(panel, BorderLayout.NORTH);
        frame.add(bPanel);
        first();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setBackground(new Color(240, 60, 70));
                        buttons[i].setText("X");
                        player1_turn = false;
                        label.setText("O TURN");
                        Check();
                    }

                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setBackground(new Color(70, 60, 240));
                        buttons[i].setText("O");
                        player1_turn = true;
                        label.setText("X TURN");
                        Check();
                    }
                }
            }
        }

    }

    public void first() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (random.nextInt(2) == 0) {
            player1_turn = true;
            label.setText("X TURN");
        } else {
            player1_turn = false;
            label.setText("O TURN");
        }
    }

    public void Check() {

        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")) {
            xwin(0, 1, 2);

        }
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")) {
            xwin(3, 4, 5);

        }
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xwin(6, 7, 8);

        }
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xwin(0, 3, 6);

        }
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")) {
            xwin(2, 5, 8);

        }
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")) {
            xwin(0, 4, 8);

        }
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")) {
            xwin(2, 4, 6);

        }
        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")) {
            owin(0, 1, 2);

        }
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")) {
            owin(3, 4, 5);

        }
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            owin(6, 7, 8);

        }
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            owin(0, 3, 6);

        }
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")) {
            owin(2, 5, 8);

        }
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")) {
            owin(0, 4, 8);

        }
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")) {
            owin(2, 4, 6);

        }
        boolean draw = true;
        for (int i = 0; i < 9; i++) {
            if (buttons[i].getText().equals("")) {
                draw = false;
                break;
            }
        }
        if (draw) Draw();
    }


    public void xwin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        label.setText("X WINS");
    }

    public void owin(int a, int b, int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for (int i = 0; i < 9; i++) {
            buttons[i].setEnabled(false);
        }
        label.setText("O WINS");
    }

    public void Draw() {
        for (int i = 0; i < 9; i++) {
            buttons[i].setBackground(Color.RED);
            label.setText("ITS DRAW");

        }
    }


    public static void main(String[] args) {
        new TickTacToe();
    }
}