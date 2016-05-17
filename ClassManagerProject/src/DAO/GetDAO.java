package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDAO {
	private static Connection connection;
	private String url = "jdbc:mysql://localhost:3306/classmanager";
	private String id = "root";
	private String pw = "mysql";
	private static GetDAO instance;
	private static ScheduleDAO scheduleDAO;
	private static ChatDao chatDAO;
	private static DchDAO dchDAO;
	private static EventDAO eventDAO;
	private static FriendDAO friendDAO;
	private static MemberDAO memberDAO;
	private static MultiDAO multiDAO;

	private GetDAO() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, id, pw);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static GetDAO getInstance() {
		if (instance == null)
			instance = new GetDAO();
		return instance;
	}

	public ScheduleDAO schDao() {
		if (scheduleDAO == null)
			scheduleDAO = ScheduleDAO.getInstance(connection);
		return scheduleDAO;
	}

	public MemberDAO getMemberDao() {
		if (memberDAO == null)
			memberDAO = MemberDAO.getInstance(connection);
		return memberDAO;
	}

	public ChatDao getChatDao() {
		if (chatDAO == null)
			chatDAO = ChatDao.getInstance(connection);
		return chatDAO;
	}

	public DchDAO getDchDao() {
		if (dchDAO == null)
			dchDAO = DchDAO.getInstance(connection);
		return dchDAO;
	}

	public EventDAO getEventDao() {
		if (eventDAO == null)
			eventDAO = EventDAO.getInstance(connection);
		return eventDAO;
	}

	public MultiDAO getMultiDao() {
		if (multiDAO == null)
			multiDAO = MultiDAO.getInstance(connection);
		return multiDAO;
	}
	
	public FriendDAO getFriendDao() {
		if (friendDAO == null)
			friendDAO = FriendDAO.getInstance(connection);
		return friendDAO;
	}
}