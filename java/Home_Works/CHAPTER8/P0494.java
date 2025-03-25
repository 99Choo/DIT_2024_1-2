package CHAPTER8;

import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

class P0495 {
    private Vector<String> wordVector = new Vector<>();
    private String currentWord;
    private String hiddenWord;
    private int wrongAttempts;

    public void loadWords(String filePath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filePath));
            while (scanner.hasNext()) {
                String word = scanner.nextLine();
                wordVector.add(word);
            }
            scanner.close();
            System.out.println("총 " + wordVector.size() + "개의 단어를 읽었습니다.");
        } catch (IOException e) {
            System.out.println("파일을 읽는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        
        System.out.println("지금부터 행맨 게임을 시작합니다.");
        boolean keepPlaying = true;

        while (keepPlaying) {
            selectWord(rand);
            hideLetters();
            wrongAttempts = 0;

            while (wrongAttempts < 5 && hiddenWord.contains("-")) {
                System.out.println(hiddenWord);
                System.out.print(">>");
                char guess = sc.next().charAt(0);

                if (currentWord.indexOf(guess) != -1) {
                    revealLetter(guess);
                } else {
                    wrongAttempts++;
                    System.out.println("틀렸습니다! 남은 기회: " + (5 - wrongAttempts));
                }
            }

            if (wrongAttempts == 5) {
                System.out.println("5번 실패하였습니다.");
                System.out.println("정답은: " + currentWord);
            } else {
                System.out.println(currentWord);
                System.out.println("축하합니다! 정답입니다.");
            }

            System.out.print("Next(y/n)?");
            keepPlaying = sc.next().equalsIgnoreCase("y");
        }

        sc.close();
        System.out.println("행맨 게임을 종료합니다.");
    }

    private void selectWord(Random rand) {
        currentWord = wordVector.get(rand.nextInt(wordVector.size()));
    }

    private void hideLetters() {
        StringBuilder sb = new StringBuilder(currentWord);
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            int index;
            do {
                index = rand.nextInt(currentWord.length());
            } while (sb.charAt(index) == '-');
            sb.setCharAt(index, '-');
        }
        hiddenWord = sb.toString();
    }

    private void revealLetter(char guess) {
        StringBuilder sb = new StringBuilder(hiddenWord);
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) == guess) {
                sb.setCharAt(i, guess);
            }
        }
        hiddenWord = sb.toString();
    }

    public static void main(String[] args) {
        P0495 game = new P0495();
        game.loadWords("words.txt");
        game.startGame();
    }
}
