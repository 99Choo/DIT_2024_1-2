package Home_Work;
// 여러 클래스와 여러 객체들을 다루는 종합 응용 
import java.util.Scanner;

class Seat {
    private String[] seats; // 좌석 배열

    public Seat() {
        seats = new String[10]; // 좌석 배열 초기화
        for (int i = 0; i < seats.length; i++) {
            seats[i] = "---"; // 초기 좌석 상태
        }
    }

    // 좌석 예약 메소드
    public boolean reserve(String name, int seatNumber) {
        if (seatNumber < 1 || seatNumber > 10 || !seats[seatNumber - 1].equals("---")) {
            return false; // 잘못된 좌석 번호 또는 이미 예약된 좌석
        }
        seats[seatNumber - 1] = name; // 좌석 예약
        return true;
    }

    // 좌석 취소 메소드
    public boolean cancel(String name) {
        for (int i = 0; i < seats.length; i++) {
            if (seats[i].equals(name)) {
                seats[i] = "---"; // 좌석 취소
                return true;
            }
        }
        return false; // 예약자 이름이 없는 경우
    }

    // 좌석 상태 출력 메소드
    public void show() {
        for (String seat : seats) {
            System.out.print(seat + " ");
        }
        System.out.println();
    }
}

public class P0252_13 {
    private Seat[] seats; // S석, A석, B석 좌석 배열
    private Scanner scanner;

    public P0252_13() {
        seats = new Seat[3]; // S석, A석, B석 초기화
        for (int i = 0; i < seats.length; i++) {
            seats[i] = new Seat();
        }
        scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("명품콘서트홀 예약 시스템입니다.");
        while (true) {
            System.out.print("예약:1, 조회:2, 취소:3, 끝내기:4>>");
            int menu = scanner.nextInt();
            switch (menu) {
                case 1:
                    reserve();
                    break;
                case 2:
                    show();
                    break;
                case 3:
                    cancel();
                    break;
                case 4:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다. 다시 시도하세요.");
            }
        }
    }

    private void reserve() {
        System.out.print("좌석구분 S(1), A(2), B(3)>>");
        int seatType = scanner.nextInt();
        if (seatType < 1 || seatType > 3) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }
        System.out.print("이름>>");
        String name = scanner.next();
        System.out.print("번호>>");
        int seatNumber = scanner.nextInt();
        if (!seats[seatType - 1].reserve(name, seatNumber)) {
            System.out.println("예약에 실패했습니다. 다시 시도하세요.");
        }
    }

    private void show() {
        System.out.print("S>> ");
        seats[0].show();
        System.out.print("A>> ");
        seats[1].show();
        System.out.print("B>> ");
        seats[2].show();
        System.out.println("<<<조회를 완료하였습니다.>>>");
    }

    private void cancel() {
        System.out.print("좌석 S:1, A:2, B:3>>");
        int seatType = scanner.nextInt();
        if (seatType < 1 || seatType > 3) {
            System.out.println("잘못된 좌석 구분입니다.");
            return;
        }
        System.out.print("이름>>");
        String name = scanner.next();
        if (!seats[seatType - 1].cancel(name)) {
            System.out.println("취소에 실패했습니다. 다시 시도하세요.");
        }
    }

    public static void main(String[] args) {
        P0252_13 concertReservationSystem = new P0252_13();
        concertReservationSystem.run();
    }
}

