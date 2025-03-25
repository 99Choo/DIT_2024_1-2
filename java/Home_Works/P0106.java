package Home_Work;
import java.util.Scanner;

public class P0106 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("가위바위보 게임입니다. 가위, 바위, 보 중에서 입력하세요.");
        
        System.out.print("철수 >> ");
        String chulsoo = scanner.next();

        System.out.print("영희 >> ");
        String younghee = scanner.next();

        // 결과 비교
        if (chulsoo.equals(younghee)) {
            System.out.println("비겼습니다.");
        } else if ((chulsoo.equals("가위") && younghee.equals("보")) ||
                   (chulsoo.equals("바위") && younghee.equals("가위")) ||
                   (chulsoo.equals("보") && younghee.equals("바위"))) {
            System.out.println("철수가 이겼습니다.");
        } else {
            System.out.println("영희가 이겼습니다.");
        }

        scanner.close();
    }
}
