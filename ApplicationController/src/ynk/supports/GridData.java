package ynk.supports;

import java.util.ArrayList;
import java.util.List;

public class GridData
{     
    protected GridSummary summary = new GridSummary();
    
    public GridData()
    {
    }
    
    public void setSummary(GridSummary summary)
    {
        this.summary = summary;
    }

    public GridSummary getSummary()
    {
        return summary;
    }	
	
}