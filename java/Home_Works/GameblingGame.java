package Home_Work;

import java.util.Scanner;

public class GameblingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("갬블링 게임에 참여할 선수 숫자>> ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Player399_11[] players = new Player399_11[numPlayers];
        for (int i = 0; i < numPlayers; i++) {
            System.out.print((i + 1) + "번째 선수 이름 >> ");
            String name = scanner.nextLine();
            players[i] = new Player399_11(name);
        }

        boolean gameWon = false;
        while (!gameWon) {
            for (Player399_11 player : players) {
                System.out.print("[" + player.getName() + "]:<Enter>");
                scanner.nextLine(); // wait for <Enter> key
                gameWon = player.play();
                if (gameWon) {
                    break;
                }
            }
        }
        scanner.close();
    }
}
