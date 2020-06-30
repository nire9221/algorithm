package parking;

import java.time.LocalDateTime; //current 
import java.util.Date; // old version

//Model is Type
public class Car {
	private String plateNum; 
	private Date in; 
	private LocalDateTime out; 
	private double price; 
	
	public String getPlateNum() {
		return plateNum;
	}
	public void setPlateNum(String plateNum) {
		this.plateNum = plateNum;
	}
	public Date getIn() {
		return in;
	}
	public void setIn(Date in) {
		this.in = in;
	}
	public LocalDateTime getOut() {
		return out;
	}
	public void setOut(LocalDateTime out) {
		this.out = out;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double carPrice() {
		double extra = 0;
		// Date in vs LocalDateTIme out
		price += extra;
		
		long lin = in.getTime();
		long lout;
		lout = Date.UTC(out.getYear(), out.getMonthValue(), out.getDayOfMonth(), out.getHour(), out.getMinute(), out.getSecond());
		extra = (((lout-lin)/60000) / 10) * 5000;  //1000 sec /60 min
		
		
//		String sin = in.toString();
//		String sout = out.toString();

		//Tue Jun 30 12:11:54 KST 2020
//		System.out.println(sin);
//		String[] sin1 = sin.split(" ");

		//2020-06-30T12:11:57.333
//		System.out.println(sout);
//		String[] s1 = sout.split("T");
//		String[] sd = s1[0].split("-");
//		int year = Integer.parseInt(sd[0]);
//		int month = Integer.parseInt(sd[1]);
//		int day = Integer.parseInt(sd[2]);
//		System.out.println(s1[1]);
		
//		String[] st = s1[1].split(":");
//		int hour = Integer.parseInt(st[0]);
//		int min = Integer.parseInt(st[1]);
//		double sec = Double.parseDouble(st[2]);

		return price;
	}
}
