package Home_Work;

public class P0166_2 {
 public static void main(String[] args) {
    int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
    for(int i=0; i<n.length; i++) {
        if(n[i] > 0 && n[i] % 4 == 0) {
            System.out.print(n[i] + " ");
        }
    }    
 }
}
// (1) 무엇을 계산하는 코드인가? 실행 결과 출력되는 내용은?
// 양수이면서 4의 배수인 숫자들을 찾아 출력하는 코드
// (2) 위의 코드를 main() 메소드로 만들고 ForLoopArray 클래스로 완성하라.
// package Home_Work;

// public class ForLoopArray {
//     public static void main(String[] args) {
//         int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
//         for (int i = 0; i < n.length; i++) {
//             if (n[i] > 0 && n[i] % 4 == 0) {
//                 System.out.print(n[i] + " ");
//             }
//         }
//     }
// }

// (3) while 문을 이용하여 동일하게 실행되는 WhileLoopArray 클래스를 작성하라.
// package Home_Work;

// public class WhileLoopArray {
//     public static void main(String[] args) {
//         int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
//         int i = 0;
//         while (i < n.length) {
//             if (n[i] > 0 && n[i] % 4 == 0) {
//                 System.out.print(n[i] + " ");
//             }
//             i++;
//         }
//     }
// }

// (4) do-while 문을 이용하여 동일하게 실행되는 DoWhileLoopArray 클래스를 작성하라.
// package Home_Work;

// public class DoWhileLoopArray {
//     public static void main(String[] args) {
//         int n[] = {1, -2, 6, 20, 5, 72, -16, 256};
//         int i = 0;
//         do {
//             if (n[i] > 0 && n[i] % 4 == 0) {
//                 System.out.print(n[i] + " ");
//             }
//             i++;
//         } while (i < n.length);
//     }
// }
