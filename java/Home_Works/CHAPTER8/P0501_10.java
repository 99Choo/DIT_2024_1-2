package CHAPTER8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class P0501_10 {
    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        
        // 파일 읽기
        try {
            Scanner fileScanner = new Scanner(new File("c:\\temp\\phone.txt"));
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(" ");
                String name = parts[0];
                String phoneNumber = parts[1];
                phoneBook.put(name, phoneNumber);
            }
            fileScanner.close();
            System.out.println("총 " + phoneBook.size() + "개의 전화번호를 읽었습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다: c:\\temp\\phone.txt");
            e.printStackTrace();
            return;
        }

        // 사용자 입력 및 검색
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("이름 >> ");
            String name = sc.nextLine();
            if (name.equals("그만")) break;

            String phoneNumber = phoneBook.get(name);
            if (phoneNumber != null) {
                System.out.println(phoneNumber);
            } else {
                System.out.println("찾는 이름이 없습니다.");
            }
        }
        sc.close();
    }
}
