package Home_Work;

import java.util.Scanner;

abstract class Shape {
 private Shape next;

 public Shape() {
     next = null;
 }

 public void setNext(Shape obj) {
     next = obj;
 }

 public Shape getNext() {
     return next;
 }

 public abstract void draw(); // 각 도형을 그리는 추상 메서드
}

class Line extends Shape {
 @Override
 public void draw() {
     System.out.println("Line");
 }
}

class Rect extends Shape {
 @Override
 public void draw() {
     System.out.println("Rect");
 }
}

class Circle extends Shape {
 @Override
 public void draw() {
     System.out.println("Circle");
 }
}

class GraphicEditor {
 private Shape head; // 도형 목록의 시작을 가리키는 참조 변수
 private Shape tail; // 도형 목록의 끝을 가리키는 참조 변수

 public GraphicEditor() {
     head = null;
     tail = null;
 }

 public void insert(int shapeType) {
     Shape newShape = null;
     switch (shapeType) {
         case 1:
             newShape = new Line();
             break;
         case 2:
             newShape = new Rect();
             break;
         case 3:
             newShape = new Circle();
             break;
         default:
             System.out.println("잘못된 입력입니다.");
             return;
     }

     if (head == null) { // 처음 삽입할 때
         head = newShape;
         tail = newShape;
     } else {
         tail.setNext(newShape);
         tail = newShape;
     }
     System.out.println("삽입되었습니다.");
 }

 public void delete() {
     if (head == null) {
         System.out.println("삭제할 도형이 없습니다.");
         return;
     }

     if (head.getNext() == null) { // 도형이 하나만 있는 경우
         head = null;
         tail = null;
     } else {
         Shape temp = head;
         while (temp.getNext() != tail) { // tail 앞의 노드 찾기
             temp = temp.getNext();
         }
         temp.setNext(null);
         tail = temp;
     }
     System.out.println("삭제되었습니다.");
 }

 public void showAll() {
     if (head == null) {
         System.out.println("저장된 도형이 없습니다.");
         return;
     }

     Shape current = head;
     while (current != null) {
         current.draw();
         current = current.getNext();
     }
 }

 public void run() {
     Scanner scanner = new Scanner(System.in);
     System.out.println("Beauty Graphic Editor를 실행합니다.");

     while (true) {
         System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4) >> ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Line(1), Rect(2), Circle(3) >> ");
                 int shapeType = scanner.nextInt();
                 insert(shapeType);
                 break;
             case 2:
                 delete();
                 break;
             case 3:
                 showAll();
                 break;
             case 4:
                 System.out.println("Beauty Graphic Editor를 종료합니다.");
                 scanner.close();
                 return;
             default:
                 System.out.println("잘못된 입력입니다.");
         }
     }
 }
}

public class P0329_14 {
 public static void main(String[] args) {
     GraphicEditor editor = new GraphicEditor();
     editor.run();
 }
}
