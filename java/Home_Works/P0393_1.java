package Home_Work;
import java.util.Objects;

class Student {
    private String name; // 학생의 이름
    private int id; // 학생의 ID

    // 생성자
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // toString 메서드 오버라이드
    @Override
    public String toString() {
        return "학번이 " + id + "인 " + name;
    }

    // equals 메서드 오버라이드
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student student = (Student) obj;
        return id == student.id; // 이름과 ID 모두 같을 때 같은 학생으로 간주
    }

    // hashCode 메서드 오버라이드
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class P0393_1 {
    public static void main(String[] args) {
        Student a = new Student("황기태", 23); // id가 23인 황기태 학생
        Student b = new Student("황기태", 77); // id가 77인 황기태 학생
        System.out.println(a);

        if (a.equals(b)) {
            System.out.println("같은 학생입니다.");
        } else {
            System.out.println("다른 학생입니다.");
        }
    }
}
