package CHAPTER11;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class P0654_5 extends JFrame {
    private JLabel valueLabel;
    private JSlider slider;

    public P0654_5() {
        setTitle("슬라이더와 레이블 연동");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setLayout(new BorderLayout());

        // 슬라이더 설정
        slider = new JSlider(JSlider.HORIZONTAL, 100, 200, 150);
        slider.setMajorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        add(slider, BorderLayout.CENTER);

        // 레이블 설정
        valueLabel = new JLabel("Value: " + slider.getValue(), SwingConstants.CENTER);
        valueLabel.setFont(new Font("Serif", Font.BOLD, 20));
        add(valueLabel, BorderLayout.SOUTH);

        // ChangeListener 추가
        slider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                valueLabel.setText("Value: " + slider.getValue());
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new P0654_5());
    }
}
