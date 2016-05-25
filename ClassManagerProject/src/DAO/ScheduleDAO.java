package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Model.Schedule;

public class ScheduleDAO {

	private static ScheduleDAO instance;
	private static final String DBName = "schedule";

	public static ScheduleDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new ScheduleDAO(connection);
		return instance;
	}

	private Connection conn;

	private ScheduleDAO(Connection connection) {
		this.conn = connection;
	}

	/**
	 * schedule DB 자료 추가
	 * 
	 * @param schedule
	 * @return 1 = 일정 추가 성공<br>
	 *         2 = 일정 추가 실패<br>
	 *         3 = 일정 제목 없음<br>
	 *         4 = 일정 내용 없음<br>
	 *         5 = 일정 날짜 없음<br>
	 *         6 = 일정 관계자 없음
	 */
	public int insertSchedule(Schedule schedule) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?, ?)";
		PreparedStatement pstmt = null;
		// 서비스에 추가될 내용
		// if (schedule.getSchTitle() == null)
		// return 3; // 일정 제목 없음
		// if (schedule.getSch() == null)
		// return 4; // 일정 내용 없음
		// if (schedule.getSchDate() == null)
		// return 5; // 일정 날짜 없음
		// if (schedule.getSchTitle() == null)
		// return 6; // 관계자 ID 없음

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSchTitle());
			pstmt.setDate(2, schedule.getSchDate());
			pstmt.setString(3, schedule.getSchID());
			pstmt.setString(4, schedule.getSch());
			return pstmt.executeUpdate();
			/** 일정 추가 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 추가 실패 */
			return -1;
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
	 * 일정 삭제
	 * 
	 * @param schedule
	 * @return + = 일정 삭제 성공<br>
	 *         - = 일정 삭제 실패<br>
	 */
	public int deleteSchedule(Schedule schedule) {
		String sql = "DELETE FROM " + DBName + " WHERE schtitle = ? AND schDate = ? AND schID = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSchTitle());
			pstmt.setDate(2, schedule.getSchDate());
			pstmt.setString(3, schedule.getSchID());
			return pstmt.executeUpdate();
			/** 일정 삭제 성공 시 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 삭제 실패 시 */
			return -1;
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
	 * 일정 수정
	 * 
	 * @param newSchedule
	 *            수정할 일정의 내용
	 * @param schedule
	 *            원본 일정
	 * @return + = 일정 수정 성공<br>
	 *         - = 일정 수정 실패<br>
	 */
	public int updateSchedule(Schedule newSchedule, Schedule schedule) {
		String sql = "UPDATE " + DBName + " SET schtitle = ?, sch = ?, schDate = ?, schId = ?"
				+ " WHERE schtitle = ? AND sch = ? AND schDate = ? AND schID = ?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newSchedule.getSchTitle());
			pstmt.setString(2, newSchedule.getSch());
			pstmt.setDate(3, newSchedule.getSchDate());
			pstmt.setString(4, newSchedule.getSchID());
			pstmt.setString(5, schedule.getSchTitle());
			pstmt.setString(6, schedule.getSch());
			pstmt.setDate(7, schedule.getSchDate());
			pstmt.setString(8, schedule.getSchID());
			return pstmt.executeUpdate();
			/** 일정 수정 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 수정 실패 */
			return -1;
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
	 * 일정 조회
	 * 
	 * @param schedule
	 *            schedule의 속성에 null이 있을 경우 %로 대체
	 * @return 일정 목록
	 */
	public List<Schedule> selectSchedule(Schedule schedule) {
		// String sql = "SELECT * FROM " + DBName + " WHERE schtitle LIKE ? AND
		// sch LIKE ? AND schID LIKE ?";
		String sql = "SELECT * FROM " + DBName + " WHERE schtitle LIKE ? AND schID LIKE ?";
		if (schedule.getSchDate() != null)
			sql += " AND schDate = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSchTitle() == null ? "%" : schedule.getSchTitle());
			// pstmt.setString(2, schedule.getSch() == null ? "%" :
			// schedule.getSch());
			pstmt.setString(2, schedule.getSchID() == null ? "%" : schedule.getSchID());
			if (schedule.getSchDate() != null)
				pstmt.setDate(3, schedule.getSchDate());
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Schedule tempSchedule = new Schedule();
				tempSchedule.setSchTitle(rs.getString("schtitle"));
				tempSchedule.setSch(rs.getString("sch"));
				tempSchedule.setSchDate(rs.getDate("schDate"));
				tempSchedule.setSchID(rs.getString("schID"));
				scheduleList.add(tempSchedule);
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
	 * 일정 조회 by schDate
	 * 
	 * @param startDate
	 *            null이면 2016-01-01
	 * @param endDate
	 *            null이면 현재
	 * @return
	 */
	public List<Schedule> selectScheduleByDate(Schedule schedule, Date startDate, Date endDate) {
		String sql = "SELECT * FROM " + DBName
				+ " WHERE schtitle LIKE ? AND sch LIKE ? AND schID LIKE ? schDate > ? AND schDate < ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Schedule> scheduleList = new ArrayList<Schedule>();

		if (startDate == null) {
			startDate = Date.valueOf("2016-01-01");
		}
		if (endDate == null) {
			endDate = Date.valueOf(LocalDate.now());
		}

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSchTitle() == null ? "%" : schedule.getSchTitle());
			pstmt.setString(2, schedule.getSch() == null ? "%" : schedule.getSch());
			pstmt.setString(3, schedule.getSchID() == null ? "%" : schedule.getSchID());
			pstmt.setDate(4, startDate);
			pstmt.setDate(5, endDate);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Schedule tempSchedule = new Schedule();
				tempSchedule.setSchTitle(rs.getString("schtitle"));
				tempSchedule.setSch(rs.getString("sch"));
				tempSchedule.setSchDate(rs.getDate("schDate"));
				tempSchedule.setSchID(rs.getString("schID"));
				scheduleList.add(tempSchedule);
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
}