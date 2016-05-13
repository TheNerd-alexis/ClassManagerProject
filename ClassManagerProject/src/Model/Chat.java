package Model;

import java.sql.Date;

public class Chat {
	private String RTITLE;
	private String JID;
	private Date COME;

	public String getJid() {
		return JID;
	}
	public String getRtitle() {
		return RTITLE;
	}
	public void setRtitle(String RTITLE) {
		this.RTITLE = RTITLE;
	}
	public void setJid(String JID) {
		this.JID = JID;
	}
	public Date getCome() {
		return COME;
	}
	public void setCome(Date COME) {
		this.COME = COME;
	}
}