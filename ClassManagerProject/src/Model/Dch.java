package Model;

import java.sql.Date;

/**
 * Daily Check class <br>
 * [String MID, Date ATTENDDATE, Boolean ATTENDANCE]
 */
public class Dch {
	private String MID;
	private Date ATTENDDATE;
	private Integer ATTENDANCE;

	public String getMID() {
		return MID;
	}

	public void setMID(String mID) {
		MID = mID;
	}

	public Date getATTENDDATE() {
		return ATTENDDATE;
	}

	public void setATTENDDATE(Date aTTENDDATE) {
		ATTENDDATE = aTTENDDATE;
	}

	public Integer getATTENDANCE() {
		return ATTENDANCE;
	}

	public void setATTENDANCE(Integer aTTENDANCE) {
		ATTENDANCE = aTTENDANCE;
	}
}