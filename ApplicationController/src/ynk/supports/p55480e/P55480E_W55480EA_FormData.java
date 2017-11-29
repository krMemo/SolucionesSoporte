package ynk.supports.p55480e;

import ynk.supports.Field;
import ynk.supports.FormFieldMobile;
import ynk.supports.ListField;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P55480E_W55480EA_FormData {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
}
