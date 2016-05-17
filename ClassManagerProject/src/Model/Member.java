package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Member implements AbstractModel<Member>,Serializable{
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
	public String getPW() {
		return PW;
	}
	public String getSALT() {
		return SALT;
	}
	public String getMNAME() {
		return MNAME;
	}
	public Integer getMCL() {
		return MCL;
	}
	public Integer getPWQ() {
		return PWQ;
	}
	public String getPWA() {
		return PWA;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public void setPW(String pW) {
		PW = pW;
	}
	public void setSALT(String sALT) {
		SALT = sALT;
	}
	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}
	public void setMCL(Integer mCL) {
		MCL = mCL;
	}
	public void setPWQ(Integer pWQ) {
		PWQ = pWQ;
	}
	public void setPWA(String pWA) {
		PWA = pWA;
	}

	@Override
	public Member toModel(JSONObject json) {
		Member member = new Member();
		member.setMID((String) json.get("MID"));
		member.setPW((String) json.get("PW"));
		member.setSALT((String) json.get("SALT"));
		member.setMNAME((String) json.get("MNAME"));
		member.setMCL((Integer) json.get("MCL"));
		member.setPWQ((Integer) json.get("PWQ"));
		member.setPWA((String) json.get("PWA"));

		return member;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("MID", this.getMID());
		json.put("PW", this.getPW());
		json.put("SALT", this.getSALT());
		json.put("MNAME", this.getMNAME());
		json.put("MCL", this.getMCL());
		json.put("PWQ", this.getPWQ());
		json.put("PWA", this.getPWA());

		return json;
	}
}
