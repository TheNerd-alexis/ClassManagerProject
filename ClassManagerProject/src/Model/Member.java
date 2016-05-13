package Model;

public class Member {
	private String MID;
	private String PW;
	private String SALT;
	private String MNAME;
	private Integer MCL;
	private Integer PWQ;
	private String PWA;
	
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getPW() {
		return PW;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public String getSALT() {
		return SALT;
	}
	public void setSALT(String sALT) {
		SALT = sALT;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}
	public Integer getMCL() {
		return MCL;
	}
	public void setMCL(Integer mCL) {
		MCL = mCL;
	}
	public Integer getPWQ() {
		return PWQ;
	}
	public void setPWQ(Integer pWQ) {
		PWQ = pWQ;
	}
	public String getPWA() {
		return PWA;
	}
	public void setPWA(String pWA) {
		PWA = pWA;
	}
}
