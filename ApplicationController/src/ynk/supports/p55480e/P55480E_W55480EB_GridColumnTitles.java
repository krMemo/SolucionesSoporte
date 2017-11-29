package ynk.supports.p55480e;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P55480E_W55480EB_GridColumnTitles {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    private String col_19;
    private String col_20;
    private String col_21;
    private String col_22;
    private String col_23;
    private String col_24;
    private String col_26;

    public P55480E_W55480EB_GridColumnTitles() {
        super();
    }

    public void setCol_19(String col_19) {
        String oldcol_19 = this.col_19;
        this.col_19 = col_19;
        propertyChangeSupport.firePropertyChange("col_19", oldcol_19,col_19);
    }

    public String getCol_19() {
        return col_19;
    }

    public void setCol_20(String col_20) {
        String oldcol_20 = this.col_20;
        this.col_20 = col_20;
        propertyChangeSupport.firePropertyChange("col_20", oldcol_20,col_20);
    }

    public String getCol_20() {
        return col_20;
    }

    public void setCol_21(String col_21) {
        String oldcol_21 = this.col_21;
        this.col_21 = col_21;
        propertyChangeSupport.firePropertyChange("col_21", oldcol_21,col_21);
    }

    public String getCol_21() {
        return col_21;
    }

    public void setCol_22(String col_22) {
        String oldcol_22 = this.col_22;
        this.col_22 = col_22;
        propertyChangeSupport.firePropertyChange("col_22", oldcol_22,col_22);
    }

    public String getCol_22() {
        return col_22;
    }

    public void setCol_23(String col_23) {
        String oldcol_23 = this.col_23;
        this.col_23 = col_23;
        propertyChangeSupport.firePropertyChange("col_23", oldcol_23,col_23);
    }

    public String getCol_23() {
        return col_23;
    }

    public void setCol_24(String col_24) {
        String oldcol_24 = this.col_24;
        this.col_24 = col_24;
        propertyChangeSupport.firePropertyChange("col_24", oldcol_24,col_24);
    }

    public String getCol_24() {
        return col_24;
    }

    public void setCol_26(String col_26) {
        String oldcol_26 = this.col_26;
        this.col_26 = col_26;
        propertyChangeSupport.firePropertyChange("col_26", oldcol_26,col_26);
    }

    public String getCol_26() {
        return col_26;
    }
}
