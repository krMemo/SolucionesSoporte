package ynk.supports.p55480e;

import ynk.supports.FormParent;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;


public class P55480E_W55480EB_FormParent extends FormParent {

    private P55480E_W55480EB fs_P55480E_W55480EB = new P55480E_W55480EB();

    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    public P55480E_W55480EB_FormParent() {
        super();
    }

    public void setFs_P55480E_W55480EB(P55480E_W55480EB fs_P55480E_W55480EB) {
        P55480E_W55480EB oldfs_P55480E_W55480EB = this.fs_P55480E_W55480EB;
        this.fs_P55480E_W55480EB = fs_P55480E_W55480EB;
        propertyChangeSupport.firePropertyChange("fs_P55480E_W55480EB", oldfs_P55480E_W55480EB,fs_P55480E_W55480EB);
    }

    public P55480E_W55480EB getFs_P55480E_W55480EB() {
        return fs_P55480E_W55480EB;
    }

    public int getRowIndexForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getRowIndex();
    }

    public boolean getMOExistForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMOExist();
    }

    public String getMnAddressNumber_19ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMnAddressNumber_19().getValue();
    }

    public String getMnEstrellas_20ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMnEstrellas_20().getValue();
    }

    public String getMnOrderNumber_21ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMnOrderNumber_21().getValue();
    }

    public String getSQuestionDescription_22ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getSQuestionDescription_22().getValue();
    }

    public String getMnNumerodePregunta_23ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMnNumerodePregunta_23().getValue();
    }

    public String getDtFecha_24ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getDtFecha_24().getValue();
    }

    public String getMnAccumulatingRegisterNumber_26ForRow(int rowNum) {
        return getFs_P55480E_W55480EB().getData().getGridData().getRowset()[rowNum].getMnAccumulatingRegisterNumber_26().getValue();
    }
}
