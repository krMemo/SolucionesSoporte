package ynk.supports.p55480e;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import ynk.supports.Field;
import ynk.supports.GridRowMobile;

import java.util.Date;

public class P55480E_W55480EB_GridRow extends GridRowMobile {

    Field mnAddressNumber_19 = new Field();
    Field mnEstrellas_20 = new Field();
    Field mnOrderNumber_21 = new Field();
    Field sQuestionDescription_22 = new Field();
    Field mnNumerodePregunta_23 = new Field();
    Field dtFecha_24 = new Field();
    Field mnAccumulatingRegisterNumber_26 = new Field();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P55480E_W55480EB_GridRow() {
        super();
    }

    public void setMnAddressNumber_19(Field mnAddressNumber_19) {
        Field oldmnAddressNumber_19 = this.mnAddressNumber_19;
        this.mnAddressNumber_19 = mnAddressNumber_19;
        propertyChangeSupport.firePropertyChange("mnAddressNumber_19", oldmnAddressNumber_19,mnAddressNumber_19);
    }

    public Field getMnAddressNumber_19() {
        return mnAddressNumber_19;
    }

    public void setMnEstrellas_20(Field mnEstrellas_20) {
        Field oldmnEstrellas_20 = this.mnEstrellas_20;
        this.mnEstrellas_20 = mnEstrellas_20;
        propertyChangeSupport.firePropertyChange("mnEstrellas_20", oldmnEstrellas_20,mnEstrellas_20);
    }

    public Field getMnEstrellas_20() {
        return mnEstrellas_20;
    }

    public void setMnOrderNumber_21(Field mnOrderNumber_21) {
        Field oldmnOrderNumber_21 = this.mnOrderNumber_21;
        this.mnOrderNumber_21 = mnOrderNumber_21;
        propertyChangeSupport.firePropertyChange("mnOrderNumber_21", oldmnOrderNumber_21,mnOrderNumber_21);
    }

    public Field getMnOrderNumber_21() {
        return mnOrderNumber_21;
    }

    public void setSQuestionDescription_22(Field sQuestionDescription_22) {
        Field oldsQuestionDescription_22 = this.sQuestionDescription_22;
        this.sQuestionDescription_22 = sQuestionDescription_22;
        propertyChangeSupport.firePropertyChange("sQuestionDescription_22", oldsQuestionDescription_22,sQuestionDescription_22);
    }

    public Field getSQuestionDescription_22() {
        return sQuestionDescription_22;
    }

    public void setMnNumerodePregunta_23(Field mnNumerodePregunta_23) {
        Field oldmnNumerodePregunta_23 = this.mnNumerodePregunta_23;
        this.mnNumerodePregunta_23 = mnNumerodePregunta_23;
        propertyChangeSupport.firePropertyChange("mnNumerodePregunta_23", oldmnNumerodePregunta_23,mnNumerodePregunta_23);
    }

    public Field getMnNumerodePregunta_23() {
        return mnNumerodePregunta_23;
    }

    public void setDtFecha_24(Field dtFecha_24) {
        Field olddtFecha_24 = this.dtFecha_24;
        this.dtFecha_24 = dtFecha_24;
        propertyChangeSupport.firePropertyChange("dtFecha_24", olddtFecha_24,dtFecha_24);
    }

    public Field getDtFecha_24() {
        return dtFecha_24;
    }

    public void setDtFecha_24AsJavaDate(Date date) {
        Field.setFieldToJavaDate(dtFecha_24, date);
    }

    public Date getDtFecha_24AsJavaDate() {
        return Field.convertFieldToJavaDate(dtFecha_24);
    }

    public void setMnAccumulatingRegisterNumber_26(Field mnAccumulatingRegisterNumber_26) {
        Field oldmnAccumulatingRegisterNumber_26 = this.mnAccumulatingRegisterNumber_26;
        this.mnAccumulatingRegisterNumber_26 = mnAccumulatingRegisterNumber_26;
        propertyChangeSupport.firePropertyChange("mnAccumulatingRegisterNumber_26", oldmnAccumulatingRegisterNumber_26,mnAccumulatingRegisterNumber_26);
    }

    public Field getMnAccumulatingRegisterNumber_26() {
        return mnAccumulatingRegisterNumber_26;
    }
}
