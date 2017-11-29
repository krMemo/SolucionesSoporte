package ynk.supports.p55480e;

import ynk.supports.FormMobile;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

public class P55480E_W55480ED extends FormMobile {

    private P55480E_W55480ED_FormData data = new P55480E_W55480ED_FormData();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P55480E_W55480ED() {
        super();
    }

    public void setData(P55480E_W55480ED_FormData data) {
        P55480E_W55480ED_FormData olddata = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange("data", olddata,data);
    }

    public P55480E_W55480ED_FormData getData() {
        return data;
    }
}
