package Fmenu;
import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FmenuDao {
	
	private Connection conn;
	
	private static final String URL = "jdbc:mysql://localhost:3306/namkungk";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "skarnd11";
	private static FmenuDao instance;
	
	public static FmenuDao getInstance(){
		if(instance == null)
			instance = new FmenuDao();
		return instance;
		
	}
	
	private FmenuDao(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
	}catch(SQLException|ClassNotFoundException e){
		e.printStackTrace();}
	}
	
	public void insertFmenu(Fmenu menu){
		
		String sql = "insert into Fmenu values (?)";
		PreparedStatement psm = null;
		
		try {
			psm =conn.prepareStatement(sql);
			psm.setString(1, menu.getFtitle());
			
			psm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateFmenu(Fmenu menu){
		
		String sql = "update fmenu set menu = ?;";
		PreparedStatement psm = null;
		
		try {
			psm = conn.prepareStatement(sql);
			psm.setString(1, menu.getFtitle());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}}		
		
	public void deleteFmenu(Fmenu menu){
		
		String sql = "delete from fmenu where ftitle ?";
		PreparedStatement psm = null;
		
		try{
		
		psm = conn.prepareStatement(sql);
		
		psm.setString(1,menu.getFtitle());
		
		psm.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally {
			try {
				if (psm != null && !psm.isClosed())
					psm.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
		
		public void selectOne(Fmenu menu){
			
			String sql = "select * from fmenu where ftitle = ? ";
			PreparedStatement psm = null;
			
			try{
			psm = conn.prepareStatement(sql);
			psm.setString(1, menu.getFtitle());
			
			psm.executeQuery();
			}catch(SQLException e){
				e.printStackTrace();
			}finally {
				try {
					if (psm != null && !psm.isClosed())
						psm.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	
		public List<Fmenu> selectAll(){
			String sql = "select * from fmenu";
			PreparedStatement psm = null;
			ResultSet rs = null;
			List<Fmenu> fmenuList= new ArrayList();
			
			Fmenu menu = new Fmenu();
			try {
				menu.setFtitle(rs.getString("ftable"));
				
				fmenuList.add(menu);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return fmenuList;
			
			
		}
}
