package ynk.supports.p5698ows;

public class P5698OWS_W5698OWSB_FormParent {

    private P5698OWS_W5698OWSB fs_P5698OWS_W5698OWSB = new P5698OWS_W5698OWSB();

    public P5698OWS_W5698OWSB_FormParent() {
        super();
    }

    public void setFs_P5698OWS_W5698OWSB(P5698OWS_W5698OWSB fs_P5698OWS_W5698OWSB) {
        this.fs_P5698OWS_W5698OWSB = fs_P5698OWS_W5698OWSB;
    }

    public P5698OWS_W5698OWSB getFs_P5698OWS_W5698OWSB() {
        return fs_P5698OWS_W5698OWSB;
    }

    public int getRowIndexForRow(int rowNum) {
        return getFs_P5698OWS_W5698OWSB().getData().getGridData().getRowset()[rowNum].getRowIndex();
    }

    public boolean getMOExistForRow(int rowNum) {
        return getFs_P5698OWS_W5698OWSB().getData().getGridData().getRowset()[rowNum].getMOExist();
    }

    public String getSProgramID_19ForRow(int rowNum) {
        return getFs_P5698OWS_W5698OWSB().getData().getGridData().getRowset()[rowNum].getSProgramID_19().getValue();
    }

    public String getSElectronicAddress_20ForRow(int rowNum) {
        return getFs_P5698OWS_W5698OWSB().getData().getGridData().getRowset()[rowNum].getSElectronicAddress_20().getValue();
    }

    public String getSFutureUse7_21ForRow(int rowNum) {
        return getFs_P5698OWS_W5698OWSB().getData().getGridData().getRowset()[rowNum].getSFutureUse7_21().getValue();
    }
}
