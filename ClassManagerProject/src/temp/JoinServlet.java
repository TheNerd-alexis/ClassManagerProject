package temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/joinServlet123")
public class JoinServlet extends HttpServlet {

	MemberService memberService = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		doProc(req, resp);
	}
	
	
	public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Member member = new Member();
		member.setId( req.getParameter("id") );
		member.setPw( req.getParameter("pw") );
		member.setName( req.getParameter("name") );
		member.setEmail( req.getParameter("email") );
		
		if(!memberService.joinProecess(member)) {
			resp.sendRedirect("01_joinForm.jsp");
		}
		else{
			resp.sendRedirect("01_LoginForm.jsp");
		}
		
	}
}
