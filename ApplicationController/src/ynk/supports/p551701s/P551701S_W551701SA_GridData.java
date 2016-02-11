package ynk.supports.p551701s;

import ynk.supports.GridDataMobile;
import java.util.ArrayList;

public class P551701S_W551701SA_GridData extends GridDataMobile {

    private P551701S_W551701SA_GridColumnTitles titles = new P551701S_W551701SA_GridColumnTitles();

    public P551701S_W551701SA_GridData() {
        super();
    }

    public void setTitles(P551701S_W551701SA_GridColumnTitles titles) {
        this.titles = titles;
    }

    public P551701S_W551701SA_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(P551701S_W551701SA_GridRow[] rowset) {
        this.rowset = new ArrayList();

        for (int i = 0; i < rowset.length; i++){
            this.rowset.add(rowset[i]);
        }

        providerChangeSupport.fireProviderRefresh("rowset");
    }

    public P551701S_W551701SA_GridRow[] getRowset() {
        return (P551701S_W551701SA_GridRow[]) rowset.toArray(new P551701S_W551701SA_GridRow[rowset.size()]);
    }

    public void addRow(P551701S_W551701SA_GridRow row) {
        rowset.add(row);
    }

    /* Stub for delete row.  If you need delete row functionality, you will need
     * to modify this method to reflect which grid column represents the row id.
     * For example, for P01012_W01012B, you would use mnAddressNumber.  */
    // public void deleteRowId(String id) {
    //     for (int i = 0; i < rowset.size(); i++) {
    //         P551701S_W551701SA_GridRow current = (P551701S_W551701SA_GridRow) rowset.get(i);
    // 
    //         if (current.<ID_FIELD>.getValue().equals(id)){
    //             rowset.remove(i);
    //         }
    //     }
    //
    //     summary.setRecords(rowset.size());
    // }
}
