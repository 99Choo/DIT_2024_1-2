package Home_Work;

public class Player399_11 {
    private String name;

    public Player399_11(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean play() {
        int[] numbers = new int[3];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 3) + 1;
        }
        
        System.out.print("[ " + name + " ]: ");
        for (int num : numbers) {
            System.out.print(num + "\t");
        }
        
        if (numbers[0] == numbers[1] && numbers[1] == numbers[2]) {
            System.out.println(name + "님이 이겼습니다!");
            return true;
        } else {
            System.out.println("아쉽군요!");
            return false;
        }
    }

	public void addScore1() {
		// TODO Auto-generated method stub
		
	}
}
