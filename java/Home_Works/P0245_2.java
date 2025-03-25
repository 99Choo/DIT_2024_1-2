package Home_Work;
// 클래스 만들기(생성자, 메소드, 필드 등 작성)와 객체 활용
public class P0245_2 {
    public static void main(String[] args) {
        Cube cube = new Cube(1, 2, 3); // 가로, 세로, 높이가 1, 2, 3인 큐브 객체 생성
        System.out.println("큐브의 부피는 " + cube.getVolume());
        cube.increase(1, 2, 3); // 가로, 세로, 높이 각각 1, 2, 3씩 증가
        System.out.println("큐브의 부피는 " + cube.getVolume());
        if (cube.isZero())
            System.out.println("큐브의 부피는 0");
        else
            System.out.println("큐브의 부피는 0이 아님");
    }
}

class Cube {
    private int width;
    private int height;
    private int depth;

    public Cube(int width, int height, int depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int getVolume() {
        return width * height * depth;
    }

    public void increase(int w, int h, int d) {
        width += w;
        height += h;
        depth += d;
    }

    public boolean isZero() {
        return getVolume() == 0;
    }
}

