package Model;

public class Multi {
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
}