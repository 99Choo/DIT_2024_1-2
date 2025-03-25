package CHAPTER11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class P0650 extends JFrame {
    private JLabel imageLabel;
    private ArrayList<ImageIcon> images;
    private int currentIndex = 0;

    public P0650() {
        setTitle("이미지 갤러리");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setLayout(new BorderLayout());

        // 이미지 레이블 설정
        imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // MenuPanel 설정
        JPanel menuPanel = new MenuPanel();
        add(menuPanel, BorderLayout.SOUTH);

        // 이미지 로드
        loadImages();
        if (!images.isEmpty()) {
            imageLabel.setIcon(images.get(0));
        }

        setVisible(true);
    }

    private void loadImages() {
        images = new ArrayList<>();
        // 이미지 파일들이 저장된 디렉토리를 지정합니다
        File dir = new File("images"); // images 디렉토리를 프로젝트 디렉토리 내에 생성하고 이미지 파일들을 넣으세요
        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles((dir1, name) -> name.toLowerCase().endsWith(".jpg") || name.toLowerCase().endsWith(".png"));
            if (files != null) {
                for (File file : files) {
                    images.add(new ImageIcon(file.getPath()));
                }
            }
        }
    }

    private class MenuPanel extends JPanel {
        public MenuPanel() {
            JButton prevButton = new JButton("<");
            JButton nextButton = new JButton(">");

            prevButton.setFont(new Font("Arial", Font.BOLD, 24));
            nextButton.setFont(new Font("Arial", Font.BOLD, 24));

            prevButton.setBackground(Color.LIGHT_GRAY);
            nextButton.setBackground(Color.LIGHT_GRAY);

            prevButton.setPreferredSize(new Dimension(50, 50));
            nextButton.setPreferredSize(new Dimension(50, 50));

            prevButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!images.isEmpty()) {
                        currentIndex = (currentIndex - 1 + images.size()) % images.size();
                        imageLabel.setIcon(images.get(currentIndex));
                    }
                }
            });

            nextButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (!images.isEmpty()) {
                        currentIndex = (currentIndex + 1) % images.size();
                        imageLabel.setIcon(images.get(currentIndex));
                    }
                }
            });

            add(prevButton);
            add(nextButton);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P0650());
    }
}
