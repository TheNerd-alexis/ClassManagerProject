package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {
	private Connection conn;
	private static final String DBName = "chat";
	private static ChatDao instance;

	public static ChatDao getInstance(Connection connection) {
		if (instance == null)
			instance = new ChatDao(connection);
		return instance;
	}

	private ChatDao(Connection connection) {
		this.conn = connection;
	}

	public int insertChat(String RTITLE, String JID, String COME) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?);";
		PreparedStatement psm = null;
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, RTITLE);
			psm.setString(2, JID);
			psm.setDate(3, Date.valueOf(COME));
			psm.executeUpdate();
			/** insertChat succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insertChat failed */
			return 2;
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

	public int deleteChat(String RTITLE) {
		String sql = "DELETE FROM " + DBName + " WHERE RTITLE = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, RTITLE);
			psm.executeUpdate();
			/** deleteChat succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** deleteChat failed */
			return 2;
		}
	}

	public int deleteJidChat(String RTITLE, String JID) {
		String sql = "DELETE FROM " + DBName + " WHERE RTITLE = ? AND JID = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, RTITLE);
			psm.setString(2, JID);
			psm.executeUpdate();
			/** deleteJidChat succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** deleteJidChat failed */
			return 2;
		}
	}

	public List<Chat> selectJid(String RTITLE) {
		String sql = "SELECT * from " + DBName + " WHERE RTITLE = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Chat> chatList = new ArrayList<Chat>();

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, RTITLE);
			rs = psm.executeQuery();
			while (rs.next()) {
				Chat chat = new Chat();
				chat.setRtitle(rs.getString("RTITLE"));
				chat.setJid(rs.getString("JID"));
				chat.setCome(rs.getDate("COME"));
				chatList.add(chat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chatList;
	}

	public List<String> selectAllRtitle() {
		String sql = "SELECT RTITLE from " + DBName;
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<String> chatList = new ArrayList<String>();

		try {
			psm = conn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				chatList.add(rs.getString("RTITLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chatList;
	}
	
	public List<String> selectJidRtitle(String JID) {
		String sql = "SELECT RTITLE from " + DBName + "WHERE JID = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<String> chatList = new ArrayList<String>();

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, JID);
			rs = psm.executeQuery();
			while (rs.next()) {
				chatList.add(rs.getString("RTITLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chatList;
	}
}

class Chat {
	private String RTITLE;
	private String JID;
	private Date COME;

	public String getJid() {
		return JID;
	}

	String getRtitle() {
		return RTITLE;
	}

	void setRtitle(String RTITLE) {
		this.RTITLE = RTITLE;
	}

	public void setJid(String JID) {
		this.JID = JID;
	}

	public Date getCome() {
		return COME;
	}

	public void setCome(Date COME) {
		this.COME = COME;
	}
}