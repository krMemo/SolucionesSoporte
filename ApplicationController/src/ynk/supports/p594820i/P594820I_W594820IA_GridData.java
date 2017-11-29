package ynk.supports.p594820i;

import ynk.supports.GridDataMobile;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.PropertyChangeListener;

import java.util.ArrayList;

public class P594820I_W594820IA_GridData extends GridDataMobile {

    private P594820I_W594820IA_GridColumnTitles titles = new P594820I_W594820IA_GridColumnTitles();
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this); 

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public P594820I_W594820IA_GridData() {
        super();
    }

    public void setTitles(P594820I_W594820IA_GridColumnTitles titles) {
        P594820I_W594820IA_GridColumnTitles oldtitles = this.titles;
        this.titles = titles;
        propertyChangeSupport.firePropertyChange("titles", oldtitles,titles);
    }

    public P594820I_W594820IA_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(P594820I_W594820IA_GridRow[] rowset) {
        this.rowset = new ArrayList();

        for (int i = 0; i < rowset.length; i++){
            this.rowset.add(rowset[i]);
        }

        providerChangeSupport.fireProviderRefresh("rowset");
    }

    public P594820I_W594820IA_GridRow[] getRowset() {
        return (P594820I_W594820IA_GridRow[]) rowset.toArray(new P594820I_W594820IA_GridRow[rowset.size()]);
    }

    public void addRow(P594820I_W594820IA_GridRow row) {
        rowset.add(row);
    }

    /* Stub for delete row.  If you need delete row functionality, you will need
     * to modify this method to reflect which grid column represents the row id.
     * For example, for P01012_W01012B, you would use mnAddressNumber.  */
     public void deleteRowId(String id) {
         for (int i = 0; i < rowset.size(); i++) {
             P594820I_W594820IA_GridRow current = (P594820I_W594820IA_GridRow) rowset.get(i);
     
             if (current.getMnPegtoWO_424().getValue().equals(id)){
                 rowset.remove(i);
             }
         }
    
         summary.setRecords(rowset.size());
     }
}
