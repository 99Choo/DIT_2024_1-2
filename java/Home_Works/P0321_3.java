// 패키지 선언
package Home_Work;

// Point 클래스 정의
class Point {
    private int x, y; // 좌표

    // Point 클래스의 생성자
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // x 좌표 반환 메서드
    public int getX() {
        return x;
    }

    // y 좌표 반환 메서드
    public int getY() {
        return y;
    }

    // 좌표 이동 메서드
    protected void move(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

// Point 클래스를 상속하는 ColorPoint 클래스 정의
class ColorPoint extends Point {
    private String color; // 색상

    // ColorPoint 클래스의 생성자
    public ColorPoint(int x, int y, String color) {
        super(x, y); // 부모 클래스의 생성자 호출
        this.color = color;
    }

    // 색상 설정 메서드
    public void setColor(String color) {
        this.color = color;
    }

    // 좌표 설정 메서드
    public void setXY(int x, int y) {
        move(x, y); // 부모 클래스의 move 메서드 호출
    }

    // 객체의 속성을 문자열로 반환하는 메서드
    @Override
    public String toString() {
        return color + " 색의 (" + getX() + ", " + getY() + ")";
    }
}

// 메인 클래스 P321_3 정의
public class P321_3 {
    public static void main(String[] args) {
        // 5, 5 좌표와 빨간색("RED")을 가진 ColorPoint 객체 생성
        ColorPoint cp = new ColorPoint(5, 5, "RED");

        // 좌표를 10, 20으로 변경
        cp.setXY(10, 20);

        // 색상을 파란색("BLUE")으로 변경
        cp.setColor("BLUE");

        // ColorPoint 객체의 속성을 문자열로 변환하여 출력
        String str = cp.toString();
        System.out.println(str + "입니다."); // 출력: BLUE 색의 (10, 20)입니다.
    }
}
