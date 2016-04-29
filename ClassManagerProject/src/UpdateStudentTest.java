import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateStudentTest {

	public static void main(String[] args) {
		Connection conn;
		// Statement stmt;
		PreparedStatement pstmt;
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 학생 번호를 입력하세요");
		int sid = scan.nextInt();
		System.out.println("새로운 학생 이름을 입력하세요");
		String name = scan.next();
		System.out.println("새로운 학생 성적을 입력하세요");
		int grade = scan.nextInt();
		try {
			// 연결할 DBMS의 주소(디비명까지)
			String url = "jdbc:mysql://localhost:3306/khw";
			// 접속할 mysql id와 비밀번호
			String id = "root";
			String pw = "mysql";
			Class.forName("com.mysql.jdbc.Driver");

			conn = DriverManager.getConnection(url, id, pw);

			/*
			 stmt = conn.createStatement(); 
			 String sql = "update student set name = " + name + ", grade = " + grade 
			 + "where id = " + sid; 
			 stmt.executeUpdate(sql);
			 */
			pstmt = conn.prepareStatement("update student set name = ?, grade = ? where id = ?");
			pstmt.setString(1, name);
			pstmt.setInt(2, grade);
			pstmt.setInt(3, sid);
			pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
