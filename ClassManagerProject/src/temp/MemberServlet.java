package temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

public class MemberServlet extends HttpServlet {

	MemberDAO memberDao = MemberDAO.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		doProc(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doPost(req, resp);
		doProc(req, resp);
	}
	
	public void doProc(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reqUri = req.getRequestURI();
		String contextPath = req.getContextPath();
		
		if(reqUri.equals(contextPath + "/main.do")) {
			req.getRequestDispatcher("Main.jsp").forward(req, resp);
			return;
		}
		else if(reqUri.equals(contextPath + "/allMember.do")) {
			
			req.setAttribute("memberList", memberDao.selectMemberList());
			//req.getSession().setAttribute("memberList", memberDao.selectMemberList());
			req.getRequestDispatcher("allMember.jsp").forward(req, resp);
		}
		System.out.println("URI :" + reqUri);
		System.out.println("PATH :" + contextPath);	
	}
}
