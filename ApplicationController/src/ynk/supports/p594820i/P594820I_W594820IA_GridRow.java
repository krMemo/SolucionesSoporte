package ynk.supports.p594820i;

import ynk.supports.Field;
import ynk.supports.FieldMobile;
import ynk.supports.GridRowMobile;

import java.util.Date;

public class P594820I_W594820IA_GridRow extends GridRowMobile {

    FieldMobile mnPegtoWO_424 = new FieldMobile();
    FieldMobile sSerialNumber_563 = new FieldMobile();
    FieldMobile dtOrderDate_19 = new FieldMobile();
    FieldMobile sWOSt_447 = new FieldMobile();
    FieldMobile sDescrpcinModelo_678 = new FieldMobile();
    FieldMobile sDescripcinFalla_217 = new FieldMobile();
    FieldMobile sNombreDeUsuario_595 = new FieldMobile();
    FieldMobile sTelefonoUsuario_12 = new FieldMobile();
    FieldMobile chWOType_10 = new FieldMobile();
    FieldMobile sHoursTime_699 = new FieldMobile();
    FieldMobile sWOSt_9 = new FieldMobile();
    FieldMobile dtFechaTermino_145 = new FieldMobile();
    FieldMobile sHoraFin_701 = new FieldMobile();

    public P594820I_W594820IA_GridRow() {
        super();
    }

    public void setMnPegtoWO_424(FieldMobile mnPegtoWO_424) {
        this.mnPegtoWO_424 = mnPegtoWO_424;
    }

    public FieldMobile getMnPegtoWO_424() {
        return mnPegtoWO_424;
    }

    public void setSSerialNumber_563(FieldMobile sSerialNumber_563) {
        this.sSerialNumber_563 = sSerialNumber_563;
    }

    public FieldMobile getSSerialNumber_563() {
        return sSerialNumber_563;
    }

    public void setDtOrderDate_19(FieldMobile dtOrderDate_19) {
        this.dtOrderDate_19 = dtOrderDate_19;
    }

    public FieldMobile getDtOrderDate_19() {
        return dtOrderDate_19;
    }

    public void setDtOrderDate_19AsJavaDate(Date date) {
        Field.setFieldToJavaDate(dtOrderDate_19, date);
    }

    public Date getDtOrderDate_19AsJavaDate() {
        return Field.convertFieldToJavaDate(dtOrderDate_19);
    }

    public void setSWOSt_447(FieldMobile sWOSt_447) {
        this.sWOSt_447 = sWOSt_447;
    }

    public FieldMobile getSWOSt_447() {
        return sWOSt_447;
    }

    public void setSDescrpcinModelo_678(FieldMobile sDescrpcinModelo_678) {
        this.sDescrpcinModelo_678 = sDescrpcinModelo_678;
    }

    public FieldMobile getSDescrpcinModelo_678() {
        return sDescrpcinModelo_678;
    }

    public void setSDescripcinFalla_217(FieldMobile sDescripcinFalla_217) {
        this.sDescripcinFalla_217 = sDescripcinFalla_217;
    }

    public FieldMobile getSDescripcinFalla_217() {
        return sDescripcinFalla_217;
    }

    public void setSNombreDeUsuario_595(FieldMobile sNombreDeUsuario_595) {
        this.sNombreDeUsuario_595 = sNombreDeUsuario_595;
    }

    public FieldMobile getSNombreDeUsuario_595() {
        return sNombreDeUsuario_595;
    }

    public void setSTelefonoUsuario_12(FieldMobile sTelefonoUsuario_12) {
        this.sTelefonoUsuario_12 = sTelefonoUsuario_12;
    }

    public FieldMobile getSTelefonoUsuario_12() {
        return sTelefonoUsuario_12;
    }

    public void setChWOType_10(FieldMobile chWOType_10) {
        this.chWOType_10 = chWOType_10;
    }

    public FieldMobile getChWOType_10() {
        return chWOType_10;
    }

    public void setSHoursTime_699(FieldMobile sHoursTime_699) {
        this.sHoursTime_699 = sHoursTime_699;
    }

    public FieldMobile getSHoursTime_699() {
        return sHoursTime_699;
    }

    public void setSWOSt_9(FieldMobile sWOSt_9) {
        this.sWOSt_9 = sWOSt_9;
    }

    public FieldMobile getSWOSt_9() {
        return sWOSt_9;
    }

    public void setDtFechaTermino_145(FieldMobile dtFechaTermino_145) {
        this.dtFechaTermino_145 = dtFechaTermino_145;
    }

    public FieldMobile getDtFechaTermino_145() {
        return dtFechaTermino_145;
    }

    public void setSHoraFin_701(FieldMobile sHoraFin_701) {
        this.sHoraFin_701 = sHoraFin_701;
    }

    public FieldMobile getSHoraFin_701() {
        return sHoraFin_701;
    }

}
