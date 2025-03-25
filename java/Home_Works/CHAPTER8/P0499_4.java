package CHAPTER8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class P0499_4 {
    public static void main(String[] args) {
        File file = new File("c:\\windows\\system.ini");
        try {
            Scanner sc = new Scanner(file);
            System.out.println("c:\\windows\\system.ini 파일을 읽어 출력합니다.");
            int lineNumber = 1;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                System.out.println(lineNumber + ": " + line);
                lineNumber++;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: " + file.getAbsolutePath());
            e.printStackTrace();
        }
    }
}
