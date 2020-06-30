package banking;

import java.io.IOException;
import java.util.Random;

public class Banking1 {
	static int total = 0;
	static int [] inMoney = new int[40]; // deposit record
	static int inIdx; 
	static int [] outMoney = new int[40]; // withdraw record 
	static int outIdx;	

	
	static void deposit(int d) { // d ==> money
		//deposit  ==> d 
		//current balance + deposit
		total += d;
		inMoney[inIdx] = d;
		++inIdx;
//		System.out.println("deposit :" + d);
//		System.out.println("inIdx :" + inIdx);
//		System.out.println("total :" + total);
	}
	
	static void withdraw(int w) {
		//withdraw  ==> w
		//current balance  - withdraw : possible to be negative
		if(w <= total) {
			//update total balance 
			total -= w;			
			outMoney[outIdx] = w;
			++outIdx;
		} else {
			System.out.println("not enough");
		}
	}
	
	public static void main(String[] args) throws IOException {
		Random ran = new Random();
		int max = 10000; 
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