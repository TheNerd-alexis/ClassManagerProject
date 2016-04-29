package Schedule;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ScheduleDao {
	
	private static ScheduleDao instance;
	
	public ScheduleDao getInstance(){
		if(instance == null)
			instance = new ScheduleDao();
		return instance;
	}
	
	private Connection conn;
	private static final String URL = "jdbc:mysql://localhost/classmanager";
	private static final String USERNAME = "root";
	private static final String PW = "mysql";
	
	ScheduleDao(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, USERNAME, PW);			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * @return 1 = 일정 추가 성공 시
	 * @return 0 = 일정 추가 실패 시
	 */
	public int insertSchedule(Schedule schedule)
	{
		String sql = "insert into Schedule values (?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSch());
			pstmt.setDate(2, schedule.getSchDate());
			pstmt.setInt(3, schedule.getSchType());
			pstmt.executeUpdate();
			/** 일정 추가 성공 시*/
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			 /** 일정 추가 실패 시 */
			return 0;
		}finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}
	}
	
	public List<Schedule> selectScheduleBySchDate(Date schDate){
		String sql = "select * from schedule where schDate like ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		List<Schedule> schedulelist = new ArrayList<Schedule>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, schDate);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Schedule schedule = new Schedule();
				schedule.setSchDate(rs.getDate("schDate"));
				schedule.setSch(rs.getString("sch"));
				schedule.setSchType(rs.getInt("schType"));
				schedulelist.add(schedule);
			}			
			/** 일정 조회 성공 시*/
			return schedulelist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 조회 실패 시*/
			return null;
		} finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				if(rs != null && !rs.isClosed())
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}							
		}
		
	}
	/**
	 * @return 1 = 일정 삭제 성공 시
	 * @return 0 = 일정 삭제 실패 시
	 */
	public int deleteSchedule(Schedule schedule){
		String sql = "delete from schedule where (sch like ? and schdate like ?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, schedule.getSch());
			pstmt.setDate(2, schedule.getSchDate());
			pstmt.executeUpdate();
			/** 일정 삭제 성공 시*/
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 일정 삭제 실패 시*/
			return 0;
		}finally{
			try {
				if(pstmt != null && !pstmt.isClosed())
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
		}
	}
		
	
	
}
