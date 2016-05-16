package Model;

import java.io.Serializable;
import java.sql.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Dch implements AbstractModel,Serializable {
	private String MID;
	private Date ATTENDDATE;
	private Integer ATTENDANCE;
	
	public String getMID() {
		return MID;
	}
	public Date getATTENDDATE() {
		return ATTENDDATE;
	}
	public Integer getATTENDANCE() {
		return ATTENDANCE;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public void setATTENDDATE(Date aTTENDDATE) {
		ATTENDDATE = aTTENDDATE;
	}
	public void setATTENDANCE(Integer aTTENDANCE) {
		ATTENDANCE = aTTENDANCE;
	}

	@Override
	public AbstractModel toModel(JSONObject json) {
		Dch dch = new Dch();
		dch.setMID((String) json.get("MID"));
		dch.setATTENDDATE((Date) json.get("ATTENDDATE"));
		dch.setATTENDANCE((Integer) json.get("ATTENDANCE"));

		return dch;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("MID", this.getMID());
		json.put("ATTENDDATE", this.getATTENDDATE());
		json.put("ATTENDANCE", this.getATTENDANCE());

		return json;
	}
}