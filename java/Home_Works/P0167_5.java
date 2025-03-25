package Home_Work;

import java.util.Scanner;

public class P0167_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = new int[10]; // 크기가 10인 일차원 배열 선언

        // 양의 정수 10개 입력받기
        System.out.print("양의 정수 10개 입력>> ");
        for (int i = 0; i < n.length; i++) {
            n[i] = scanner.nextInt(); // 입력받은 정수를 배열에 저장
        }

        // 3의 배수 출력
        System.out.print("3의 배수는... ");
        for (int i = 0; i < n.length; i++) {
            if (n[i] % 3 == 0) { // 배열의 요소가 3의 배수인지 확인
                System.out.print(n[i] + " "); // 3의 배수인 경우 출력
            }
        }

        scanner.close(); // 스캐너 닫기
    }
}
