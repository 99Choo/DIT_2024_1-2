package Home_Work;

class Point3D1 extends Point {
 private int z;

 public Point3D1(int x, int y, int z) {
     super(x, y);
     this.z = z;
 }

 public int getZ() { return z; }

 public void move(int x, int y, int z) {
     super.move(x, y);
     this.z = z;
 }
}

class Point3DColor extends Point3D1 {
 private String color;

 public Point3DColor(int x, int y, int z, String color) {
     super(x, y, z);
     this.color = color;
 }

 public void setColor(String color) {
     this.color = color;
 }

 @Override
 public String toString() {
     return "(" + getX() + "," + getY() + "," + getZ() + ")" + color + "점";
 }

 public boolean equals(Point3DColor other) {
     return this.getX() == other.getX() &&
            this.getY() == other.getY() &&
            this.getZ() == other.getZ() &&
            this.color.equals(other.color);
 }
}

public class P0323_7 {
 public static void main(String[] args) {
     Point3DColor p = new Point3DColor(10, 20, 30, "RED");
     System.out.println(p.toString() + "입니다."); // 출력: (10,20,30)RED점입니다.

     Point3DColor q = new Point3DColor(1, 2, 3, "BLUE");
     System.out.println(q.toString() + "입니다."); // 출력: (1,2,3)BLUE점입니다.

     // q 객체의 좌표로 p를 이동시킴
     p.move(q.getX(), q.getY(), q.getZ());
     System.out.println(p.toString() + "입니다."); // 출력: (1,2,3)RED점입니다.

     Point3DColor r = new Point3DColor(1, 2, 3, "RED");
     if (p.equals(r))
         System.out.println("예, 같은 위치 같은 색깔의 점입니다.");
     else
         System.out.println("아니요.");
 }
}

