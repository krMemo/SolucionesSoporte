package application;

import com.oracle.e1.jdemf.ApplicationGlobals;
import com.oracle.e1.jdemf.FSREvent;

import com.oracle.e1.jdemf.FormRequest;

import com.oracle.e1.jdemf.JDERestServiceException;
import com.oracle.e1.jdemf.JDERestServiceProvider;

import oracle.adfmf.framework.FeatureContext;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.json.JSONObject;

import ynk.supports.p5848app.P5848APP_W5848APPA_FormParent;
import ynk.supports.p594820i.P594820I_W594820IA_FormParent;

/**
 * @param customersAlias_FormParent
 */
public class CustomersDC {
    String custNumber;
    String alphaName;
    String aliasName;
    String soFilter;
    String soType; 

    P5848APP_W5848APPA_FormParent customersAlias_FormParent = new P5848APP_W5848APPA_FormParent();
    P594820I_W594820IA_FormParent serviceOrders_FormParent = new P594820I_W594820IA_FormParent();
    
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

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setSoFilter(String soFilter) {
        this.soFilter = soFilter;
    }

    public String getSoFilter() {
        return soFilter;
    }

    public void setCustomersAlias_FormParent(P5848APP_W5848APPA_FormParent customersAlias_FormParent) {
        this.customersAlias_FormParent = customersAlias_FormParent;
    }

    public P5848APP_W5848APPA_FormParent getCustomersAlias_FormParent() {
        return customersAlias_FormParent;
    }


    public void setServiceOrders_FormParent(P594820I_W594820IA_FormParent serviceOrders_FormParent) {
        this.serviceOrders_FormParent = serviceOrders_FormParent;
    }

    public P594820I_W594820IA_FormParent getServiceOrders_FormParent() {
        return serviceOrders_FormParent;
    }

    public void getCustomersAliasList(){
            setCustNumber(ApplicationGlobals.getInstance().getLoginResponse().getUsername());
            setAlphaName(ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getAlphaName());
            
            FormRequest formRequest = new FormRequest();
            formRequest.setFormName("P5848APP_W5848APPA");
            formRequest.setVersion("");
            formRequest.setFormServiceAction("R");
            
            FSREvent custAliasFSREvent = new FSREvent();
            custAliasFSREvent.setFieldValue("30",getCustNumber()); //set search type to parent customer
            
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
                if (customersAlias_FormParent.getFs_P5848APP_W5848APPA().getData().getGridData().getRowset().length==0){
                    AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.manager}", (Boolean)false);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.alias}", getCustNumber());
                    AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", getAlphaName());
                }
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
    
    public void getServiceOrdersList() {
        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P594820I_W594820IA");
        formRequest.setVersion("DICIPA001");
        formRequest.setFormServiceAction("R");
        formRequest.setMaxPageSize("20");
        //FI

        FSREvent w594820IAFSREvent = new FSREvent();
        w594820IAFSREvent.setFieldValue("695", (String)AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.alias}"));
        //FC
        if (soFilter != null && soFilter.trim().length() > 0) {
            //set Service Order filter  in QBE
            w594820IAFSREvent.setQBEValue("1[424]", "*" + soFilter.trim() + "*");
        } 
        w594820IAFSREvent.doControlAction("6"); //TriggertheFindButton
        formRequest.addFSREvent(w594820IAFSREvent); //addtheeventstotheformrequest
        try {
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);
            P594820I_W594820IA_FormParent temp_p594820I_W594820IA_FormParent =
                (P594820I_W594820IA_FormParent) JSONBeanSerializationHelper.fromJSON(P594820I_W594820IA_FormParent.class,
                                                                                     response);

            serviceOrders_FormParent.getFs_P594820I_W594820IA().getData().getGridData().setRowsetWithList(temp_p594820I_W594820IA_FormParent.getFs_P594820I_W594820IA().getData().getGridData().retrieveRowsetList());
        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }

}
