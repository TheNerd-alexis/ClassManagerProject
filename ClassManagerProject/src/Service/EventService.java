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
	
	/*
	 * Null Type:
	 * -100: MID 외래키(MID)(PK)
	 * -101: ETYPE
	 * -102: ETITLE(PK)
	 * -103: ESTATUS
	 * 
	 * -200: (EDIT) MID
	 * -201: (EDIT) ETITLE
	 */
		
	public static CMResult event_refresh(AbstractModel model) {
		
		Event event = (Event) model;
		CMResult result = new CMResult();
		
		List<Event> listEvent = dao.getEventDao().selectEvent(event);
		if (listEvent.size() < 1)
			return result.setResult(-2);
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for(AbstractModel m : listEvent) {
			resultList.add(m);
		}
		
		result.setResultList( resultList );
		return result.setResult(1);
	}

	public static CMResult event_add(AbstractModel model) {
		
		Event event = (Event) model;
		CMResult result = new CMResult();
		
		if (event.getMid() == null)
			return result.setResult(-100);
		
		if (event.getEtype() == null)
			return result.setResult(-101);
		
		if (event.getEtitle() == null)
			return result.setResult(-102);
		
		if (event.getEstatus() == null)
			return result.setResult(-103);
				
		return result.setResult( dao.getEventDao().insertEvent(event) );
	}
	
	
	public static CMResult event_delete(AbstractModel model) {
		
		Event event = (Event) model;
		CMResult result = new CMResult();
		
		if (event.getMid() == null)
			return result.setResult(-100);
		
		if (event.getEtitle() == null)
			return result.setResult(-102);
			
		return result.setResult( dao.getEventDao().deleteEvent(event) );
	}
	

	public static CMResult event_edit(AbstractModel newModel, AbstractModel editModel) {
		Event newEvent = (Event) newModel;
		Event editEvent = (Event) editModel;
		
		CMResult result = new CMResult();
		
		if (newEvent.getMid() == null)
			result.setResult(-100);
		
		if (newEvent.getEtitle() == null)
			result.setResult(-102);
		
		if (editEvent.getMid() == null)
			result.setResult(-200);
		
		if (editEvent.getEtitle() == null)
			result.setResult(-201);
		
		return result.setResult( dao.getEventDao().updateEvent(newEvent, editEvent) );
	}
}
