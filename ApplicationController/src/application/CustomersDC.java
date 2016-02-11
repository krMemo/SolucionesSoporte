package application;

import com.oracle.e1.jdemf.ApplicationGlobals;
import com.oracle.e1.jdemf.FSREvent;

import com.oracle.e1.jdemf.FormRequest;

import com.oracle.e1.jdemf.JDERestServiceException;
import com.oracle.e1.jdemf.JDERestServiceProvider;

import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.json.JSONObject;

import ynk.supports.p551701s.P551701S_W551701SA_FormParent;
import ynk.supports.p5848app.P5848APP_W5848APPA_FormParent;
import ynk.supports.p594820i.P594820I_W594820IA_FormParent;


public class CustomersDC {
    String custNumber; //User logged in
    String alphaName; //User logged in
    String alias; //User to be refered
    //Querying Service Orders
    String soFilter;
    String soType;
    P5848APP_W5848APPA_FormParent customersAlias_FormParent = new P5848APP_W5848APPA_FormParent();
    P594820I_W594820IA_FormParent serviceOrders_FormParent = new P594820I_W594820IA_FormParent();

    //Creating Service Orders
    String serialFilter;
    P551701S_W551701SA_FormParent productList_FormParent = new P551701S_W551701SA_FormParent();

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

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    public void setSoFilter(String soFilter) {
        this.soFilter = soFilter;
    }

    public String getSoFilter() {
        return soFilter;
    }

    public void setSoType(String soType) {
        this.soType = soType;
    }

    public String getSoType() {
        return soType;
    }

    public void setSerialFilter(String serialFilter) {
        this.serialFilter = serialFilter;
    }

    public String getSerialFilter() {
        return serialFilter;
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

    public void setProductList_FormParent(P551701S_W551701SA_FormParent productList_FormParent) {
        this.productList_FormParent = productList_FormParent;
    }

    public P551701S_W551701SA_FormParent getProductList_FormParent() {
        return productList_FormParent;
    }

    public void getCustomersAliasList() {
        setCustNumber(ApplicationGlobals.getInstance().getLoginResponse().getUsername());
        setAlphaName(ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getAlphaName());

        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P5848APP_W5848APPA");
        formRequest.setVersion("");
        formRequest.setFormServiceAction("R");

        FSREvent custAliasFSREvent = new FSREvent();
        custAliasFSREvent.setFieldValue("30", getCustNumber()); //set search type to parent customer

        custAliasFSREvent.doControlAction("15"); // Trigger the Find Button
        formRequest.addFSREvent(custAliasFSREvent); //add the events to the form request
        try {
            //Serialize the form request to JSON String
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();

            // Call to JDERestServiceProvider with parameters JSON string
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);

            //deserialize the response to the class for the form
            customersAlias_FormParent =
                (P5848APP_W5848APPA_FormParent) JSONBeanSerializationHelper.fromJSON(P5848APP_W5848APPA_FormParent.class,
                                                                                     response);
            if (customersAlias_FormParent.getFs_P5848APP_W5848APPA().getData().getGridData().getRowset().length == 0) {
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.manager}", false);
                setAlias(getCustNumber());
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.alias}", getCustNumber());
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", getAlphaName());
            }
        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }

    public void getRecentServiceOrders() {
        setSoFilter(null);
        setSoType(null);
        setAlias((String) AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.alias}"));
        getServiceOrdersList();
    }

    public void getServiceOrdersList() {
        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P594820I_W594820IA");
        formRequest.setVersion("DICIPA001");
        formRequest.setFormServiceAction("R");
        formRequest.setMaxPageSize("20");
        //FI

        FSREvent w594820IAFSREvent = new FSREvent();
        w594820IAFSREvent.setFieldValue("695", getAlias());
        //FC
        if (soFilter != null && soFilter.trim().length() > 0) {
            //set Service Order filter  in QBE
            w594820IAFSREvent.setQBEValue("1[424]", "*" + soFilter.trim() + "*");
        } else if (soType != null && soType.trim().length() > 0) {
            w594820IAFSREvent.setQBEValue("1[10]", soType.trim());
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

    public void getProductsList() {
        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P551701S_W551701SA");
        formRequest.setVersion("DICIPA001");
        formRequest.setFormServiceAction("R");
        formRequest.setMaxPageSize("100");
        FSREvent findProductFSREvent = new FSREvent();
        findProductFSREvent.setQBEValue("1[83]", getAlias());
        if (serialFilter != null && serialFilter.trim().length() > 0) {
            findProductFSREvent.setQBEValue("1[86]", "*" + serialFilter.trim() + "*");
        }
        findProductFSREvent.doControlAction("14"); //TriggertheFindButton
        formRequest.addFSREvent(findProductFSREvent); //addtheeventstotheformrequest
        try {
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);
            P551701S_W551701SA_FormParent temp_findProduct_FormParent =
                (P551701S_W551701SA_FormParent) JSONBeanSerializationHelper.fromJSON(P551701S_W551701SA_FormParent.class,
                                                                                     response);

            productList_FormParent.getFs_P551701S_W551701SA().getData().getGridData().setRowsetWithList(temp_findProduct_FormParent.getFs_P551701S_W551701SA().getData().getGridData().retrieveRowsetList());

        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }


}
