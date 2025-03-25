package Home_Work;
import java.util.Objects; // Objects 클래스 import

class Book {
    private String author; // 저자 이름
    private String title; // 도서명
    private String purchaser; // 구입자 이름

    // 생성자
    public Book(String author, String title, String purchaser) {
        this.author = author; // 전달된 저자 이름으로 초기화
        this.title = title; // 전달된 도서명으로 초기화
        this.purchaser = purchaser; // 전달된 구입자 이름으로 초기화
    }

    // toString 메서드 오버라이드
    @Override
    public String toString() {
        return purchaser + "이 구입한 도서: " + author + "의 " + title;
    }

    // equals 메서드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { // 객체 자신과 비교
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) { // null 또는 다른 클래스와 비교
            return false;
        }
        Book book = (Book) obj; // 타입 캐스팅
        return author.equals(book.author) && title.equals(book.title); // 저자와 도서명이 같으면 true
    }

    // hashCode 메서드 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(author, title); // 저자와 도서명을 기반으로 해시 코드 생성
    }
}

public class P0394_2 {
    public static void main(String[] args) {
        Book a = new Book("황기태", "명품자바", "김하진"); // 첫 번째 책 객체 생성
        Book b = new Book("황기태", "명품자바", "하여린"); // 두 번째 책 객체 생성
        System.out.println(a); // 첫 번째 책 정보 출력
        System.out.println(b); // 두 번째 책 정보 출력

        if (a.equals(b)) { // 두 책 객체 비교
            System.out.println("같은 책"); // 같은 책일 때 출력
        } else {
            System.out.println("다른 책"); // 다른 책일 때 출력
        }
    }
}
