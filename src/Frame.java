//Samantha Barnum
//3/3/22
//CS-1181L-07

import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Frame extends JFrame {

    private JButton playAgainButton;
    private JLabel winnerLabel;
    private int leftCounter = 0;
    private int rightCounter = 0;

    private JLabel getNumberOfWins() {
        JLabel numberOfWins = new JLabel("");
        numberOfWins.setForeground(Color.BLACK);
        numberOfWins.setFont(new Font("Arial", Font.BOLD, 15));
        numberOfWins.setHorizontalAlignment(JLabel.CENTER);
        numberOfWins.setOpaque(true);
        return numberOfWins;
    }

    private JLabel getTotalWinsLabel() {
        JLabel totalWins = new JLabel("Total wins: ");
        totalWins.setForeground(Color.BLACK);
        totalWins.setFont(new Font("Arial", Font.PLAIN, 15));
        totalWins.setHorizontalAlignment(JLabel.CENTER);
        totalWins.setOpaque(true);
        return totalWins;
    }

    private JLabel getCardLabel() {
        JLabel cardNumber = new JLabel("");
        cardNumber.setIcon(new ImageIcon("src/card.png"));
        cardNumber.setForeground(Color.BLACK);
        cardNumber.setFont(new Font("Arial", Font.PLAIN, 75));
        cardNumber.setHorizontalTextPosition(JLabel.CENTER);
        cardNumber.setVerticalTextPosition(JLabel.CENTER);
        cardNumber.setVerticalAlignment(JLabel.TOP);
        cardNumber.setLayout(new BorderLayout());
        cardNumber.setBorder(new EmptyBorder(0, 10, 0, 0));
        cardNumber.setOpaque(true);
        return cardNumber;
    }

    private JLabel getWinnerMessage(String message) {
        JLabel winner = new JLabel("" + message);
        winner.setForeground(Color.BLACK);
        winner.setFont(new Font("Arial", Font.BOLD, 18));
        winner.setOpaque(true);
        return winner;
    }

    Frame() {
        // the base panel
        JPanel root = new JPanel();
        root.setLayout(new BoxLayout(root, BoxLayout.Y_AXIS));

        final JLabel leftCardNumber = getCardLabel();
        final JLabel rightCardNumber = getCardLabel();

        // the panel that holds the cards
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.X_AXIS));
        cardPanel.setBorder(new EmptyBorder(15, 0, 0, 0));

        // adding the cards to the panel holding them
        cardPanel.add(leftCardNumber);
        cardPanel.add(rightCardNumber);

        JPanel winnerMessagePanel = new JPanel();
        winnerLabel = getWinnerMessage("Right card won!");
        winnerLabel.setHorizontalAlignment(JLabel.CENTER);
        winnerLabel.setVisible(false);

        winnerMessagePanel.add(winnerLabel);

        // the panel that holds the score info in a grid layout
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new GridLayout(2, 2));
        scorePanel.setMaximumSize(new Dimension(200, 150));

        JLabel leftTotalWinsText = getTotalWinsLabel();
        JLabel rightTotalWinsText = getTotalWinsLabel();
        JLabel leftNumberOfWins = getNumberOfWins();
        JLabel rightNumberOfWins = getNumberOfWins();

        scorePanel.add(leftTotalWinsText);
        scorePanel.add(rightTotalWinsText);
        scorePanel.add(leftNumberOfWins);
        scorePanel.add(rightNumberOfWins);

        JPanel buttonPanel = new JPanel();
        playAgainButton = new JButton("Click me to play!");

        playAgainButton.addActionListener(e -> {

            playAgainButton.setText("Play again?");
            winnerLabel.setVisible(true);

            Random random = new Random();
            int randomNumberForTheLeftCard = random.nextInt(10) + 1;
            int randomNumberForTheRightCard = random.nextInt(10) + 1;

            // paste the random number onto the screen
            leftCardNumber.setText(randomNumberForTheLeftCard + "");
            rightCardNumber.setText(randomNumberForTheRightCard + "");

            String leftCardText = leftCardNumber.getText();
            int leftCardTextConverter = Integer.parseInt(leftCardText);

            String rightCardText = rightCardNumber.getText();
            int rightCardTextConverter = Integer.parseInt(rightCardText);

            if (leftCardTextConverter > rightCardTextConverter) {
                winnerLabel.setText("Left card wins!");
                leftCounter++;
                leftNumberOfWins.setText(leftCounter + "");
            } else if (leftCardTextConverter < rightCardTextConverter) {
                winnerLabel.setText("Right card wins!");
                rightCounter++;
                rightNumberOfWins.setText(rightCounter + "");
            } else {
                winnerLabel.setText("It's a tie!");
            }

            root.validate();
            root.repaint();

        });

        buttonPanel.setBorder(new EmptyBorder(10, 0, 0, 0));

        playAgainButton.setFocusable(false);

        buttonPanel.add(playAgainButton);

        // adding the stuff to the base panel
        root.add(cardPanel);
        root.add(winnerMessagePanel);
        root.add(scorePanel);
        root.add(buttonPanel);

        // adding the base panel to the frame
        setContentPane(root);

        this.setBackground(Color.WHITE);
        this.setTitle("Project 2 Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(300, 350);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

        ImageIcon doge = new ImageIcon("src/dogeicon.png");
        this.setIconImage(doge.getImage());
    }
}