package Home_Work;

import java.util.Scanner; // Scanner 클래스를 가져와서 입력을 받을 수 있도록 함

public class P0396_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        System.out.println("문자열을 입력하세요. 빈 칸이 있어도 되고 영어 한글 모두 됩니다."); // 사용자에게 입력을 요청하는 메시지 출력
        String input = scanner.nextLine(); // 사용자가 입력한 문자열을 읽어옴
        
        int length = input.length(); // 입력된 문자열의 길이를 저장
        for (int i = 0; i < length; i++) {
            // substring() 메소드를 사용하여 문자열을 회전시키기
            String rotated = input.substring(i) + input.substring(0, i); // 문자열을 회전시켜 새로운 문자열 생성
            System.out.println(rotated); // 회전된 문자열 출력
        }
        // 마지막에 원래 문자열 출력하기
        System.out.println(input); // 원래 문자열을 다시 출력하여 끝맺음
        
        scanner.close(); // Scanner 객체 닫기
    }
}
