package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Service.ScheduleService;

public class CM_DAO {
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/classmanager";
	private String id = "root";
	private String pw = "mysql";
	private ScheduleDAO scheduleDAO;
	private static ScheduleService instance;

	public static ScheduleService getScheduleDAO() {
		if (instance == null)
			instance = new ScheduleService();
		return instance;
	}

	private ScheduleService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, id, pw);
			scheduleDAO = MemberDAO.getInstance(connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
