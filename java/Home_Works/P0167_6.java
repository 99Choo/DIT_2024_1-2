package Home_Work;

import java.util.Scanner;

public class P0167_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = new int[10]; // 크기가 10인 일차원 배열 선언

        // 양의 정수 10개 입력받기
        System.out.print("양의 정수 10개 입력>> ");
        for (int i = 0; i < n.length; i++) {
            n[i] = scanner.nextInt(); // 입력받은 정수를 배열에 저장
        }

        // 자리수의 합이 9인 수 출력
        System.out.print("자리수의 합이 9인 것은... ");
        for (int i = 0; i < n.length; i++) {
            if (sumOfDigits(n[i]) == 9) { // 자리수의 합이 9인지 확인
                System.out.print(n[i] + " "); // 조건을 만족하는 경우 출력
            }
        }

        scanner.close(); // 스캐너 닫기
    }

    // 주어진 수의 자리수 합을 계산하는 메소드
    public static int sumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10; // 마지막 자리수를 더함
            number /= 10; // 마지막 자리수를 제거
        }
        return sum; // 자리수 합 반환
    }
}
