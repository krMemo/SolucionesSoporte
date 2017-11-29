package ynk.supports.p55480e;

import ynk.supports.Field;
import ynk.supports.FormFieldMobile;
import ynk.supports.ListField;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P55480E_W55480EB_FormData {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    private FormFieldMobile txtOrderNumber_28 = new FormFieldMobile();
    private FormFieldMobile lblOrderNumber_29 = new FormFieldMobile();
    private P55480E_W55480EB_GridData gridData = new P55480E_W55480EB_GridData();

    public void setTxtOrderNumber_28(FormFieldMobile txtOrderNumber_28) {
        FormFieldMobile oldtxtOrderNumber_28 = this.txtOrderNumber_28;
        this.txtOrderNumber_28 = txtOrderNumber_28;
        propertyChangeSupport.firePropertyChange("txtOrderNumber_28", oldtxtOrderNumber_28,txtOrderNumber_28);
    }

    public FormFieldMobile getTxtOrderNumber_28() {
        return txtOrderNumber_28;
    }

    public void setLblOrderNumber_29(FormFieldMobile lblOrderNumber_29) {
        FormFieldMobile oldlblOrderNumber_29 = this.lblOrderNumber_29;
        this.lblOrderNumber_29 = lblOrderNumber_29;
        propertyChangeSupport.firePropertyChange("lblOrderNumber_29", oldlblOrderNumber_29,lblOrderNumber_29);
    }

    public FormFieldMobile getLblOrderNumber_29() {
        return lblOrderNumber_29;
    }

    public void setGridData(P55480E_W55480EB_GridData gridData) {
        P55480E_W55480EB_GridData oldgridData = this.gridData;
        this.gridData = gridData;
        propertyChangeSupport.firePropertyChange("gridData", oldgridData,gridData);
    }

    public P55480E_W55480EB_GridData getGridData() {
        return gridData;
    }
}
