package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

	private Connection connection;
	private static EventDAO instance;
	private static final String DBName = "event";

	private EventDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return EventDAO
	 */
	public static EventDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new EventDAO(connection);
		return instance;
	}

	/**
	 * mid의 이벤트에 etype의 etitle을 추가
	 * 
	 * @param mid
	 * @param etype
	 * @param etitle
	 * @return 1 = insert event succeed, 2 = failed
	 */
	public int insertEvent(String mid, int etype, String etitle) {

		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?)";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, mid);
			psm.setInt(2, etype);
			psm.setString(3, etitle);
			psm.executeUpdate();
			/** insert Event succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insert Event failed */
			return 2;
		}
	}

	/**
	 * mid의 이벤트에서 etype의 etitle을 삭제
	 * 
	 * @param mid
	 * @param etitle
	 * @return 1 = delete event succeed, 2 = failed
	 */
	public int deleteEvent(String mid, String etitle) {
		String sql = "DELETE FROM " + DBName + " WHERE mid = ? AND etitle = ?";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, mid);
			psm.setString(2, etitle);
			psm.executeUpdate();
			/** delete Event succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** delete Event failed */
			return 2;
		}
	}

	/**
	 * mid의 이벤트 중 etype, etitle을 etype2, etitle2로 수정
	 * 
	 * @param mid
	 * @param etype
	 *            기존 이벤트의 종류
	 * @param etitle
	 *            기존 이벤트의 내용
	 * @param etype2
	 *            수정할 이벤트의 종류
	 * @param etitle2
	 *            수정할 이벤트의 내용
	 * @return 1 = update event succeed, 2 = failed
	 */
	public int updateEvent(String mid, int etype, String etitle, int etype2, String etitle2) {

		String sql = "UPDATE " + DBName + " SET etype = ?, etitle = ? WHERE mid = ? AND etype = ? AND etitle = ? ";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setInt(1, etype2);
			psm.setString(2, etitle2);
			psm.setString(3, mid);
			psm.setInt(4, etype);
			psm.setString(5, etitle);
			psm.executeUpdate();
			/** update Event succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** update Event failed */
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

	/**
	 * mid의 etype 이벤트를 출력
	 * 
	 * @param mid
	 * @param etype
	 * @return list of etype event
	 */
	public List<Event> selectEventByType(String mid, int etype) {
		String sql = "SELECT * FROM " + DBName + " WHERE mid = ? AND etype = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> result = new ArrayList<Event>();
		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, mid);
			psm.setInt(2, etype);
			rs = psm.executeQuery();
			while (rs.next()) {
				Event event = new Event();
				event.setEtype(rs.getInt("etype"));
				event.setEtitle(rs.getString("etitle"));
				result.add(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	/**
	 * mid의 모든 이벤트 출력
	 * 
	 * @param mid
	 * @return list of event of mid
	 */
	public List<Event> selectAllEvent(String mid) {
		String sql = "SELECT * FROM " + DBName + " WHERE mid = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> eventList = new ArrayList();

		Event event = new Event();
		try {
			psm.setString(1, mid);
			rs = psm.executeQuery();
			while (rs.next()) {
				event.setMid(rs.getString("mid"));
				event.setEtype(rs.getInt("etype"));
				event.setEtitle(rs.getString("etitle"));
				eventList.add(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return eventList;
	}
}

/**
 * Popup Event class <br>
 * [String MID, int ETYPE, String ETYTLE]
 */
class Event {
	private String mid;
	private int etype;
	private String etitle;

	String getMid() {
		return mid;
	}

	void setMid(String mid) {
		this.mid = mid;
	}

	public int getEtype() {
		return etype;
	}

	public void setEtype(int etype) {
		this.etype = etype;
	}

	public String getEtitle() {
		return etitle;
	}

	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}
}
