package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Friend implements AbstractModel<Friend>,Serializable{
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
	public Friend toModel(JSONObject json) {
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
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return FID;
	}
	@Override
	public Friend setID(String id) {
		// TODO Auto-generated method stub
		Friend newInstance = new Friend();
		newInstance.setMID(id);
		return newInstance;
	}
}
