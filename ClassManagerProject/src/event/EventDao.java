package event;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EventDao {
	
private Connection conn;
	
	private static final String UserName = "root";
	private static final String PASSWORD = "skarnd11";//자신의 비밀번호 입력
	private static final String URL = "jdbc:mysql://localhost:3306/namkungk";
	private static EventDao instance;
	public static EventDao getInstance(){
		if(instance == null)
			instance = new EventDao();
		return instance;
		
	}
	
	private EventDao(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,UserName,PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertEvent(Event event) {

		String sql = "insert into event values (?,?)";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, event.getEtype());
			psm.setString(2, event.getEtitle());
			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteEvent(int etype) {
		String sql = "delete from event where evnttype = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, etype);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateEvent(Event event) {

		String sql = "update event set etype = ?, etitle = ? ";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, event.getEtype());
			psm.setString(2, event.getEtitle());

			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	}

	public void selectOne(int etype){
		String sql = "select * from event where etype = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, 70);
			rs = psm.executeQuery();
			if(rs.next()){
				Event event = new Event();
				event.setEtype(rs.getInt("etype"));
				event.setEtitle(rs.getString("etitle"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try{
				if(psm != null && !psm.isClosed())
					psm.close();
			}catch(SQLException e){
				e.printStackTrace();
			} 
		}
	}
	
	public List<Event> selectAll(){
		String sql = "select * from event";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Event> eventList= new ArrayList();
		
		Event event = new Event();
		try {
			event.setEtype(rs.getInt("etype"));
			event.setEtitle
			(rs.getString("etitle"));
			eventList.add(event);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return eventList;
		
		
	}
	
	
	


}
