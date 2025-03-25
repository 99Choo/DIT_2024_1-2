package Home_Work;

public class P0248_7 {
	 public static void main(String[] args) {
	        Memo a = new Memo("유송연", "10:10", "자바 과제 있음");
	        Memo b = new Memo("박채원", "10:15", "시카고로 어학 연수가요!");
	        Memo c = new Memo("김경미", "11:30", "사랑하는 사람이 생겼어요.");

	        a.show();
	        if (a.isSameName(b)) {
	            System.out.println("동일한 사람입니다.");
	        } else {
	            System.out.println("다른 사람입니다.");
	        }
	        System.out.println(c.getName() + "가 작성한 메모의 길이는 " + c.length());
	    }
	}

	class Memo {
	    private String name; // 메모 작성자
	    private String time; // 메모 시점
	    private String content; // 메모 텍스트

	    // 생성자: 메모 작성자, 메모 시점, 메모 텍스트를 초기화
	    public Memo(String name, String time, String content) {
	        this.name = name;
	        this.time = time;
	        this.content = content;
	    }

	    // 메모 작성자 이름을 반환하는 메소드
	    public boolean isSameName(Memo other) {
	        return this.name.equals(other.name);
	    }

	    // 메모 정보를 출력하는 메소드
	    public void show() {
	        System.out.println(name + ", " + time + " " + content);
	    }

	    // 메모 텍스트의 길이를 반환하는 메소드
	    public int length() {
	        return content.length();
	    }

	    // 메모 작성자 이름을 반환하는 메소드
	    public String getName() {
	        return name;
	    }
}
