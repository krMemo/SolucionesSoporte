package ynk.supports;

import java.util.ArrayList;
import java.util.List;

public class ListField extends FormField {
    private List list;
    public ListField() {
        super();
    }
    
    public void setList(ListFieldPair[] listFields){
        this.list = new ArrayList();
        
        for(int i=0; i<listFields.length; i++){
            this.list.add(listFields[i]);
        }
    }
    
    public ListFieldPair[] getList() {
        ListFieldPair r[] = null;

        r = (ListFieldPair[])list.toArray(new ListFieldPair[list.size()]);

        return r;
    }
}
