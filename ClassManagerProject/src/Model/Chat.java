package Model;

import java.io.Serializable;
import java.sql.Date;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Chat implements AbstractModel<Chat>,Serializable{
	private String RTITLE;
	private String JID;
	private Date COME;
	
	public String getJid() {
		return JID;
	}
	public String getRtitle() {
		return RTITLE;
	}
	public Date getCome() {
		return COME;
	}
	public void setRtitle(String RTITLE) {
		this.RTITLE = RTITLE;
	}
	public void setJid(String JID) {
		this.JID = JID;
	}
	public void setCome(Date COME) {
		this.COME = COME;
	}
	@Override
	public Chat toModel(JSONObject json){
		Chat chat = new Chat();
		chat.setRtitle((String) json.get("RTITLE"));
		chat.setJid((String) json.get("JID"));
		chat.setCome((Date) json.get("COME"));

		return chat;
	}
	
	@Override
	public JSONObject toJson(){
		JSONObject json = new JSONObject();
		json.put("RTITLE", this.getRtitle());
		json.put("JID", this.getJid());
		json.put("COME", this.getCome());
		
		return json;
	}
	@Override
	public String getID() {
		// TODO Auto-generated method stub
		return JID;
	}
	@Override
	public Chat setID(String id) {
		// TODO Auto-generated method stub
		Chat newInstance = new Chat();
		newInstance.setJid(id);
		return newInstance;
	}
}