package Home_Work;
import java.util.Scanner;
public class P0113 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("냉장고 상태 입력");
        String str = scanner.next(); // 문자열로 "00001101" 등을 입력
        byte status = Byte.parseByte(str, 2); // 문자열 00001010을 2진수로 만들어 바이트 타입의 정수 status 저장

        if((status & 0b00000001) != 0) System.out.println("전원 켜져 있음. ");
        else System.out.println("전원 꺼져 있음. ");
        if((status & 0b00000010) != 0) System.out.println("문 닫혀 있음. ");
        else System.out.println("문 열려 있음. ");
        if((status & 0b00000100) != 0) System.out.println("전구 정상 작동. ");
        else System.out.println("전구 손상. ");
        if((status & 0b00001000) != 0) System.out.println("냉장고 온도 3도 미만. ");
        else System.out.println("3도 이상. ");
        
        scanner.close();
    }
}
