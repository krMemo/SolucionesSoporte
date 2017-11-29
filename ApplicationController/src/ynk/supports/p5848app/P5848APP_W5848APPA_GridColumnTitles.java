package ynk.supports.p5848app;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P5848APP_W5848APPA_GridColumnTitles {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    private String col_20;
    private String col_37;
    private String col_19;
    private String col_36;

    public P5848APP_W5848APPA_GridColumnTitles() {
        super();
    }

    public void setCol_20(String col_20) {
        String oldcol_20 = this.col_20;
        this.col_20 = col_20;
        propertyChangeSupport.firePropertyChange("col_20", oldcol_20,col_20);
    }

    public String getCol_20() {
        return col_20;
    }

    public void setCol_37(String col_37) {
        String oldcol_37 = this.col_37;
        this.col_37 = col_37;
        propertyChangeSupport.firePropertyChange("col_37", oldcol_37,col_37);
    }

    public String getCol_37() {
        return col_37;
    }

    public void setCol_19(String col_19) {
        String oldcol_19 = this.col_19;
        this.col_19 = col_19;
        propertyChangeSupport.firePropertyChange("col_19", oldcol_19,col_19);
    }

    public String getCol_19() {
        return col_19;
    }

    public void setCol_36(String col_36) {
        String oldcol_36 = this.col_36;
        this.col_36 = col_36;
        propertyChangeSupport.firePropertyChange("col_36", oldcol_36,col_36);
    }

    public String getCol_36() {
        return col_36;
    }
}
