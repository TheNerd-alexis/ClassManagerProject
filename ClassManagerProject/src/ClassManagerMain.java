import CMServer.CMServer;
import MemberDAO.MemberDAO;

public class ClassManagerMain {
	public static void main(String[] args) {
		String[] pw1 = MemberDAO.password("hello");
		String[] pw2 = MemberDAO.password("Hello");
		String pw3 = MemberDAO.password("hello",pw1[1]);
		String pw4 = MemberDAO.password("Hello",pw1[1]);
		System.out.println(pw1[0] + "  " + pw1[1]);
		System.out.println(pw2[0] + "  " + pw2[1]);
		System.out.println(pw3 + "  " + pw4);
	}
}
