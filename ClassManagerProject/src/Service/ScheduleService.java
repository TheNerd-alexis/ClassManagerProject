package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import DAO.MemberDAO;
import DAO.ScheduleDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Member;
import Model.Schedule;

public class ScheduleService {
	
	static GetDAO dao = GetDAO.getInstance();
	
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
	public static CMResult schedul_add(AbstractModel model) {
		Schedule schedule = (Schedule) model;
		CMResult result = new CMResult();
		if (schedule.getSchTitle() == null)
			result.setResult(-1); // 일정 제목 없음
		if (schedule.getSch() == null)
			result.setResult(-2); // 일정 내용 없음
		if (schedule.getSchDate() == null)
			result.setResult(-3); // 일정 날짜 없음
		if (schedule.getSchTitle() == null)
			result.setResult(-4); // 관계자 ID 없음
		
		result.setResult(dao.schDao().insertSchedule(schedule));
		
		return result;
	}
	
//	public List<AbstractModel> show(AbstractModel model) {
//		Schedule schedule = (Schedule) model;
//		List<Schedule> list = scheduleDAO.selectSchedule(schedule);
//		List<AbstractModel> result = new ArrayList<AbstractModel>();
//
//		for (Schedule s : list) {
//			result.add(s);
//		}
//		return result;
//	}
	
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
	 public static CMResult PrivateSchdule_show(AbstractModel model) {//개인일정
		 Schedule schedule = (Schedule) model;
		 CMResult result = new CMResult();
		 if(schedule.getSchID() == null) 
			 result.setResult(-2);

		 result.setResult(1);
		 
		 List<AbstractModel> resultList = new ArrayList<AbstractModel>();
			for(AbstractModel m :dao.schDao().selectSchedule(schedule.setID(schedule.getID()))){
				resultList.add(m);
			}
			result.setResultList(resultList);
			
			return result;
	 }
	 
	 public static CMResult PublicSchdule_show(AbstractModel model) {//전체일정
		 Schedule schedule = (Schedule) model;
		 CMResult result = new CMResult();
		 if(schedule.getSchDate() == null) 
			 result.setResult(-1);
		 if(!schedule.getSchID().equals("public"))
			 result.setResult(-2);
		
		 List<AbstractModel> resultList = new ArrayList<AbstractModel>();
			for(AbstractModel m :dao.schDao().selectSchedule(schedule)){
				resultList.add(m);
			}
			result.setResultList(resultList);
			
			return result;
	 }
}
