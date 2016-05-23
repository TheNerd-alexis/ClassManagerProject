package temp;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import model.Member;

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
		
		req.setCharacterEncoding("UTF-8");
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
		
		else if(reqUri.equals(contextPath + "/addMember.do")) {
			Member m = new Member();
			
			m.setName( req.getParameter("name") );
			m.setUserid( req.getParameter("userid") );
			m.setPwd( req.getParameter("pwd") );
			m.setEmail( req.getParameter("email") );
			m.setPhone( req.getParameter("phone") );
			m.setAdmin( Integer.parseInt( req.getParameter("admin") ) );
			
			memberDao.insertMember(m);
			//req.getSession().setAttribute("memberList", memberDao.selectMemberList());
			resp.sendRedirect("allMember.do");
			return;
		}
		else if(reqUri.equals(contextPath + "/insertMember.do")) {
			req.getRequestDispatcher("addMember.jsp").forward(req, resp);
		}
		System.out.println("URI :" + reqUri);
		System.out.println("PATH :" + contextPath);	
	}
}
