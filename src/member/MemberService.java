package member;

public class MemberService {
	private Member[] list = new Member[10];
	private int index; //list[index]
	
	public void create(String name, String email) {
		Member member = new Member();
		member.setName(name);
		member.setEmail(email);
		
		list[index] = member;
		++index; 
	}
	
	public Member[] read() {
		Member [] rt = new Member[index];
		for (int i=0; i<index;++i) {
			rt[i] = list[i]; 
		}
		return rt;
	}
	public void update(Member member) {
		
	}
	
	public void delete(int d) {
		list[d] = null;
		if(index > 0) { 
			Member t = list[index -1];
			list[d] = t;
			--index;
		}
	}

	public Member getMemberByIndex(int n) {
		if(0 <= n && n < list.length) {
			if(list[n] != null) {
				return list[n];
			}
		}
		return null;
	}	
}
