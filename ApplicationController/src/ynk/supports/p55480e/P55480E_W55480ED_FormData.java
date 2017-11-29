package ynk.supports.p55480e;

import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

import ynk.supports.FormFieldMobile;

public class P55480E_W55480ED_FormData {

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    private FormFieldMobile txtAddressNumber_15 = new FormFieldMobile();
    private FormFieldMobile txtRegisterNumber_33 = new FormFieldMobile();
    private FormFieldMobile txtPercentage_17 = new FormFieldMobile();
    private FormFieldMobile txtOrderNumber_19 = new FormFieldMobile();
    private FormFieldMobile txtQuestionDescription_23 = new FormFieldMobile();

    public void setTxtOrderNumber_19(FormFieldMobile txtOrderNumber_19) {
        FormFieldMobile oldtxtOrderNumber_19 = this.txtOrderNumber_19;
        this.txtOrderNumber_19 = txtOrderNumber_19;
        propertyChangeSupport.firePropertyChange("txtOrderNumber_19", oldtxtOrderNumber_19,txtOrderNumber_19);
    }

    public FormFieldMobile getTxtOrderNumber_19() {
        return txtOrderNumber_19;
    }

    public void setTxtPercentage_17(FormFieldMobile txtPercentage_17) {
        FormFieldMobile oldtxtPercentage_17 = this.txtPercentage_17;
        this.txtPercentage_17 = txtPercentage_17;
        propertyChangeSupport.firePropertyChange("txtPercentage_17", oldtxtPercentage_17,txtPercentage_17);
    }

    public FormFieldMobile getTxtPercentage_17() {
        return txtPercentage_17;
    }

    public void setTxtAddressNumber_15(FormFieldMobile txtAddressNumber_15) {
        FormFieldMobile oldtxtAddressNumber_15 = this.txtAddressNumber_15;
        this.txtAddressNumber_15 = txtAddressNumber_15;
        propertyChangeSupport.firePropertyChange("txtAddressNumber_15", oldtxtAddressNumber_15,txtAddressNumber_15);
    }

    public FormFieldMobile getTxtAddressNumber_15() {
        return txtAddressNumber_15;
    }

    public void setTxtQuestionDescription_23(FormFieldMobile txtQuestionDescription_23) {
        FormFieldMobile oldtxtQuestionDescription_23 = this.txtQuestionDescription_23;
        this.txtQuestionDescription_23 = txtQuestionDescription_23;
        propertyChangeSupport.firePropertyChange("txtQuestionDescription_23", oldtxtQuestionDescription_23,txtQuestionDescription_23);
    }

    public FormFieldMobile getTxtQuestionDescription_23() {
        return txtQuestionDescription_23;
    }

    public void setTxtRegisterNumber_33(FormFieldMobile txtRegisterNumber_33) {
        FormFieldMobile oldtxtRegisterNumber_33 = this.txtRegisterNumber_33;
        this.txtRegisterNumber_33 = txtRegisterNumber_33;
        propertyChangeSupport.firePropertyChange("txtRegisterNumber_33", oldtxtRegisterNumber_33,txtRegisterNumber_33);
    }

    public FormFieldMobile getTxtRegisterNumber_33() {
        return txtRegisterNumber_33;
    }

}
