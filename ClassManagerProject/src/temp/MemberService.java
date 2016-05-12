package temp;

import java.util.List;

public class MemberService {
	private MemberDAO  memberDAO = MemberDAO.getInstance();
	private static MemberService instance;
	private Member member;
		
	public static MemberService getInstance() {
		
		if (instance == null)
			instance = new MemberService();
		return instance;
	}
	
	public boolean loginProcess(String id, String pw){
		boolean isLogin = false;
		member = memberDAO.selectMemberByID(id);
		if(member != null){
			if(pw.equals(member.getPw())){
				isLogin = true;
			}
		}
		return isLogin;
	}
	
	public Member getMemberInfo(String id){
		member = memberDAO.selectMemberByID(id);
		return member;
	}
	
	public boolean updateMemberInfo(Member member){
		boolean isPwChecked = false;
		Member memberInDAO = memberDAO.selectMemberByID(member.getId());
		if(member.getPw().equals(memberInDAO.getPw())){
			memberInDAO.setName(member.getName());
			memberInDAO.setEmail(member.getEmail());
			memberDAO.updateMemberByID(memberInDAO);
			isPwChecked = true;
		}
		return isPwChecked;
	}
	
	public List<Member> getAllMemberInfo(){
		return memberDAO.selectAllMember();
	}

	public boolean joinProecess(Member member){
		boolean isJoin = false;
		Member memberInDAO = null;
		memberInDAO = memberDAO.selectMemberByID(member.getId());
		if(memberInDAO == null){
			memberDAO.insertMember(member);
			isJoin = true;
		}
		return isJoin;
	}
}
