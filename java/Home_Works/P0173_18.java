package Home_Work;

import java.util.InputMismatchException;
import java.util.Scanner;

public class P0173_18 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 10명의 학생 학번과 점수를 저장할 배열
        int[] studentIds = new int[10];
        int[] scores = new int[10];

        System.out.println("10명 학생의 학번과 점수 입력");

        // 10명의 학생 학번과 점수를 입력받아 배열에 저장
        for (int i = 0; i < 10; i++) {
            System.out.print((i + 1) + ">>");
            studentIds[i] = scanner.nextInt(); // 학번 입력 받기
            scores[i] = scanner.nextInt(); // 점수 입력 받기
        }

        while (true) {
            System.out.print("학번으로 검색: 1, 점수로 검색: 2, 끝내려면 3>>");
            int choice = 0;

            try {
                choice = scanner.nextInt(); // 검색 옵션 입력 받기
            } catch (InputMismatchException e) {
                System.out.println("경고!! 정수를 입력하세요.");
                scanner.nextLine(); // 입력 버퍼 비우기
                continue;
            }

            if (choice == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.print("학번>>");
                    try {
                        int id = scanner.nextInt(); // 학번 입력 받기
                        boolean found = false;

                        for (int i = 0; i < studentIds.length; i++) {
                            if (studentIds[i] == id) {
                                System.out.println(scores[i] + "점");
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println(id + "의 학생은 없습니다.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine(); // 입력 버퍼 비우기
                    }
                    break;

                case 2:
                    System.out.print("점수>>");
                    try {
                        int score = scanner.nextInt(); // 점수 입력 받기
                        boolean found = false;

                        for (int i = 0; i < scores.length; i++) {
                            if (scores[i] == score) {
                                System.out.println("점수가 " + score + "인 학생은 없습니다.");
                                found = true;
                                break;
                            }
                        }

                        if (!found) {
                            System.out.println("점수가 " + score + "인 학생은 없습니다.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("경고!! 정수를 입력하세요.");
                        scanner.nextLine(); // 입력 버퍼 비우기
                    }
                    break;

                default:
                    System.out.println("잘못된 선택입니다. 다시 입력하세요.");
                    break;
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
