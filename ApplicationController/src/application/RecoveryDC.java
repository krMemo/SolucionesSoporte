package application;

import com.oracle.e1.jdemf.ApplicationGlobals;
import com.oracle.e1.jdemf.CapabilityException;
import com.oracle.e1.jdemf.DefaultConfig;
import com.oracle.e1.jdemf.FSREvent;
import com.oracle.e1.jdemf.FormRequest;
import com.oracle.e1.jdemf.JDERestServiceException;
import com.oracle.e1.jdemf.JDERestServiceProvider;

import com.oracle.e1.jdemf.JDEmfCapability;
import com.oracle.e1.jdemf.JDEmfUtilities;
import com.oracle.e1.jdemf.LoginConfiguration;

import com.oracle.e1.jdemf.LoginRequest;
import com.oracle.e1.jdemf.LoginResponse;

import com.oracle.e1.jdemf.disconnected.E1Connect;
import com.oracle.e1.jdemf.disconnected.E1Disconnected;

import com.oracle.e1.jdemf.mobile.LoginDC;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.el.ELContext;
import javax.el.ValueExpression;

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

import oracle.adfmf.util.BundleFactory;
import oracle.adfmf.util.Utility;
import oracle.adfmf.util.logging.Trace;

import ynk.supports.FormErrorWarningMobile;
import ynk.supports.p5698ows.P5698OWS_W5698OWSB_FormParent;

public class RecoveryDC {
    FormErrorWarningMobile[] errors;
    
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    @SuppressWarnings("oracle.jdeveloper.java.field-transient-in-non-serializable-class")
    protected transient ProviderChangeSupport errorChangeSupport = new ProviderChangeSupport(this);

    public void addProviderChangeListener(ProviderChangeListener l) {
        errorChangeSupport.addProviderChangeListener(l);
    }

    public void removeProviderChangeListener(ProviderChangeListener l) {
        errorChangeSupport.removeProviderChangeListener(l);
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


    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }
    
    
    public RecoveryDC() {
        super();
    }
    
    public void getPassword() {
        String userID = (String)AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.recoveryUser}");
        String email = (String)AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.recoveryMail}");
        
        if ((userID == null || email == null) || (userID.trim() == "" || email.trim() == "")){
            throw new AdfException("Favor de capturar su No. de Cliente y Correo.", AdfException.ERROR);
        }
        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P5698OWS_W5698OWSB");
        formRequest.setVersion("");
        formRequest.setFormServiceAction("R");

        FSREvent w5698OWSBFSREvent = new FSREvent();
        //FC
        w5698OWSBFSREvent.setFieldValue("22", userID);
        w5698OWSBFSREvent.setFieldValue("24", email);
        w5698OWSBFSREvent.doControlAction("15"); //TriggertheFindButton
        formRequest.addFSREvent(w5698OWSBFSREvent); //addtheeventstotheformrequest
        try {
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);
            P5698OWS_W5698OWSB_FormParent temp_passRecovery_FormParent =
                (P5698OWS_W5698OWSB_FormParent) JSONBeanSerializationHelper.fromJSON(P5698OWS_W5698OWSB_FormParent.class,
                                                                                     response);
            clearErrors();
            if (temp_passRecovery_FormParent.getFs_P5698OWS_W5698OWSB().getErrors() != null &&
                temp_passRecovery_FormParent.getFs_P5698OWS_W5698OWSB().getErrors().length > 0) {
                setErrors(temp_passRecovery_FormParent.getFs_P5698OWS_W5698OWSB().getErrors());
            } else {
                w5698OWSBFSREvent.doControlAction("31");
                formRequest.addFSREvent(w5698OWSBFSREvent);
                jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
                postData = jsonObject.toString();
                response =
                    JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                              JDERestServiceProvider.FORM_SERVICE_URI);
                temp_passRecovery_FormParent =
                    (P5698OWS_W5698OWSB_FormParent) JSONBeanSerializationHelper.fromJSON(P5698OWS_W5698OWSB_FormParent.class,
                                                                                         response);
                @SuppressWarnings("unused")
                Object errorMsg = AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                          "popupUtilsShowPopup", new Object[] {
                                                                          "_popShowId" });
            }
        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }

    public void clearErrors() {
        setErrors(null);
    }
    
}
