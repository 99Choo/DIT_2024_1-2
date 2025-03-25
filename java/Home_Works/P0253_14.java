package Home_Work;
// 클래스와 배열을 다루는 종합 응용 
class VArray {
    private int[] array; // 내부 배열
    private int size; // 현재 저장된 개수

    // 생성자: 초기 배열 크기를 설정
    public VArray(int capacity) {
        array = new int[capacity];
        size = 0;
    }

    // 배열의 용량을 반환하는 메소드
    public int capacity() {
        return array.length;
    }

    // 배열에 저장된 개수를 반환하는 메소드
    public int size() {
        return size;
    }

    // 배열의 마지막 원소로 저장하는 메소드
    public void add(int value) {
        if (size >= array.length) {
            resize(); // 배열 크기를 2배로 늘림
        }
        array[size++] = value; // 값 저장 후 size 증가
    }

    // 배열의 인덱스에 값을 삽입하는 메소드
    public void insert(int index, int value) {
        if (index > size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        if (size >= array.length) {
            resize(); // 배열 크기를 2배로 늘림
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1]; // 값을 오른쪽으로 이동
        }
        array[index] = value; // 값 삽입
        size++;
    }

    // 배열의 인덱스에 있는 값을 삭제하는 메소드
    public void remove(int index) {
        if (index >= size) {
            System.out.println("잘못된 인덱스입니다.");
            return;
        }
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1]; // 값을 왼쪽으로 이동
        }
        size--;
    }

    // 배열의 모든 값을 출력하는 메소드
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    // 배열 크기를 2배로 늘리는 메소드
    private void resize() {
        int[] newArray = new int[array.length * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }
}

public class P0253_14 {
    public static void main(String[] args) {
        VArray v = new VArray(5); // 5개의 정수를 저장하는 가변 배열 객체 생성
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());

        for (int i = 0; i < 7; i++) // 7개 저장
            v.add(i); // 배열에 순서대로 정수 i 값 저장
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.insert(3, 100); // 배열의 인덱스 3에 100 삽입
        v.insert(5, 200); // 배열의 인덱스 5에 200 삽입
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        v.remove(10); // 배열의 인덱스 10의 정수 삭제
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();

        for (int i = 50; i < 55; i++) // 5개 저장
            v.add(i); // 배열에 순서대로 정수 i 값 저장
        System.out.println("용량: " + v.capacity() + ", 저장된 개수: " + v.size());
        v.printAll();
    }
}

