package temp0525;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

public class BoardListAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String url = "board/boardList.jsp";
		BoardDAO boardDao = BoardDAO.getInstance();
		
		List<Board> boardList = boardDao.selectAllBoards();
		req.setAttribute("boardList", boardList);
		
		req.getRequestDispatcher(url).forward(req, resp);
		
	}
	
	

}
