package parking;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CarParking {
	private Car[] space;
	
	public CarParking(int length) { 
		space = new Car[length]; 
	}

	public String getState() {
		return this.toString();
	}
	@Override
	public String toString() {
		String s = "";
		int count = 0;
		for (Car car : space) {
			++count;
			if(car != null) {
				s += "["+car.getPlateNum()+"]";
			} else {
				s += "[    ]";
			}
			if(count == space.length/2) {
				s += "\n";	
			}
		}
		return s;
//		return "CarParking [space=" + Arrays.toString(space) + "]";
	}

	public void insert(String plateNum, Date in, double price) {
		//get car info, in time  
		Car car = new Car();
		car.setPlateNum(plateNum);
		car.setIn(in);
		car.setOut(null);
		car.setPrice(price);

		int i = isEmpty();
		if(i>=0) {
			space[i] = car;
		}
		
//		space[location] = car; //get parking location
//		++location;//update space availability
		
		//show parking info
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		System.out.println(plateNum +" is parked at location " + i + ", " + dateFormat.format(in));
		System.out.println("Basic price: $" + price );
		System.out.println();
	}

	public int isEmpty() {
		for (int i = 0; i < space.length; ++i) {
			if(space[i] == null) {
				return i;
			}
		}
		return -1; //no empty space available
	}

	public Car getCar(String plateNum) {
		// car info from space
		for(Car car : space) {
			if (car != null) { 
				//compare scanned info and parked(leaving) car info
				if(car.getPlateNum().equals(plateNum)) { 
					return car;
				}
			}
		}
		return null;
	}

	public void removeCar(Car car) {
		int del = -1;
		for(int i=0; i <space.length;i++) {
			if(space[i] == car) {
				del = i; 
				break;
			}
		}
		if(del >= 0) {
			space[del] = null;			
		}
	}
}
