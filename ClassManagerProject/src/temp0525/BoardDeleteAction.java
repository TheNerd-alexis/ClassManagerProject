package temp0525;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class BoardDeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String num=req.getParameter("num");
	BoardDAO boardDao = BoardDAO.getInstance();
			boardDao.deleteBoard(num);
			
			new BoardListAction().execute(req, resp);
	}
	
}
