package Home_Work;

import java.util.Random; // Random 클래스를 사용하기 위해 임포트
import java.util.Scanner; // Scanner 클래스를 사용하기 위해 임포트

public class P0167_7 {
    public static void main(String[] args) {
        int[] n = new int[10]; // 크기가 10인 일차원 배열 선언
        Random random = new Random(); // Random 객체 생성
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        // 11~19 범위의 랜덤한 정수 10개 생성하여 배열에 저장
        for (int i = 0; i < n.length; i++) {
            n[i] = random.nextInt(9) + 11; // 11~19 범위의 랜덤한 정수 생성
        }

        // 배열에 저장된 정수 출력
        System.out.print("랜덤한 정수들... ");
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " "); // 배열의 각 요소 출력
        }
        System.out.println(); // 줄바꿈

        // 배열에 저장된 정수들의 합 계산
        int sum = 0;
        for (int i = 0; i < n.length; i++) {
            sum += n[i]; // 배열의 각 요소를 합산
        }

        // 평균 계산 및 출력
        double average = (double) sum / n.length; // 평균 계산
        System.out.printf("평균은 %.1f\n", average); // 평균 출력

        scanner.close(); // 스캐너 닫기
    }
}
