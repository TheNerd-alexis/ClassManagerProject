package Model;

import java.io.Serializable;
import java.sql.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Schedule implements AbstractModel<Schedule>, Serializable{
	private String schTitle;
	private String sch;
	private Date schDate;
	private String schID;
		
	public String getSchTitle() {
		return schTitle;
	}

	public String getSch() {
		return sch;
	}

	public Date getSchDate() {
		return schDate;
	}

	public String getSchID() {
		return schID;
	}
	public void setSchTitle(String schTitle) {
		this.schTitle = schTitle;
	}
	public void setSch(String sch) {
		this.sch = sch;
	}
	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}
	public void setSchID(String schID) {
		this.schID = schID;
	}
	
	@Override
	public Schedule toModel(JSONObject json){
		Schedule schedule = new Schedule();
		schedule.setSchTitle((String)json.get("SchTitle"));
		schedule.setSch((String)json.get("Sch"));
		schedule.setSchDate((Date)json.get("SchDate"));
		schedule.setSchID((String)json.get("SchId"));
		
		return schedule;
	}
	
	@Override
	public JSONObject toJson(){
		JSONObject json = new JSONObject();
		json.put("SchTitle", this.getSchTitle());
		json.put("Sch", this.getSch());
		json.put("SchDate", this.getSchDate());
		json.put("SchId", this.getSchID());
		
		return json;
	}
}
