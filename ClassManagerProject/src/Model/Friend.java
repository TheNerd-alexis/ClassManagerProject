package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Friend implements AbstractModel,Serializable{
	private String MID;
	private String FID;
	public String getMID() {
		return MID;
	}
	public void setMID(String mID) {
		MID = mID;
	}
	public String getFID() {
		return FID;
	}
	public void setFID(String fID) {
		FID = fID;
	}

	@Override
	public AbstractModel toModel(JSONObject json) {
		Friend friend = new Friend();
		friend.setMID((String)json.get("MID"));
		friend.setFID((String)json.get("FID"));
		
		return friend;
	}
	
	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("MID", this.getMID());
		json.put("FID", this.getFID());
		
		return json;
	}
}
