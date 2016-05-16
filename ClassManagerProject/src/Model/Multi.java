package Model;

import java.io.Serializable;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Multi implements AbstractModel,Serializable{
	private Integer DAY;
	private Character FCOURSE;
	private Character FTYPE;
	private String FMENU;
	
	public Integer getDAY() {
		return DAY;
	}
	public void setDAY(Integer dAY) {
		DAY = dAY;
	}
	public String getFCOURSE() {
		return String.valueOf(FCOURSE);
	}
	public void setFCOURSE(String fCOURSE) {
		FCOURSE = fCOURSE.charAt(0);
	}
	public String getFTYPE() {
		return String.valueOf(FTYPE);
	}
	public void setFTYPE(String fTYPE) {
		FTYPE = fTYPE.charAt(0);
	}
	public String getFMENU() {
		return FMENU;
	}
	public void setFMENU(String fMENU) {
		FMENU = fMENU;
	}
	@Override
	public AbstractModel toModel(JSONObject json) {
		Multi multi = new Multi();
		multi.setDAY((Integer)json.get("DAY"));
		multi.setFCOURSE((String)json.get("FCOURSE"));
		multi.setFTYPE((String)json.get("FTYPE"));
		multi.setFMENU((String)json.get("FMENU"));
		
		return multi;
	}
	@Override
	public JSONObject toJson() {
		JSONObject json = new JSONObject();
		json.put("DAY", this.getDAY());
		json.put("FCOURSE", this.getFCOURSE());
		json.put("FTYPE", this.getFTYPE());
		json.put("FMENU", this.getFMENU());
		
		return json;
	}
	
}