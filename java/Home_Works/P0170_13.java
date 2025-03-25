package Home_Work;

import java.util.Scanner;

public class P0170_13 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 과목명과 학점이 들어 있는 배열
        String[] course = {"C", "C++", "Python", "Java", "HTML5"};
        String[] grade = {"A", "B+", "B", "A+", "D"};

        // 무한 반복문을 사용하여 사용자 입력을 계속 받음
        while (true) {
            System.out.print("과목>>");
            String courseName = scanner.next(); // 과목명 입력 받기

            // "그만"을 입력하면 프로그램 종료
            if (courseName.equals("그만")) {
                break;
            }

            boolean found = false; // 과목을 찾았는지 여부를 저장하는 변수

            // 배열을 순회하며 입력받은 과목명을 찾음
            for (int i = 0; i < course.length; i++) {
                if (course[i].equals(courseName)) { // 과목명이 배열의 요소와 일치하는 경우
                    System.out.println(courseName + " 학점은 " + grade[i]);
                    found = true; // 과목을 찾았음을 표시
                    break;
                }
            }

            // 과목을 찾지 못한 경우
            if (!found) {
                System.out.println(courseName + "는 없는 과목입니다.");
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
