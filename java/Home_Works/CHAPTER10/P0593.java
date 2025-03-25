package CHAPTER10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class P0593 extends JFrame {
    private JLabel numberLabel;
    private int hiddenNumber;
    private boolean isOddSelected = false;
    private boolean isEvenSelected = false;

    public P0593() {
        setTitle("홀짝 맞추기 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 300);
        setLayout(new BorderLayout());

        numberLabel = new JLabel("?", SwingConstants.CENTER);
        numberLabel.setFont(new Font("Serif", Font.BOLD, 60));
        add(numberLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton oddButton = new JButton("홀");
        JButton evenButton = new JButton("짝");
        JButton checkButton = new JButton("확인");
        JButton resetButton = new JButton("다시");

        buttonPanel.add(oddButton);
        buttonPanel.add(evenButton);
        buttonPanel.add(checkButton);
        buttonPanel.add(resetButton);

        add(buttonPanel, BorderLayout.SOUTH);

        oddButton.addActionListener(e -> {
            isOddSelected = true;
            isEvenSelected = false;
        });

        evenButton.addActionListener(e -> {
            isOddSelected = false;
            isEvenSelected = true;
        });

        checkButton.addActionListener(e -> {
            if (!isOddSelected && !isEvenSelected) {
                JOptionPane.showMessageDialog(this, "홀이나 짝 먼저 선택");
                return;
            }

            boolean isCorrect = (hiddenNumber % 2 == 0 && isEvenSelected) || (hiddenNumber % 2 != 0 && isOddSelected);
            JOptionPane.showMessageDialog(this, isCorrect ? "성공" : "실패");

            // 선택 초기화
            isOddSelected = false;
            isEvenSelected = false;
        });

        resetButton.addActionListener(e -> resetGame());

        resetGame();

        setVisible(true);
    }

    private void resetGame() {
        Random rand = new Random();
        hiddenNumber = rand.nextInt(10) + 1;  // 1에서 10 사이의 정수 생성
        numberLabel.setText("?");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P0593());
    }
}
