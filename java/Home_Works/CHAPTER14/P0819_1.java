package CHAPTER14;

import javax.swing.*;
import java.awt.event.*;

public class P0819_1 {
    public static void main(String[] args) {
        // 프레임 생성
        JFrame frame = new JFrame("간단한 메뉴");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // 메뉴바 생성
        JMenuBar menuBar = new JMenuBar();
        
        // "파일" 메뉴 생성
        JMenu fileMenu = new JMenu("파일");
        menuBar.add(fileMenu);

        // "편집" 메뉴 생성
        JMenu editMenu = new JMenu("편집");
        menuBar.add(editMenu);
        
        // "보기" 메뉴 생성 및 아이템 추가
        JMenu viewMenu = new JMenu("보기");
        JMenuItem zoomInItem = new JMenuItem("화면확대");
        JMenuItem pageOutlineItem = new JMenuItem("쪽윤곽");
        viewMenu.add(zoomInItem);
        viewMenu.add(pageOutlineItem);
        menuBar.add(viewMenu);
        
        // "입력" 메뉴 생성
        JMenu inputMenu = new JMenu("입력");
        menuBar.add(inputMenu);
        
        // 메뉴바를 프레임에 추가
        frame.setJMenuBar(menuBar);
        
        // 프레임 표시
        frame.setVisible(true);
    }
}
