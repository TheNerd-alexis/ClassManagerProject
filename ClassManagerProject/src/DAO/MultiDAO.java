package DAO;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MultiDAO {

	private Connection conn;

	private static MultiDAO instance;
	private static final String DBName = "multi";

	private MultiDAO(Connection connection) {
		this.conn = connection;
	}

	/**
	 * @param connection
	 * @return MultiDAO
	 */
	public static MultiDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new MultiDAO(connection);
		return instance;
	}

	public int insertFmenu(int day, char fcourse, int ftype, String fmenu) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?, ?)";
		PreparedStatement psm = null;
		String course = String.valueOf(fcourse);

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, day);
			psm.setString(2, course);
			psm.setInt(3, ftype);
			psm.setString(4, fmenu);
			psm.executeUpdate();
			/** insert Fmenu succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insert Fmenu failed */
			return 2;
		}
	}

	public int updateFmenu(int day, char fcourse, int ftype, String fmenu, char fcourse2, int ftype2, String fmenu2) {
		String sql = "UPDATE " + DBName
				+ " SET fcourse = ?, ftype = ?, fmenu = ? WHERE day = ? AND fcourse = ? AND ftype = ? AND fmenu = ?";
		PreparedStatement psm = null;
		String course = String.valueOf(fcourse);
		String course2 = String.valueOf(fcourse2);

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, course2);
			psm.setInt(2, ftype2);
			psm.setString(3, fmenu2);
			psm.setInt(4, day);
			psm.setString(5, course);
			psm.setInt(6, ftype);
			psm.setString(7, fmenu);
			psm.executeUpdate();
			/** update Fmenu succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** update Fmenu failed */
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

	public int deleteFmenuOfDay(int day) {
		String sql = "DELETE FROM " + DBName + " WHERE day = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, day);
			psm.executeUpdate();
			/** delete Fmenu succeed */
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			/** delete Fmenu failed */
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

	public int deleteFcourseOfDay(int day, char fcourse) {
		String course = String.valueOf(fcourse);
		String sql = "DELETE FROM " + DBName + " WHERE day = ? AND fcourse = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, day);
			psm.setString(2, course);
			psm.executeUpdate();
			/** delete Fcourse succeed */
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			/** delete Fcourse failed */
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

	public int deleteAllFmenu() {
		String sql = "DELETE FROM " + DBName;
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.executeUpdate();
			/** delete All Fmenu succeed */
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			/** delete All Fmenu failed */
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

	public List<Fmenu> selectFmenuByDayAndCourse(int day, char fcourse) {
		String sql = "SELECT * FROM " + DBName + " WHERE day = ? AND fcourse = ? ";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Fmenu> fmenuList = new ArrayList<Fmenu>();

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, day);
			psm.setString(2, String.valueOf(fcourse));
			rs = psm.executeQuery();
			while (rs.next()) {
				Fmenu menu = new Fmenu();
				menu.setDay(rs.getInt("day"));
				menu.setFcourse(rs.getString("fcourse").charAt(0));
				menu.setFmenu(rs.getString("fmenu"));
				menu.setFtype(rs.getInt("ftype"));
				fmenuList.add(menu);
			}
		} catch (SQLException e) {
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
		return fmenuList;
	}

	public List<Fmenu> selectAllFmenu() {
		String sql = "SELECT * FROM " + DBName;
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Fmenu> fmenuList = new ArrayList();
		try {
			psm = conn.prepareStatement(sql);
			rs = psm.executeQuery();
			while (rs.next()) {
				Fmenu menu = new Fmenu();
				menu.setDay(rs.getInt("day"));
				menu.setFcourse(rs.getString("day").charAt(0));
				menu.setFtype(rs.getInt("ftype"));
				menu.setFmenu(rs.getString("fmenu"));
				fmenuList.add(menu);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fmenuList;
	}
}

class Fmenu {
	int day;
	char fcourse;
	int ftype;
	String fmenu;

	int getDay() {
		return day;
	}

	void setDay(int day) {
		this.day = day;
	}

	char getFcourse() {
		return fcourse;
	}

	void setFcourse(char fcourse) {
		this.fcourse = fcourse;
	}

	int getFtype() {
		return ftype;
	}

	void setFtype(int ftype) {
		this.ftype = ftype;
	}

	String getFmenu() {
		return fmenu;
	}

	void setFmenu(String fmenu) {
		this.fmenu = fmenu;
	}
}
