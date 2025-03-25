package Home_Work;

public class P0248_8 {
	 public static void main(String[] args) {
	        Account a = new Account(100); // 100원을 예금하면서 계좌 생성
	        a.deposit(5000); // 5000원 예금
	        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

	        int bulk[] = {100, 500, 200, 700};
	        a.deposit(bulk); // bulk[] 배열에 있는 모든 돈 예금
	        System.out.println("잔금은 " + a.getBalance() + "원입니다.");

	        int money = 1000; // 인출하고자 하는 금액
	        int wMoney = a.withdraw(money); // 1000원 인출 시도. wMoney는 실제 인출한 금액
	        if (wMoney < money)
	            System.out.println(wMoney + "원만 인출"); // 잔금이 1000원보다 작은 경우
	        else
	            System.out.println(wMoney + "원 인출"); // 잔금이 1000원보다 큰 경우

	        System.out.println("잔금은 " + a.getBalance() + "원입니다.");
	    }
	}

	class Account {
	    private int balance; // 잔금

	    // 생성자: 초기 잔금을 설정
	    public Account(int initialBalance) {
	        this.balance = initialBalance;
	    }

	    // 금액을 예금하는 메소드
	    public void deposit(int amount) {
	        balance += amount;
	    }

	    // 배열에 있는 모든 금액을 예금하는 메소드
	    public void deposit(int[] amounts) {
	        for (int amount : amounts) {
	            balance += amount;
	        }
	    }

	    // 금액을 인출하는 메소드
	    public int withdraw(int amount) {
	        if (balance < amount) {
	            int temp = balance;
	            balance = 0;
	            return temp; // 잔금이 인출 금액보다 작으면 잔금만큼만 인출
	        } else {
	            balance -= amount;
	            return amount; // 잔금이 인출 금액보다 크거나 같으면 인출 금액만큼 인출
	        }
	    }

	    // 잔금을 반환하는 메소드
	    public int getBalance() {
	        return balance;
	    }
}
