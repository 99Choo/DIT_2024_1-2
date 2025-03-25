package Home_Work; // 패키지 선언

import java.util.Scanner;

public class P0395_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("여러 과목의 학점을 빈 칸으로 분리 입력>>");
            String line = scanner.nextLine();
            
            if (line.equalsIgnoreCase("그만")) {
                break;
            }
            
            String[] gradeArray = line.split(" ");
            double totalScore = 0;
            int count = 0;
            
            for (String grade : gradeArray) {
                switch (grade.toUpperCase()) {
                    case "A":
                        totalScore += 100;
                        break;
                    case "B":
                        totalScore += 90;
                        break;
                    case "C":
                        totalScore += 80;
                        break;
                    case "D":
                        totalScore += 70;
                        break;
                    case "F":
                        totalScore += 0;
                        break;
                    default:
                        System.out.println("입력 오류: " + grade);
                        continue;
                }
                count++;
            }
            
            if (count > 0) {
                double average = totalScore / count;
                System.out.println("평균은 " + average);
            }
        }
        
        scanner.close();
    }
}
