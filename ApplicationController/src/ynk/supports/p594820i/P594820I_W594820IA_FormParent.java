package ynk.supports.p594820i;

import ynk.supports.FormParent;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class P594820I_W594820IA_FormParent extends FormParent {

    private P594820I_W594820IA fs_P594820I_W594820IA = new P594820I_W594820IA();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P594820I_W594820IA_FormParent() {
        super();
    }

    public void setFs_P594820I_W594820IA(P594820I_W594820IA fs_P594820I_W594820IA) {
        P594820I_W594820IA oldfs_P594820I_W594820IA = this.fs_P594820I_W594820IA;
        this.fs_P594820I_W594820IA = fs_P594820I_W594820IA;
        propertyChangeSupport.firePropertyChange("fs_P594820I_W594820IA", oldfs_P594820I_W594820IA,fs_P594820I_W594820IA);
    }

    public P594820I_W594820IA getFs_P594820I_W594820IA() {
        return fs_P594820I_W594820IA;
    }

    public int getRowIndexForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getRowIndex();
    }

    public boolean getMOExistForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getMOExist();
    }

    public String getMnPegtoWO_424ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getMnPegtoWO_424().getValue();
    }

    public String getSDescrpcinModelo_678ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSDescrpcinModelo_678().getValue();
    }

    public String getSSerialNumber_563ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSSerialNumber_563().getValue();
    }

    public String getSWOSt_9ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSWOSt_9().getValue();
    }

    public String getSWOSt_447ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSWOSt_447().getValue();
    }

    public String getDtOrderDate_19ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getDtOrderDate_19().getValue();
    }

    public String getSDescripcinFalla_217ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSDescripcinFalla_217().getValue();
    }

    public String getSNombredeUsuario_595ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSNombredeUsuario_595().getValue();
    }

    public String getSTelefonoUsuario_12ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSTelefonoUsuario_12().getValue();
    }

    public String getChWOType_10ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getChWOType_10().getValue();
    }

    public String getDtFechaTermino_145ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getDtFechaTermino_145().getValue();
    }

    public String getSHoursTime_699ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSHoursTime_699().getValue();
    }

    public String getSHoraFin_701ForRow(int rowNum) {
        return getFs_P594820I_W594820IA().getData().getGridData().getRowset()[rowNum].getSHoraFin_701().getValue();
    }
}
