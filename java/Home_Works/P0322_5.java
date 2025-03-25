package Home_Work;

class Point3D extends Point {
  private int z;

  public Point3D(int x, int y, int z) {
      super(x, y);
      this.z = z;
  }

  public void moveUp() {
      z++;
  }

  public void moveDown() {
      z--;
  }

  public void move(int x, int y, int z) {
      super.move(x, y);
      this.z = z;
  }

  @Override
  public String toString() {
      return "(" + getX() + "," + getY() + "," + z + ")의 점";
  }
}

public class P0322_5 {
  public static void main(String[] args) {
      Point3D p = new Point3D(3, 2, 1);
      System.out.println(p.toString() + "입니다."); 

      p.moveUp(); // z 좌표를 3으로 이동
      System.out.println(p.toString() + "입니다."); 

      p.moveDown(); // z 좌표를 -2로 이동
      System.out.println(p.toString() + "입니다."); 

      p.move(10, 10, 10); // x=10, y=10, z=10으로 이동
      System.out.println(p.toString() + "입니다."); 

      p.move(100, 200, 300);
      System.out.println(p.toString() + "입니다."); 
  }
}