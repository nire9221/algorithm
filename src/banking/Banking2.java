package banking;
public class Banking2 {
	static int ctotal;
	static int[][] table = new int[10][];
	static int row;
	
	void todo() {
		int[][][] d3 = new int[5][3][2];
		int[][] d2 = d3[0];
		int[] d1 = d2[0];
		int v = d1[0];
	}
	
	static int getTotal() {
		int rt = 0;
		rt = ctotal;
		return rt;
	}	
	
	static int[] deposit(int d) {
		int total = getTotal();
		total += d;
		ctotal = total;
		int[] event = new int[3];
		event[0] = d;
		event[1] = 0;
		event[2] = total;

		return event;
	}
	static int[] withdraw(int w) {
		int total = getTotal();
		if(w <=total) {
			total -= w;
			ctotal = total;
			int[] event = new int[3];
			event[0] = 0;
			event[1] = w;
			event[2] = total;	
			return event;
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		for (int i=0; i<5; ++i) {
			int [] event = deposit(5000);
			table[row] = event;
			++row;
			
			event = withdraw(500);
			table[row] = event;
			++row;
			if (event != null) {
			}
		}
		for (int i = 0; i < row; i++) {
			int [] event = table[i];
			System.out.println(event[0] + " : " + event[1] + " : "+ event[2]);
		}
	}
}
