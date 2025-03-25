package Home_Work;
import java.util.*;

public class P0400_B {
    List<P0400_A> players = new ArrayList<>();
    Random random = new Random();

    void addPlayer(String name) {
        players.add(new P0400_A(name));
    }

    void startGame() {
        Scanner scanner = new Scanner(System.in);

        // 각 선수들에게 좋아하는 숫자를 입력받음
        for (P0400_A player : players) {
            System.out.print("[" + player.name + "] 정수 선택(1~10)>>");
            int favoriteNumber = scanner.nextInt();
            player.chooseNumber(favoriteNumber);
        }

        while (true) {
            // 랜덤 정수 생성
            System.out.print("Enter키 입력 >> ");
            scanner.nextLine();  // 입력 버퍼 클리어
            scanner.nextLine();
            List<Integer> randomNumbers = new ArrayList<>();
            for (int i = 0; i < 15; i++) {
                randomNumbers.add(random.nextInt(10) + 1);
            }
            System.out.println(randomNumbers);

            // 각 선수들의 좋아하는 정수 맞춘 개수 세기
            for (P0400_A player : players) {
                player.resetCount();
                for (int number : randomNumbers) {
                    if (player.favoriteNumber == number) {
                        player.count++;
                    }
                }
                System.out.println("[" + player.name + "] 맞춘 개수: " + player.count);
            }

            // 패자들 찾기
            int minCount = Integer.MAX_VALUE;
            List<P0400_A> losers = new ArrayList<>();
            for (P0400_A player : players) {
                if (player.count < minCount) {
                    minCount = player.count;
                    losers.clear();
                    losers.add(player);
                } else if (player.count == minCount) {
                    losers.add(player);
                }
            }

            // 패자가 1명이 될 때까지 반복
            if (losers.size() == 1) {
                System.out.println("최종 패자는 " + losers.get(0).name + "입니다.");
                break;
            } else {
                System.out.print("현재 패자들 : ");
                for (P0400_A player : losers) {
                    System.out.print(player.name + " ");
                }
                System.out.println();
                players = losers;
            }
        }
    }

    public static void main(String[] args) {
        P0400_B game = new P0400_B();
        Scanner scanner = new Scanner(System.in);

        System.out.print("게임에 참여할 선수들 이름 >> ");
        String[] names = scanner.nextLine().split(" ");
        for (String name : names) {
            game.addPlayer(name);
        }

        game.startGame();
    }
}
