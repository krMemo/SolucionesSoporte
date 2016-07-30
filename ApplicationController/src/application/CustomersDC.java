package application;

import com.oracle.e1.jdemf.ApplicationGlobals;
import com.oracle.e1.jdemf.FSREvent;

import com.oracle.e1.jdemf.FormRequest;

import com.oracle.e1.jdemf.JDERestServiceException;
import com.oracle.e1.jdemf.JDERestServiceProvider;

import java.util.Calendar;

import oracle.adfmf.framework.FeatureContext;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONObject;

import ynk.supports.FormErrorWarningMobile;
import ynk.supports.p551701s.P551701S_W551701SA_FormParent;
import ynk.supports.p5848app.P5848APP_W5848APPA_FormParent;
import ynk.supports.p591771i.P591771I_W591771IA_FormParent;
import ynk.supports.p594820i.P594820I_W594820IA;
import ynk.supports.p594820i.P594820I_W594820IA_FormParent;


public class CustomersDC {
    //Querying Customers Alias
    String custNumber; //User logged in
    String alphaName; //User logged in
    String alias; //User to be refered
    P5848APP_W5848APPA_FormParent customersAlias_FormParent = new P5848APP_W5848APPA_FormParent();
    //Querying Service Orders
    Calendar dateFilter = Calendar.getInstance();
    String soFilter = "";
    String soType = "2";
    String isClosed = "false";
    P594820I_W594820IA_FormParent serviceOrders_FormParent = new P594820I_W594820IA_FormParent();

    //Querying Products
    String serialFilter;
    String familyFilter;
    P551701S_W551701SA_FormParent productList_FormParent = new P551701S_W551701SA_FormParent();
    //Creating Service Orders
    String issueDesc;
    String contactName;
    String phoneContact;
    String serialProduct;
    String businessUnit;
    String custId;
    String descProductId;
    String secondItemNo;
    String parentItemNo;
    String assetNumber;
    String prodFamily;
    String priority;
    String umo;
    String wr02;
    String orderNumber;
    P591771I_W591771IA_FormParent createOS_FormParent = new P591771I_W591771IA_FormParent();

    FormErrorWarningMobile[] errors;
    FormErrorWarningMobile[] warnings;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    @SuppressWarnings("oracle.jdeveloper.java.field-transient-in-non-serializable-class")
    protected transient ProviderChangeSupport errorChangeSupport = new ProviderChangeSupport(this);

    public void addProviderChangeListener(ProviderChangeListener l) {
        errorChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        errorChangeSupport.removeProviderChangeListener(l);
    }

    public void clearErrors() {
        setErrors(null);
        setWarnings(null);
    }

    public void setErrors(FormErrorWarningMobile[] errors) {
        int oldCount = 0;
        if (this.errors != null) {
            oldCount = this.errors.length;
        }
        int newCount = 0;
        if (errors != null) {
            newCount = errors.length;
        }
        this.errors = errors;
        errorChangeSupport.fireProviderRefresh("errors");
        propertyChangeSupport.firePropertyChange("errorCount", oldCount, newCount);
    }

    public FormErrorWarningMobile[] getErrors() {
        return errors;
    }

    public int getErrorCount() {
        if (errors != null) {
            return errors.length;
        } else {
            return 0;
        }
    }

    public void setWarnings(FormErrorWarningMobile[] warnings) {
        FormErrorWarningMobile[] oldWarnings = this.warnings;
        this.warnings = warnings;
        propertyChangeSupport.firePropertyChange("warnings", oldWarnings, warnings);
    }

