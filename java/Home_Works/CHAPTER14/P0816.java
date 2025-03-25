package CHAPTER14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class P0816 extends JFrame {
    private int cups = 10;
    private int coffee = 10;
    private int water = 10;
    private int sugar = 10;
    private int cream = 10;

    private JLabel statusLabel;

    public P0816() {
        setTitle("커피 자판기");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("Welcome, Hot Coffee!!"));
        add(northPanel, BorderLayout.NORTH);

        JPanel southPanel = new JPanel();
        JButton blackCoffeeButton = new JButton("Black Coffee");
        JButton sugarCoffeeButton = new JButton("Sugar Coffee");
        JButton dabangCoffeeButton = new JButton("Dabang Coffee");
        JButton resetButton = new JButton("Reset");  // Reset 버튼 추가

        blackCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCoffee("Black Coffee");
            }
        });

        sugarCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCoffee("Sugar Coffee");
            }
        });

        dabangCoffeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                makeCoffee("Dabang Coffee");
            }
        });

        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resetIngredients();
            }
        });

        southPanel.add(blackCoffeeButton);
        southPanel.add(sugarCoffeeButton);
        southPanel.add(dabangCoffeeButton);
        southPanel.add(resetButton);  // Reset 버튼 추가
        add(southPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        statusLabel = new JLabel(getStatus());
        centerPanel.add(statusLabel);
        add(centerPanel, BorderLayout.CENTER);
    }

    private void makeCoffee(String type) {
        if (cups == 0 || coffee == 0 || water == 0 || 
            (type.equals("Sugar Coffee") && sugar == 0) || 
            (type.equals("Dabang Coffee") && (sugar == 0 || cream == 0))) {
            JOptionPane.showMessageDialog(this, "재료가 부족합니다.", "경고", JOptionPane.WARNING_MESSAGE);
        } else {
            cups--;
            coffee--;
            water--;
            if (type.equals("Sugar Coffee") || type.equals("Dabang Coffee")) sugar--;
            if (type.equals("Dabang Coffee")) cream--;
            
            statusLabel.setText(getStatus());
            JOptionPane.showMessageDialog(this, type + "가 준비되었습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void resetIngredients() {
        cups = 10;
        coffee = 10;
        water = 10;
        sugar = 10;
        cream = 10;
        statusLabel.setText(getStatus());
    }

    private String getStatus() {
        return String.format("컵: %d, 커피: %d, 물: %d, 설탕: %d, 크림: %d", cups, coffee, water, sugar, cream);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new P0816().setVisible(true);
            }
        });
    }
}
