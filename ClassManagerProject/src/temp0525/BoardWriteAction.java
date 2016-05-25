package temp0525;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import model.Board;

public class BoardWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Board board = new Board();
		board.setName( req.getParameter("name") );
		board.setPass( req.getParameter("pass") );
		board.setEmail( req.getParameter("email") );
		board.setTitle( req.getParameter("title") );
		board.setContent( req.getParameter("content") );
		
		BoardDAO boardDao = BoardDAO.getInstance();
		boardDao.insertBoard(board);
		
		new BoardListAction().execute(req, resp);
		
	}
}
