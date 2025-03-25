package Home_Work;

import java.util.Scanner;

abstract class Box1 {
  protected int size; // 현재 박스에 있는 재료의 양

  public Box1(int size) {
      this.size = size;
  }

  public boolean isEmpty() {
      return size == 0;
  }

  public abstract boolean consume(); // 박스에 들어 있는 재료를 일정량 소비
  public abstract void print(); // 박스에 들어 있는 양을 문자로 출력
}

class IngredientBox1 extends Box1 {
  private String name;

  public IngredientBox1(String name, int size) {
      super(size);
      this.name = name;
  }

  @Override
  public boolean consume() {
      if (size > 0) {
          size--; // 재료 소비
          return true;
      } else {
          System.out.println(name + " 원료가 부족합니다.");
          return false;
      }
  }

  @Override
  public void print() {
      System.out.print(name + " ");
      for (int i = 0; i < size; i++) {
          System.out.print("*");
      }
      System.out.println(" " + size);
  }
}

public class P0324_8 {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      IngredientBox1 coffeeBox = new IngredientBox1("커피", 5);
      IngredientBox1 creamBox = new IngredientBox1("프림", 5);
      IngredientBox1 sugarBox = new IngredientBox1("설탕", 5);
      System.out.println("****** 청춘 커피 자판기 입니다. ******");

      while (true) {
          coffeeBox.print();
          creamBox.print();
          sugarBox.print();

          System.out.print("다방커피:1, 설탕 커피:2, 블랙 커피:3, 종료:4>> ");
          int choice = scanner.nextInt();

          if (choice == 1) {
              // 다방 커피: 커피 1, 프림 1, 설탕 1 소비
              if (coffeeBox.consume() && creamBox.consume() && sugarBox.consume()) {
                  System.out.println("다방커피가 나왔습니다.");
              }
          } else if (choice == 2) {
              // 설탕 커피: 커피 1, 설탕 1 소비
              if (coffeeBox.consume() && sugarBox.consume()) {
                  System.out.println("설탕 커피가 나왔습니다.");
              }
          } else if (choice == 3) {
              // 블랙 커피: 커피 1 소비
              if (coffeeBox.consume()) {
                  System.out.println("블랙 커피가 나왔습니다.");
              }
          } else if (choice == 4) {
              System.out.println("커피 자판기 프로그램을 종료합니다.");
              break;
          } else {
              System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
          }
      }

      scanner.close();
  }
}