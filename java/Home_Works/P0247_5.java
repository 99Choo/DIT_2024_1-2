package Home_Work;
// 클래스 만들기와 객체 활용
public class P0247_5 {
    public static void main(String[] args) {
        // Song 객체 생성
        Song song = new Song("가로수 그늘 아래 서면", "이문세", 1988, "한국");
        // 노래 정보 출력
        song.show();
    }
}

class Song {
    private String title; // 노래 제목
    private String singer; // 가수 이름
    private int year; // 발표 년도
    private String lang; // 가수 나라

    // 생성자: 노래 제목, 가수 이름, 발표 년도, 가수 나라를 초기화
    public Song(String title, String singer, int year, String lang) {
        this.title = title;
        this.singer = singer;
        this.year = year;
        this.lang = lang;
    }

    // 노래 정보를 출력하는 메소드
    public void show() {
        System.out.println(year + "년 " + lang + "의 " + singer + "가 부른 " + title);
    }
}

