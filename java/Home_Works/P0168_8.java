package Home_Work;

import java.util.HashSet; // 중복을 피하기 위해 HashSet을 사용
import java.util.Random; // 랜덤 숫자를 생성하기 위해 Random을 사용
import java.util.Scanner; // 사용자 입력을 받기 위해 Scanner를 사용

public class P0168_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        Random random = new Random(); // Random 객체 생성
        HashSet<Integer> uniqueNumbers = new HashSet<>(); // 중복을 피하기 위해 HashSet 사용

        // 사용자로부터 저장할 정수의 개수를 입력받음
        System.out.print("정수를 몇 개 저장하시겠습니까?>> ");
        int count = scanner.nextInt();

        // 입력받은 개수만큼의 배열을 생성
        int[] numbers = new int[count];

        // 1~100 범위의 랜덤한 정수를 배열에 저장 (중복되지 않게)
        while (uniqueNumbers.size() < count) {
            int num = random.nextInt(100) + 1; // 1~100 범위의 랜덤한 정수 생성
            uniqueNumbers.add(num); // HashSet에 추가 (중복된 값은 자동으로 걸러짐)
        }

        // HashSet의 값을 배열에 복사
        int index = 0;
        for (int num : uniqueNumbers) {
            numbers[index++] = num;
        }

        // 배열에 저장된 정수 출력
        System.out.print("랜덤한 정수들... ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println(); // 줄바꿈

        // 배열에 저장된 정수들의 합 계산
        int sum = 0;
        for (int num : numbers) {
            sum += num; // 배열의 각 요소를 합산
        }

        // 평균 계산 및 출력
        double average = (double) sum / numbers.length; // 평균 계산
        System.out.printf("평균은 %.15f\n", average); // 평균 출력

        scanner.close(); // 스캐너 닫기
    }
}
