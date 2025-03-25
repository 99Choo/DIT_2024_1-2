package CHAPTER10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class P0599_5 extends JFrame {
    private JLabel label;

    public P0599_5() {
        setTitle("클릭 연습용 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null); // 배치관리자 삭제
        
        // JLabel 생성 및 초기 위치 설정
        label = new JLabel("C");
        label.setSize(50, 50);
        label.setLocation(100, 100);
        label.setFont(new Font("Gothic", Font.BOLD, 20));
        
        // 마우스 리스너 추가
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (int) (Math.random() * contentPane.getWidth());
                int y = (int) (Math.random() * contentPane.getHeight());
                label.setLocation(x, y);
            }
        });
        
        contentPane.add(label);
        setSize(400, 400);
        setVisible(true);
    }

    public static void main(String[] args) {
        new P0599_5();
    }
}
