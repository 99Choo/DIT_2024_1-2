package Home_Work;

import java.util.Scanner;

public class P0170_14 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        System.out.println("***** 갬블링 게임을 시작합니다. *****");

        // 무한 반복문을 사용하여 게임 진행
        while (true) {
            System.out.print("엔터키 입력>>");
            scanner.nextLine(); // 엔터키 입력 받기

            // 0, 1, 2 중에서 랜덤하게 3개의 수 생성
            int num1 = (int) (Math.random() * 3);
            int num2 = (int) (Math.random() * 3);
            int num3 = (int) (Math.random() * 3);

            // 생성된 수 출력
            System.out.println(num1 + " " + num2 + " " + num3);

            // 3개의 수가 모두 같은지 확인
            if (num1 == num2 && num2 == num3) {
                System.out.println("성공! 대박났어요!");
            }

            // 게임 계속 여부 묻기
            System.out.print("계속하시겠습니까?(yes/no)>>");
            String answer = scanner.nextLine(); // yes/no 입력 받기

            // "no"를 입력하면 게임 종료
            if (answer.equals("no")) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
