package CHAPTER9;

import javax.swing.*;
import java.awt.*;

public class P0548_5 extends JFrame {
    public P0548_5() {
        setTitle("4x4 Color Grid");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        Container contentPane = getContentPane();
        
        // GridLayout 설정
        contentPane.setLayout(new GridLayout(4, 4));

        // 색상 배열
        Color[] colors = {
            Color.WHITE, Color.GRAY, Color.RED, Color.ORANGE,
            Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE,
            Color.MAGENTA, Color.PINK, Color.LIGHT_GRAY, Color.DARK_GRAY,
            Color.BLACK, Color.ORANGE, Color.CYAN, Color.MAGENTA
        };

        // JLabel 생성 및 배경색 설정
        for (Color color : colors) {
            JLabel label = new JLabel();
            label.setOpaque(true); // 배경색 설정을 위해 필수
            label.setBackground(color);
            contentPane.add(label);
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new P0548_5();
    }
}
