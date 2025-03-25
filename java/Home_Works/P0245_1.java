package Home_Work;
// 자바 클래스 만들기.(생성자,메소드,필드 등 작성)와 객체 활용
public class P0245_1 {
    // 필드
    private String brand;
    private int size;
    private int price;

    // 생성자
    public P0245_1(String brand, int size, int price) {
        this.brand = brand;
        this.size = size;
        this.price = price;
    }

    // 메소드
    public void show() {
        System.out.println(brand + "에서 만든 " + price + "만원짜리의 " + size + "인치 TV");
    }

    // main 메소드
    public static void main(String[] args) {
        P0245_1 tv = new P0245_1("Samsung", 50, 300); // 300만원짜리 Samsung에서 만든 50인치 TV
        tv.show();
    }
}
