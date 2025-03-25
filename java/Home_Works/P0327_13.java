package Home_Work;

import java.util.Scanner;

abstract class Calc {
  protected String errorMsg = null; // 오류 메시지
  protected int a, b; // 피연산자 값

  public void setValue(int a, int b) {
      this.a = a;
      this.b = b;
  }

  public abstract int calculate(); // 각 연산에 맞는 계산 수행
}

class Add extends Calc {
  @Override
  public int calculate() {
      errorMsg = null;
      return a + b;
  }
}

class Sub extends Calc {
  @Override
  public int calculate() {
      errorMsg = null;
      return a - b;
  }
}

class Mul extends Calc {
  @Override
  public int calculate() {
      errorMsg = null;
      return a * b;
  }
}

class Div extends Calc {
  @Override
  public int calculate() {
      if (b == 0) { // 0으로 나누기 오류 처리
          errorMsg = "0으로 나눌 수 없습니다.";
          return 0; // 오류 시 반환값을 0으로 설정
      }
      errorMsg = null;
      return a / b;
  }
}

public class P0327_13 {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      Calc operation = null;

      while (true) {
          System.out.print("두 정수와 연산자를 입력하세요>> ");
          int a = scanner.nextInt();
          int b = scanner.nextInt();
          String operator = scanner.next();

          switch (operator) {
              case "+":
                  operation = new Add();
                  break;
              case "-":
                  operation = new Sub();
                  break;
              case "*":
                  operation = new Mul();
                  break;
              case "/":
                  operation = new Div();
                  break;
              default:
                  System.out.println("잘못된 연산자입니다.");
                  continue;
          }

          operation.setValue(a, b);
          int result = operation.calculate();

          if (operation.errorMsg != null) {
              System.out.println(operation.errorMsg);
              break; // 오류 발생 시 프로그램 종료
          } else {
              System.out.println("계산 결과: " + result);
          }
      }

      scanner.close();
  }
}
