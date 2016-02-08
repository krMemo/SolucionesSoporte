package ynk.supports.p594820i;

import ynk.supports.GridDataMobile;
import java.util.ArrayList;

public class P594820I_W594820IA_GridData extends GridDataMobile {

    private P594820I_W594820IA_GridColumnTitles titles = new P594820I_W594820IA_GridColumnTitles();

    public P594820I_W594820IA_GridData() {
        super();
    }

    public void setTitles(P594820I_W594820IA_GridColumnTitles titles) {
        this.titles = titles;
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
}
