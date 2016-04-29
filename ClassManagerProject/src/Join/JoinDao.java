package Join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoinDao {
	private Connection conn;

	private static final String UserName = "root";
	private static final String PASSWORD = "skarnd11";
	private static final String URL = "jdbc:mysql://localhost:3306/namkungk";
	private static JoinDao instance;

	public static JoinDao getInstance() {
		if (instance == null)
			instance = new JoinDao();
		return instance;

	}

	private JoinDao() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, UserName, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void insertFmenu(Join join) {
		// 1. sql문

		String sql = "insert into join values (?,?);";
		PreparedStatement psm = null;
		// 2. 인자값 마련
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, join.getJid());
			psm.setString(2, join.getCome());

			psm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteJoin(String jid) {
		String sql = "delete from join where jid = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, jid);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateJoin(Join join) {

		String sql = "update join set jid = ?, come =?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, join.getJid());
			psm.setString(2, join.getCome());

			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectOne(String jid){
		String sql = "select * from join where jid ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, jid);
			rs = psm.executeQuery();
			if(rs.next()){
				Join join = new Join();
				join.setJid(rs.getString("jid"));
				join.setCome(rs.getString("come"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				if(psm != null && !psm.isClosed())
					psm.close();
			}catch(SQLException e){
				e.printStackTrace();
			} 
		}
	}
	
	public List<Join> selectAll(){
		String sql = "select * from join";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Join> joinList= new ArrayList();
		
		Join join = new Join();
		try {
			join.setJid(rs.getString("jid"));
			join.setCome(rs.getString("come"));
			joinList.add(join);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		return joinList;
		
		
	}
	
	
	
	
}
