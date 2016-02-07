package ynk.supports.p5848app;

import ynk.supports.Field;
import ynk.supports.FormFieldMobile;
import ynk.supports.ListField;

import java.util.Date;

import oracle.adfmf.java.beans.PropertyChangeSupport;

public class P5848APP_W5848APPA_FormData {

    private FormFieldMobile txtOriginator_30 = new FormFieldMobile();
    private P5848APP_W5848APPA_GridData gridData = new P5848APP_W5848APPA_GridData();

    public void setTxtOriginator_30(FormFieldMobile txtOriginator_30) {
        this.txtOriginator_30 = txtOriginator_30;
    }

    public FormFieldMobile getTxtOriginator_30() {
        return txtOriginator_30;
    }

    public void setGridData(P5848APP_W5848APPA_GridData gridData) {
        this.gridData = gridData;
    }

    public P5848APP_W5848APPA_GridData getGridData() {
        return gridData;
    }
}
