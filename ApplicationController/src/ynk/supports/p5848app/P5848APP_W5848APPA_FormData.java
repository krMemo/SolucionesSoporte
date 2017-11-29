package ynk.supports.p5848app;

import ynk.supports.Field;
import ynk.supports.FormFieldMobile;
import ynk.supports.ListField;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P5848APP_W5848APPA_FormData {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    private P5848APP_W5848APPA_GridData gridData = new P5848APP_W5848APPA_GridData();

    public void setGridData(P5848APP_W5848APPA_GridData gridData) {
        P5848APP_W5848APPA_GridData oldgridData = this.gridData;
        this.gridData = gridData;
        propertyChangeSupport.firePropertyChange("gridData", oldgridData,gridData);
    }

    public P5848APP_W5848APPA_GridData getGridData() {
        return gridData;
    }
}
