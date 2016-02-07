package ynk.supports;

public class FormFieldMobile extends FieldMobile {
    
    String assocDesc;
    String staticText;
    
    public FormFieldMobile() {
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
