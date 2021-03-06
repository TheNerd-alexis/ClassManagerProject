package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Event;

public class EventDAO {
	public static EventDAO instance = null;
	public static final String DBName = "event";
	private Connection connection;

	private EventDAO(Connection connection) {
		this.connection = connection;
	}

	public static EventDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new EventDAO(connection);
		return instance;
	}

	/**
	 * event DB 자료 추가
	 * 
	 * @see {@link Event}
	 * @param event
	 * @return + = 이벤트 정보 추가 성공<br>
	 *         - = 이벤트 정보 추가 실패<br>
	 */
	public int insertEvent(Event event) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?, ?)";
		if (event.getEstatus() == null)
			sql = "INSERT INTO " + DBName + "(mid, etype, etitle) VALUES (?, ?, ?)";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, event.getMid());
			psm.setInt(2, event.getEtype());
			psm.setString(3, event.getEtitle());
			if (event.getEstatus() != null)
				psm.setInt(4, event.getEstatus());
			return psm.executeUpdate();
			/** 이벤트 정보 입력 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 이벤트 정보 입력 실패 */
			return -1;
		}
	}

	public int deleteEvent(Event event) {
		String sql = "DELETE FROM " + DBName + " WHERE mid = ? AND etitle = ?";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, event.getMid());
			psm.setString(2, event.getEtitle());
			return psm.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}

	public int updateEvent(Event newEvent, Event event) {
		String sql = "UPDATE " + DBName
				+ " SET etype = ?, etitle = ?, mid = ? WHERE mid = ? AND etype = ? AND etitle = ? ";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setInt(1, newEvent.getEtype());
			psm.setString(2, newEvent.getEtitle());
			psm.setString(3, newEvent.getMid());
			psm.setString(4, event.getMid());
			psm.setString(5, event.getEtitle());
			return psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public List<Event> selectEvent(Event event) {
		String sql = "SELECT * FROM " + DBName + " WHERE mid LIKE ? AND etitle LIKE ?";
		if (event.getEtype() != null)
			sql += " AND etype = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> result = new ArrayList<Event>();
		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, event.getMid() == null ? "%" : event.getMid());
			psm.setString(2, event.getEtitle() == null ? "%" : event.getEtitle());
			if (event.getEtype() != null)
				psm.setInt(3, event.getEtype());
			rs = psm.executeQuery();
			while (rs.next()) {
				Event tempEvent = new Event();
				tempEvent.setEtype(rs.getInt("etype"));
				tempEvent.setEtitle(rs.getString("etitle"));
				tempEvent.setMid(rs.getString("mid"));
				tempEvent.setEstatus(rs.getInt("estatus"));
				result.add(tempEvent);
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
}