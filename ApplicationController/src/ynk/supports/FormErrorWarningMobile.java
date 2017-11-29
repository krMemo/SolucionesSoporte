package ynk.supports;

public class FormErrorWarningMobile {
    String CODE;
    String TITLE;
    String DESC;
    String MOBILE;
    String ERRORCONTROL;
    public FormErrorWarningMobile() {
        super();
    }

    public void setDESC(String DESC) {
        this.DESC = DESC;
    }

    public String getDESC() {
        return DESC;
    }

    public void setCODE(String CODE) {
        this.CODE = CODE;
    }

    public String getCODE() {
        return CODE;
    }

    public void setTITLE(String TITLE) {
        this.TITLE = TITLE;
    }

    public String getTITLE() {
        return TITLE;
    }

    public void setMOBILE(String MOBILE) {
        this.MOBILE = MOBILE;
    }

    public String getMOBILE() {
        return MOBILE;
    }
    
    public void setERRORCONTROL(String ERRORCONTROL) {
		this.ERRORCONTROL = ERRORCONTROL;
	}
	
	public String getERRORCONTROL() {
		return ERRORCONTROL;
	}
}
