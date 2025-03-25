package CHAPTER_2;
import java.util.Scanner;
// 예제 2-5
public class P82 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: ");
		int time = scanner.nextInt(); //정수입력
		int second = time % 60; //60으로 나눈 나머지 초
		int minute = (time / 60) % 60; // 60으로 나눈 몫을 다시 60으로 나눈 나머지 분
		int hour = (time / 60) / 60; //60으로 나눈 몫을 다시 60으로 나눈 몫은 시간
		
		System.out.print(time + "초는 ");
		System.out.print(hour + "시간, ");
		System.out.print(minute + "분, ");
		System.out.println(second + "초입니다.");
		scanner.close();
	}

}
