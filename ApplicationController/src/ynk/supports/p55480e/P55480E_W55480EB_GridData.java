package ynk.supports.p55480e;

import ynk.supports.GridDataMobile;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import java.util.ArrayList;

public class P55480E_W55480EB_GridData extends GridDataMobile {

    private P55480E_W55480EB_GridColumnTitles titles = new P55480E_W55480EB_GridColumnTitles();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P55480E_W55480EB_GridData() {
        super();
    }

    public void setTitles(P55480E_W55480EB_GridColumnTitles titles) {
        P55480E_W55480EB_GridColumnTitles oldtitles = this.titles;
        this.titles = titles;
        propertyChangeSupport.firePropertyChange("titles", oldtitles,titles);
    }

    public P55480E_W55480EB_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(P55480E_W55480EB_GridRow[] rowset) {
        this.rowset = new ArrayList();

        for (int i = 0; i < rowset.length; i++){
            this.rowset.add(rowset[i]);
        }

        providerChangeSupport.fireProviderRefresh("rowset");
    }

    public P55480E_W55480EB_GridRow[] getRowset() {
        return (P55480E_W55480EB_GridRow[]) rowset.toArray(new P55480E_W55480EB_GridRow[rowset.size()]);
    }

    public void addRow(P55480E_W55480EB_GridRow row) {
        rowset.add(row);
    }

    /* Stub for delete row.  If you need delete row functionality, you will need
     * to modify this method to reflect which grid column represents the row id.
     * For example, for P01012_W01012B, you would use mnAddressNumber.  */
    // public void deleteRowId(String id) {
    //     for (int i = 0; i < rowset.size(); i++) {
    //         P55480E_W55480EB_GridRow current = (P55480E_W55480EB_GridRow) rowset.get(i);
    // 
    //         if (current.<ID_FIELD>.getValue().equals(id)){
    //             rowset.remove(i);
    //         }
    //     }
    //
    //     summary.setRecords(rowset.size());
    // }
}
