package Home_Work;

import java.util.Random;
import java.util.Scanner;

public class P0399_10b {
    public static void main(String[] args) {
        String[] words = {"happy", "morning", "package", "together", "lovely", "sunny", "extract", "nation"};
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String word = words[random.nextInt(words.length)];
            char[] shuffledWord = word.toCharArray();
            for (int i = 0; i < shuffledWord.length; i++) {
                int j = random.nextInt(shuffledWord.length);
                char temp = shuffledWord[i];
                shuffledWord[i] = shuffledWord[j];
                shuffledWord[j] = temp;
            }

            System.out.println("10초 안에 단어를 맞추세요!!");
            System.out.println(new String(shuffledWord));

            long startTime = System.currentTimeMillis();
            String answer = scanner.nextLine();
            double elapsedTime = (System.currentTimeMillis() - startTime) / 1000.0;

            if (answer.equals(word)) {
                System.out.println("성공!!! " + elapsedTime + "초 경과");
            } else if (answer.equals("그만")) {
                break;
            } else if (elapsedTime > 10) {
                System.out.println("실패!! 10초 초과. " + elapsedTime + "초 경과");
            } else {
                System.out.println("실패!! " + word + " 입니다. " + elapsedTime + "초 경과");
            }
        }
        scanner.close();
    }
}
