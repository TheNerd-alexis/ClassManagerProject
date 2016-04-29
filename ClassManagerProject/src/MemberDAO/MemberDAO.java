package MemberDAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Join.JoinDao;

public class MemberDAO {
	private Connection connection;

	private static String SQLID;
	private static String PASSWORD;
	private static String URL;
	private static JoinDao instance;
	private static String DBname = "member";

	public MemberDAO getInstance(Connection connection) {
		return new MemberDAO(connection);
	}

	private MemberDAO(Connection connection) {
		this.connection = connection;
	}

	public int insertMember(String MID, String PW, String MNAME, String MCL) {
		String sql = "INSERT INTO " + DBname + " (MID, PW, SALT, MNAME, MCL, FRIENDdb, EVNTdb) VALUES(?,?,?,?,?,?,?)";
		PreparedStatement statement = null;
		String[] pw = password(PW);
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, MID);
			statement.setString(2, pw[0]);
			statement.setString(3, pw[1]);
			statement.setString(4, MNAME);
			statement.setString(5, MCL);
			statement.setString(6, "friend_"+MID);
			statement.setString(7, "event_"+MID);
			statement.executeUpdate();
			/**insertMember Succeed*/
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			/**insertMember Failed*/
			return 0;
		}
	}

	
	/**
	 * 
	 * @param MID
	 * @param PW
	 * @param SALT
	 * @return 1 = succed, 
	 */
	public int deleteMember(String MID, String PW, String SALT){
		
		String pw = selectPwByID(MID);
		if(password(PW,SALT).equals(pw)){
			String sql = "DELETE FROM " + DBname + " WHERE MID = ? AND PW = ?";
			PreparedStatement statement = null;
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, MID);
				statement.setString(2, PW);
				ResultSet temp = statement.executeQuery();
				if(temp.next()) pw = temp.getString("PW");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			/**deleteMember*/
			return 2;
		}
			
	}
	
	public String selectPwByID(String MID){
		String sql = "SELECT PW FROM " + DBname + " WHERE MID = ?";
		String pw = null;
		PreparedStatement statement = null;
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, MID);
			ResultSet temp = statement.executeQuery();
			if(temp.next()) pw = temp.getString("PW");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pw;
	}
	
	public static String[] password(String str) {
		String salt = null;
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			salt = byteArrayToHex(SecureRandom.getInstanceStrong().generateSeed(16));
			str = salt + str;
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}
		String[] result = { SHA, salt };

		return result;
	}

	public static String password(String str, String salt) {
		;
		String SHA = "";
		try {
			MessageDigest sh = MessageDigest.getInstance("SHA-256");
			str = salt + str;
			sh.update(str.getBytes());
			byte byteData[] = sh.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
			}
			SHA = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			SHA = null;
		}

		return SHA;
	}

	public static byte[] hexToByteArray(String hex) {
		if (hex == null || hex.length() == 0) {
			return null;
		}

		byte[] ba = new byte[hex.length() / 2];
		for (int i = 0; i < ba.length; i++) {
			ba[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
		}
		return ba;
	}

	public static String byteArrayToHex(byte[] ba) {
		if (ba == null || ba.length == 0) {
			return null;
		}

		StringBuffer sb = new StringBuffer(ba.length * 2);
		String hexNumber;
		for (int x = 0; x < ba.length; x++) {
			hexNumber = "0" + Integer.toHexString(0xff & ba[x]);

			sb.append(hexNumber.substring(hexNumber.length() - 2));
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		String[] pass = password("name");
		System.out.println(pass[0] + "  " + pass[1]);
		String pass1 = password("name", pass[1]);
		System.out.println(pass1);
	}
}

class Member {
	private String MID;
	private String PW;
	private String MNAME;
	private String MCL;
	private int DCH;
	private String FRIENDdb;
	private String EVNTdb;

	String getMID() {
		return MID;
	}

	void setMID(String mID) {
		MID = mID;
		FRIENDdb = "friend_" + mID;
		EVNTdb = "event_" + mID;
	}

	String getPW() {
		return PW;
	}

	void setPW(String pW) {
		PW = pW;
	}

	String getMNAME() {
		return MNAME;
	}

	void setMNAME(String mNAME) {
		MNAME = mNAME;
	}

	String getMCL() {
		return MCL;
	}

	void setMCL(String mCL) {
		MCL = mCL;
	}

	int getDCH() {
		return DCH;
	}

	void setDCH(int dCH) {
		DCH = dCH;
	}

	String getFREINDdb() {
		return "friend_" + MID;
	}

	String getEVNTdb() {
		return "event_" + MID;
	}
}