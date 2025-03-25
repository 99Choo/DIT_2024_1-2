package Home_Work;

import java.util.Scanner;

public class P0168_11 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);
        int wrongCount = 0; // 틀린 횟수 초기화

        System.out.println("***** 구구단을 맞추는 퀴즈입니다. *****");

        // while 반복문을 사용하여 퀴즈 진행
        while (wrongCount < 3) {
            // 1~9 범위의 랜덤한 정수 두 개 생성
            int num1 = (int) (Math.random() * 9 + 1);
            int num2 = (int) (Math.random() * 9 + 1);
            int correctAnswer = num1 * num2; // 정답 계산

            // 문제 출력
            System.out.printf("%dx%d=", num1, num2);
            int userAnswer = scanner.nextInt(); // 사용자 입력 받기

            // 정답 여부 판단
            if (userAnswer == correctAnswer) {
                System.out.println("정답입니다. 잘했습니다.");
            } else {
                wrongCount++; // 틀린 횟수 증가
                System.out.printf("%d번 틀렸습니다. 분발하세요.\n", wrongCount);
            }
        }

        // 틀린 횟수가 3번이 되면 종료 메시지 출력
        System.out.println("3번 틀렸습니다. 퀴즈 종료합니다.");
        scanner.close(); // Scanner 객체 닫기
    }
}
