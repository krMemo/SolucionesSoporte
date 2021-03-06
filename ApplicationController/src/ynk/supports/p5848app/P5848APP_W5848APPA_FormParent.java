package ynk.supports.p5848app;

import ynk.supports.FormParent;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class P5848APP_W5848APPA_FormParent extends FormParent {

    private P5848APP_W5848APPA fs_P5848APP_W5848APPA = new P5848APP_W5848APPA();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P5848APP_W5848APPA_FormParent() {
        super();
    }

    public void setFs_P5848APP_W5848APPA(P5848APP_W5848APPA fs_P5848APP_W5848APPA) {
        P5848APP_W5848APPA oldfs_P5848APP_W5848APPA = this.fs_P5848APP_W5848APPA;
        this.fs_P5848APP_W5848APPA = fs_P5848APP_W5848APPA;
        propertyChangeSupport.firePropertyChange("fs_P5848APP_W5848APPA", oldfs_P5848APP_W5848APPA,fs_P5848APP_W5848APPA);
    }

    public P5848APP_W5848APPA getFs_P5848APP_W5848APPA() {
        return fs_P5848APP_W5848APPA;
    }

    public int getRowIndexForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getRowIndex();
    }

    public boolean getMOExistForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getMOExist();
    }

    public String getMnAliasNumber_20ForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getMnAliasNumber_20().getValue();
    }

    public String getSAliasNameExtended_37ForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getSAliasNameExtended_37().getValue();
    }

    public String getMnPadreNumber_19ForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getMnPadreNumber_19().getValue();
    }

    public String getSPadreNameExtended_36ForRow(int rowNum) {
        return getFs_P5848APP_W5848APPA().getData().getGridData().getRowset()[rowNum].getSPadreNameExtended_36().getValue();
    }
}
