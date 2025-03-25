package CHAPTER8;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class P0503_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File currentDir = new File("c:\\");
        System.out.println("***** 파일 탐색기입니다. *****");

        while (true) {
            System.out.println(" [" + currentDir.getAbsolutePath() + "]");
            File[] files = currentDir.listFiles();

            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("dir\t" + file.length() + "바이트\t" + file.getName());
                } else {
                    System.out.println("\t" + file.length() + "바이트\t" + file.getName());
                }
            }

            System.out.print(">> ");
            String command = sc.nextLine();

            if (command.equals("그만")) break;

            if (command.equals("..")) {
                currentDir = currentDir.getParentFile();
                if (currentDir == null) {
                    System.out.println("더 이상 상위 디렉터리가 없습니다.");
                    currentDir = new File("c:\\");
                }
            } else {
                File nextDir = new File(currentDir, command);
                if (nextDir.isDirectory()) {
                    currentDir = nextDir;
                } else {
                    System.out.println(command + "은(는) 디렉터리가 아닙니다.");
                }
            }
        }
        
        sc.close();
    }
}
