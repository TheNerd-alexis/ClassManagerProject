package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DchDAO {
	public static DchDAO instance = null;
	public static final String DBName = "dch";
	private Connection connection;

	private DchDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return DCHdbDAO
	 */
	public static DchDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new DchDAO(connection);
		return instance;
	}

	/**
	 * MID의 date attendance를 수정
	 * 
	 * @param MID
	 * @param date
	 * @param attendance
	 * @return 1 = insert DCH succeed, 2 = failed
	 */
	public int insertDCH(String MID, String date, Boolean attendance) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?);";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;

		try {
			statement.setString(1, MID);
			statement.setDate(2, dchdate);
			statement.setBoolean(3, attendance);
			statement.executeUpdate();
			/** insertDCH succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insertDCH failed */
			return 2;
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * MID의 date attendance를 수정
	 * 
	 * @param MID
	 * @param date
	 * @param attendance
	 * @return 1 = modify DCH state succeed, 2 = failed
	 */
	public int modifiedDCH(String MID, String date, Boolean attendance) {
		String sql = "UPDATE " + DBName + " ATTENDANCE = ? WHERE MID = ? AND ATTENDDATE = ?;";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;

		try {
			statement.setBoolean(1, attendance);
			statement.setString(2, MID);
			statement.setDate(3, dchdate);
			statement.executeUpdate();
			/** insertDCH succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insertDCH failed */
			return 2;
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * MID의 date 출석 여부 출력
	 * 
	 * @param MID
	 * @param date
	 * @return true = 출석, false = 결석
	 */
	public DCH selectDCH(String MID, String date) {
		String sql = "SELECT ATTENDANCE FROM " + DBName + " WHERE MID = ? AND ATTENDDATE = ?;";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;
		ResultSet temp = null;
		DCH dch = null;

		try {
			statement.setString(1, MID);
			statement.setDate(2, dchdate);
			temp = statement.executeQuery();
			/** selectDCH succeed */
			if (temp.next()) {
				dch = new DCH();
				dch.setMID(temp.getString("MID"));
				dch.setATTENDDATE(temp.getDate("ATTENDDATE"));
				dch.setATTENDANCE(temp.getBoolean("ATTENDANCE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return dch;
	}

	/**
	 * MID의 startDate부터 endDate까지의 출석여부
	 * @param MID
	 * @param startDate
	 * @param endDate
	 * @return true = 출석, false = 결석
	 */
	public List<DCH> selectDCH(String MID, String startDate, String endDate) {
		String sql = "SELECT * FROM " + DBName + " WHERE MID = ? AND ATTENDDATE > ? AND ATTENDDATE <?;";
		Date start = Date.valueOf(startDate);
		Date end = Date.valueOf(endDate);

		PreparedStatement statement = null;
		ResultSet temp = null;
		List<DCH> result = new ArrayList<DCH>();

		try {
			statement.setString(1, MID);
			statement.setDate(2, start);
			statement.setDate(3, end);
			temp = statement.executeQuery();
			/** selectDCH succeed */
			while (temp.next()) {
				DCH dch = new DCH();
				dch.setMID(temp.getString("MID"));
				dch.setATTENDANCE(temp.getBoolean("ATTENDANCE"));
				dch.setATTENDDATE(temp.getDate("ATTENDDATE"));
				result.add(dch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}

/**
 * Daily Check class <br>
 * [String MID, Date ATTENDDATE, Boolean ATTENDANCE]
 */
class DCH {
	private String MID;
	private Date ATTENDDATE;
	private Boolean ATTENDANCE;

	String getMID() {
		return MID;
	}

	void setMID(String mID) {
		MID = mID;
	}

	Date getATTENDDATE() {
		return ATTENDDATE;
	}

	void setATTENDDATE(Date aTTENDDATE) {
		ATTENDDATE = aTTENDDATE;
	}

	Boolean getATTENDANCE() {
		return ATTENDANCE;
	}

	void setATTENDANCE(Boolean aTTENDANCE) {
		ATTENDANCE = aTTENDANCE;
	}
}
