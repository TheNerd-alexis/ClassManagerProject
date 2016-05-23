package Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.GetDAO;
import DAO.MemberDAO;
import Model.AbstractModel;
import Model.CMResult;
import Model.Member;

public class MemberService {
	static GetDAO dao = GetDAO.getInstance();
	
	/**
	 * 로그인
	 * 
	 * @param member
	 * @return 1 = 로그인 성공<br>
	 *         -2 = id 없음<br>
	 *         -3 = pw 없음<br>
	 *         -4 = 해당 회원 없음<br>
	 *         -5 = id와 pw 일치하지 않음<br>
	 */
	// 로그인
	public static CMResult member_login(AbstractModel model) {
		Member member = (Member) model;
		CMResult result = new CMResult();

		if (member.getMID() == null)
			return result.setResult(-2); // id 없음
		if (member.getPW() == null)
			return result.setResult(-3); // pw 없음

		Member temp = new Member();
		temp.setMID(member.getMID());
		List<Member> list = dao.getMemberDao().selectMember(temp);

		// DB에 일치하는 회원 없음
		if (list.size() < 1)
			return result.setResult(-4);

		temp = list.get(0);
		// 아이디에 저장된 비밀번호와 입력한 비밀번호가 일치하지 않음
		if (!temp.getPW().equals(password(member.getPW(), temp.getSALT())))
			return result.setResult(-5);

		result.setResult(1);
		return result;
	}

	/**
	 * 회원가입
	 * 
	 * @param member(MID,
	 *            PW, SALT, MNAME, MCL, PWQ, PWA)
	 * @return 1 = 회원 정보 추가 성공<br>
	 *         -1 = 회원 정보 추가 실패<br>
	 *         -2 = id 없음<br>
	 *         -3 = pw 없음<br>
	 *         -4 = salt 없음<br>
	 *         -5 = 이름 없음<br>
	 *         -6 = 과정 선택 없음<br>
	 *         -7 = 비밀번호 찾기 질문 선택 안함<br>
	 *         -8 = 비밀번호 찾기 답변 선택 안함
	 */
	// 회원가입
	public static CMResult member_join(AbstractModel model) {
		Member member = (Member) model;
		CMResult result = new CMResult();

		if (member.getMID() == null)
			return result.setResult(-2); // id 없음
		if (member.getPW() == null)
			return result.setResult(-3); // pw 없음
		// if (member.getSALT() == null)
		// return result.setResult(-4); // salt 없음
		// if (member.getMNAME() == null)
		// result.setResult(-5); // 이름 없음
		if (member.getMCL() == null)
			return result.setResult(-6); // 과정 선택 안함
		if (member.getPWQ() == null)
			return result.setResult(-7); // 비밀번호 찾기 질문 선택 안함
		if (member.getPWA() == null)
			return result.setResult(-8); // 비밀번호 찾기 답변 선택 안함

		String[] pw = password(member.getPW());
		member.setPW(pw[0]);
		member.setSALT(pw[1]);

		result.setResult(dao.getMemberDao().insertMember(member));
		return result;
	}

	// 아이디 중복 체크
	public static CMResult member_idcheck(AbstractModel model) {
		Member member = (Member) model;
		CMResult result = new CMResult();
		if (member.getMID() == null)
			return result.setResult(-2); // 아이디 정보 없음

		List<Member> tempList = dao.getMemberDao().selectMember(member);
		if (tempList.size() < 1) {
			return result.setResult(1); // 중복 아이디 없음
		} else {
			return result.setResult(2); // 중복 아이디 있음
		}
	}

	public static CMResult member_pwcheck(AbstractModel model) {
		Member member = (Member) model;
		CMResult result = new CMResult();

		// 데이터 베이스에 접속해 ID 존재여부를 체크하고
		if (member_idcheck(member).getResult() == 1)
			return result.setResult(-2); // 해당 아이디 없음

		Member orgMem = dao.getMemberDao().selectMember(member.setID(member.getMID())).get(0);
		
		// 유저가 선택한 pwq가 설정한 pwq가 동일한지 확인
		if (!member.getPWQ().equals(orgMem.getPWQ()))
			return result.setResult(-3); // 질문 일치하지 않음

		// 유저가 입력한 pwa가 설정한 pwq와 동일한지 확인
		if (!member.getPWA().equals(orgMem.getPWA()))
			return result.setResult(-4); // 답변 일치하지 않음
		
		return result.setResult(1);
	}

	public static CMResult member_pwchange(AbstractModel model) {
		Member member = (Member) model;
		CMResult result = new CMResult();
		if (member.getMID() == null)
			return result.setResult(-2);
		if (member.getPW() == null)
			return result.setResult(-3);

		Member orgMember = new Member();
		orgMember.setMID(member.getMID());

		String[] pw = password(member.getPW());
		member.setPW(pw[0]);
		member.setSALT(pw[1]);

		orgMember = dao.getMemberDao().selectMember(orgMember).get(0);
		result.setResult(dao.getMemberDao().updateMember(member, orgMember));

		return result;
	}

	// 멤버리스트 뽑아오는 애
	public static CMResult member_show(AbstractModel model) {
		Member member = (Member) model;
		if (member.getMID() != null)
			member.setMID("%" + member.getMID() + "%");
		List<Member> list = dao.getMemberDao().selectMember(member);

		CMResult result = new CMResult();
		
		List<AbstractModel> resultList = new ArrayList<AbstractModel>();
		for (Member m : list) {
			resultList.add(m);
		}
		result.setResult(1);
		result.setResultList(resultList);

		return result;
	}

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
