package ynk.supports.p5698ows;

import ynk.supports.GridDataMobile;
import java.util.ArrayList;

public class P5698OWS_W5698OWSB_GridData extends GridDataMobile {

    private P5698OWS_W5698OWSB_GridColumnTitles titles = new P5698OWS_W5698OWSB_GridColumnTitles();

    public P5698OWS_W5698OWSB_GridData() {
        super();
    }

    public void setTitles(P5698OWS_W5698OWSB_GridColumnTitles titles) {
        this.titles = titles;
    }

    public P5698OWS_W5698OWSB_GridColumnTitles getTitles() {
        return titles;
    }

    public void setRowset(P5698OWS_W5698OWSB_GridRow[] rowset) {
        this.rowset = new ArrayList();

        for (int i = 0; i < rowset.length; i++){
            this.rowset.add(rowset[i]);
        }

        providerChangeSupport.fireProviderRefresh("rowset");
    }

    public P5698OWS_W5698OWSB_GridRow[] getRowset() {
        return (P5698OWS_W5698OWSB_GridRow[]) rowset.toArray(new P5698OWS_W5698OWSB_GridRow[rowset.size()]);
    }

    public void addRow(P5698OWS_W5698OWSB_GridRow row) {
        rowset.add(row);
    }

    /* Stub for delete row.  If you need delete row functionality, you will need
     * to modify this method to reflect which grid column represents the row id.
     * For example, for P01012_W01012B, you would use mnAddressNumber.  */
    // public void deleteRowId(String id) {
    //     for (int i = 0; i < rowset.size(); i++) {
    //         P5698OWS_W5698OWSB_GridRow current = (P5698OWS_W5698OWSB_GridRow) rowset.get(i);
    // 
    //         if (current.<ID_FIELD>.getValue().equals(id)){
    //             rowset.remove(i);
    //         }
    //     }
    //
    //     summary.setRecords(rowset.size());
    // }
}
