package ballCount;

public class BallCount {

	static int[] count(int a, int b) {
		int[] rt = new int[2];
		char [] aa = Integer.toString(a).toCharArray(); 
			// == String.valueOf(a).toCharArray();
		char [] ba = Integer.toString(b).toCharArray(); 
			// == ("" +b).toCharArray();
		
//		char [] aa = new char[3]; 
//		aa[0] = (char) (a/100);  //1
//		aa[1] = (char) (a/10 %10); //2
//		aa[2] = (char) (a%10); //3
//		
//		char [] ba = new char[3]; 
//		ba[0] = (char) (b/100);  //1
//		ba[1] = (char) (b/10 %10); //2
//		ba[2] = (char) (b%10); //3
		
		
		for(int ai=0; ai<3; ai++) {
			for(int bi=0; bi<3; bi++) {
				if(aa[ai] == ba[bi]) { 
					if(ai == bi) { 
						rt[0]++;
					} else { 
						rt[1]++;	
					}
				}
			}
		}
		return rt;
	}
	
	public static void main(String[] args) {
		int [] ballCount = count(123,312);
		System.out.println("Strike " + ballCount[0]);
		System.out.println("Ball " + ballCount[1]);
	}

}
