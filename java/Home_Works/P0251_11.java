package Home_Work;
// static 메소드, 배열 다루기, 배열 리턴 연습 
class ArrayUtil {
    // 배열 a와 b를 연결한 새로운 배열을 리턴하는 메소드
    public static int[] concat(int[] a, int[] b) {
        int[] result = new int[a.length + b.length]; // 새로운 배열 생성
        System.arraycopy(a, 0, result, 0, a.length); // 배열 a 복사
        System.arraycopy(b, 0, result, a.length, b.length); // 배열 b 복사
        return result; // 연결된 배열 리턴
    }

    // 배열 a를 출력하는 메소드
    public static void print(int[] a) {
        System.out.print("[ ");
        for (int i : a) {
            System.out.print(i + " "); // 배열의 각 요소 출력
        }
        System.out.println("]");
    }
}

public class P0251_11 {
    public static void main(String[] args) {
        int[] array1 = {1, 5, 7, 9}; // 첫 번째 배열
        int[] array2 = {3, 6, -1, 100, 77}; // 두 번째 배열
        int[] array3 = ArrayUtil.concat(array1, array2); // 배열 연결
        ArrayUtil.print(array3); // 연결된 배열 출력
    }
}

