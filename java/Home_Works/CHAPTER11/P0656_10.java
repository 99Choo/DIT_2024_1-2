package CHAPTER11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class P0656_10 extends JFrame {
    private JPanel contentPane;
    private JLabel completedSentenceLabel;
    private ArrayList<JLabel> wordLabels;
    private ArrayList<String> sentences;
    private String selectedSentence;
    private ArrayList<String> selectedWords;
    private StringBuilder currentSentence;

    public P0656_10() {
        setTitle("문장 완성 게임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // 상단을 회색으로 조금만 채우기
                g.setColor(Color.GRAY);
                g.fillRect(0, 0, getWidth(), 50);
                // 하단을 노란색으로 조금만 채우기
                g.setColor(Color.YELLOW);
                g.fillRect(0, getHeight() - 50, getWidth(), 50);
            }
        };
        contentPane.setLayout(null);
        setContentPane(contentPane);

        completedSentenceLabel = new JLabel("", SwingConstants.CENTER);
        completedSentenceLabel.setFont(new Font("Serif", Font.BOLD, 20));
        completedSentenceLabel.setBounds(10, 500, 760, 50);
        contentPane.add(completedSentenceLabel);

        JButton newTextButton = new JButton("New Text");
        newTextButton.setBounds(10, 10, 100, 30);
        contentPane.add(newTextButton);

        newTextButton.addActionListener(e -> generateNewText());

        sentences = new ArrayList<>();
        sentences.add("This is a sample sentence.");
        sentences.add("Another example sentence here.");
        sentences.add("Java Swing is fun to learn.");
        // 필요한 만큼 문장을 추가하세요

        wordLabels = new ArrayList<>();
        currentSentence = new StringBuilder();

        setVisible(true);
    }

    private void generateNewText() {
        clearWords();
        currentSentence.setLength(0);
        completedSentenceLabel.setText("");

        Random rand = new Random();
        selectedSentence = sentences.get(rand.nextInt(sentences.size()));
        selectedWords = new ArrayList<>();

        for (String word : selectedSentence.split(" ")) {
            selectedWords.add(word);
        }

        Collections.shuffle(selectedWords);

        for (String word : selectedWords) {
            JLabel wordLabel = new JLabel(word);
            wordLabel.setOpaque(true);
            wordLabel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
            wordLabel.setBounds(rand.nextInt(700), rand.nextInt(400), 100, 50);
            wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
            wordLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (wordLabel.getBackground() != Color.LIGHT_GRAY) {
                        wordLabel.setBackground(Color.LIGHT_GRAY);
                        currentSentence.append(wordLabel.getText()).append(" ");
                        completedSentenceLabel.setText(currentSentence.toString().trim());

                        if (currentSentence.toString().trim().equals(selectedSentence)) {
                            JOptionPane.showMessageDialog(null, "성공! 문장을 완성했습니다.");
                        }
                    }
                }
            });
            wordLabels.add(wordLabel);
            contentPane.add(wordLabel);
        }

        contentPane.repaint();
    }

    private void clearWords() {
        for (JLabel label : wordLabels) {
            contentPane.remove(label);
        }
        wordLabels.clear();
        contentPane.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P0656_10());
    }
}
