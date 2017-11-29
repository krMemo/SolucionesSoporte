package ynk.supports;

public class ListFieldPair {
    private String code;
    private String description;
    
    public ListFieldPair() {
        super();
    }

    public ListFieldPair(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
