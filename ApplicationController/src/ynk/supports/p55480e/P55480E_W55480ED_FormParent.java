package ynk.supports.p55480e;

import ynk.supports.FormParent;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class P55480E_W55480ED_FormParent extends FormParent {

    private P55480E_W55480ED fs_P55480E_W55480ED = new P55480E_W55480ED();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P55480E_W55480ED_FormParent() {
        super();
    }

    public void setFs_P55480E_W55480ED(P55480E_W55480ED fs_P55480E_W55480ED) {
        P55480E_W55480ED oldfs_P55480E_W55480ED = this.fs_P55480E_W55480ED;
        this.fs_P55480E_W55480ED = fs_P55480E_W55480ED;
        propertyChangeSupport.firePropertyChange("fs_P55480E_W55480ED", oldfs_P55480E_W55480ED,fs_P55480E_W55480ED);
    }

    public P55480E_W55480ED getFs_P55480E_W55480ED() {
        return fs_P55480E_W55480ED;
    }
}
