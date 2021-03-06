package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Friend;

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
			instance = new FriendDAO(connection);
		return instance;
	}
	/**
	 * friend DB 자료 추가
	 * 
	 * @param friend
	 * @return + = 친구 정보 추가 성공<br>
	 *         - = 친구 정보 추가 실패<br>
	 */
	public int insertFriend(Friend friend) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?);";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, friend.getMID());
			statement.setString(2, friend.getFID());
			return statement.executeUpdate();
			/** 친구 정보 입력 성공 */
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			/** 친구 정보 입력 실패 */
			return -1;
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

	public int deleteFriend(Friend friend) {
		String sql = "DELETE FROM " + DBName + " WHERE MID = ? AND FID = ?;";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, friend.getMID());
			statement.setString(2, friend.getFID());
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
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

	
	public List<Friend> selectFriend(Friend friend) {
		String sql = "SELECT * FROM " + DBName + " WHERE MID LIKE ? AND FID LIKE ?";
		PreparedStatement statement = null;
		ResultSet temp = null;
		List<Friend> friendList = new ArrayList<Friend>();
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, friend.getMID() == null ? "%" : friend.getMID());
			statement.setString(2, friend.getFID() == null ? "%" : friend.getFID());
			temp = statement.executeQuery();
			while (temp.next()) {
				Friend tempFriend = new Friend();
				tempFriend.setMID(temp.getString("MID"));
				tempFriend.setFID(temp.getString("FID"));
				friendList.add(tempFriend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return friendList;
	}
}