package Home_Work;

import java.util.Scanner;

interface IStack {
 int capacity();              // 스택의 최대 저장 가능한 수 반환
 int length();                // 현재 스택에 저장된 수 반환
 boolean push(String val);    // 스택의 top에 문자열 저장. 성공하면 true, 실패하면 false 반환
 String pop();                // 스택의 top에 있는 문자열을 반환하고 제거. 스택이 비어 있으면 null 반환
}

class StringStack implements IStack {
 private String[] stack;      // 스택 배열
 private int top;             // 스택의 현재 위치를 나타내는 인덱스

 public StringStack(int capacity) {
     stack = new String[capacity]; // 주어진 용량으로 스택 초기화
     top = 0; // 초기 상태에서는 아무것도 들어있지 않으므로 0으로 설정
 }

 @Override
 public int capacity() {
     return stack.length; // 스택의 전체 용량 반환
 }

 @Override
 public int length() {
     return top; // 현재 스택에 저장된 요소 수 반환
 }

 @Override
 public boolean push(String val) {
     if (top == stack.length) { // 스택이 꽉 찬 경우
         return false;
     }
     stack[top++] = val; // 스택의 top에 값 추가 후 top 증가
     return true;
 }

 @Override
 public String pop() {
     if (top == 0) { // 스택이 비어있는 경우
         return null;
     }
     return stack[--top]; // top을 감소시키고 그 위치의 값을 반환
 }
}

public class P0327_11 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);

     // 스택 용량을 사용자에게 입력받음
     System.out.print("스택의 용량을 입력하세요: ");
     int capacity = scanner.nextInt();
     StringStack stack = new StringStack(capacity); // 입력된 용량으로 스택 초기화
     
     System.out.print("문자열을 입력하세요 ('그만'을 입력하면 종료): ");

     // 문자열 입력받아 스택에 저장, "그만" 입력 시 종료
     while (true) {
         String input = scanner.next();
         if (input.equals("그만")) {  // "그만" 입력 시 종료
             break;
         }
         if (!stack.push(input)) {
             System.out.println("스택이 꽉 차서 " + input + "을(를) 저장할 수 없습니다.");
         }
     }

     // 스택에서 문자열을 꺼내서 출력
     System.out.print("스택에 저장된 모든 문자열 팝: ");
     while (stack.length() > 0) {
         String val = stack.pop();
         if (val != null) {
             System.out.print(val + " ");
         }
     }

     scanner.close();
 }
}
