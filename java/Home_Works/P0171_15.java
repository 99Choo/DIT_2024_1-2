package Home_Work;

import java.util.InputMismatchException;
import java.util.Scanner;

public class P0171_15 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        int n = 0, m = 0; // 두 정수를 저장할 변수 초기화

        while (true) {
            try {
                System.out.print("곱하고자 하는 정수 2개 입력>>");
                n = scanner.nextInt(); // 첫 번째 정수 입력 받기
                m = scanner.nextInt(); // 두 번째 정수 입력 받기
                break; // 두 정수가 정상적으로 입력되면 반복문 종료
            } catch (InputMismatchException e) {
                // 정수가 아닌 값이 입력된 경우 예외 처리
                System.out.println("정수를 입력하세요!");
                scanner.nextLine(); // 입력 버퍼 비우기
            }
        }

        // 곱셈 결과 출력
        System.out.println(n + "x" + m + "=" + (n * m));
        scanner.close(); // Scanner 객체 닫기
    }
}
