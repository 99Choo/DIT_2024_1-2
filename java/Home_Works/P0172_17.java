package Home_Work;

import java.util.InputMismatchException;
import java.util.Scanner;

public class P0172_17 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 커피 메뉴와 가격 배열
        String[] coffee = {"핫아메리카노", "아이스아메리카노", "카푸치노", "라떼"};
        int[] price = {3000, 3500, 4000, 5000};

        System.out.println("핫아메리카노, 아이스아메리카노, 카푸치노, 라떼 있습니다.");

        // 무한 반복문을 사용하여 주문을 계속 받음
        while (true) {
            System.out.print("주문>>");
            String order = scanner.next(); // 커피 종류 입력 받기

            // "그만"을 입력하면 프로그램 종료
            if (order.equals("그만")) {
                break;
            }

            boolean found = false; // 메뉴를 찾았는지 여부를 저장하는 변수

            // 메뉴 배열을 순회하며 입력받은 커피 종류를 찾음
            for (int i = 0; i < coffee.length; i++) {
                if (coffee[i].equals(order)) { // 커피 종류가 배열의 요소와 일치하는 경우
                    found = true; // 메뉴를 찾았음을 표시

                    try {
                        int quantity = scanner.nextInt(); // 잔 수 입력 받기
                        if (quantity <= 0) {
                            throw new InputMismatchException(); // 잔 수가 양의 정수가 아닌 경우 예외 발생
                        }
                        int totalPrice = price[i] * quantity; // 총 가격 계산
                        System.out.println("가격은 " + totalPrice + "원입니다.");
                    } catch (InputMismatchException e) {
                        System.out.println("잔 수는 양의 정수로 입력해주세요!");
                        scanner.nextLine(); // 입력 버퍼 비우기
                    }
                    break;
                }
            }

            // 메뉴를 찾지 못한 경우
            if (!found) {
                System.out.println(order + "는 없는 메뉴입니다.");
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
