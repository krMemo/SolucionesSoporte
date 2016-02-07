package application;

import com.oracle.e1.jdemf.ApplicationGlobals;
import com.oracle.e1.jdemf.FSREvent;

import com.oracle.e1.jdemf.FormRequest;

import com.oracle.e1.jdemf.JDERestServiceException;
import com.oracle.e1.jdemf.JDERestServiceProvider;

import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.json.JSONObject;

import ynk.supports.p5848app.P5848APP_W5848APPA_FormParent;

/**
 * @param customersAlias_FormParent
 */
public class CustomersDC {
    String custNumber;
    String alphaName;
    P5848APP_W5848APPA_FormParent customersAlias_FormParent = new P5848APP_W5848APPA_FormParent();
    
    public CustomersDC() {
        super();
        getCustomersAliasList();
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public String getCustNumber() {
        return custNumber;
    }

    public void setAlphaName(String alphaName) {
        this.alphaName = alphaName;
    }

    public String getAlphaName() {
        return alphaName;
    }

    public void setCustomersAlias_FormParent(P5848APP_W5848APPA_FormParent customersAlias_FormParent) {
        this.customersAlias_FormParent = customersAlias_FormParent;
    }

    public P5848APP_W5848APPA_FormParent getCustomersAlias_FormParent() {
        return customersAlias_FormParent;
    }
    
    public void getCustomersAliasList(){
            setCustNumber(ApplicationGlobals.getInstance().getLoginResponse().getUsername());
            setAlphaName(ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getAlphaName());
            
            FormRequest formRequest = new FormRequest();
            formRequest.setFormName("P5848APP_W5848APPA");
            formRequest.setVersion("");
            formRequest.setFormServiceAction("R");
            
            FSREvent custAliasFSREvent = new FSREvent();
            //TODO change 50 for custNumber or Alias
            custAliasFSREvent.setFieldValue("30","50"); //set search type to parent customer
            
            custAliasFSREvent.doControlAction("15");  // Trigger the Find Button
            formRequest.addFSREvent(custAliasFSREvent); //add the events to the form request
            try
            {
                //Serialize the form request to JSON String
                JSONObject jsonObject = (JSONObject)JSONBeanSerializationHelper.toJSON(formRequest);
                String postData = jsonObject.toString();
                
                // Call to JDERestServiceProvider with parameters JSON string
                String response = JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,JDERestServiceProvider.FORM_SERVICE_URI);
                
                //deserialize the response to the class for the form
                customersAlias_FormParent = (P5848APP_W5848APPA_FormParent)JSONBeanSerializationHelper.fromJSON(P5848APP_W5848APPA_FormParent.class, response);
            }
            catch (JDERestServiceException e)
            {
                JDERestServiceProvider.handleServiceException(e);
            }        
            catch(Exception e)
            {
                throw new AdfException(e.getMessage(), AdfException.ERROR);    
            }   
        }

}
