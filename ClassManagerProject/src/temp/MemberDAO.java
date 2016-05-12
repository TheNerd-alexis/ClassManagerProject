package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MemberDAO {
	
	private Connection connection;
	
	
	private static MemberDAO instance;
	
	private final static String URL = "jdbc:mysql://localhost:3306/member";
	private final static String USER = "root";
	private final static String PASS = "mysql";
	
	
	public static MemberDAO getInstance() {
		if(instance == null)
			instance = new MemberDAO();
		return instance;
	}
	
	private MemberDAO() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("클래스 적재 실패");
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("DB 연결 실패");
			//e.printStackTrace();
		}
	}
	
	
	public Member SelectMemberByID(String id) {
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM `member` WHERE `id` LIKE ?";
		ResultSet rs = null;
		
		Member member = null;
		
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if ( rs.next() ) {
				member = new Member();
				member.setId( rs.getString("id") );
				member.setPw( rs.getString("pw") );
				member.setName( rs.getString("name") );
				member.setEmail( rs.getString("email") );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if ( pstmt != null && !pstmt.isClosed() )
					pstmt.close();
				if ( rs != null && rs.isClosed() )
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return member;
	}
	
	public List<Member> SelectAllMember() {
		List<Member> listMember = new ArrayList<Member>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		Member member = null;
		String sql = "SELECT * FROM `member`";
		
		try {
			pstmt = connection.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while ( rs.next() ) {
				member = new Member();
				member.setId( rs.getString("id") );
				member.setPw( rs.getString("pw") );
				member.setName( rs.getString("name") );
				member.setEmail( rs.getString("email") );
				
				listMember.add(member);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			
			try {
				if ( pstmt != null && !pstmt.isClosed() )
					pstmt.close();
				
				if ( rs != null && !rs.isClosed() )
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listMember;
	}
	
	public void InsertMember(Member member) {
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO `member` VALUES(?, ?, ?, ?)";
		
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if ( pstmt != null && !pstmt.isClosed() )
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void UpdateMemberByID(Member member) {
		PreparedStatement pstmt = null;
		String sql = "UPDATE `member` SET `pw` = ?, `name` = ?, email = ? WHERE `id` LIKE ?";
				
		try {
			pstmt = connection.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		finally {
			try {
				if ( pstmt != null && !pstmt.isClosed() )
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
