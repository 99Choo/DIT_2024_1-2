package CHAPTER14;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.sound.sampled.*;

public class P0821_7 extends JFrame {
    private Clip clip;

    public P0821_7() {
        setTitle("오디오 플레이어");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("오디오");
        JMenuItem playItem = new JMenuItem("연주");
        JMenuItem stopItem = new JMenuItem("종료");

        playItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playAudio();
            }
        });

        stopItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                stopAudio();
            }
        });

        menu.add(playItem);
        menu.add(stopItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void playAudio() {
        JFileChooser fileChooser = new JFileChooser();
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File audioFile = fileChooser.getSelectedFile();
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
                clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (UnsupportedAudioFileException e) {
                JOptionPane.showMessageDialog(this, "지원되지 않는 오디오 파일 형식입니다.", "오류", JOptionPane.ERROR_MESSAGE);
            } catch (LineUnavailableException e) {
                JOptionPane.showMessageDialog(this, "오디오 장치를 사용할 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "오디오 파일을 열 수 없습니다.", "오류", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopAudio() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new P0821_7().setVisible(true);
            }
        });
    }
}
