package banking;

import java.io.IOException;
import java.util.Random;

public class Banking1 {
	static int total = 0;
	static int [] inMoney = new int[40]; // 입금액 기록 
	static int inIdx; //지역변수로 두면 안되는 것들..	
	static int [] outMoney = new int[40]; // 출금액 기록 
	static int outIdx; //지역변수로 두면 안되는 것들..	

	
	//입금처리
	static void deposit(int d) { // d ==> money
		//입금액  ==> d 
		//현잔액  + 입금액
		total += d;
		//총잔액 저장
		inMoney[inIdx] = d;
		++inIdx;
//		System.out.println("deposit :" + d);
//		System.out.println("inIdx :" + inIdx);
//		System.out.println("total :" + total);
	}
	
	//출금처리
	static void withdraw(int w) {
		//출금액  ==> w
		//현잔액  - 출금액 : 음수 가능성
		if(w <= total) {
			//총잔액 저장
			total -= w;			
			outMoney[outIdx] = w;
			++outIdx;
		} else {
			System.out.println("잔액부족");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Random ran = new Random();
		int max = 10000; //난수 값 범위를 줄인다...
		int money;
		
		while(true) {
			int key = System.in.read();
			switch(key) {
				case '1' :
					money = ran.nextInt(max);
					deposit(money);	
					break;
				case '2' :
					money = ran.nextInt(max);
					withdraw(money);				
					break;
				case '3' :
					history();
			}	
			if(key != '\r' && key != '\n') {  // same as  !(key == '\r' || key == '\n')
				System.out.println("total: $" + total);
			}
		}
	}

	private static void history() {
		for (int i =0; i < 30 ; ++i) {
			System.out.println("[" + i + "]" + "(" +inMoney[i] + ")" + "(" + outMoney +")" + "{" + total +"}");
		}
	}
}