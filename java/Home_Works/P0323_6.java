package Home_Work;

class PositivePoint extends Point {

  public PositivePoint() {
      super(1, 1); // 기본값 (1, 1)
  }

  public PositivePoint(int x, int y) {
      super(x > 0 ? x : 1, y > 0 ? y : 1); // 양수 좌표만 허용, 음수면 (1, 1)
  }

  @Override
  public void move(int x, int y) {
      if (x > 0 && y > 0) { // 양수 좌표일 때만 이동
          super.move(x, y);
      }
  }

  @Override
  public String toString() {
      return "(" + getX() + "," + getY() + ")의 점";
  }
}

public class P0323_6 {
  public static void main(String[] args) {
      PositivePoint p = new PositivePoint(10, 10); 
      System.out.println(p.toString() + "입니다."); // 출력: (10,10)의 점입니다.

      p.move(5, 5); 
      System.out.println(p.toString() + "입니다."); // 출력: (5,5)의 점입니다.

      p.move(-2, -2); 
      System.out.println(p.toString() + "입니다."); // 출력: (5,5)의 점입니다. (이동하지 않음)

      PositivePoint q = new PositivePoint(-10, -10); 
      System.out.println(q.toString() + "입니다."); // 출력: (1,1)의 점입니다.
  }
}
 
