package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendDAO {
	private Connection connection;

	public static FriendDAO instance;
	public static final String DBName = "friend";

	private FriendDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return DCHdbDAO
	 */
	public static FriendDAO getInstance(Connection connection) {
		if (instance == null)
			new FriendDAO(connection);
		return instance;
	}

	/**
	 * MID의 친구로 FID를 추가
	 * 
	 * @param MID
	 * @param FID
	 * @return 1 = insert friend succeed, 2 = not existed friend
	 */
	public int insertFriend(String MID, String FID) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?);";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, MID);
			statement.setString(2, FID);
			statement.executeUpdate();
			/** insertFriend succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** insertFriend failed */
			return 2;
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * MID의 친구 중 FID를 삭제
	 * 
	 * @param MID
	 * @param FID
	 * @return 1 = delete friend succeed, 2 = failed
	 */
	public int deleteFriend(String MID, String FID) {
		String sql = "DELETE FROM " + DBName + " WHERE MID = ? AND FID = ?;";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, MID);
			statement.setString(2, FID);
			statement.executeUpdate();
			/** delete friend succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** delete friend failed */
			return 2;
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * MID의 친구 중 FID가 있는지 확인
	 * @param MID
	 * @param FID
	 * @return true = FID is MID's friend, false = is not
	 */
	public Boolean isFriend(String MID, String FID) {
		String sql = "SELECT FID FROM " + DBName + " WHERE MID = ? AND FID = ?;";
		PreparedStatement statement = null;
		ResultSet temp = null;
		Boolean isFriend = false;

		try {
			statement.setString(1, MID);
			statement.setString(2, FID);
			temp = statement.executeQuery();
			if (temp.next())
				isFriend = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (statement != null || !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return isFriend;
	}
	
	/**
	 * MID의 친구 목록을 출력
	 * @param MID
	 * @return List<String>
	 */
	public List<String> selectAllFriends(String MID){
		String sql = "SELECT FID FROM "+DBName + "WHERE MID = ?";
		PreparedStatement statement = null;
		ResultSet temp = null;
		List<String> friendList = new ArrayList<String>();
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, MID);
			temp = statement.executeQuery();
			while(temp.next()){
				friendList.add(temp.getString("FID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendList;
	}
}
