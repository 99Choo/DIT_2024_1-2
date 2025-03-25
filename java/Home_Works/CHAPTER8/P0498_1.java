package CHAPTER8;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class P0498_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileWriter writer = new FileWriter("c:\\temp\\phone.txt");
            System.out.println("전화번호 입력 프로그램입니다.");

            while (true) {
                System.out.print("이름 전화번호 >> ");
                String input = sc.nextLine();
                if (input.equals("그만")) {
                    break;
                }
                writer.write(input + "\n");
            }

            writer.close();
            System.out.println("c:\\temp\\phone.txt에 저장하였습니다.");
        } catch (IOException e) {
            System.out.println("파일을 저장하는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
        sc.close();
    }
}