    public FormErrorWarningMobile[] getWarnings() {
        return warnings;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public CustomersDC() {
        getCustomersAliasList();
    }

    public void setCustNumber(String custNumber) {
        this.custNumber = custNumber;
    }

    public String getCustNumber() {
        if (AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.user}")=="50")
            return "50";
        return custNumber;
    }

    public void setAlphaName(String alphaName) {
        this.alphaName = alphaName;
    }

    public String getAlphaName() {
        return alphaName;
    }

    public String getAlias() {
        return (String) AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.alias}");
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

    public void setIsClosed(String isClosed) {
        this.isClosed = isClosed;
    }

    public String getIsClosed() {
        return isClosed;
    }

    public void setSerialFilter(String serialFilter) {
        this.serialFilter = serialFilter;
    }

    public String getSerialFilter() {
        return serialFilter;
    }


    public void setFamilyFilter(String familyFilter) {
        this.familyFilter = familyFilter;
    }

    public String getFamilyFilter() {
        return familyFilter;
    }

    public void setIssueDesc(String issueDesc) {
        this.issueDesc = issueDesc;
    }

    public String getIssueDesc() {
        return issueDesc;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactName() {
        return contactName;
    }

    public void setPhoneContact(String phoneContact) {
        this.phoneContact = phoneContact;
    }

    public String getPhoneContact() {
        return phoneContact;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderNumber() {
        return orderNumber;
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
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.alias}", getCustNumber());
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", getAlphaName());
            } else {
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.manager}", true);
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.alias}", "");
                AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", "");
            }
        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }

    @SuppressWarnings("oracle.jdeveloper.java.insufficient-catch-block")
    public void getRecentServiceOrders() {
        try {
            serviceOrders_FormParent.setFs_P594820I_W594820IA(new P594820I_W594820IA());
            if (!AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.alias}").equals(null)) {
                setSoFilter(null);
                setIsClosed("false");
                getServiceOrdersList();
            }
        } catch (NullPointerException e) {

        }
    }

    public String getLastServiceOrder() {
        soFilter = "";
        isClosed = "false";
        getRecentServiceOrders();
        return this.serviceOrders_FormParent.getMnPegtoWO_424ForRow(0);
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
        } else {
            if (soType == null || soType.trim().length() == 0) 
                setSoType("2");
            w594820IAFSREvent.setQBEValue("1[10]", soType.trim());
            if(isClosed != null && isClosed.equals("true")){
                w594820IAFSREvent.setQBEValue("1[9]", "M7");
                dateFilter = Calendar.getInstance();
                dateFilter.add(Calendar.MONTH, -1);
                String date = ">=" + dateFilter.get(Calendar.DATE) + "/";
                date += (dateFilter.get(Calendar.MONTH)+1) + "/";
                date += dateFilter.get(Calendar.YEAR); 
                w594820IAFSREvent.setQBEValue("1[145]", date); 
            } else {
                w594820IAFSREvent.setQBEValue("1[9]", "!=M7");    
            }
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
        } else if (familyFilter != null && familyFilter.trim().length() > 0) {
            findProductFSREvent.setFieldValue("205", familyFilter.trim());
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

    public void createServiceOrder(String serialProduct, String descProductId, String businessUnit, String custId,
                                   String assetNumber, String parentItemNo, String secondItemNo, String priority,
                                   String umo, String wr02, String prodFamily, String soType) {

        boolean success = false;
        String error = "";
        this.serialProduct = serialProduct;
        this.businessUnit = businessUnit.trim();
        this.custId = custId.trim();
        this.descProductId = descProductId.trim();
        this.secondItemNo = secondItemNo.trim();
        this.parentItemNo = parentItemNo.trim();
        this.assetNumber = assetNumber.trim();
        this.prodFamily = prodFamily.trim();
        this.priority = priority.trim();
        this.umo = umo.trim();
        this.wr02 = wr02.trim();
        this.soType = soType.trim();
        if (this.getSoType() == null || this.getSoType().isEmpty()) {
            error = "Tipo";
        }
        if (this.getIssueDesc() == null || this.getIssueDesc().isEmpty()) {
            if (error == "")
                error = "Descripción";
            else
                error += ", Descripción";
        }
        if (this.getContactName() == null || this.getContactName().equals("")) {
            if (error == "")
                error = "Responsable";
            else
                error += ", Responsable";
        }
        if (this.getPhoneContact() == null || this.getPhoneContact().equals("")) {
            if (error == "")
                error = "Teléfono";
            else
                error += ", Teléfono";
        }
        if (error != "") {
            throw new AdfException("Favor de capturar: " + error + ".", AdfException.ERROR);
        }

        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P591771I_W591771IA");
        formRequest.setVersion("DICIPA001");
        formRequest.setFormServiceAction("C");

        /** De P594820I a P591771I new order **/
        formRequest.addToFISet("33", "0"); //mnX4801JobNumber
        formRequest.addToFISet("34", "0"); //cCopyWorkOrderDetails
        formRequest.addToFISet("17", this.custId); //Address Number
        formRequest.addToFISet("35", getAlias()); //mnServiceAddressNumber_SAID
        formRequest.addToFISet("38", "V01"); //PO szNoVisita_WR06
        formRequest.addToFISet("41", "0"); //cAction
        formRequest.addToFISet("31", this.businessUnit);

        FSREvent createSOFSREvent = new FSREvent();
        //createSOFSREvent.setFieldValue("76", "26/05/2016"); //Visible Serial Product
        //createSOFSREvent.setFieldValue("225", "18:20:00"); //Visible Serial Product
        createSOFSREvent.setFieldValue("41", this.serialProduct); //Visible Serial Product
        createSOFSREvent.setFieldValue("445", getAlias()); //Visible Cust Alias
        createSOFSREvent.setFieldValue("47", this.issueDesc); // Visible Issue
        createSOFSREvent.setFieldValue("28", this.contactName); //Visible Contacto szUsuario_VR02
        createSOFSREvent.setFieldValue("84", this.phoneContact); //Visible Phone Status Comment STCM
        createSOFSREvent.setFieldValue("22", this.custId); //Customer Long Address Number ALKY
        createSOFSREvent.setFieldValue("45", this.descProductId); //Product Model PRODM
        createSOFSREvent.setFieldValue("49", this.secondItemNo); //Item Number _ UITM
        createSOFSREvent.setFieldValue("57", this.parentItemNo.trim()); //Item Number Short
        createSOFSREvent.setFieldValue("55", this.assetNumber); //Asset Number
        createSOFSREvent.setFieldValue("150", this.priority); //Priority 201 / 200
        createSOFSREvent.setFieldValue("321", this.umo); // UMO  200
        createSOFSREvent.setFieldValue("118", this.wr02); //wr02
        createSOFSREvent.setFieldValue("458", this.prodFamily); //prodFamily
        createSOFSREvent.setFieldValue("26", this.soType); //TYPS (tipo de mtto)
        createSOFSREvent.doControlAction("11");
        formRequest.addFSREvent(createSOFSREvent);


        try {
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);

            createOS_FormParent =
                (P591771I_W591771IA_FormParent) JSONBeanSerializationHelper.fromJSON(P591771I_W591771IA_FormParent.class,
                                                                                     response);
            clearErrors();
            if (createOS_FormParent.getFs_P591771I_W591771IA().getErrors() != null &&
                createOS_FormParent.getFs_P591771I_W591771IA().getErrors().length > 0) {
                setErrors(createOS_FormParent.getFs_P591771I_W591771IA().getErrors());
            } else if (createOS_FormParent.getFs_P591771I_W591771IA().getWarnings() != null &&
                       createOS_FormParent.getFs_P591771I_W591771IA().getWarnings().length > 0) {
                setErrors(createOS_FormParent.getFs_P591771I_W591771IA().getWarnings());
            } else {
                success = true;
            }
        } catch (JDERestServiceException e) {
            System.out.println(e.getMessage().toString());
            // JDERestServiceProvider.handleServiceException(e);
            success = true;
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
        if (success == true) {
            setOrderNumber(getLastServiceOrder());
            @SuppressWarnings("unused")
            Object errorMsg =
                AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                          "popupUtilsShowPopup", new Object[] {
                                                                          "_popShowId" });
        } else {
            throw new AdfException("No fue posible generar el reporte, favor de reintentar o llamar al Call Center al 01 800 284 2000.",
                                   AdfException.INFO);
        }
    }

}
