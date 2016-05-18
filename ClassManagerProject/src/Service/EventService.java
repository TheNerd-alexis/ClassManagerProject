package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import DAO.EventDAO;
import Model.AbstractModel;
import Model.Event;

public class EventService {
	
	private final static String URL = "jdbc:mysql://localhost:3306/classmanager";
	private final static String USER = "root";
	private final static String PASSWORD = "mysql";
	Connection connection;
	EventDAO eventDao;
	
	public EventService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			eventDao = EventDAO.getInstance(connection);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 적재 실패 com.mysql/jdbc.Driver !");
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQL 연결 실패!");
		}		
	}
	
	
	public List<Event> event_refresh(AbstractModel model) {
		
		Event tempEvent = (Event) model;
		return  eventDao.selectEvent(tempEvent);
	}
	
	public int event_add(AbstractModel model) {
		
		Event tempEvent = (Event) model;

		List<Event> listEvent = eventDao.selectEvent(tempEvent);
		
		if (listEvent.size() > 0) {
			for(Event el : listEvent) {
				if(tempEvent.getMid() == el.getMid() && tempEvent.getEtitle().equals(el.getEtitle())) {
					return 3;
				}
			}
		}
		return eventDao.insertEvent(tempEvent);
	}
	
	public int event_delete(AbstractModel model) {
		
		Event tempEvent = (Event) model;
		return eventDao.deleteEvent(tempEvent);
	}
	
	public int event_edit(AbstractModel newModel, AbstractModel editModel) {
		Event newEvent = (Event) newModel;
		Event editEvent = (Event) editModel;
		
		return eventDao.updateEvent(newEvent, editEvent);
	}
}
