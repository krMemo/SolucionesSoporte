package ynk.supports.p594820i;

import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import ynk.supports.Field;
import ynk.supports.GridRowMobile;

import java.util.Date;

public class P594820I_W594820IA_GridRow extends GridRowMobile {

    Field mnPegtoWO_424 = new Field();
    Field sDescrpcinModelo_678 = new Field();
    Field sSerialNumber_563 = new Field();
    Field sWOSt_9 = new Field();
    Field sWOSt_447 = new Field();
    Field dtOrderDate_19 = new Field();
    Field sDescripcinFalla_217 = new Field();
    Field sNombredeUsuario_595 = new Field();
    Field sTelefonoUsuario_12 = new Field();
    Field chWOType_10 = new Field();
    Field dtFechaTermino_145 = new Field();
    Field sHoursTime_699 = new Field();
    Field sHoraFin_701 = new Field();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P594820I_W594820IA_GridRow() {
        super();
    }

    public void setMnPegtoWO_424(Field mnPegtoWO_424) {
        Field oldmnPegtoWO_424 = this.mnPegtoWO_424;
        this.mnPegtoWO_424 = mnPegtoWO_424;
        propertyChangeSupport.firePropertyChange("mnPegtoWO_424", oldmnPegtoWO_424,mnPegtoWO_424);
    }

    public Field getMnPegtoWO_424() {
        return mnPegtoWO_424;
    }

    public void setSDescrpcinModelo_678(Field sDescrpcinModelo_678) {
        Field oldsDescrpcinModelo_678 = this.sDescrpcinModelo_678;
        this.sDescrpcinModelo_678 = sDescrpcinModelo_678;
        propertyChangeSupport.firePropertyChange("sDescrpcinModelo_678", oldsDescrpcinModelo_678,sDescrpcinModelo_678);
    }

    public Field getSDescrpcinModelo_678() {
        return sDescrpcinModelo_678;
    }

    public void setSSerialNumber_563(Field sSerialNumber_563) {
        Field oldsSerialNumber_563 = this.sSerialNumber_563;
        this.sSerialNumber_563 = sSerialNumber_563;
        propertyChangeSupport.firePropertyChange("sSerialNumber_563", oldsSerialNumber_563,sSerialNumber_563);
    }

    public Field getSSerialNumber_563() {
        return sSerialNumber_563;
    }

    public void setSWOSt_9(Field sWOSt_9) {
        Field oldsWOSt_9 = this.sWOSt_9;
        this.sWOSt_9 = sWOSt_9;
        propertyChangeSupport.firePropertyChange("sWOSt_9", oldsWOSt_9,sWOSt_9);
    }

    public Field getSWOSt_9() {
        return sWOSt_9;
    }

    public void setSWOSt_447(Field sWOSt_447) {
        Field oldsWOSt_447 = this.sWOSt_447;
        this.sWOSt_447 = sWOSt_447;
        propertyChangeSupport.firePropertyChange("sWOSt_447", oldsWOSt_447,sWOSt_447);
    }

    public Field getSWOSt_447() {
        return sWOSt_447;
    }

    public void setDtOrderDate_19(Field dtOrderDate_19) {
        Field olddtOrderDate_19 = this.dtOrderDate_19;
        this.dtOrderDate_19 = dtOrderDate_19;
        propertyChangeSupport.firePropertyChange("dtOrderDate_19", olddtOrderDate_19,dtOrderDate_19);
    }

    public Field getDtOrderDate_19() {
        return dtOrderDate_19;
    }

    public void setDtOrderDate_19AsJavaDate(Date date) {
        Field.setFieldToJavaDate(dtOrderDate_19, date);
    }

    public Date getDtOrderDate_19AsJavaDate() {
        return Field.convertFieldToJavaDate(dtOrderDate_19);
    }

    public void setSDescripcinFalla_217(Field sDescripcinFalla_217) {
        Field oldsDescripcinFalla_217 = this.sDescripcinFalla_217;
        this.sDescripcinFalla_217 = sDescripcinFalla_217;
        propertyChangeSupport.firePropertyChange("sDescripcinFalla_217", oldsDescripcinFalla_217,sDescripcinFalla_217);
    }

    public Field getSDescripcinFalla_217() {
        return sDescripcinFalla_217;
    }

    public void setSNombredeUsuario_595(Field sNombredeUsuario_595) {
        Field oldsNombredeUsuario_595 = this.sNombredeUsuario_595;
        this.sNombredeUsuario_595 = sNombredeUsuario_595;
        propertyChangeSupport.firePropertyChange("sNombredeUsuario_595", oldsNombredeUsuario_595,sNombredeUsuario_595);
    }

    public Field getSNombredeUsuario_595() {
        return sNombredeUsuario_595;
    }

    public void setSTelefonoUsuario_12(Field sTelefonoUsuario_12) {
        Field oldsTelefonoUsuario_12 = this.sTelefonoUsuario_12;
        this.sTelefonoUsuario_12 = sTelefonoUsuario_12;
        propertyChangeSupport.firePropertyChange("sTelefonoUsuario_12", oldsTelefonoUsuario_12,sTelefonoUsuario_12);
    }

    public Field getSTelefonoUsuario_12() {
        return sTelefonoUsuario_12;
    }

    public void setChWOType_10(Field chWOType_10) {
        Field oldchWOType_10 = this.chWOType_10;
        this.chWOType_10 = chWOType_10;
        propertyChangeSupport.firePropertyChange("chWOType_10", oldchWOType_10,chWOType_10);
    }

    public Field getChWOType_10() {
        return chWOType_10;
    }

    public void setDtFechaTermino_145(Field dtFechaTermino_145) {
        Field olddtFechaTermino_145 = this.dtFechaTermino_145;
        this.dtFechaTermino_145 = dtFechaTermino_145;
        propertyChangeSupport.firePropertyChange("dtFechaTermino_145", olddtFechaTermino_145,dtFechaTermino_145);
    }

    public Field getDtFechaTermino_145() {
        return dtFechaTermino_145;
    }

    public void setDtFechaTermino_145AsJavaDate(Date date) {
        Field.setFieldToJavaDate(dtFechaTermino_145, date);
    }

    public Date getDtFechaTermino_145AsJavaDate() {
        return Field.convertFieldToJavaDate(dtFechaTermino_145);
    }

    public void setSHoursTime_699(Field sHoursTime_699) {
        Field oldsHoursTime_699 = this.sHoursTime_699;
        this.sHoursTime_699 = sHoursTime_699;
        propertyChangeSupport.firePropertyChange("sHoursTime_699", oldsHoursTime_699,sHoursTime_699);
    }

    public Field getSHoursTime_699() {
        return sHoursTime_699;
    }

    public void setSHoraFin_701(Field sHoraFin_701) {
        Field oldsHoraFin_701 = this.sHoraFin_701;
        this.sHoraFin_701 = sHoraFin_701;
        propertyChangeSupport.firePropertyChange("sHoraFin_701", oldsHoraFin_701,sHoraFin_701);
    }

    public Field getSHoraFin_701() {
        return sHoraFin_701;
    }
}
