package CHAPTER9;

import java.awt.*;
import java.util.*;
import javax.swing.*;

public class P0543 extends JFrame {
    public P0543() {
        setTitle("단어 조합 게임!...");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        
        // NORTH 패널 설정
        JPanel northPanel = new JPanel();
        northPanel.setBackground(Color.GRAY); // NORTH 패널 배경색을 회색으로 설정
        JLabel titleLabel = new JLabel("단어 조합 게임...");
        titleLabel.setOpaque(true);
        titleLabel.setBackground(Color.GRAY); // JLabel 배경색을 회색으로 설정
        northPanel.add(titleLabel);
        JButton newTextButton = new JButton("new Text");
        northPanel.add(newTextButton);
        contentPane.add(northPanel, BorderLayout.NORTH);
        
        // SOUTH 패널 설정
        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.YELLOW); // SOUTH 패널 배경색을 노란색으로 설정
        southPanel.add(new JLabel("이름: "));
        JTextField resultField = new JTextField(10);
        southPanel.add(resultField);
        contentPane.add(southPanel, BorderLayout.SOUTH);
        
        // CENTER 패널 설정
        JPanel centerPanel = new JPanel(null);
        String text = "I can't help falling in love with you";
        String[] words = text.split(" "); // 단어들 분리
        
        // 각 단어를 랜덤한 위치에 배치
        for (String word : words) {
            JLabel wordLabel = new JLabel(word);
            wordLabel.setFont(new Font("Gothic", Font.BOLD, 15));
            int x = (int) (Math.random() * 351); // 0~350 범위의 랜덤 x 좌표
            int y = (int) (Math.random() * 181); // 0~180 범위의 랜덤 y 좌표
            wordLabel.setBounds(x, y, 100, 20); // JLabel 크기 설정
            centerPanel.add(wordLabel);
        }
        
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
        setSize(400, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    public static void main(String[] args) {
        new P0543();
    }
}
