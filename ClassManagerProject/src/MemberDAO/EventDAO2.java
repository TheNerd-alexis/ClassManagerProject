package MemberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EventDAO2 {

	private Connection connection;

	private static EventDAO2 instance;

	public static EventDAO2 getInstance(Connection connection) {
		if (instance == null)
			instance = new EventDAO2(connection);
		return instance;
	}

	private EventDAO2(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param MID
	 * @return 1 = succeed, 2 = failed
	 */
	public int createEventDb(String MID){
		String sql = "CREATE TABLE " + "event_"+MID+"(ETYPE INT, ETITLE VARCHAR(200))";
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
			/**create EventDb succeed*/
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/**create EventDb failed*/
			return 2;
		}
	}
	/**
	 * @param MID
	 * @return 1 = succeed, 2 = failed
	 */
	public int deleteEventDb(String MID){
		String sql = "DROP TABLE " + "event_"+MID;
		Statement statement = null;
		try {
			statement = connection.createStatement();
			statement.execute(sql);
			/**delete EventDb succeed*/
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/**delete EventDb failed*/
			return 2;
		}
	}

	public void insertEvent(String MID, int eType, String eTitle) {
		String sql = "INSERT INTO " + "event_" + MID + " VALUES (?,?)";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setInt(1, eType);
			psm.setString(2, eTitle);
			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEvent(String MID, String eTitle) {
		String sql = "DELETE FROM " + "event_" + MID + " WHERE eTitle = ?";
		PreparedStatement psm = null;

		try {
			psm = connection.prepareStatement(sql);
			psm.setString(1, eTitle);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null || !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Event> selectEventByType(String MID, int eType) {
		String sql = "SELECT * FROM " + "event_" + MID + " WHERE ETYPE = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> eventList = new ArrayList<Event>();
		try {
			psm = connection.prepareStatement(sql);
			psm.setInt(1, eType);
			rs = psm.executeQuery();
			while (rs.next()) {
				Event event = new Event();
				event.setEtype(rs.getInt("ETYPE"));
				event.setEtitle(rs.getString("ETITLE"));
				eventList.add(event);
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
		return eventList;
	}

	public List<Event> selectAll() {
		String sql = "select * from event";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> eventList = new ArrayList<Event>();

		Event event = new Event();
		try {
			while (rs.next()) {
				event.setEtype(rs.getInt("ETYPE"));
				event.setEtitle(rs.getString("ETITLE"));
				eventList.add(event);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (psm != null || !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return eventList;
	}
}

class Event {

	private int etype;
	private String etitle;

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
