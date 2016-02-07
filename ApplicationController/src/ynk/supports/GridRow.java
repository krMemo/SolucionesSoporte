package ynk.supports;

public class GridRow

{
	// these fields are included in the JSON for a grid row
    private int rowIndex;
    private boolean MOExist;

    public void setRowIndex(int rowIndex)
    {
        this.rowIndex = rowIndex;
    }

    public int getRowIndex()
    {
        return this.rowIndex;
    }

    public void setMOExist(boolean MOExist)
    {
        this.MOExist = MOExist;
    }

    public boolean getMOExist()
    {
        return this.MOExist;
    }
}
