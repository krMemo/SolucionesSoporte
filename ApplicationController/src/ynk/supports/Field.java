package ynk.supports;

import java.util.Date;
import java.util.TimeZone;

public class Field {
    
    private String id;
    private String value;
    private String title;
    private String datatype;
    private Object internalValue;
    private boolean editable;    
    private boolean visible;
    private boolean bsvw;
    
    public Field() {
        super();
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
   
    public void setInternalValue(Object internalValue) {
        this.internalValue = internalValue;
    }

    public Object getInternalValue() {
        return internalValue;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setDatatype(String datatype) {
        this.datatype = datatype;
    }

    public String getDatatype() {
        return datatype;
    }
    
    public static Date convertFieldToJavaDate(Field field) 
    {
        // the field's internal value should contain milliseconds since 1970, which we use to create a Java Date.       
        if (field != null) 
        {            
            Object iValObj = field.getInternalValue();            
            if (iValObj != null) 
            {
                try 
                {
                    long millis = Long.parseLong(iValObj.toString());
					//apply offset to millis so formatted dates will be correct no matter what time zone					
					millis = millis - TimeZone.getDefault().getOffset(millis);
					Date returnDate = new Date(millis);
                    return returnDate;
                }
                catch (NumberFormatException nfe) 
                {
                    return null;
                }
            }            
        }
        return null;
    }
    
    public static void setFieldToJavaDate(Field field, Date date) 
    {
        if ((field != null) && (date != null)) 
        {
            // Set the FormField's internal value to the milliseconds since 1970
            Long millis = new Long(date.getTime());
            field.setInternalValue(millis);
            
            // We don't (easily) have access to user's date preference, so we can't set the String value to
            // something correct.  Rather than have a lingering incorrect/out-of-sync value, null it out.
            field.setValue(null);
        }
    }
    
    public void setEditable(boolean editable)
    {
        this.editable = editable;
    }
    
    public boolean getEditable()
    {
        return this.editable;
    }
    
    public void setVisible(boolean visible)
    {
        this.visible = visible;
    }
    public boolean isVisible()
    {
        return visible;
    }

    public void setBsvw(boolean bsvw) {
        this.bsvw = bsvw;
    }

    public boolean isBsvw() {
        return bsvw;
    }
}
