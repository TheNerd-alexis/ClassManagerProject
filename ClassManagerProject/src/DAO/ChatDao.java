package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Chat;

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

	public int insertChat(Chat chat) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?)";
		PreparedStatement psm = null;
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, chat.getRtitle());
			psm.setString(2, chat.getJid());
			psm.setDate(3, chat.getCome() == null ? Date.valueOf(LocalDate.now()) : chat.getCome());
			return psm.executeUpdate();
			/** DB chat 추가 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** DB chat 추가 실패 */
			return -1;
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

	public int deleteChat(Chat chat) {
		String sql = "DELETE FROM " + DBName + " WHERE RTITLE = ? AND JID = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, chat.getRtitle());
			psm.setString(2, chat.getJid());
			return psm.executeUpdate();
			/** DB chat 삭제 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** DB chat 삭제 실패 */
			return -1;
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

	public List<Chat> selectChat(Chat chat) {
		String sql = "SELECT * from " + DBName + " WHERE RTITLE LIKE ? AND JID LIKE ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Chat> chatList = new ArrayList<Chat>();

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, chat.getRtitle() == null ? "%" : chat.getRtitle());
			psm.setString(2, chat.getJid() == null ? "%" : chat.getJid());
			// System.out.println(psm.toString());
			rs = psm.executeQuery();
			while (rs.next()) {
				Chat temp = new Chat();
				temp.setRtitle(rs.getString("RTITLE"));
				temp.setJid(rs.getString("JID"));
				temp.setCome(rs.getDate("COME"));
				chatList.add(temp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return chatList;
	}
}