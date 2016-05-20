package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Event implements AbstractModel<Event>,Serializable {
	private String mid;
	private Integer etype;
	private String etitle;
	private Integer estatus;

	public Integer getEstatus() {
		return estatus;
	}
	public void setEstatus(Integer estatus) {
		this.estatus = estatus;
	}
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
	public Event toModel(JSONObject json) {
		Event event = new Event();
		event.setMid((String) json.get("MID"));
		event.setEtype((Integer) json.get("ETYPE"));
		event.setEtitle((String) json.get("ETITLE"));
		event.setEstatus((Integer)json.get("ESTATUS"));
		return event;
	}

	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("MID", this.getMid());
		json.put("ETYPE", this.getEtype());
		json.put("ETITLE", this.getEtitle());
		json.put("ESTATUS", this.getEstatus());
		return json;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return mid;
	}
	@Override
	public Event setID(String id) {
		// TODO Auto-generated method stub
		Event newInstance = new Event();
		newInstance.setMid(id);
		return newInstance;
	}
}