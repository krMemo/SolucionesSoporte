package ynk.supports.p551701s;


public class P551701S_W551701SA_FormParent {

    private P551701S_W551701SA fs_P551701S_W551701SA = new P551701S_W551701SA();

    public P551701S_W551701SA_FormParent() {
        super();
    }

    public void setFs_P551701S_W551701SA(P551701S_W551701SA fs_P551701S_W551701SA) {
        this.fs_P551701S_W551701SA = fs_P551701S_W551701SA;
    }

    public P551701S_W551701SA getFs_P551701S_W551701SA() {
        return fs_P551701S_W551701SA;
    }

    public int getRowIndexForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getRowIndex();
    }

    public boolean getMOExistForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getMOExist();
    }

    public String getSBranchPlant_77ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSBranchPlant_77().getValue();
    }
    
    public String getSProductModel_78ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSProductModel_78().getValue();
    }

    public String getSSerialNumber_86ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSSerialNumber_86().getValue();
    }

    public String getSProductModel_165ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSProductModel_165().getValue();
    }
    
    public String getMnCliente_84ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getMnCliente_84().getValue();
    }
    
    public String getMnAssetNumber_57ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getMnAssetNumber_57().getValue();
    }
    
    public String getMnParentItemNo_195ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getMnParentItemNo_195().getValue();
    }
    
    public String getS2ndItemNumber_196ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getS2ndItemNumber_196().getValue();
    }
    
    public String getSUnidadMedida_199ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSUnidadMedida_199().getValue();
    }
    
    public String getSPrioridad_200ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSPrioridad_200().getValue();
    }
    
    public String getSRatGrp_45ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSRatGrp_45().getValue();
    }
    
    public String getSLinea_79ForRow(int rowNum) {
        return getFs_P551701S_W551701SA().getData().getGridData().getRowset()[rowNum].getSLinea_79().getValue();
    }
    
}
