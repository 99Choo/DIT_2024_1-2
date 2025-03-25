package Home_Work;

import java.util.Calendar;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P0397_8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성하여 사용자 입력 받기
        Calendar today = Calendar.getInstance(); // 현재 날짜와 시간을 얻어옴
        today.set(2024, Calendar.APRIL, 15); // 오늘 날짜를 2024년 4월 15일로 설정

        while (true) {
            System.out.print("생일 입력(년 월 일)>>"); // 사용자에게 생일 입력 요청
            String birthDate = scanner.nextLine(); // 사용자로부터 생일 입력 받기
            
            StringTokenizer st = new StringTokenizer(birthDate); // 입력받은 생일을 공백 기준으로 나누기
            int birthYear = Integer.parseInt(st.nextToken()); // 년도 추출
            int birthMonth = Integer.parseInt(st.nextToken()) - 1; // 월 추출 (0부터 시작)
            int birthDay = Integer.parseInt(st.nextToken()); // 일 추출
            
            Calendar birthCalendar = Calendar.getInstance(); // 생일을 저장할 Calendar 객체 생성
            birthCalendar.set(birthYear, birthMonth, birthDay); // 생일 설정
            
            if (birthCalendar.after(today)) {
                System.out.println("잘못된 입력입니다. 다시 입력해 주세요."); // 생일이 오늘 이후라면 오류 메시지 출력
                continue; // 루프 재시작
            }
            
            int daysLived = calculateDaysLived(birthCalendar, today); // 살아온 날 수 계산
            
            if (daysLived > 0) {
                System.out.printf("오늘까지 %d일 살아왔습니다.%n", daysLived); // 살아온 날 수 출력
            } else {
                System.out.printf("%d일 더 살아야 생일이 됩니다.%n", -daysLived); // 생일까지 남은 날 수 출력
            }
        }
    }
    
    // 생일부터 오늘까지의 날 수를 계산하는 메소드
    private static int calculateDaysLived(Calendar birthCalendar, Calendar today) {
        int daysLived = 0; // 초기화
        
        while (birthCalendar.before(today) || birthCalendar.equals(today)) {
            daysLived++; // 하루 증가
            birthCalendar.add(Calendar.DAY_OF_YEAR, 1); // 하루씩 더하기
        }
        
        return daysLived; // 계산된 날 수 반환
    }
}
