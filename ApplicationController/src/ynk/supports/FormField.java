package ynk.supports;

public class FormField extends Field {
    
    String assocDesc;
    String staticText;
    
    public FormField() {
        super();
    }

    public void setAssocDesc(String assocDesc) {
        this.assocDesc = assocDesc;
    }

    public String getAssocDesc() {
        return assocDesc;
    }

    public void setStaticText(String staticText) {
        this.staticText = staticText;
    }

    public String getStaticText() {
        return staticText;
    }
}
