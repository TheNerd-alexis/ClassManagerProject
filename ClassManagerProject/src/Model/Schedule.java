package Model;

import java.sql.Date;

public class Schedule {
	private String schTitle;
	private String sch;
	private Date schDate;
	private String schID;

	public String getSchTitle() {
		return schTitle;
	}

	public void setSchTitle(String schTitle) {
		this.schTitle = schTitle;
	}

	public String getSchID() {
		return schID;
	}

	public void setSchID(String schID) {
		this.schID = schID;
	}

	public String getSch() {
		return sch;
	}

	public void setSch(String sch) {
		this.sch = sch;
	}

	public Date getSchDate() {
		return schDate;
	}

	public void setSchDate(Date schDate) {
		this.schDate = schDate;
	}

	public String getschID() {
		return schID;
	}

	public void setschID(String schID) {
		this.schID = schID;
	}
}
