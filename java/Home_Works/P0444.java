package Home_Work;

import java.util.Scanner;
import java.util.Vector;
import java.util.Random;

public class P0444 {

    private Vector<Word> v = new Vector<Word>();
    private Scanner scanner = new Scanner(System.in);

    public P0444() {
        v.add(new Word("love", "사랑"));
        v.add(new Word("animal", "동물"));
        v.add(new Word("painting", "그림"));
        v.add(new Word("bear", "곰"));
        v.add(new Word("eye", "눈"));
        v.add(new Word("picture", "사진"));
        v.add(new Word("society", "사회"));
        v.add(new Word("human", "인간"));
        // 나머지 단어들을 추가
        // ...
    }

    public void run() {
        System.out.println("\"명품영어\"의 단어 테스트를 시작합니다. -1을 입력하면 종료합니다.");
        System.out.println("현재 " + v.size() + "개의 단어가 들어 있습니다.");

        Random random = new Random();
        while (true) {
            int index = random.nextInt(v.size());
            Word word = v.get(index);

            System.out.println(word.getEnglish() + "?");

            int answerIndex = random.nextInt(4);
            Vector<String> choices = new Vector<String>();

            for (int i = 0; i < 4; i++) {
                if (i == answerIndex) {
                    choices.add(word.getKorean());
                } else {
                    int wrongIndex;
                    do {
                        wrongIndex = random.nextInt(v.size());
                    } while (wrongIndex == index || choices.contains(v.get(wrongIndex).getKorean()));
                    choices.add(v.get(wrongIndex).getKorean());
                }
            }

            for (int i = 0; i < 4; i++) {
                System.out.print("(" + (i + 1) + ")" + choices.get(i) + " ");
            }
            System.out.print(":>");
            int choice = scanner.nextInt();

            if (choice == -1) {
                System.out.println("\"명품영어\"를 종료합니다...");
                break;
            } else if (choice - 1 == answerIndex) {
                System.out.println("Excellent !!");
            } else {
                System.out.println("No. !!");
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        new P0444().run();
    }
}
