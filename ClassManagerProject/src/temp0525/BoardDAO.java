package temp0525;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Board;

public class BoardDAO {

	private static BoardDAO instance;
	private static Connection conn;
	
	private static final String URL = "jdbc:mysql://localhost:3306/xe";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "mysql";
	
	private BoardDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static BoardDAO getInstance() {
		if (instance == null)
			instance = new BoardDAO();
		return instance;
	}
	
	public List<Board> selectAllBoards() {
		String sql = "SELECT * FROM `board` ORDER BY NUM";
		List<Board> boardList = new ArrayList<Board>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				
				board = new Board();
				board.setNum( rs.getInt("num") );
				board.setPass( rs.getString("pass") );
				board.setName( rs.getString("name") );
				board.setEmail( rs.getString("email") );
				board.setTitle( rs.getString("title") );
				board.setContent( rs.getString("content") );
				board.setReadcount( rs.getInt("readcount") );
				board.setWritedate( rs.getTimestamp("writedate") );
				
				boardList.add(board);
			}
				
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
				try {
					if (pstmt != null && !pstmt.isClosed())
						pstmt.close();
					if (rs != null && !rs.isClosed())
						rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return boardList;
	}
	
	
	
	public void insertBoard(Board board) {
		String sql = "INSERT INTO board(pass, name, email, title, content) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void updateReadCount(String num) {
		String sql = "UPDATE `board` SET `readcount` = readcount+1 WHERE num LIKE ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	// 게시판 글 상세 내용 보기:글번호로 찾아온다. : 실패 null,
	public Board selectOneByNum(String num) {
		String sql = "SELECT * FROM `board` WHERE `num` LIKE ?";
		
		Board board = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				board = new Board();
				board.setNum( rs.getInt("num") );
				board.setPass( rs.getString("pass") );
				board.setName( rs.getString("name") );
				board.setEmail( rs.getString("email") );
				board.setTitle( rs.getString("title") );
				board.setContent( rs.getString("content") );
				board.setReadcount( rs.getInt("readcount") );
				board.setWritedate( rs.getTimestamp("writedate") );
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
	
	public void updateBoard(Board board) {
		String sql = "UPDATE `board` SET pass=?, name=?, email=?, title=?, content=? WHERE num=?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getPass());
			pstmt.setString(2, board.getName());
			pstmt.setString(3, board.getEmail());
			pstmt.setString(4, board.getTitle());
			pstmt.setString(5, board.getContent());
			pstmt.setInt(6, board.getNum());
			
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public Board checkPassWord(String pass, String num) {
		String sql = "SELECT * FROM `board` WHERE `pass` = ? AND `num` = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Board board = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pass);
			pstmt.setString(2, num);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				board = new Board();
				board.setNum( rs.getInt("num") );
				board.setPass( rs.getString("pass") );
				board.setName( rs.getString("name") );
				board.setEmail( rs.getString("email") );
				board.setTitle( rs.getString("title") );
				board.setContent( rs.getString("content") );
				board.setReadcount( rs.getInt("readcount") );
				board.setWritedate( rs.getTimestamp("writedate") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return board;
	}
	
	public void deleteBoard(String num) {
		String sql = "DELETE FROM `baord` WHERE `num` = ?";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
