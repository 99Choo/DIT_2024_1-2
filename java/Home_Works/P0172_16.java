package Home_Work;

import java.util.Scanner;

public class P0172_16 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        int sum = 0; // 양수의 합을 저장할 변수
        int count = 0; // 양수의 개수를 저장할 변수

        System.out.println("양의 정수를 입력하세요. -1은 입력 끝>>");

        while (true) {
            String input = scanner.next(); // 사용자 입력 받기

            // "-1"을 입력하면 프로그램 종료
            if (input.equals("-1")) {
                break;
            }

            try {
                int number = Integer.parseInt(input); // 입력을 정수로 변환

                // 양수인 경우 합과 개수에 포함
                if (number > 0) {
                    sum += number;
                    count++;
                } else {
                    System.out.println(input + " 제외");
                }
            } catch (NumberFormatException e) {
                // 정수가 아닌 입력에 대한 예외 처리
                System.out.println(input + " 제외");
            }
        }

        // 평균 계산 및 출력
        if (count > 0) {
            double average = (double) sum / count;
            System.out.println("평균은 " + average);
        } else {
            System.out.println("입력된 양수가 없습니다.");
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
