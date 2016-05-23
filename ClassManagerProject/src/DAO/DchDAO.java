package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Dch;

public class DchDAO {
	public static DchDAO instance = null;
	public static final String DBName = "dch";
	private Connection connection;

	private DchDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return DchdbDAO
	 */
	public static DchDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new DchDAO(connection);
		return instance;
	}

	/**
	 * dch DB 자료 추가
	 * 
	 * @see {@link Dch}
	 * @param dch
	 * @return + = 출석 정보 추가 성공<br>
	 *         - = 출석 정보 추가 실패<br>
	 */
	public int insertDch(Dch dch) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?);";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, dch.getMID());
			statement.setDate(2, dch.getATTENDDATE());
			statement.setInt(3, dch.getATTENDANCE());
			return statement.executeUpdate();
			/** 출석 정보 입력 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 출석 정보 입력 실패 */
			return -1;
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int updateDch(Dch newDch, Dch dch) {
		String sql = "UPDATE " + DBName + " SET ATTENDANCE = ?, ATTENDDATE = ?, MID = ? "
				+ "WHERE MID = ? AND ATTENDDATE = ?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setInt(1, newDch.getATTENDANCE());
			statement.setDate(2, newDch.getATTENDDATE());
			statement.setString(3, newDch.getMID());
			statement.setString(4, dch.getMID());
			statement.setDate(5, dch.getATTENDDATE());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public List<Dch> selectDch(Dch dch) {
		String sql = "SELECT * FROM " + DBName + " WHERE MID LIKE ?";
		if (dch.getATTENDDATE() != null)
			sql += " AND ATTENDDATE = ?";
		PreparedStatement statement = null;
		ResultSet temp = null;
		List<Dch> result = new ArrayList<Dch>();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, dch.getMID());
			if (dch.getATTENDDATE() != null)
				statement.setDate(2, dch.getATTENDDATE());
			temp = statement.executeQuery();
			if (temp.next()) {
				Dch tempDch = new Dch();
				tempDch.setMID(temp.getString("MID"));
				tempDch.setATTENDDATE(temp.getDate("ATTENDDATE"));
				tempDch.setATTENDANCE(temp.getInt("ATTENDANCE"));
				result.add(tempDch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Dch> selectDch(Dch dch, Date startDate, Date endDate) {
		String sql = "SELECT * FROM " + DBName + " WHERE MID LIKE ? AND ATTENDDATE > ? AND ATTENDDATE <?";

		if (startDate == null) {
			startDate = Date.valueOf("2016-01-01");
		}
		if (endDate == null) {
			endDate = Date.valueOf(LocalDate.now());
		}

		PreparedStatement statement = null;
		ResultSet temp = null;
		List<Dch> result = new ArrayList<Dch>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, dch.getMID() == null ? "%" : dch.getMID());
			statement.setDate(2, startDate);
			statement.setDate(3, endDate);
			temp = statement.executeQuery();
			while (temp.next()) {
				Dch tempDch = new Dch();
				tempDch.setMID(temp.getString("MID"));
				tempDch.setATTENDANCE(temp.getInt("ATTENDANCE"));
				tempDch.setATTENDDATE(temp.getDate("ATTENDDATE"));
				result.add(tempDch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
				if (temp != null && !temp.isClosed())
					temp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Dch> selectDchByDate(Dch dch, Date startDate, Date endDate) {
		String sql = "SELECT * FROM " + DBName + " WHERE MID LIKE ? AND ATTENDDATE > ? AND ATTENDDATE <?";
		if (dch.getATTENDANCE() != null)
			sql += " AND ATTENDANCE = ?";

		if (startDate == null) {
			startDate = Date.valueOf("2016-01-01");
		}
		if (endDate == null) {
			endDate = Date.valueOf(LocalDate.now());
		}

		PreparedStatement statement = null;
		ResultSet temp = null;
		List<Dch> result = new ArrayList<Dch>();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, dch.getMID() == null ? "%" : dch.getMID());
			statement.setDate(2, startDate);
			statement.setDate(3, endDate);
			if (dch.getATTENDANCE() != null)
				statement.setInt(4, dch.getATTENDANCE());
			temp = statement.executeQuery();
			while (temp.next()) {
				Dch tempDch = new Dch();
				tempDch.setMID(temp.getString("MID"));
				tempDch.setATTENDANCE(temp.getInt("ATTENDANCE"));
				tempDch.setATTENDDATE(temp.getDate("ATTENDDATE"));
				result.add(tempDch);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
				if (temp != null && !temp.isClosed())
					temp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}
