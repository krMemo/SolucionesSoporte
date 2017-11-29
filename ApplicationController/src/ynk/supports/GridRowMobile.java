package ynk.supports;

public class GridRowMobile extends GridRow

{
    // Field level representation of the row at this level for ADF use only, not part of JSON.
    private String id;
    private String value;
    private String title;
    private String datatype;
    private Object internalValue;
    private boolean editable;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDatatype() {
        return datatype;
    }

    public void setInternalValue(Object internalValue) {
        this.internalValue = internalValue;
    }

    public Object getInternalValue() {
        return internalValue;
    }
    
    public void setEditable(boolean editable)
    {
        this.editable = editable;
    }
    
    public boolean getEditable()
    {
        return this.editable;
    }
    
}
