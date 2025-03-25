package Home_Work;
//1
public class P0166_1 {
    public static void main(String[] args) {
        int sum = 0, i = 1;
        while (true) {
            if (i > 50)
                break;
            sum = sum + i;
            i += 3;
        }
        System.out.println(sum);
    }
}


//(1) 무엇을 계산하는 코드인가? 실행 결과 출력되는 내용은? 1 부터 50까지 숫자 중에서 3씩 증가하는 숫자들의 합을 계산.
//(2) 위의 코드를 main() 메소드로 만들고 WhileLoop 클래스로 완성하라.
// package Home_Work;

// public class WhileLoop {
//     public static void main(String[] args) {
//         int sum = 0, i = 1;
        
//         while (true) {
//             if (i > 50) {
//                 break;
//             }
//             sum = sum + i;
//             i += 3;
//         }
        
//         System.out.println(sum);
//     }
// }

// //(3) for 문을 이용하여 동일하게 실행되는 FoorLoop 클래스를 작성하라.
// package Home_Work;

// public class ForLoop {
//     public static void main(String[] args) {
//         int sum = 0;
        
//         for (int i = 1; i <= 50; i += 3) {
//             sum += i;
//         }
        
//         System.out.println(sum);
//     }
// }

// //(4) do-while 문을 이용하여 동일하게 실행되는 DowhileLoop 클래스를 작성하라.
// package Home_Work;

// public class DowhileLoop {
//     public static void main(String[] args) {
//         int sum = 0, i = 1;
        
//         do {
//             sum += i;
//             i += 3;
//         } while (i <= 50);
        
//         System.out.println(sum);
//     }
// }
