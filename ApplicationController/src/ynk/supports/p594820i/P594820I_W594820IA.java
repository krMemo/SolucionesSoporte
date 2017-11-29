package ynk.supports.p594820i;

import ynk.supports.FormMobile;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class P594820I_W594820IA extends FormMobile {

    private P594820I_W594820IA_FormData data = new P594820I_W594820IA_FormData();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P594820I_W594820IA() {
        super();
    }

    public void setData(P594820I_W594820IA_FormData data) {
        P594820I_W594820IA_FormData olddata = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange("data", olddata,data);
    }

    public P594820I_W594820IA_FormData getData() {
        return data;
    }
}
