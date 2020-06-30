package member;

import java.util.Scanner;

public class AppStarter {
	
	private MemberService memberService;
	
	public static void main(String[] args) {
		mgrMember();
		
	}
	
	public static void mgrMember() {
		AppStarter console = new AppStarter();
		console.memberService = new MemberService();
		Scanner input = new Scanner(System.in);
		
		while(true) { 
			System.out.println("[quit] [a, add] [show] [edit] [remove]");
			String cmd = input.nextLine();

//----------------------------quit----------------------------
			if(cmd.equals("quit")) { 
				break;  
			}
			
//----------------------------add, show, update, delete---------------------------- 			
			switch(cmd) {
			case "remove":
				System.out.println("select no. > ");
				int index = input.nextInt();
				input.nextLine(); 
				console.memberService.delete(index);
				
				break;
			case "edit" :
				System.out.println("select no. > ");
				index = input.nextInt();
				input.nextLine();
				Member member = console.memberService.getMemberByIndex(index);
				if(member != null) {
					System.out.println("Name : ");
					member.setName(input.nextLine()); 
				}
				console.memberService.update(member);
				break;
			case "show" :
				//list = rt
				Member [] list = console.memberService.read();
				for(int i = 0; i<list.length; ++i) {
					String s = "";
					s += i + ":";
					s += list[i].getName() + ",";
					s += list[i].getEmail();
					
					System.out.println(s);
				}
				break;
			case "a" : 
			case "add" :
				//add member (get name & email information from scanner)
				System.out.println("Name > ");
				String name = input.nextLine();
				System.out.println("Email > ");
				String email = input.nextLine();
				console.memberService.create(name, email);
				break;
			}
		}
						
		input.close();
		console.memberService = null;
		console = null;
	}

}
