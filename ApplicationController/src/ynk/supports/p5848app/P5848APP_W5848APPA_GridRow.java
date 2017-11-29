package ynk.supports.p5848app;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import ynk.supports.Field;
import ynk.supports.GridRowMobile;

import java.util.Date;

public class P5848APP_W5848APPA_GridRow extends GridRowMobile {

    Field mnAliasNumber_20 = new Field();
    Field sAliasNameExtended_37 = new Field();
    Field mnPadreNumber_19 = new Field();
    Field sPadreNameExtended_36 = new Field();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P5848APP_W5848APPA_GridRow() {
        super();
    }

    public void setMnAliasNumber_20(Field mnAliasNumber_20) {
        Field oldmnAliasNumber_20 = this.mnAliasNumber_20;
        this.mnAliasNumber_20 = mnAliasNumber_20;
        propertyChangeSupport.firePropertyChange("mnAliasNumber_20", oldmnAliasNumber_20,mnAliasNumber_20);
    }

    public Field getMnAliasNumber_20() {
        return mnAliasNumber_20;
    }

    public void setSAliasNameExtended_37(Field sAliasNameExtended_37) {
        Field oldsAliasNameExtended_37 = this.sAliasNameExtended_37;
        this.sAliasNameExtended_37 = sAliasNameExtended_37;
        propertyChangeSupport.firePropertyChange("sAliasNameExtended_37", oldsAliasNameExtended_37,sAliasNameExtended_37);
    }

    public Field getSAliasNameExtended_37() {
        return sAliasNameExtended_37;
    }

    public void setMnPadreNumber_19(Field mnPadreNumber_19) {
        Field oldmnPadreNumber_19 = this.mnPadreNumber_19;
        this.mnPadreNumber_19 = mnPadreNumber_19;
        propertyChangeSupport.firePropertyChange("mnPadreNumber_19", oldmnPadreNumber_19,mnPadreNumber_19);
    }

    public Field getMnPadreNumber_19() {
        return mnPadreNumber_19;
    }

    public void setSPadreNameExtended_36(Field sPadreNameExtended_36) {
        Field oldsPadreNameExtended_36 = this.sPadreNameExtended_36;
        this.sPadreNameExtended_36 = sPadreNameExtended_36;
        propertyChangeSupport.firePropertyChange("sPadreNameExtended_36", oldsPadreNameExtended_36,sPadreNameExtended_36);
    }

    public Field getSPadreNameExtended_36() {
        return sPadreNameExtended_36;
    }
}
