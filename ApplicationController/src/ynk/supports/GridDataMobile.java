package ynk.supports;

import java.util.ArrayList;
import java.util.List;

import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;

public class GridDataMobile extends GridData

{
     // Field level representation of the row at this level for ADF use only, not part of JSON.
	private int rowIndex;
    private boolean MOExist;
	
	protected List rowset = new ArrayList();
    protected transient ProviderChangeSupport providerChangeSupport = new ProviderChangeSupport(this);

    public GridDataMobile()
    {
    }

    public void setRowsetWithList(List rowset)
    {
        this.rowset = rowset;
        providerChangeSupport.fireProviderRefresh("rowset");
    }
    
    public List retrieveRowsetList()
    {
        return rowset;
    }
    
    public void addProviderChangeListener(ProviderChangeListener l)
    {
        providerChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l)
    {
        providerChangeSupport.removeProviderChangeListener(l);
    }   
	
	public void setRowIndex(int rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    public int getRowIndex()
    {
        return this.rowIndex;
    }

	
	public void setMOExist(boolean MOExist)
    {
        this.MOExist = MOExist;
    }

    public boolean getMOExist()
    {
        return this.MOExist;
    }
}