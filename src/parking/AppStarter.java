/**
 * 객체 지향은 여러 개의 객체들이 상호 작용하는 프로그램
 * - 객체 간의 관계(상속, 구현)
 * - 서로 간 실행을 위해 전달, 반환, 호출하는 흐름 
 * - 객체 여러 개, 개발하는 사람 여러 명, 여러 개의 프로젝트 
 * - 여러 명이 함께 개발하기 좋은 방법 ??? 
 */

package parking;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

public class AppStarter {
	
	public static void main(String[] args) {
		parking();
	}
	
	public static void parking() {
		Scanner sc = new Scanner(System.in);
		CarParking service = new CarParking(10); //10 ==> maximum parking space
//		CarParking service2 = new CarParking(); 
//		System.out.println(service);
		
		
		while(true) {
			String state = service.getState();
			System.out.println(state + "\ncmd >");
			String cmd = sc.nextLine();
			
//--------------------------exit--------------------------
			if (cmd.equals("exit")) {
				break;				
			}
			
//--------------------------in--------------------------
			if (cmd.equals("in")) {
				System.out.println("in > ");
				
				//check space availability
				if(service.isEmpty() == -1) {
					System.out.println("Full, sorry");
				} else {
					//add car info (String plateNum, date time)
					String plateNum = sc.nextLine();
					Date in = new Date();
					double price = 10;
	
					service.insert(plateNum, in, price);
				}
			}

//--------------------------out--------------------------
			
			if (cmd.equals("out")) {
				System.out.println("out > ");
				//get leaving car info
				String plateNum = sc.nextLine();
				Car car = service.getCar(plateNum); //by plate number

				//if no car info
				if(car == null) {  
					System.out.println("no information");
				} else {
					//get time
					LocalDateTime out = LocalDateTime.now();
					car.setOut(out);
					// get price (return double type)
					double price = car.carPrice(); 
					System.out.println(price);	
				}
				
				service.removeCar(car); 
			} 
		}
		System.out.println("terminated");
		
		sc.close();
	}
}
