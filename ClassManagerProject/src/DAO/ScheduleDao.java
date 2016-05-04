package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {

	private static ScheduleDao instance;
	private static final String DBName = "schedule";

	public ScheduleDao getInstance(Connection connection) {
		if (instance == null)
			instance = new ScheduleDao(connection);
		return instance;
	}

	private Connection conn;

	ScheduleDao(Connection connection) {
		this.conn = connection;
	}

	/**
	 * schID의 일정에 schDate sch 추가
	 * 
	 * @param sch
	 *            일정 내용
	 * @param schDate
	 *            일정 날짜
	 * @param schID
	 *            일정 ID(_public = 전체)
	 * @return 1 = 일정 추가 성공 시 <br>
	 *         2 = 일정 추가 실패 시
	 */
	public int insertSchedule(String sch, String schDate, String schID) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sch);
			pstmt.setDate(2, Date.valueOf(schDate));
			pstmt.setString(3, schID);
			pstmt.executeUpdate();
			/** 일정 추가 성공 시 */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 추가 실패 시 */
			return 2;
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * schID의 schDate 일정 목록
	 * 
	 * @param schDate
	 *            일정 날짜
	 * @param schID
	 *            일정 ID(_public = 전체)
	 * @return schID의 schDate 일정 목록
	 */
	public List<Schedule> selectScheduleBySchDate(String schDate, String schID) {
		String sql = "SELECT * FROM " + DBName + " WHERE schDate LIKE ? AND schID LIKE ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, Date.valueOf(schDate));
			pstmt.setString(2, schID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Schedule schedule = new Schedule();
				schedule.setSch(rs.getString("sch"));
				schedule.setSchDate(rs.getDate("schDate"));
				schedule.setschID(rs.getString("schID"));
				scheduleList.add(schedule);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return scheduleList;
	}

	/**
	 * schID의 일정에 schDate sch 삭제
	 * 
	 * @param sch
	 *            일정 내용
	 * @param schDate
	 *            일정 날짜
	 * @param schID
	 *            일정 ID(_public = 전체)
	 * @return 1 = 일정 삭제 성공 시 <br>
	 *         2 = 일정 삭제 실패 시
	 */
	public int deleteSchedule(String sch, String schDate, String schID) {
		String sql = "DELETE FROM " + DBName + " WHERE (sch LIKE ? AND schDate LIKE ? AND schID LIKE ?)";
		PreparedStatement pstmt = null;
		Date date = Date.valueOf(schDate);
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sch);
			pstmt.setDate(2, date);
			pstmt.setString(3, schID);
			pstmt.executeUpdate();
			/** 일정 삭제 성공 시 */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 삭제 실패 시 */
			return 2;
		} finally {
			try {
				if (pstmt != null && !pstmt.isClosed())
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Schedule {
	private String sch;
	private Date schDate;
	private String schID;

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
	}

	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public String getschID() {
		return schID;
	}

	public void setschID(String schID) {
		this.schID = schID;
	}

	@Override
	public String toString() {
		return "Calendar [sch=" + sch + ", schDate=" + schDate + ", schID=" + schID + "]";
	}
}
