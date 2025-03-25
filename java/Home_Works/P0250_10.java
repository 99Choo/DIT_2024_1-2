package Home_Work;
import java.util.Scanner;

public class P0250_10 {
	public static void main(String[] args) {
        MonthDiary monthDiary = new MonthDiary(2024, 10); // 2024년 10월 다이어리
        monthDiary.run();
    }
}

class DayDiary {
    private String memo; // 하루의 메모 텍스트

    public DayDiary() {
        this.memo = ""; // 초기 메모는 빈 문자열
    }

    public void setMemo(String memo) {
        this.memo = memo; // 메모 설정
    }

    public String getMemo() {
        return memo; // 메모 반환
    }
}

class MonthDiary {
    private int year;
    private int month;
    private DayDiary[] days; // 30일의 메모를 저장할 배열
    private Scanner scanner;

    public MonthDiary(int year, int month) {
        this.year = year;
        this.month = month;
        this.days = new DayDiary[30]; // 30일로 초기화
        for (int i = 0; i < 30; i++) {
            days[i] = new DayDiary(); // 각 날에 대한 DayDiary 객체 생성
        }
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        while (true) {
            int menu = getMenu();
            if (menu == 1) {
                write();
            } else if (menu == 2) {
                show();
            } else if (menu == 3) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
        }
    }

    private int getMenu() {
        System.out.print("기록:1, 보기:2, 종료:3>>");
        return scanner.nextInt();
    }

    private void write() {
        System.out.print("날짜(1~30)와 텍스트(빈칸없이 4글자이하)>>");
        int day = scanner.nextInt();
        String memo = scanner.next();
        if (day >= 1 && day <= 30 && memo.length() <= 4) {
            days[day - 1].setMemo(memo);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }

    private void show() {
        System.out.println("***** " + year + "년 " + month + "월 다이어리 *****");
        for (int i = 0; i < 30; i++) {
            if (!days[i].getMemo().isEmpty()) {
                System.out.println((i + 1) + "일: " + days[i].getMemo());
            }
        }
    }
}
