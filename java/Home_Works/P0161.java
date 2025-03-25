package Home_Work;
import java.util.Random;
import java.util.Scanner;

public class P0161 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random r = new Random();
        char playAgain = 'y';  // 'y'를 문자로 지정

        while (playAgain == 'y') {  // 'y'인 동안 게임 반복
            int k = r.nextInt(100) + 1;  // 1~100 사이의 숫자를 랜덤으로 선택
            int num = -1;  // 초기 값을 -1로 설정
            System.out.println("수를 결정하였습니다. 맞추어 보세요");

            while (num != k) {  // 숫자가 맞을 때까지 반복
                System.out.print("숫자를 입력하세요: ");
                num = scanner.nextInt();

                if (num > k) {
                    System.out.println("더 낮게");
                } else if (num < k) {
                    System.out.println("더 높게");
                } else {
                    System.out.println("맞았습니다.");
                }
            }

            // 게임을 다시 할지 물어봄
            System.out.print("다시 하시겠습니까(y/n): ");
            playAgain = scanner.next().charAt(0);  // 다시 플레이할지 결정
        }

        scanner.close();
    }
}
