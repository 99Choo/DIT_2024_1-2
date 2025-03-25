package Home_Work;

import java.util.Scanner;

class BaseArray {
  protected int array[]; // 배열 메모리
  protected int nextIndex = 0; // 다음에 삽입할 배열에 대한 인덱스

    public BaseArray(int size) {
        array = new int[size];
    }

    public int length() { return array.length; }

    public void add(int n) { // 정수 n을 배열 끝에 추가
        if (nextIndex == array.length) return; // 배열이 꽉 찼으면 추가 안 함
        array[nextIndex++] = n;
    }

    public void print() {
        for (int n : array) System.out.print(n + " ");
        System.out.println();
    }
}

class BinaryArray extends BaseArray {
    private int threshold;

    public BinaryArray(int size, int threshold) {
        super(size);
        this.threshold = threshold;
    }

    @Override
    public void add(int n) {
        // threshold보다 작거나 같으면 0, 크면 1을 추가
        int valueToAdd = (n > threshold) ? 1 : 0;
        super.add(valueToAdd); // 부모 클래스의 add 메서드 호출
    }
}

public class P0326_9 {
    public static void main(String[] args) {
        int threshold = 50; // 기준값 설정
        BinaryArray bArray = new BinaryArray(10, threshold); // 배열 크기는 10

        Scanner scanner = new Scanner(System.in);
        System.out.print("10개의 정수를 입력하세요>> ");
        for (int i = 0; i < bArray.length(); i++) {
            int n = scanner.nextInt();
            bArray.add(n);
        }

        bArray.print();
        scanner.close();
    }
}