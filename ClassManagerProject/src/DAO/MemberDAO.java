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

	/**
	 * member DB 자료 추가
	 * 
	 * @param member(MID,
	 *            PW, SALT, MNAME, MCL, PWQ, PWA)
	 * @return 1 = 회원 정보 추가 성공<br>
	 *         2 = 회원 정보 추가 실패<br>
	 *         3 = id 없음<br>
	 *         4 = pw 없음<br>
	 *         5 = salt 없음<br>
	 *         6 = 이름 없음<br>
	 *         7 = 과정 선택 없음<br>
	 *         8 = 비밀번호 찾기 질문 선택 안함<br>
	 *         9 = 비밀번호 찾기 답변 선택 안함
	 */
	public int insertMember(Member member) {
		String sql = "INSERT INTO " + DBName + " VALUES(?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement statement = null;
		
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMID());
			statement.setString(2, member.getPW());
			statement.setString(3, member.getSALT());
			statement.setString(4, member.getMNAME());
			statement.setInt(5, member.getMCL());
			statement.setInt(6, member.getPWQ());
			statement.setString(7, member.getPWA());
			statement.executeUpdate();
			/** 회원 정보 입력 성공 */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** 회원 정보 입력 실패 */
			return 2;
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
	 *         6 = 이름 없음<br>
	 *         7 = 과정 선택 없음<br>
	 *         8 = 비밀번호 찾기 질문 선택 안함<br>
	 *         9 = 비밀번호 찾기 답변 선택 안함
	 */
	public int deleteMember(Member member) {
		String sql = "DELETE FROM " + DBName + " WHERE mid = ?";
		PreparedStatement statement = null;

		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, member.getMID());
			statement.executeUpdate();
			/** member 자료 삭제 성공 */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** member 자료 삭제 실패 */
			return 2;
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
	 * member DB 자료 수정
	 * 
	 * @param newMember
	 *            수정할 정보
	 * @param member
	 *            기존 정보
	 * @return 1 = DB 수정 성공<br>
	 *         2 = DB 수정 실패<br>
	 *         3 = id 없음<br>
	 *         4 = pw 없음<br>
	 *         5 = salt 없음<br>
	 *         6 = 이름 없음<br>
	 *         7 = 과정 선택 없음<br>
	 *         8 = 비밀번호 찾기 질문 선택 안함<br>
	 *         9 = 비밀번호 찾기 답변 선택 안함<br>
	 *         10 = 수정 정보 없음
	 */
	public int updateMember(Member newMember, Member member) {
		String sql = "UPDATE " + DBName + " SET mid = ?, pw = ?, salt = ?, mname = ?, mcl = ?, pwq = ?, pwa = ?"
				+ " WHERE mid = ?";

		PreparedStatement statement = null;

		// 서비스로 이동될 내용
		// if (member.getMID() == null)
		// return 3; // id 없음
		// if (member.getPW() == null)
		// return 4; // pw 없음
		// if (member.getSALT() == null)
		// return 5; // salt 없음
		// if (member.getMNAME() == null)
		// return 6; // 이름 없음
		// if (member.getMCL() == null)
		// return 7; // 과정 선택 안함
		// if (member.getPWQ() == null)
		// return 8; // 비밀번호 찾기 질문 선택 안함
		// if (member.getPWA() == null)
		// return 9; // 비밀번호 찾기 답변 선택 안합
		// if (newMember == null)
		// return 10; // 수정할 정보 없음

		try {
			statement = connection.prepareStatement(sql);
			statement = connection.prepareStatement(sql);
			statement.setString(1, newMember.getMID() == null ? member.getMID() : newMember.getMID());
			statement.setString(2, newMember.getPW() == null ? member.getPW() : newMember.getPW());
			statement.setString(3, newMember.getSALT() == null ? member.getSALT() : newMember.getSALT());
			statement.setString(4, newMember.getMNAME() == null ? member.getMNAME() : newMember.getMNAME());
			statement.setInt(5, newMember.getMCL() == null ? member.getMCL() : newMember.getMCL());
			statement.setInt(6, newMember.getPWQ() == null ? member.getPWQ() : newMember.getPWQ());
			statement.setString(7, newMember.getPWA() == null ? member.getPWA() : newMember.getPWA());
			statement.setString(8, member.getMID());

			statement.executeUpdate();
			/** member 자료 수정 성공 */
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/** member 자료 수정 실패 */
			return 2;
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
		String sql = "SELECT * FROM " + DBName + " WHERE mid LIKE ? AND pw LIKE ? AND mname LIKE ?";
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
			statement.setString(3, member.getMNAME() == null ? "%" : member.getMNAME());
			if (member.getMCL() != null)
				statement.setInt(4, member.getMCL());
			temp = statement.executeQuery();

			while (temp.next()) {
				Member tempMember = new Member();
				tempMember.setMID(temp.getString("mid"));
				tempMember.setPW(temp.getString("pw"));
				tempMember.setSALT(temp.getString("salt"));
				tempMember.setMNAME(temp.getString("mname"));
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
