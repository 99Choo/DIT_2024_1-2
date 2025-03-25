package Home_Work;

import java.util.Scanner;



class SortedArray extends BaseArray {
  public SortedArray(int size) {
      super(size);
  }

  @Override
  public void add(int n) {
      if (nextIndex == array.length) return; // 배열이 꽉 찼으면 추가 안 함

      // 적절한 위치를 찾아서 배열을 오름차순으로 유지하며 삽입
      int i = nextIndex - 1;
      while (i >= 0 && array[i] > n) {
          array[i + 1] = array[i]; // 배열 요소를 오른쪽으로 이동
          i--;
      }
      array[i + 1] = n; // 새로운 숫자 삽입
      nextIndex++; // 다음 인덱스를 증가
  }
}

public class P0326_10 {
  public static void main(String[] args) {
      SortedArray sArray = new SortedArray(10); // 배열 크기는 10

      Scanner scanner = new Scanner(System.in);
      System.out.print("10개의 정수를 입력하세요>> ");
      for (int i = 0; i < sArray.length(); i++) {
          int n = scanner.nextInt();
          sArray.add(n);
      }

      sArray.print(); // 최종 배열 출력
      scanner.close();
  }
}
