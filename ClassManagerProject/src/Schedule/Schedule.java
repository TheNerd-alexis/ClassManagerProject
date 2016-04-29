package Schedule;

import java.sql.Date;

public class Schedule {

	private String sch;
	private Date schDate;
	private int schType;

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
	public int getSchType() {
		return schType;
	}
	public void setSchType(int schType) {
		this.schType = schType;
	}
	@Override
	public String toString() {
		return "Calendar [sch=" + sch + ", schDate=" + schDate + ", schType=" + schType + "]";
	}
}
