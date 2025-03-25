package Home_Work;

import java.util.Random; // 랜덤 숫자를 생성하기 위해 Random 클래스를 임포트
import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner 클래스를 임포트

public class P0168_10 {
    public static void main(String[] args) {
        int[][] array = new int[4][4]; // 4x4 크기의 2차원 배열 선언
        Random random = new Random(); // Random 객체 생성
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성

        // 2차원 배열에 랜덤한 값 저장
        for (int i = 0; i < array.length; i++) { // 배열의 행을 순회
            for (int j = 0; j < array[i].length; j++) { // 배열의 열을 순회
                array[i][j] = random.nextInt(256); // 0~255 범위의 랜덤한 정수 생성하여 저장
            }
        }

        // 2차원 배열 출력
        System.out.println("4x4 배열에 랜덤한 값을 저장한 후 출력합니다.");
        for (int i = 0; i < array.length; i++) { // 배열의 행을 순회
            for (int j = 0; j < array[i].length; j++) { // 배열의 열을 순회
                System.out.print(array[i][j] + " "); // 배열의 각 요소를 출력
            }
            System.out.println(); // 각 행이 끝날 때 줄바꿈
        }

        // 임계값 입력받기
        System.out.print("임계값 입력>> ");
        int threshold = scanner.nextInt(); // 임계값 입력받기

        // 배열 수정: 임계값보다 크면 255, 작거나 같으면 0으로 수정
        for (int i = 0; i < array.length; i++) { // 배열의 행을 순회
            for (int j = 0; j < array[i].length; j++) { // 배열의 열을 순회
                if (array[i][j] > threshold) { // 조건문: 값이 임계값보다 큰 경우
                    array[i][j] = 255; // 255로 수정
                } else { // 값이 임계값보다 작거나 같은 경우
                    array[i][j] = 0; // 0으로 수정
                }
            }
        }

        // 수정된 배열 출력
        System.out.println("수정된 배열:");
        for (int i = 0; i < array.length; i++) { // 배열의 행을 순회
            for (int j = 0; j < array[i].length; j++) { // 배열의 열을 순회
                System.out.print(array[i][j] + " "); // 배열의 각 요소를 출력
            }
            System.out.println(); // 각 행이 끝날 때 줄바꿈
        }

        scanner.close(); // 스캐너 닫기
    }
}
