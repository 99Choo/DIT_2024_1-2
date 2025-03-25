package Home_Work;

import java.util.Calendar;
import java.util.Scanner;

public class P0396_7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성하여 사용자 입력 받기

        while (true) {
            System.out.print("년도 입력(-1이면 종료)>>"); // 년도를 입력받아 출력
            int year = scanner.nextInt(); // 사용자로부터 년도를 입력받음

            if (year == -1) {
                break; // 사용자가 -1을 입력하면 프로그램 종료
            }

            // 각 달의 달력을 출력하기 위해 반복
            for (int month = 0; month < 12; month++) {
                printCalendar(year, month); // 달력 출력 메소드 호출
            }
        }

        scanner.close(); // Scanner 객체 닫기
    }

    private static void printCalendar(int year, int month) {
        Calendar calendar = Calendar.getInstance(); // Calendar 객체 생성
        calendar.set(year, month, 1); // 해당 년도와 월의 첫 번째 날짜로 설정

        int lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH); // 해당 달의 마지막 날짜
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 해당 달의 첫 번째 날의 요일

        System.out.printf("\n%d년 %d월\n", year, month + 1); // 년도와 월 출력
        System.out.println("일 월 화 수 목 금 토"); // 요일 출력

        // 첫 주의 요일에 맞춰 빈 칸 출력
        for (int i = 1; i < dayOfWeek; i++) {
            System.out.print("   ");
        }

        // 날짜 출력
        for (int day = 1; day <= lastDay; day++) {
            System.out.printf("%2d ", day); // 날짜 출력
            if ((dayOfWeek + day - 1) % 7 == 0) {
                System.out.println(); // 한 주가 끝나면 줄 바꿈
            }
        }
        System.out.println(); // 다음 달력 출력을 위해 줄 바꿈
    }
}
