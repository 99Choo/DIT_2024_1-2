package Home_Work;

import java.util.Scanner;

public class P0249_9 {
    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.start();
    }
}

class Player {
    private String name; // 선수 이름
    private int score; // 누적 점수

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        score++;
    }
}

class GuessGame {
    private Player[] players;
    private Scanner scanner;

    public GuessGame() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("*** 예측 게임을 시작합니다. ***");
        System.out.print("게임에 참여할 선수 수 >>");
        int numPlayers = scanner.nextInt();
        players = new Player[numPlayers];

        for (int i = 0; i < numPlayers; i++) {
            System.out.print("선수 이름>>");
            String name = scanner.next();
            players[i] = new Player(name);
        }

        boolean continueGame = true;
        while (continueGame) {
            playRound();
            System.out.print("계속하려면 yes 입력>>");
            String response = scanner.next();
            continueGame = response.equalsIgnoreCase("yes");
        }

        showFinalScores();
    }

    private void playRound() {
        int hiddenAnswer = (int) (Math.random() * 100 + 1); // 1~100 범위의 랜덤 정수
        System.out.println("1~100사이의 숫자가 결정되었습니다. 선수들은 맞추어 보세요.");

        int closestGuess = Integer.MAX_VALUE;
        Player winner = null;

        for (Player player : players) {
            System.out.print(player.getName() + ">>");
            int guess = scanner.nextInt();
            int diff = Math.abs(hiddenAnswer - guess); // 두 정수의 차이

            if (diff < closestGuess) {
                closestGuess = diff;
                winner = player;
            }
        }

        System.out.println("정답은 " + hiddenAnswer + ". " + winner.getName() + "이 이겼습니다. 승점 1점 확보!");
        winner.addScore();
    }

    private void showFinalScores() {
        System.out.println();
        for (Player player : players) {
            System.out.println(player.getName() + ":" + player.getScore());
        }

        Player finalWinner = players[0];
        for (Player player : players) {
            if (player.getScore() > finalWinner.getScore()) {
                finalWinner = player;
            }
        }

        System.out.println(finalWinner.getName() + "이 최종 승리하였습니다.");
    }
}

