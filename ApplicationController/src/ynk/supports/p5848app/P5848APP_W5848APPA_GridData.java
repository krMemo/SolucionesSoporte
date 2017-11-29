package ynk.supports.p5848app;

import ynk.supports.GridDataMobile;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import java.util.ArrayList;

public class P5848APP_W5848APPA_GridData extends GridDataMobile {

    private P5848APP_W5848APPA_GridColumnTitles titles = new P5848APP_W5848APPA_GridColumnTitles();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P5848APP_W5848APPA_GridData() {
        super();
    }

    public void setTitles(P5848APP_W5848APPA_GridColumnTitles titles) {
        P5848APP_W5848APPA_GridColumnTitles oldtitles = this.titles;
        this.titles = titles;
        propertyChangeSupport.firePropertyChange("titles", oldtitles,titles);
    }

    public P5848APP_W5848APPA_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(P5848APP_W5848APPA_GridRow[] rowset) {
        this.rowset = new ArrayList();

        for (int i = 0; i < rowset.length; i++){
            this.rowset.add(rowset[i]);
        }

        providerChangeSupport.fireProviderRefresh("rowset");
    }

    public P5848APP_W5848APPA_GridRow[] getRowset() {
        return (P5848APP_W5848APPA_GridRow[]) rowset.toArray(new P5848APP_W5848APPA_GridRow[rowset.size()]);
    }

    public void addRow(P5848APP_W5848APPA_GridRow row) {
        rowset.add(row);
    }

    /* Stub for delete row.  If you need delete row functionality, you will need
     * to modify this method to reflect which grid column represents the row id.
     * For example, for P01012_W01012B, you would use mnAddressNumber.  */
    // public void deleteRowId(String id) {
    //     for (int i = 0; i < rowset.size(); i++) {
    //         P5848APP_W5848APPA_GridRow current = (P5848APP_W5848APPA_GridRow) rowset.get(i);
    // 
    //         if (current.<ID_FIELD>.getValue().equals(id)){
    //             rowset.remove(i);
    //         }
    //     }
    //
    //     summary.setRecords(rowset.size());
    // }
}
