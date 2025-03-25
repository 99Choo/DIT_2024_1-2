package Home_Work;

class ColorPoint2 extends ColorPoint {

  public ColorPoint2(int x, int y, String color) {
      super(x, y, color);
  }

  public ColorPoint2() {
      super(0, 0, "WHITE"); // 기본 위치와 색상 설정
  }

  // 두 점 사이의 거리를 계산하는 메서드
  public double getDistance(ColorPoint2 other) {
      int dx = getX() - other.getX();
      int dy = getY() - other.getY();
      return Math.sqrt(dx * dx + dy * dy);
  }
}

public class P0322_4 {
	  public static void main(String[] args) {
	      ColorPoint2 zeroPoint = new ColorPoint2();
	      System.out.println(zeroPoint.toString() + "입니다."); // WHITE색의 (0,0)의 점입니다.

	      ColorPoint2 cp = new ColorPoint2(10, 10, "RED");
	      System.out.println(cp.toString() + "입니다."); // RED색의 (10,10)의 점입니다.
	      
	      cp.setColor("BLUE");
	      cp.setXY(10, 20);
	      System.out.println(cp.toString() + "입니다."); // BLUE색의 (10,20)의 점입니다.

	      ColorPoint2 thresholdPoint = new ColorPoint2(100, 100, "BLACK");
	      System.out.println("cp에서 임계점까지의 거리는 " + cp.getDistance(thresholdPoint));
	  }
}
