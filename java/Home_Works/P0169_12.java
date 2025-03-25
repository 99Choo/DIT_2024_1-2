package Home_Work;

import java.util.Scanner;

public class P0169_12 {
    public static void main(String[] args) {
        // Scanner 객체 생성하여 사용자 입력 받기
        Scanner scanner = new Scanner(System.in);

        // 남자와 여자의 이름을 구성하는 중간 글자와 마지막 글자 배열
        String[] boyMiddleList = {"기", "민", "용", "종", "현", "진", "재", "승", "소", "상", "지"};
        String[] boyLastList = {"태", "진", "광", "혁", "우", "철", "빈", "준", "구", "호", "석"};
        String[] girlMiddleList = {"은", "원", "경", "수", "현", "예", "여", "송", "서", "채", "하"};
        String[] girlLastList = {"진", "연", "경", "서", "리", "숙", "미", "원", "린", "희", "수"};

        System.out.println("***** 작명 프로그램이 실행됩니다. *****");

        // 무한 반복문을 사용하여 사용자 입력을 계속 받음
        while (true) {
            System.out.print("남/여 선택>>");
            String gender = scanner.next(); // 성별 입력 받기

            // "그만"을 입력하면 프로그램 종료
            if (gender.equals("그만")) {
                break;
            }

            // 성별이 "남" 또는 "여"가 아닌 경우 오류 메시지 출력
            if (!gender.equals("남") && !gender.equals("여")) {
                System.out.println("남/여/그만 중에서 입력하세요!");
                continue;
            }

            System.out.print("성 입력>>");
            String lastName = scanner.next(); // 성 입력 받기

            // 랜덤하게 중간 글자와 마지막 글자 선택
            int middleIndex = (int) (Math.random() * 11);
            int lastIndex = (int) (Math.random() * 11);

            String name = ""; // 최종 이름 초기화

            // 성별에 따라 이름 생성
            if (gender.equals("남")) {
                name = lastName + boyMiddleList[middleIndex] + boyLastList[lastIndex];
            } else if (gender.equals("여")) {
                name = lastName + girlMiddleList[middleIndex] + girlLastList[lastIndex];
            }

            // 추천 이름 출력
            System.out.println("추천 이름: " + name);
        }

        scanner.close(); // Scanner 객체 닫기
    }
}
