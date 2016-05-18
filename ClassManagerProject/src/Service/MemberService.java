package Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.MemberDAO;
import Model.AbstractModel;
import Model.Member;

public class MemberService {
	private Connection connection;
	private String url = "jdbc:mysql://localhost:3306/classmanager";
	private String id = "root";
	private String pw = "mysql";
	private MemberDAO memberDAO;
	private static MemberService instance;

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	private MemberService() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, id, pw);
			memberDAO = MemberDAO.getInstance(connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 로그인
	 * 
	 * @param member
	 * @return 1 = 로그인 성공<br>
	 *         2 = 해당 회원 없음<br>
	 *         3 = id 없음<br>
	 *         4 = pw 없음<br>
	 *         5 = id와 pw 일치하지 않음<br>
	 */
	// 로그인
	public int login(AbstractModel model) {
		Member member = (Member) model;
		if (member.getMID() == null)
			return 3; // id 없음
		if (member.getPW() == null)
			return 4; // pw 없음

		Member temp = new Member();
		temp.setMID(member.getMID());
		List<Member> result = memberDAO.selectMember(temp);
		if (result.size()<1)
			return 2;

		temp = result.get(0);
		if (!temp.getPW().equals(member.getPW()))
			return 5;

		return 1;
	}

	/**
	 * 회원가입
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
	//회원가입
	public int join(AbstractModel model) {
		Member member = (Member) model;
		if (member.getMID() == null)
			return 3; // id 없음
		if (member.getPW() == null)
			return 4; // pw 없음
		if (member.getSALT() == null)
			return 5; // salt 없음
		if (member.getMNAME() == null)
			return 6; // 이름 없음
		if (member.getMCL() == null)
			return 7; // 과정 선택 안함
		if (member.getPWQ() == null)
			return 8; // 비밀번호 찾기 질문 선택 안함
		if (member.getPWA() == null)
			return 9; // 비밀번호 찾기 답변 선택 안함

		return memberDAO.insertMember(member);
	}
	
	//중복아이디 체크하는 애
	
	public boolean idcheck(){
		Member member = new Member();
		member = (Member) memberDAO.selectMember(member);
		if(member.getMID() == null){
			return true;//가입가능
		}else{
			return false;//가입불가
		}
		
	}
	
	
	//PW찾는 애
	
	public int findPW(AbstractModel model){
		
		Member member= (Member) model;
		MemberDAO dao;
		if( dao.selectMemberOne(member) == null)//데이터 베이스에 접속해 ID 존재여부를 체크하고
		{
			return -1;//아이디 존재 안하면 -1 반환
		}
		else//존재한다면
		{
			if( ?GUI.pwq? == dao.selectMemberOne(member).getPWQ()){	//유저가 선택한 pwq가 설정한 pwq가 동일한지 확인
				if( ?GUI.pwa? == dao.selectMemberOne(member).getPWA()){ //유저가 입력한 pwa가 설정한 pwq와 동일한지 확인
					return = 1; // 모두 동일하다면 1반환
				}else{
					return = -2; //pwa 동일하지 않으면 -2 반환 
				}
			
	}
}
	
	
	
	
	//멤버리스트 뽑아오는 애 
	public List<AbstractModel> show(AbstractModel model) {
		Member member = (Member) model;
		List<Member> list = memberDAO.selectMember(member);
		List<AbstractModel> result = new ArrayList<AbstractModel>();

			result.add(m);
		}
		return result;
	}

	static class SecuredPassword {
		/**
		 * 비밀번호 암호화 메소드
		 * 
		 * @param str
		 * @return [암호화된 비밀번호, salt]
		 */
		public static String[] password(String pw) {
			String salt = null;
			String SHA = "";
			try {
				MessageDigest sh = MessageDigest.getInstance("SHA-256");
				salt = byteArrayToHex(SecureRandom.getInstanceStrong().generateSeed(16));
				pw = salt + pw;
				sh.update(pw.getBytes());
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

		/**
		 * 암호화된 비밀번호 확인 메소드
		 * 
		 * @param pw
		 *            비밀먼호
		 * @param salt
		 *            암호화시 사용된 salt
		 * @return 암호화된 비밀번호
		 */
		public static String password(String pw, String salt) {
			String SHA = "";
			try {
				MessageDigest sh = MessageDigest.getInstance("SHA-256");
				pw = salt + pw;
				sh.update(pw.getBytes());
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
	}
}
