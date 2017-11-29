package ynk.supports.p594820i;

import ynk.supports.Field;
import ynk.supports.FormFieldMobile;
import ynk.supports.ListField;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

public class P594820I_W594820IA_FormData {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    private FormFieldMobile lblNumerodeUsuario_696 = new FormFieldMobile();
    private FormFieldMobile txtServiceAddress2_695 = new FormFieldMobile();
    private P594820I_W594820IA_GridData gridData = new P594820I_W594820IA_GridData();

    public void setLblNumerodeUsuario_696(FormFieldMobile lblNumerodeUsuario_696) {
        FormFieldMobile oldlblNumerodeUsuario_696 = this.lblNumerodeUsuario_696;
        this.lblNumerodeUsuario_696 = lblNumerodeUsuario_696;
        propertyChangeSupport.firePropertyChange("lblNumerodeUsuario_696", oldlblNumerodeUsuario_696,lblNumerodeUsuario_696);
    }

    public FormFieldMobile getLblNumerodeUsuario_696() {
        return lblNumerodeUsuario_696;
    }

    public void setTxtServiceAddress2_695(FormFieldMobile txtServiceAddress2_695) {
        FormFieldMobile oldtxtServiceAddress2_695 = this.txtServiceAddress2_695;
        this.txtServiceAddress2_695 = txtServiceAddress2_695;
        propertyChangeSupport.firePropertyChange("txtServiceAddress2_695", oldtxtServiceAddress2_695,txtServiceAddress2_695);
    }

    public FormFieldMobile getTxtServiceAddress2_695() {
        return txtServiceAddress2_695;
    }

    public void setGridData(P594820I_W594820IA_GridData gridData) {
        P594820I_W594820IA_GridData oldgridData = this.gridData;
        this.gridData = gridData;
        propertyChangeSupport.firePropertyChange("gridData", oldgridData,gridData);
    }

    public P594820I_W594820IA_GridData getGridData() {
        return gridData;
    }
}
