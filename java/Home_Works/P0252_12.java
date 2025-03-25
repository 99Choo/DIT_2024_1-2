package Home_Work;
// static 메소드 작성 및 호출, 배열 다루기 연습 
import java.util.Scanner;

class Dictionary {
    private static String[] kor = {"사랑", "아기", "돈", "미래", "희망"}; // 한글 단어 배열
    private static String[] eng = {"love", "baby", "money", "future", "hope"}; // 영어 단어 배열

    // 한글 단어를 영어 단어로 변환하는 메소드
    public static String kor2Eng(String word) {
        for (int i = 0; i < kor.length; i++) {
            if (kor[i].equals(word)) {
                return eng[i]; // 한글 단어에 해당하는 영어 단어 반환
            }
        }
        return null; // 해당하는 영어 단어가 없으면 null 반환
    }
}

public class P0252_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("한영 단어 검색 프로그램입니다.");

        while (true) {
            System.out.print("한글 단어? ");
            String word = scanner.next();

            if (word.equals("그만")) {
                System.out.println("프로그램을 종료합니다.");
                break; // "그만"을 입력하면 프로그램 종료
            }

            String translation = Dictionary.kor2Eng(word);
            if (translation != null) {
                System.out.println(word + "는 " + translation);
            } else {
                System.out.println(word + "는 저의 사전에 없습니다.");
            }
        }

        scanner.close();
    }
}
