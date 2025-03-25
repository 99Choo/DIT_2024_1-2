package Home_Work;
import java.util.Scanner;

public class P0114 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("자동차 상태 입력>> ");
        int status = scanner.nextInt();  // 자동차 상태를 나타내는 정수 입력받기

        // 자동차 달리는 상태: 비트 7
        if ((status & 0b10000000) != 0) {
            System.out.print("자동차는 달리는 상태이고 ");
        } else {
            System.out.print("자동차는 멈춘 상태이고 ");
        }

        // 에어컨 상태: 비트 6
        if ((status & 0b01000000) != 0) {
            System.out.print("에어컨이 켜진 상태이고 ");
        } else {
            System.out.print("에어컨이 꺼진 상태이고 ");
        }

        // 차내 온도: 비트 0~5 (하위 6비트)
        int temperature = status & 0b00111111;  // 하위 6비트로 차내 온도 추출
        System.out.println("온도는 " + temperature + "도");

        scanner.close();
    }
}
