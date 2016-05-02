package MemberDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Join.JoinDao;

public class DCHdbDAO {

	private Connection connection;

	private static String SQLID;
	private static String PASSWORD;
	private static String URL;
	private static JoinDao instance;
	private static String DBname = "member";

	public DCHdbDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return DCHdbDAO
	 */
	public DCHdbDAO getInstance(Connection connection) {
		return new DCHdbDAO(connection);
	}

	public int createDCHdb(String MID) {
		String sql = "CREATE TABLE IF NOT EXISTS ?(ATTENDDATE DATE PRIMARY KEY, ATTENDANCE BOOLEAN);";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, "dch_" + MID);
			statement.execute();
			/** createDCHdb succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** createDCHdb failed */
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

	public int insertDCH(String MID, String date, Boolean attendance) {
		String sql = "INSERT INTO " + "dch_" + MID + " VALUES (?,?);";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;

		try {
			statement.setDate(1, dchdate);
			statement.setBoolean(2, attendance);
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

	public int modifiedDCH(String MID, String date, Boolean attendance) {
		String sql = "UPDATE " + "dch_" + MID + " ATTENDANCE = ? WHERE ATTENDDATE = ?;";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;

		try {
			statement.setBoolean(1, attendance);
			statement.setDate(2, dchdate);
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

	public Boolean selectDCH(String MID, String date) {
		String sql = "SELECT ATTENDANCE FROM " + "dch_" + MID + " WHERE ATTENDDATE = ?;";
		Date dchdate = Date.valueOf(date);
		PreparedStatement statement = null;
		ResultSet temp = null;
		Boolean attend = null;

		try {
			statement.setDate(1, dchdate);
			temp = statement.executeQuery();
			/** selectDCH succeed */
			if (temp.next())
				attend = temp.getBoolean("ATTENDANCE");
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
		return attend;
	}
}
