package MemberDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FriendDAO {
	private Connection connection;

	private FriendDAO(Connection connection) {
		this.connection = connection;
	}

	/**
	 * @param connection
	 * @return DCHdbDAO
	 */
	public static FriendDAO getInstance(Connection connection) {
		return new FriendDAO(connection);
	}

	/**
	 * create friend
	 * 
	 * @param MID
	 *            user ID
	 * @return 1 = succeed, 2 = failed
	 */
	public int createFriendDb(String MID) {
		String sql = "CREATE TABLE IF NOT EXISTS " + "friend_" + MID
				+ " (FID VARCHAR(20), FOREIGN KEY(FID) REFERENCES member(MID) ON UPDATE CASCADE ON DELETE CASCADE);";
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.execute();
			/** createFriendDb succeed */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** createFriendDb failed */
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
	 * insert friend
	 * 
	 * @param MID
	 *            user ID
	 * @param FID
	 *            friend ID
	 * @return 1 = succeed, 2 = not existed friend, 3 = already existed friend
	 */
	public int insertFriend(String MID, String FID) {
		String sql = "INSERT INTO " + "friend_" + MID + " VALUES (?);";
		PreparedStatement statement = null;
		/** already existed friend */
		if (selectFriend(MID, FID))
			return 3;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, FID);
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
	 * delete friend
	 * 
	 * @param MID
	 *            user ID
	 * @param FID
	 *            friend ID
	 * @return 1 = succeed, 2 = failed, 3 = is not friend
	 */
	public int deleteFriend(String MID, String FID) {
		String sql = "DELETE FROM " + "friend_" + MID + " WHERE FID = ?;";
		PreparedStatement statement = null;
		if (!selectFriend(MID, FID))
			return 3;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, FID);
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

	public Boolean selectFriend(String MID, String FID) {
		String sql = "SELECT FID FROM " + "friend_" + MID + " WHERE FID = ?;";
		PreparedStatement statement = null;
		ResultSet temp = null;
		Boolean isFriend = false;

		try {
			statement.setString(1, FID);
			temp = statement.executeQuery();
			/** selectDCH succeed */
			if (temp.next())
				if (temp.getString("FID").equals(FID))
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
}
