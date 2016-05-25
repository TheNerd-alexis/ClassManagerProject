package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.EventDAO;
import DAO.GetDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Event;

public class EventService {

	static GetDAO dao = GetDAO.getInstance();

	public static CMResult event_refresh(AbstractModel model) {

		Event tempEvent = new Event();
		tempEvent.setMid(((Event) model).getMid());
		CMResult result = new CMResult();

		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for (AbstractModel m : dao.getEventDao().selectEvent(tempEvent)) {
			resultList.add(m);
		}
		
		if (resultList.size() < 1)
			return result.setResult(-2);

		result.setResultList(resultList);
		return result.setResult(1);
	}

	/**
	 * 이벤트 추가 서비스
	 * 
	 * @param model
	 *            = 이벤트 추가시킬 MODEL
	 * @return 0 = DB에서 찾을 수 없음 + = 이벤트 추가 성공 -1 = 이벤트 추가 실패 (PRIMARY KEY 중복)
	 */
	public static CMResult event_add(AbstractModel model) {

		Event event = (Event) model;
		CMResult result = new CMResult();

		if (event.getMid() == null) 
			return result.setResult(-2);
		if (event.getEtype() == null) 
			return result.setResult(-3);
		if (event.getEtitle() == null) 
			return result.setResult(-4);
		
		return result.setResult(dao.getEventDao().insertEvent(event));
	}

	/**
	 * 이벤트 삭제 서비스
	 * 
	 * @param model
	 *            = 이벤트 삭제시킬 MODEL
	 * @return 0 = DB에서 찾을 수 없음 + = 이벤트 삭제 성공 - = 이벤트 삭제 실패
	 */
	public static CMResult event_delete(AbstractModel model) {

		Event event = (Event) model;
		CMResult result = new CMResult();

		if (event.getMid() == null) {
			result.setResult(-2);
		} else if (event.getEtype() == null) {
			result.setResult(-3);
		} else if (event.getEtitle() == null) {
			result.setResult(-4);
		} else if (event.getEstatus() == null) {
			result.setResult(-5);
		} else {
			result.setResult(dao.getEventDao().deleteEvent(event));
		}
		return result;
	}

	/**
	 * 이벤트 수정 서비스
	 * 
	 * @param newModel
	 *            = 이벤트 수정값 데이터 MODEL
	 * @param editModel
	 *            = 이벤트 수정시킬 데이터 MODEL
	 * @return 0 = DB에서 찾을 수 없음 + = 이벤트 수정 성공 - = 이벤트 수정 실패
	 */
	public static CMResult event_edit(AbstractModel newModel, AbstractModel editModel) {
		Event newEvent = (Event) newModel;
		Event editEvent = (Event) editModel;

		CMResult result = new CMResult();

		if (newEvent.getMid() == null) {
			result.setResult(-2);
		} else if (newEvent.getEtype() == null) {
			result.setResult(-3);
		} else if (newEvent.getEtitle() == null) {
			result.setResult(-4);
		} else if (newEvent.getEstatus() == null) {
			result.setResult(-5);
		} else {
			result.setResult(dao.getEventDao().updateEvent(newEvent, editEvent));
		}
		return result;
	}
}
