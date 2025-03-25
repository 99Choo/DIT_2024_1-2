패키지 홈Work; // 이 패키지가 실제로 존재하는지 확인 또는 삭제

java.util 가져오기.스캐너;

학급 플레이어1 { 
 개인 문자열 이름;

 공개 플레이어1( 문자열 이름) {
 this.name = 이름;
    }

 공용 문자열 getName() {
 이름 반환;
    }

 공용 문자열 getWordFromUser(스캐너 스캐너) {
 System.out.print(이름 + ">>");
 스캐너를 반환합니다.다음 ();
    }
}

일반의 학급 P0239 {
 개인 플레이어1[] 플레이어;
 개인 문자열 시작 단어 = "아버지";
 개인 스캐너 스캐너;

    일반의 P0239() {
 스캐너 = 새 스캐너(System.in );
    }

    일반의 공백 달려.() {
 System.out.println("끝말잇기 게임을 시작합니다...");
 System.out.print("게임에 참가하는 인원은 몇명입니까>>");
 int numPlayers = scanner.nextInt();
 플레이어 = 신규 플레이어1[numPlayers];

 (int i = 0; i < numPlayers; i++) {의 경우
 System.out.print("참가자의 이름을 입력하세요>>");
 문자열 이름 = 스캐너.next ();
 player[i] = 새로운 Player1(이름);
        }

 System.out.println("시작하는 단어는" + startWord + "입니다.");
 문자열 현재 단어 = startWord;

        하는 동안에 (진실의) {
 (Player1 플레이어 : 플레이어) {
 문자열 newWord = player.getWordFromUser(스캐너);
 if (!checkSuccess(현재 Word, 새 Word)) {
 System.out.println(player.getName() + "이 졌습니다.");
 반환;
                }
 현재 Word = newWord;
            }
        }
    }

 개인 부울 체크Success(현재 단어 문자열, 새 단어 문자열) {
 마지막으로인덱스 = currentWord.length() - 1;
 char lastChar = currentWord.charAt(라스트인덱스);
 char firstChar = newWord.charAt(0);
 lastChar == firstChar를 반환합니다;
    }

 공용 정적 보이드 메인(String[] args) {
 P0239 game = new P0239();
 game.run ();
    }
}
