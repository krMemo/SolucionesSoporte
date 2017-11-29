package ynk.supports.p55480e;

import ynk.supports.FormParent;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class P55480E_W55480EA_FormParent extends FormParent {

    private P55480E_W55480EA fs_P55480E_W55480EA = new P55480E_W55480EA();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P55480E_W55480EA_FormParent() {
        super();
    }

    public void setFs_P55480E_W55480EA(P55480E_W55480EA fs_P55480E_W55480EA) {
        P55480E_W55480EA oldfs_P55480E_W55480EA = this.fs_P55480E_W55480EA;
        this.fs_P55480E_W55480EA = fs_P55480E_W55480EA;
        propertyChangeSupport.firePropertyChange("fs_P55480E_W55480EA", oldfs_P55480E_W55480EA,fs_P55480E_W55480EA);
    }

    public P55480E_W55480EA getFs_P55480E_W55480EA() {
        return fs_P55480E_W55480EA;
    }
}
