package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Member;

public class MemberDAO {

	private static String DBName = "member";

	private Connection connection;

	public static MemberDAO instance = null;

	public static MemberDAO getInstance(Connection connection) {
		if (instance == null)
			instance = new MemberDAO(connection);
		return instance;
	}

	private MemberDAO(Connection connection) {
		this.connection = connection;
	}

	public int insertMember(Member member) {
//		String sql = "INSERT INTO " + DBName + " VALUES(?, ?, ?, ?, ?, ?, ?)";
		String sql = "INSERT INTO " + DBName + " VALUES(?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMID());
			statement.setString(2, member.getPW());
			statement.setString(3, member.getSALT());
//			statement.setString(4, member.getMNAME());
			statement.setInt(4, member.getMCL());
			statement.setInt(5, member.getPWQ());
			statement.setString(6, member.getPWA());
			/** 회원 정보 입력 성공 */
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 회원 정보 입력 실패 */
			return -1;
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * member DB 자료 삭제
	 * 
	 * @param member(MID,
	 *            PW, SALT, MNAME, MCL, PWQ, PWA)
	 * @return 1 = DB 삭제 성공<br>
	 *         2 = DB 삭제 실패<br>
	 *         3 = id 없음<br>
	 *         4 = pw 없음<br>
	 *         5 = salt 없음<br>
//	 *         6 = 이름 없음<br>
	 *         6 = 과정 선택 없음<br>
	 *         7 = 비밀번호 찾기 질문 선택 안함<br>
	 *         8 = 비밀번호 찾기 답변 선택 안함
	 */
	public int deleteMember(Member member) {
		String sql = "DELETE FROM " + DBName + " WHERE mid = ?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMID());
			/** member 자료 삭제 성공 */
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** member 자료 삭제 실패 */
			return -1;
		} finally {
			try {
				if (statement != null && !statement.isClosed())
					statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public int updateMember(Member newMember, Member member) {
//		String sql = "UPDATE " + DBName + " SET mid = ?, pw = ?, salt = ?, mname = ?, mcl = ?, pwq = ?, pwa = ?"
//				+ " WHERE mid = ?";
		String sql = "UPDATE " + DBName + " SET mid = ?, pw = ?, salt = ?, mcl = ?, pwq = ?, pwa = ?"
				+ " WHERE mid = ?";

		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement = connection.prepareStatement(sql);
			statement.setString(1, newMember.getMID() == null ? member.getMID() : newMember.getMID());
			statement.setString(2, newMember.getPW() == null ? member.getPW() : newMember.getPW());
			statement.setString(3, newMember.getSALT() == null ? member.getSALT() : newMember.getSALT());
//			statement.setString(4, newMember.getMNAME() == null ? member.getMNAME() : newMember.getMNAME());
			statement.setInt(4, newMember.getMCL() == null ? member.getMCL() : newMember.getMCL());
			statement.setInt(5, newMember.getPWQ() == null ? member.getPWQ() : newMember.getPWQ());
			statement.setString(6, newMember.getPWA() == null ? member.getPWA() : newMember.getPWA());
			statement.setString(7, member.getMID());

			/** member 자료 수정 성공 */
			return statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** member 자료 수정 실패 */
			return -1;
		} finally {
			try {
				if (!statement.isClosed() && statement != null) {
					statement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * member DB 정보 검색
	 * 
	 * @param member
	 * @return Member List
	 */
	public List<Member> selectMember(Member member) {
		String sql = "SELECT * FROM " + DBName + " WHERE mid LIKE ? AND pw LIKE ?";
		if (member.getMCL() != null)
			sql += " AND mcl = ?";
		PreparedStatement statement = null;
		ResultSet temp = null;

		List<Member> result = new ArrayList<Member>();
		if (member == null)
			member = new Member();

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMID() == null ? "%" : member.getMID());
			statement.setString(2, member.getPW() == null ? "%" : member.getPW());
//			statement.setString(3, member.getMNAME() == null ? "%" : member.getMNAME());
			if (member.getMCL() != null)
				statement.setInt(3, member.getMCL());
			temp = statement.executeQuery();

			while (temp.next()) {
				Member tempMember = new Member();
				tempMember.setMID(temp.getString("mid"));
				tempMember.setPW(temp.getString("pw"));
				tempMember.setSALT(temp.getString("salt"));
//				tempMember.setMNAME(temp.getString("mname"));
				tempMember.setMCL(temp.getInt("mcl"));
				tempMember.setPWQ(temp.getInt("pwq"));
				tempMember.setPWA(temp.getString("pwa"));
				result.add(tempMember);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (!statement.isClosed() && statement != null) {
					statement.close();
				}
				if (temp != null && !temp.isClosed())
					temp.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}
}