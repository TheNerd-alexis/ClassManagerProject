package DAO;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Multi;

public class MultiDAO {

	private Connection conn;

	private static MultiDAO instance;
	private static final String DBName = "multi";

	private MultiDAO(Connection connection) {
		this.conn = connection;
	}

	/**
	 * @param connection
	 * @return MultiDAO
	 */
	public static MultiDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new MultiDAO(connection);
		return instance;
	}

	/**
	 * multi DB 자료 추가
	 * 
	 * @param multi
	 * @return 1 = 멀티캠퍼스 식단 추가 성공<br>
	 *         2 = 멀티캠퍼스 식단 추가 실패<br>
	 */
	public int insertMulti(Multi multi) {
		String sql = "INSERT INTO " + DBName + " VALUES (?, ?, ?, ?)";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, multi.getDAY());
			psm.setString(2, multi.getFCOURSE());
			psm.setString(3, multi.getFTYPE());
			psm.setString(4, multi.getFMENU());
			psm.executeUpdate();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
		}
	}

	public int updateMulti(Multi newMulti, Multi multi) {
		String sql = "UPDATE " + DBName + " SET day = ?, fcourse = ?, ftype = ?, fmenu = ? "
				+ "WHERE day = ? AND fcourse = ? AND ftype = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, newMulti.getDAY());
			psm.setString(2, newMulti.getFCOURSE());
			psm.setString(3, newMulti.getFTYPE());
			psm.setString(4, newMulti.getFMENU());
			psm.setInt(5, multi.getDAY());
			psm.setString(6, multi.getFCOURSE());
			psm.setString(7, multi.getFTYPE());
			psm.executeUpdate();

			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 2;
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

	public int deleteMulti(Multi multi) {
		String sql = "DELETE FROM " + DBName + " WHERE day = ? AND fcourse = ? AND ftype = ?";
		PreparedStatement psm = null;

		try {
			psm = conn.prepareStatement(sql);
			psm.setInt(1, multi.getDAY());
			psm.setString(2, multi.getFCOURSE());
			psm.setString(3, multi.getFTYPE());
			psm.executeUpdate();
			return 1;
		} catch (SQLException e) {
			e.printStackTrace();
			return 2;
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

	public List<Multi> selectMulti(Multi multi) {
		String sql = "SELECT * FROM " + DBName + " WHERE fcourse LIKE ? AND fmenu LIKE ? AND forder LIKE ?";
		if (multi.getDAY() != null)
			sql += " AND day = ?";
		PreparedStatement psm = null;
		ResultSet rs = null;
		List<Multi> fmenuList = new ArrayList<Multi>();

		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, multi.getFCOURSE() == null ? "%" : multi.getFCOURSE());
			psm.setString(2, multi.getFMENU() == null ? "%" : multi.getFMENU());
			psm.setString(3, multi.getFTYPE() == null ? "%" : multi.getFTYPE());
			if (multi.getDAY() != null)
				psm.setInt(4, multi.getDAY());
			rs = psm.executeQuery();
			while (rs.next()) {
				Multi menu = new Multi();
				menu.setDAY(rs.getInt("day"));
				menu.setFCOURSE(rs.getString("fcourse"));
				menu.setFMENU(rs.getString("fmenu"));
				menu.setFTYPE(rs.getString("ftype"));
				fmenuList.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
				if (rs != null && !rs.isClosed())
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return fmenuList;
	}
}
