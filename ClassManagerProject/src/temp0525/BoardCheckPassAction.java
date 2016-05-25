package temp0525;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

public class BoardCheckPassAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		String num = req.getParameter("num");
		String pass = req.getParameter("pass");
		
		BoardDAO boardDAO = BoardDAO.getInstance();
		Board board = new Board();
		
		if(board.getPass().equals(pass)) { // 성공
			url = "board/checkSuccess.jsp";
		}
		else { // 실패
			url= "board/boardCheckPass.jsp";
			req.setAttribute("message", "비밀번호가 틀렸습니다.");
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
	

}
