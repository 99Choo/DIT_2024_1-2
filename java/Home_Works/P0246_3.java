package Home_Work;
// 클래스 만들기와 객체 활용
import java.util.Scanner;

public class P0246_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner 객체 생성
        System.out.print("이름, 자바, 웹프로그래밍, 운영체제 순으로 점수 입력>>");
        String name = scanner.next(); // 이름 입력
        int java = scanner.nextInt(); // 자바 점수 입력
        int web = scanner.nextInt(); // 웹프로그래밍 점수 입력
        int os = scanner.nextInt(); // 운영체제 점수 입력
        Grade st = new Grade(name, java, web, os); // Grade 객체 생성
        System.out.print(st.getName() + "의 평균은 " + st.getAverage()); // 평균 출력
        scanner.close(); // Scanner 객체 닫기
    }
}

class Grade {
    private String name; // 학생 이름
    private int javaScore; // 자바 점수
    private int webScore; // 웹프로그래밍 점수
    private int osScore; // 운영체제 점수

    public Grade(String name, int javaScore, int webScore, int osScore) {
        this.name = name; // 이름 초기화
        this.javaScore = javaScore; // 자바 점수 초기화
        this.webScore = webScore; // 웹프로그래밍 점수 초기화
        this.osScore = osScore; // 운영체제 점수 초기화
    }

    public String getName() {
        return name; // 이름 반환
    }

    public double getAverage() {
        return (javaScore + webScore + osScore) / 3.0; // 평균 계산 및 반환
    }
}
