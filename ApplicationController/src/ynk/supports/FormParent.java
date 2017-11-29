package ynk.supports;

public class FormParent {
    
    private String currentApp;
    private String timeStamp;
   
    
    public FormParent() {
        super();
    }

    public void setCurrentApp(String currentApp)
    {
        this.currentApp = currentApp;
    }
    public String getCurrentApp()
    {
        return currentApp;
    }
    public void setTimeStamp(String timeStamp)
    {
        this.timeStamp = timeStamp;
    }
    public String getTimeStamp()
    {
        return timeStamp;
    }

}

