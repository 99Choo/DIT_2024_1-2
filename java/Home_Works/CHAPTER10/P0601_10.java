package CHAPTER10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class P0601_10 extends JFrame {
    private JPanel contentPane;

    public P0601_10() {
        setTitle("블록 생성 및 드래깅 배치");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setLayout(null);  // 배치 관리자 제거
        setContentPane(contentPane);

        // Key listener for 'm' key
        contentPane.setFocusable(true);
        contentPane.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'm') {
                    createBlock();
                }
            }
        });

        setVisible(true);
    }

    // Method to create a block
    private void createBlock() {
        JLabel block = new JLabel();
        block.setOpaque(true);  // 불투명성 설정
        block.setBackground(getRandomColor());
        block.setBounds(100, 100, 80, 80);
        contentPane.add(block);
        contentPane.repaint();

        // Mouse listener for dragging
        MyMouseListener ml = new MyMouseListener();
        block.addMouseListener(ml);
        block.addMouseMotionListener(ml);
    }

    // Method to get a random color
    private Color getRandomColor() {
        Random rand = new Random();
        return new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P0601_10());
    }
}

class MyMouseListener extends MouseAdapter {
    private Point initialClick;

    @Override
    public void mousePressed(MouseEvent e) {
        initialClick = e.getPoint();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        JComponent jc = (JComponent) e.getSource();
        int x = jc.getX() + e.getX() - initialClick.x;
        int y = jc.getY() + e.getY() - initialClick.y;
        jc.setLocation(x, y);
    }
}
