package Home_Work;
// 클래스 만들기와 객체 활용
public class P0246_4 {
	public static void main(String[] args) {
        Average avg = new Average();
        avg.put(10); // 10 저장
        avg.put(15); // 15 저장
        avg.put(100); // 100 저장
        avg.showAll(); // 저장된 모든 원소 출력
        System.out.print("평균은 " + avg.getAvg()); // 평균 출력
    }
}

class Average {
    private int[] numbers; // 정수를 저장할 배열
    private int nextIndex; // 현재 저장된 개수를 나타내는 변수

    public Average() {
        numbers = new int[10]; // 배열 크기 10으로 초기화
        nextIndex = 0; // 초기 인덱스 0으로 설정
    }

    public void put(int number) {
        if (nextIndex < 10) { // 배열에 10개 이하로 저장할 수 있는지 확인
            numbers[nextIndex] = number; // 배열에 정수 저장
            nextIndex++; // 인덱스 증가
        } else {
            System.out.println("더 이상 저장할 수 없습니다."); // 배열이 가득 찬 경우 메시지 출력
        }
    }

    public void showAll() {
        System.out.println("***** 저장된 데이터 모두 출력 *****");
        for (int i = 0; i < nextIndex; i++) {
            System.out.print(numbers[i] + " "); // 저장된 모든 정수 출력
        }
        System.out.println();
    }

    public double getAvg() {
        int sum = 0;
        for (int i = 0; i < nextIndex; i++) {
            sum += numbers[i]; // 모든 정수의 합 계산
        }
        return (double) sum / nextIndex; // 평균 계산 및 반환
    }

}
