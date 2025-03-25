package Home_Work;

public class P0247_6 {
	 public static void main(String[] args) {
	        Rectangle a = new Rectangle(3, 3, 6, 6); // (3,3) 점에서 6x6 크기의 사각형
	        Rectangle b = new Rectangle(4, 4, 2, 3); // (4,4) 점에서 2x3의 크기의 사각형

	        a.show();
	        if (a.isSquare()) {
	            System.out.println("a는 정사각형입니다.");
	        } else {
	            System.out.println("a는 직사각형입니다.");
	        }
	        if (a.contains(b)) {
	            System.out.println("a는 b를 포함합니다.");
	        }
	    }
	}

	class Rectangle {
	    private int x, y, width, height; // 사각형을 구성하는 점과 크기 정보

	    // 생성자: x, y, width, height를 초기화
	    public Rectangle(int x, int y, int width, int height) {
	        this.x = x;
	        this.y = y;
	        this.width = width;
	        this.height = height;
	    }

	    // 사각형 정보를 출력하는 메소드
	    public void show() {
	        System.out.println("(" + x + "," + y + ")에서 크기가 " + width + "x" + height + "인 사각형");
	    }

	    // 정사각형인지 확인하는 메소드
	    public boolean isSquare() {
	        return width == height;
	    }

	    // 현재 사각형 내부에 매개변수로 받은 사각형 r이 있는지 확인하는 메소드
	    public boolean contains(Rectangle r) {
	        return (this.x <= r.x && this.y <= r.y &&
	                (this.x + this.width) >= (r.x + r.width) &&
	                (this.y + this.height) >= (r.y + r.height));
	    }
}
