package ynk.supports.p5848app;

import ynk.supports.FormMobile;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class P5848APP_W5848APPA extends FormMobile {

    private P5848APP_W5848APPA_FormData data = new P5848APP_W5848APPA_FormData();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P5848APP_W5848APPA() {
        super();
    }

    public void setData(P5848APP_W5848APPA_FormData data) {
        P5848APP_W5848APPA_FormData olddata = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange("data", olddata,data);
    }

    public P5848APP_W5848APPA_FormData getData() {
        return data;
    }
}
