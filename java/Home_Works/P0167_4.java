package Home_Work;

public class P0167_4 {
    public static void main(String[] args) {
        // 2차원 배열 n을 정의.
        int n[][] = {
            {1, 2, 3},
            {1, 2},
            {1},
            {1, 2, 3},
            {1, 2, 3, 4}
        };

        // 배열의 각 행을 순회.
        for (int i = 0; i < n.length; i++) {
            // 각 행의 요소를 순회.
            for (int j = 0; j < n[i].length; j++) {
                // 각 요소를 탭으로 구분하여 출력.
                System.out.print(n[i][j] + "\t");
            }
            // 각 행이 끝날 때 줄바꿈.
            System.out.println();
        }
    }
}
