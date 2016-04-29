import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//java코드로 khw디비에 접속해서
//student 테이블을 만들어보자.
//create table student(
//id int,
//name varchar(20),
//grade int
//);

//class 로딩
//DBMS의 특정 DB와 연결을 갖는 Connection 객체 획득
//내가 날릴 쿼리문을 품은 Statement 객체 생성
//Connection 객체에 Statement 구문 객체를 전달

public class CreateTableTest {
	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt = null;
		// 연결할 DBMS의 주소(디비명까지)
		String url = "jdbc:mysql://localhost:3306/khw";
		// 접속할 mysql id와 비밀번호
		String id = "root";
		String pw = "mysql";

		try {
			Class.forName("com.mysql.jdbc.Driver");// 클래스를 적재해 달라고 요구(자동으로 되기도
													// 하고 이렇게 직접 해줘야 하기도 하고 케바케)
			conn = DriverManager.getConnection(url, id, pw);
			stmt = conn.createStatement();// DB와 연결된 conn객체로부터 구문객체를 획득
			StringBuilder sb = new StringBuilder();
			String sql = sb.append("create table if not exists student(")
			.append("id int,")
			.append("name varchar(20),")
			.append("grade int")
			.append(");").toString();
			
			stmt.execute(sql);
			// 구문객체를 던지는 방법은 3가지
			// 1.execute -> 테이블 생성 등 데이터베이스 관리 명령어 사용
			// 2.executeUpdate -> 레코드 삽입 수정 삭제 등 데이터 조작 명령어 사용
			// 3.executeQuery -> 레코드 조회, 테이블 조회 등 조회 명령어 사용
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("클래스 로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null && !conn.isClosed())
					conn.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}
}
