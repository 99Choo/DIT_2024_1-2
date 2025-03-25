package CHAPTER9;

import java.awt.*;
import javax.swing.*;

public class P0550_10 extends JFrame {
    public P0550_10() {
        setTitle("West Grid 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        
        // WEST 영역에 GridLayout으로 색깔 패널 배치
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(10, 1));
        
        // 10개의 패널에 각기 다른 색깔 설정 및 크기 조정
        Color[] colors = {Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE,
                          Color.MAGENTA, Color.CYAN, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY};
        for (Color color : colors) {
            JPanel panel = new JPanel();
            panel.setBackground(color); // 패널 색상 설정
            panel.setPreferredSize(new Dimension(100, 0)); // 패널 너비 설정
            colorPanel.add(panel); // 패널을 GridLayout에 추가
        }
        contentPane.add(colorPanel, BorderLayout.WEST);
        
        // CENTER 영역에 JLabel 배치
        JPanel centerPanel = new JPanel(null); // LayoutManager 없는 패널
        
        // 0-9 사이의 정수 랜덤 생성 및 JLabel 설정
        for (int i = 0; i < 10; i++) {
            JLabel numberLabel = new JLabel(Integer.toString(i));
            numberLabel.setFont(new Font("Gothic", Font.BOLD, 30));
            
            // 랜덤 좌표 설정 (50, 50) ~ (200, 200)
            int x = 50 + (int) (Math.random() * 151);
            int y = 50 + (int) (Math.random() * 151);
            numberLabel.setBounds(x, y, 50, 50);
            
            centerPanel.add(numberLabel);
        }
        contentPane.add(centerPanel, BorderLayout.CENTER);
        
        setSize(600, 300); // 프레임 크기 설정
        setVisible(true); // 프레임을 화면에 표시
    }

    public static void main(String[] args) {
        new P0550_10();
    }
}
