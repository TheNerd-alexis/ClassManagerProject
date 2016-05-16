package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Event implements AbstractModel,Serializable {
	private String mid;
	private Integer etype;
	private String etitle;

	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public Integer getEtype() {
		return etype;
	}
	public void setEtype(Integer etype) {
		this.etype = etype;
	}
	public String getEtitle() {
		return etitle;
	}
	public void setEtitle(String etitle) {
		this.etitle = etitle;
	}

	@Override
	public AbstractModel toModel(JSONObject json) {
		Event event = new Event();
		event.setMid((String) json.get("MID"));
		event.setEtype((Integer) json.get("ETYPE"));
		event.setEtitle((String) json.get("ETITLE"));
		return event;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("MID", this.getMid());
		json.put("ETYPE", this.getEtype());
		json.put("ETITLE", this.getEtitle());
		
		return json;
	}
}