package Home_Work;

interface Shape15 {
    final double PI = 3.14; // 원주율 상수

    void draw(); // 도형을 그리는 추상 메서드
    double getArea(); // 도형의 면적을 반환하는 추상 메서드

    default public void redraw() { // 디폴트 메서드
        System.out.print("--- 다시 그립니다. ");
        draw();
    }
}

class Circle15 implements Shape15 {
    private double radius;

    public Circle15(double radius) {
        this.radius = radius;
    }

    @Override
    public void draw() {
        System.out.println("반지름이 " + radius + "인 원");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }
}

class Oval15 implements Shape15 {
    private double width, height;

    public Oval15(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println(width + "x" + height + "에 내접하는 타원");
    }

    @Override
    public double getArea() {
        return PI * width * height / 4.0;
    }
}

class Rect15 implements Shape15 {
    private double width, height;

    public Rect15(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw() {
        System.out.println((int)width + "x" + (int)height + " 크기의 사각형");
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class P0330_15 {
    public static void main(String[] args) {
        Shape15[] list = new Shape15[3]; // Shape15 인터페이스 타입의 객체 배열 생성
        list[0] = new Circle15(5); // 반지름이 5인 원 객체
        list[1] = new Oval15(20, 30); // 20x30에 내접하는 타원 객체
        list[2] = new Rect15(10, 40); // 10x40 크기의 사각형 객체

        for (int i = 0; i < list.length; i++) {
            list[i].redraw(); // 다시 그리기
        }

        for (int i = 0; i < list.length; i++) {
            System.out.println("면적은 " + list[i].getArea());
        }
    }
}
