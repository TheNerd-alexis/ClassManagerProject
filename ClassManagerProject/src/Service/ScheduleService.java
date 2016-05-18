package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.MemberDAO;
import DAO.ScheduleDAO;
import Model.AbstractModel;
import Model.Member;
import Model.Schedule;

public class ScheduleService {
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/classmanager";
	private String id = "root";
	private String pw = "mysql";
	private ScheduleDAO scheduleDAO;
	private static ScheduleService instance;

	public static ScheduleService getInstance() {
		if (instance == null)
			instance = new ScheduleService();
		return instance;
	}

	private ScheduleService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, id, pw);
			scheduleDAO = ScheduleDAO.getInstance(connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 일정추가
	 * 
	 * @param schedule(SchTitle, Sch, SchDate, schId)
	 * @return 3 = title 없음<br>
	 *         4 = contents 없음<br>
	 *         5 = date 없음<br>
	 *         6 = id 없음<br>
	 * 
	 */
	public int addSchdule(AbstractModel model) {
		Schedule schedule = (Schedule) model;
		if (schedule.getSchTitle() == null)
			return 3; // 일정 제목 없음
		if (schedule.getSch() == null)
			return 4; // 일정 내용 없음
		if (schedule.getSchDate() == null)
			return 5; // 일정 날짜 없음
		if (schedule.getSchTitle() == null)
			return 6; // 관계자 ID 없음
		
		return scheduleDAO.insertSchedule(schedule);
	}
	
	public List<AbstractModel> show(AbstractModel model) {
		Schedule schedule = (Schedule) model;
		List<Schedule> list = scheduleDAO.selectSchedule(schedule);
		List<AbstractModel> result = new ArrayList<AbstractModel>();

		for (Schedule s : list) {
			result.add(s);
		}
		return result;
	}
	
	/**
	 * 일정조회
	 * 
	 * @param startDate
	 *            null이면 2016-01-01
	 * @param endDate
	 *            null이면 현재
	 * @return
	 * 
	 */
	 public int showSchdule(AbstractModel model) {
		 
		 
	 }
}
