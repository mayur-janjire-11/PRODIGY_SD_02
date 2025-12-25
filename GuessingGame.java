import javax.swing.*;
import java.util.Random;

public class GuessingGame {

    public static void main(String[] args) {

        // Create frame (window)
        JFrame frame = new JFrame("Guessing Game");
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Labels
        JLabel title = new JLabel("Guessing Game");
        title.setBounds(140, 10, 200, 30);

        JLabel info = new JLabel("Choose Difficulty");
        info.setBounds(120, 40, 200, 30);

        JLabel attemptsLabel = new JLabel("");
        attemptsLabel.setBounds(130, 160, 200, 30);

        // Text field
        JTextField input = new JTextField();
        input.setBounds(120, 90, 150, 30);
        input.setEnabled(false);

        // Buttons
        JButton easyBtn = new JButton("Easy");
        easyBtn.setBounds(60, 130, 100, 30);

        JButton hardBtn = new JButton("Hard");
        hardBtn.setBounds(220, 130, 100, 30);

        JButton guessBtn = new JButton("Guess");
        guessBtn.setBounds(140, 200, 100, 30);
        guessBtn.setEnabled(false);

        // Add to frame
        frame.add(title);
        frame.add(info);
        frame.add(input);
        frame.add(easyBtn);
        frame.add(hardBtn);
        frame.add(guessBtn);
        frame.add(attemptsLabel);

        frame.setVisible(true);

        // Game variables
        Random random = new Random();
        final int[] number = new int[1];
        final int[] attempts = new int[1];

        // Easy button
        easyBtn.addActionListener(e -> {
            number[0] = random.nextInt(50) + 1;
            attempts[0] = 7;
            info.setText("Guess between 1 and 50");
            attemptsLabel.setText("Attempts Left: 7");
            input.setEnabled(true);
            guessBtn.setEnabled(true);
        });

        // Hard button
        hardBtn.addActionListener(e -> {
            number[number[0]] = random.nextInt(500) + 1;
            attempts[0] = 10;
            info.setText("Guess between 1 and 500");
            attemptsLabel.setText("Attempts Left: 10");
            input.setEnabled(true);
            guessBtn.setEnabled(true);
        });

        // Guess button
        guessBtn.addActionListener(e -> {
            try {
                int guess = Integer.parseInt(input.getText());
                attempts[0]--;

                if (guess > number[0]) {
                    info.setText("Too High");
                } else if (guess < number[0]) {
                    info.setText("Too Low");
                } else {
                    JOptionPane.showMessageDialog(frame, "You Win!");
                    input.setEnabled(false);
                    guessBtn.setEnabled(false);
                    return;
                }

                attemptsLabel.setText("Attempts Left: " + attempts[0]);
                input.setText("");

                if (attempts[0] == 0) {
                    JOptionPane.showMessageDialog(frame,
                            "Game Over! Number was " + number[0]);
                    input.setEnabled(false);
                    guessBtn.setEnabled(false);
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Enter a number only");
            }
        });
    }
}
