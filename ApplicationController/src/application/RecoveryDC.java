package application;

//import com.oracle.e1.jdemf.mobile.AboutValues;
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
import com.oracle.e1.jdemf.disconnected.DBConnectionFactory;
import com.oracle.e1.jdemf.disconnected.E1Connect;
import com.oracle.e1.jdemf.disconnected.E1Disconnected;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javax.el.ValueExpression;

import oracle.adfmf.framework.FeatureContext;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.GeneratedPassword;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;
import oracle.adfmf.java.beans.ProviderChangeListener;
import oracle.adfmf.java.beans.ProviderChangeSupport;
import oracle.adfmf.json.JSONObject;
import oracle.adfmf.util.BundleFactory;
import oracle.adfmf.util.Utility;

import ynk.supports.FormErrorWarningMobile;
import ynk.supports.p559803.P559803_W559803A_FormParent;
import ynk.supports.p5698ows.P5698OWS_W5698OWSB_FormParent;

public class RecoveryDC {

    public RecoveryDC() {
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    FormErrorWarningMobile[] errors;
    @SuppressWarnings("oracle.jdeveloper.java.field-transient-in-non-serializable-class")
    protected transient ProviderChangeSupport errorChangeSupport = new ProviderChangeSupport(this);
    // LOGIN
    Boolean TEST_ENVIROMENT = false;
    private DefaultConfig defaultConfig = new DefaultConfig();
    private LoginRequest loginRequest = new LoginRequest();
    private LoginResponse loginResponse = new LoginResponse();
    private boolean displayEnvironment = false;
    private boolean displayRole = false;
    private boolean displayJas = false;
    private String url;
    //private boolean urlError = false;
    private String username = "";
    private String password = "";
    private String environment;
    private String role;
    private String jasserver;
    private boolean ssoEnabled;
    private boolean ssoServerSetting;
    private boolean defaultFeatureError = false;
    private String sqlusername;
    private String sqlpassword;
    private String sqlenvironment;
    private String sqlrole;
    //Recovery 
    private String recoveryUser = "recovery";
    private String recoveryPass = "123456";
    //private Connection conn;
    @SuppressWarnings("oracle.jdeveloper.java.field-transient-in-non-serializable-class")
    private transient PropertyChangeSupport propertyChangeSupport;

    public void recoverPassword() {
        String userID = (String) AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.recoveryUser}");
        String email = (String) AdfmfJavaUtilities.getELValue("#{applicationScope.startBean.recoveryMail}");

        if ((userID == null || email == null) || (userID.trim() == "" || email.trim() == "")) {
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
                Object errorMsg =
                    AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                              "popupUtilsShowPopup", new Object[] {
                                                                              "_popShowId" });
            }
        } catch (JDERestServiceException e) {
            JDERestServiceProvider.handleServiceException(e);
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }
    }
    
    P559803_W559803A_FormParent logEvent_FormParent = new P559803_W559803A_FormParent();
    
    public void logEventLogin() {
        FormRequest formRequest = new FormRequest();
        formRequest.setFormName("P559803_W559803A");
        formRequest.setVersion("");
        formRequest.setFormServiceAction("C");

        FSREvent w559803AFSREvent = new FSREvent();
        w559803AFSREvent.setFieldValue("15", "84002");//getUsername());
        w559803AFSREvent.setFieldValue("17", "SS_Login");
        w559803AFSREvent.doControlAction("11"); //TriggertheFindButton
        formRequest.addFSREvent(w559803AFSREvent); //addtheeventstotheformrequest
        try {
            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(formRequest);
            String postData = jsonObject.toString();
            String response =
                JDERestServiceProvider.jdeRestServiceCall(postData, JDERestServiceProvider.POST,
                                                          JDERestServiceProvider.FORM_SERVICE_URI);

            logEvent_FormParent =
                (P559803_W559803A_FormParent) JSONBeanSerializationHelper.fromJSON(P559803_W559803A_FormParent.class,
                                                                                     response);
            clearErrors();
            if (logEvent_FormParent.getFs_P559803_W559803A().getErrors() != null &&
                logEvent_FormParent.getFs_P559803_W559803A().getErrors().length > 0) {
                setErrors(logEvent_FormParent.getFs_P559803_W559803A().getErrors());
            } else if (logEvent_FormParent.getFs_P559803_W559803A().getWarnings() != null &&
                       logEvent_FormParent.getFs_P559803_W559803A().getWarnings().length > 0) {
                setErrors(logEvent_FormParent.getFs_P559803_W559803A().getWarnings());
            }
            AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getAlphaName());

        } catch (JDERestServiceException e) {
            System.out.println(e.getMessage().toString());
        } catch (Exception e) {
            throw new AdfException(e.getMessage(), AdfException.ERROR);
        }  
    }

    public void clearErrors() {
        setErrors(null);
    }

    
    /*******************************************************/
    /************************ LOGIN ************************/
    /*******************************************************/

    public void login(boolean recovery) {
        if (TEST_ENVIROMENT){
            setUsername("87.84002");
            setPassword("DCP84002");
        }
        if (getUsername().startsWith("87.")) {
            AdfmfJavaUtilities.setELValue("#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}",
                                          "http://201.149.35.59:87");
            setUsername(getUsername().substring(3));
        } else {
            AdfmfJavaUtilities.setELValue("#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}",
                                          "http://201.149.35.59:89");
        }
        if (recovery) {
            setUsername(recoveryUser);
            setPassword(recoveryPass);
            LoginConfiguration.setDefaultFeature("PassRecovery");
        } else {
            LoginConfiguration.setDefaultFeature("Customers");
        }
        
        this.loadDefaultConfig();
        this.processLoginRequest(false);
        logEventLogin();
    }

    public void initLoginFeature() {
        AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "true");
        ApplicationGlobals.getInstance().setLoginSuccess(false);
        ValueExpression ve1 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.logout}", String.class);
        String logout = (String) ve1.getValue(AdfmfJavaUtilities.getELContext());
        if (logout != null && logout.trim().length() > 0 && logout == "1") {
            ValueExpression ve2 = AdfmfJavaUtilities.getValueExpression("#{applicationScope.logout}", String.class);
            ve2.setValue(AdfmfJavaUtilities.getELContext(), "");
            this.setUsername("");
            this.setPassword("");
            this.setEnvironment("");
            this.setRole("");
            this.setJasserver("");
        }
        ResourceBundle resourceBundle =
            BundleFactory.getBundle("com.oracle.e1.jdemf.bundle.jdemfResourceBundle", Locale.getDefault(),
                                    RecoveryDC.class.getClassLoader());
        AdfmfJavaUtilities.setELValue("#{applicationScope.okTrans}", resourceBundle.getString("OK"));
    }

    public void loadDefaultConfig() {
        block30:
        {
            this.initLoginFeature();
            String requiredCapList = JDEmfCapability.listOfRequired();
            try {
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.urlError}", "0");
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.capabilityError}", "0");

                ValueExpression ve1 =
                    AdfmfJavaUtilities.getValueExpression("#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}",
                                                          String.class);
                this.url = (String) ve1.getValue(AdfmfJavaUtilities.getELContext());

                if (this.url != null) {
                    String response;
                    if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
                        try {
                            E1Disconnected.getSqlDbConnection();
                        } catch (Exception ex) {
                            Utility.ApplicationLogger.severe(ex.getMessage());
                            ex.printStackTrace();
                            throw new RuntimeException(ex);
                        }
                    }
                    boolean skipProcessing = false;
                    if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
                        if (AdfmfJavaUtilities.getELValue("#{applicationScope.connected}").toString().equalsIgnoreCase("true")) {
                            try {
                                response =
                                    JDERestServiceProvider.jdeRestServiceCallwURL(this.url, "", "GET",
                                                                                  ("defaultconfig?requiredCapabilities=" +
                                                                                   requiredCapList), "StartApp");
                                this.defaultConfig =
                                    (DefaultConfig) JSONBeanSerializationHelper.fromJSON((Class) DefaultConfig.class,
                                                                                         (String) response);
                            } catch (CapabilityException ce) {
                                skipProcessing = true;
                                //this.aboutValuesFromLocalDB();
                                AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
                            } catch (Exception e) {

                                skipProcessing = true;
                                //this.aboutValuesFromLocalDB();
                                AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
                            }
                        } else {
                            skipProcessing = true;
                            //this.aboutValuesFromLocalDB();
                        }
                    } else {
                        response =
                            JDERestServiceProvider.jdeRestServiceCallwURL(this.url, "", "GET",
                                                                          "defaultconfig?requiredCapabilities=" +
                                                                          requiredCapList, "StartApp");
                        this.defaultConfig =
                            (DefaultConfig) JSONBeanSerializationHelper.fromJSON((Class) DefaultConfig.class,
                                                                                 (String) response);
                    }
                    if (!skipProcessing) {
                        AdfmfJavaUtilities.setELValue("#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}",
                                                      this.url);
                        ApplicationGlobals.getInstance().setServerURL(this.url);
                        ApplicationGlobals.getInstance().setDefaultConfig(this.defaultConfig);
                        ApplicationGlobals.getInstance().setCapabilityList(this.defaultConfig.getCapabilityList());

                        JDEmfCapability.capabilityDetectCheck(this.defaultConfig);
                        this.setDisplayEnvironment(this.defaultConfig.isDisplayEnvironment());
                        this.setDisplayRole(this.defaultConfig.isDisplayRole());
                        this.setDisplayJas(this.defaultConfig.isDisplayJasServer());
                        if (this.defaultConfig.getDefaultEnvironment().length() != 0) {
                            this.setEnvironment(this.defaultConfig.getDefaultEnvironment());
                        }
                        if (this.defaultConfig.getDefaultRole().length() != 0) {
                            this.setRole(this.defaultConfig.getDefaultRole());
                        }
                        if (this.defaultConfig.getDefaultJasServer().length() != 0) {
                            this.setJasserver(this.defaultConfig.getDefaultJasServer());
                        }
                        this.setSsoServerSetting(this.defaultConfig.isSsoAllowed());
                        if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
                            this.setSsoEnabled(false);
                        } else if (this.ssoServerSetting) {
                            this.setSsoEnabled(JDEmfUtilities.isSSOEnabled());
                        }
                        this.loginRequest.setDeviceName();
                        LoginRequest lRequest = ApplicationGlobals.getInstance().getLoginOverrides();
                        if (lRequest != null) {
                            if (lRequest.getUsername().length() != 0) {
                                this.setUsername(lRequest.getUsername());
                            }
                            if (lRequest.getPassword().length() != 0) {
                                this.setPassword(lRequest.getPassword());
                            }
                            if (lRequest.getEnvironment().length() != 0) {
                                this.setEnvironment(lRequest.getEnvironment());
                            }
                            if (lRequest.getRole().length() != 0) {
                                this.setRole(lRequest.getRole());
                            }
                            if (lRequest.getJasserver().length() != 0) {
                                this.setJasserver(lRequest.getJasserver());
                            }
                        }
                        if (this.ssoServerSetting && this.ssoEnabled) {
                            this.processLoginRequest(true);
                        }
                    }
                    break block30;
                }
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.urlError}", "1");
            } catch (CapabilityException ce) {
                AdfmfJavaUtilities.setELValue("#{pageFlowScope.capabilityError}", "1");
            } catch (Exception e) {
                if (e.getClass() != AdfException.class) {
                    AdfmfJavaUtilities.setELValue("#{pageFlowScope.urlError}", "1");
                }
                throw (AdfException) e;
            }
        }
    }

    public void processLoginRequest(boolean suppressError) {
        block31:
        {
            if (ApplicationGlobals.getInstance().isDisconnectedApp() &&
                AdfmfJavaUtilities.getELValue("#{applicationScope.connected}").toString().equalsIgnoreCase("true")) {
                ApplicationGlobals.getInstance().setConnectedCheck(false);
                try {
                    if (this.url != null && this.url.trim().length() > 0) {
                        E1Connect.jdeRestServiceCallConnectionCheck(this.url, "", "GET", "defaultconfig", "StartApp");
                        AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "true");
                    }
                } catch (CapabilityException ce) {
                    ApplicationGlobals.getInstance().setConnectedCheck(true);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
                } catch (Exception e) {
                    ApplicationGlobals.getInstance().setConnectedCheck(true);
                    AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
                }
            }
            if (ApplicationGlobals.getInstance().isDisconnectedApp() &&
                AdfmfJavaUtilities.getELValue("#{applicationScope.connected}").toString().equalsIgnoreCase("false")) {
                String defaultFeature = ApplicationGlobals.getInstance().getDefaultFeature();
                if (this.disconnectedLoginRequest() &&
                    ((defaultFeature) == null || defaultFeature.trim().length() != 0)) {
                    AdfmfContainerUtilities.resetFeature(defaultFeature);
                }
            } else {
                if (JDEmfUtilities.logoutOnURLConfigChange()) {
                    if (this.ssoServerSetting && !ApplicationGlobals.getInstance().isDisconnectedApp()) {
                        JDEmfUtilities.saveSSOEnabled(this.ssoEnabled);
                    }
                    this.loginRequest.setUsername(this.username);
                    this.loginRequest.setPassword(this.password);
                    this.loginRequest.setEnvironment(this.environment);
                    this.loginRequest.setRole(this.role);
                    this.loginRequest.setJasserver(this.jasserver);
                    this.loginRequest.setApplicationName(ApplicationGlobals.getInstance().getApplicationName());
                    this.loginRequest.setSsoEnabled(this.ssoEnabled);

                    ResourceBundle resourceBundle =
                        BundleFactory.getBundle("com.oracle.e1.jdemf.bundle.jdemfResourceBundle", Locale.getDefault(),
                                                RecoveryDC.class.getClassLoader());
                    if (this.ssoEnabled ||
                        this.loginRequest.getPassword() != null && this.loginRequest.getUsername() != null) {
                        try {
                            JSONObject jsonObject = (JSONObject) JSONBeanSerializationHelper.toJSON(this.loginRequest);
                            String postData = jsonObject.toString();
                            String response =
                                JDERestServiceProvider.jdeRestServiceCall(postData, "POST", "tokenrequest", "StartApp");
                            LoginResponse newLoginResponse =
                                (LoginResponse) JSONBeanSerializationHelper.fromJSON((Class) LoginResponse.class,
                                                                                     (String) response);
                            this.setLoginResponse(newLoginResponse);
                            ApplicationGlobals.getInstance().setLoginResponse(this.loginResponse);
                            ApplicationGlobals.getInstance().setLoginSuccess(true);
                            if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
                                E1Disconnected.initTimeoutValues();
                                E1Disconnected.setDisconnectedTimeoutValue();
                            }
                            try {
                                this.defaultFeatureError = false;
                                String defaultFeature = ApplicationGlobals.getInstance().getDefaultFeature();
                                if (defaultFeature == null || defaultFeature.trim().length() == 0) {
                                    String exception =
                                        "The default feature has not been set.  Default feature = " + defaultFeature;
                                    AdfException adfe = new AdfException(exception, "ERROR");
                                    this.defaultFeatureError = true;
                                    throw adfe;
                                }
                                JDEmfUtilities.e1LocaleOverride();

                                if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
                                    this.disconnectedSaveLogin();
                                }
                                AdfmfContainerUtilities.resetFeature(defaultFeature);
                                break block31;
                            } catch (AdfException e) {
                                ApplicationGlobals.getInstance().setConnectedCheck(true);

                                if (e != null && e.getMessage() != null) {
                                    if (e.getMessage().indexOf("405") >= 0) {
                                        String exception = resourceBundle.getString("ADMIN_ERROR");

                                        AdfException adfe = new AdfException(exception, "ERROR");
                                        throw adfe;
                                    }
                                    if (e.getMessage().indexOf("403") >= 0) {
                                        String exception = resourceBundle.getString("AUTH_ERROR");

                                        AdfException adfe = new AdfException(exception, "ERROR");
                                        throw adfe;
                                    }
                                    if (this.defaultFeatureError) {
                                        AdfmfJavaUtilities.setELValue("#{applicationScope.serviceError}", null);
                                        AdfmfJavaUtilities.setELValue("#{pageFlowScope.urlError}", null);
                                        AdfmfJavaUtilities.setELValue("#{applicationScope.hideLogin}", null);

                                        throw e;
                                    }

                                    throw e;
                                }
                                String exception = resourceBundle.getString("DEFAULT_ERROR");

                                AdfException adfe = new AdfException(exception, "ERROR");
                                throw adfe;
                            }
                        } catch (Exception e) {
                            ApplicationGlobals.getInstance().setConnectedCheck(true);
                            if (suppressError)
                                break block31;
                            if (e.getClass() == AdfException.class) {
                                AdfException adfe = (AdfException) e;
                                throw adfe;
                            }
                            if (e != null && e.getMessage() != null) {
                                if (e.getMessage().indexOf("405") >= 0) {
                                    String exception = resourceBundle.getString("ADMIN_ERROR");

                                    AdfException adfe = new AdfException(exception, "ERROR");
                                    throw adfe;
                                }
                                if (e.getMessage().indexOf("403") >= 0) {
                                    String exception = resourceBundle.getString("AUTH_ERROR");

                                    AdfException adfe = new AdfException(exception, "ERROR");
                                    throw adfe;
                                }
                                if (e.getMessage().indexOf("445") >= 0 || e.getMessage().indexOf("446") >= 0) {

                                    AdfmfJavaUtilities.setELValue("#{applicationScope.serviceError}", "");
                                    AdfmfJavaUtilities.setELValue("#{pageFlowScope.urlError}", "0");
                                    AdfmfJavaUtilities.setELValue("#{applicationScope.hideLogin}", "0");
                                } else {
                                    if (e.getMessage().indexOf("500") >= 0 && e.getMessage().indexOf("Username") >= 0 ||
                                        e.getMessage().indexOf("500") >= 0 && e.getMessage().indexOf("Password") >= 0) {
                                        String exception = resourceBundle.getString("USER_REQ_ERROR");

                                        AdfException adfe = new AdfException(exception, "ERROR");
                                        throw adfe;
                                    }
                                    if (!e.getClass().equals(AdfException.class)) {
                                        String exception = resourceBundle.getString("DEFAULT_ERROR");

                                        AdfException adfe = new AdfException(exception, "ERROR");
                                        throw adfe;
                                    }
                                }
                                break block31;
                            }
                            String exception = resourceBundle.getString("DEFAULT_ERROR");

                            AdfException adfe = new AdfException(exception, "ERROR");
                            throw adfe;
                        }
                    }
                    String exception = resourceBundle.getString("USER_REQ_ERROR");

                    AdfException adfe = new AdfException(exception, "ERROR");
                    throw adfe;
                }
                this.loadDefaultConfig();
            }
        }
        if (ApplicationGlobals.getInstance().isDisconnectedApp()) {
            ApplicationGlobals.getInstance().setConnectedCheck(true);
        }
    }

    private boolean disconnectedLoginRequest() {
        boolean returnVal;
        block5:
        {
            returnVal = false;
            try {
                String response = E1Disconnected.localDBGet(1, "LOGINTABLE");
                if (response == null)
                    break block5;
                StringTokenizer tokens = new StringTokenizer(response, "|");
                ResourceBundle resourceBundle =
                    BundleFactory.getBundle("com.oracle.e1.jdemf.bundle.jdemfResourceBundle", Locale.getDefault(),
                                            RecoveryDC.class.getClassLoader());
                if (!E1Disconnected.isDisconnectedTimedOut()) {
                    if (tokens.countTokens() != 3)
                        break block5;
                    this.sqlusername = tokens.nextToken();
                    this.sqlenvironment = tokens.nextToken();
                    this.sqlrole = tokens.nextToken();
                    boolean pwdReturned = false;
                    String userPass = this.username.toUpperCase().trim() + this.password.toUpperCase().trim();
                    char[] cPW = GeneratedPassword.getPassword(userPass);
                    if (cPW != null && cPW.length > 0) {
                        pwdReturned = true;
                    }
                    if (this.sqlusername.equalsIgnoreCase(this.username) && pwdReturned) {
                        returnVal = true;
                        break block5;
                    }
                    String exception = resourceBundle.getString("AUTH_ERROR");

                    AdfException adfe = new AdfException(exception, "ERROR");
                    throw adfe;
                }
                String exception = resourceBundle.getString("TIMEOUT_ERROR");

                AdfException adfe = new AdfException(exception, "ERROR");
                throw adfe;
            } catch (Exception ex) {
                Utility.ApplicationLogger.severe(ex.getMessage());
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
        return returnVal;
    }

    private void disconnectedSaveLogin() {
        this.sqlusername = this.username.toUpperCase().trim();
        this.sqlpassword = this.password.toUpperCase().trim();
        this.sqlenvironment = this.environment.toUpperCase().trim();
        this.sqlrole = this.role.toUpperCase().trim();
        boolean newCreds = false;
        String userPass = this.sqlusername + this.sqlpassword;
        try {
            newCreds = DBConnectionFactory.isNewSQLDBCreated();
        } catch (Exception ex) {
            Utility.ApplicationLogger.fine(ex.getMessage());
            newCreds = true;
        }
        GeneratedPassword.setPassword(userPass, null);
        if (newCreds) {
            String loginCreds = this.sqlusername + "|" + this.sqlenvironment + "|" + this.sqlrole;
            try {
                E1Disconnected.createTable("LOGINTABLE");
                E1Disconnected.localDBInsert(1, "LOGINTABLE", loginCreds);
                //this.aboutValuesToLocalDB();
            } catch (Exception ex) {
                Utility.ApplicationLogger.severe(ex.getMessage());
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        }
    }

    /* private void aboutValuesToLocalDB() {
        try {
            AboutValues aV = new AboutValues();
            aV.setAbout_MobileAppID(ApplicationGlobals.getInstance().getAbout_MobileAppID());
            aV.setAbout_ApplicationName(ApplicationGlobals.getInstance().getAbout_ApplicationName());
            aV.setAbout_ApplicationVersion(ApplicationGlobals.getInstance().getAbout_ApplicationVersion());
            aV.setAisServerURL(ApplicationGlobals.getInstance().getAisServerURL());
            if (ApplicationGlobals.getInstance().getDefaultConfig() != null) {
                aV.setDefaultConfig(new DefaultConfig());
                aV.getDefaultConfig().setAisVersion(ApplicationGlobals.getInstance().getDefaultConfig().getAisVersion());
            }
            if (ApplicationGlobals.getInstance().getLoginResponse() != null) {
                aV.setLoginResponse(new LoginResponse());
                aV.getLoginResponse().setJasserver(ApplicationGlobals.getInstance().getLoginResponse().getJasserver());
                aV.getLoginResponse().setEnvironment(ApplicationGlobals.getInstance().getLoginResponse().getEnvironment());
                aV.getLoginResponse().setRole(ApplicationGlobals.getInstance().getLoginResponse().getRole());
                if (ApplicationGlobals.getInstance().getLoginResponse().getUserInfo() != null) {
                    aV.getLoginResponse().setUserInfo(new UserInfo());
                    aV.getLoginResponse().getUserInfo().setAlphaName(ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getAlphaName());
                    aV.getLoginResponse().getUserInfo().setSimpleDateFormat(ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().getSimpleDateFormat());
                }
                aV.getLoginResponse().setVersion(ApplicationGlobals.getInstance().getLoginResponse().getVersion());
            }
            JSONObject jsonAGObject = (JSONObject) JSONBeanSerializationHelper.toJSON(aV);
            String postAGData = jsonAGObject.toString();
            E1Disconnected.localDBInsert(2, "LOGINTABLE", postAGData);
        } catch (Exception ex) {
            Utility.ApplicationLogger.severe(ex.getMessage());
            ex.printStackTrace();
        }
    }

    private void aboutValuesFromLocalDB() {
        try {
            String response = E1Disconnected.localDBGet(2, "LOGINTABLE");
            AboutValues aG =
                (AboutValues) JSONBeanSerializationHelper.fromJSON((Class) AboutValues.class, (String) response);
            ApplicationGlobals.getInstance().setAbout_ApplicationName(aG.getAbout_ApplicationName());
            ApplicationGlobals.getInstance().setAbout_ApplicationVersion(aG.getAbout_ApplicationVersion());
            ApplicationGlobals.getInstance().setAisServerURL(aG.getAisServerURL());
            ApplicationGlobals.getInstance().setAbout_MobileAppID(aG.getAbout_MobileAppID());
            if (aG.getDefaultConfig() != null) {
                ApplicationGlobals.getInstance().setDefaultConfig(new DefaultConfig());
                ApplicationGlobals.getInstance().getDefaultConfig().setAisVersion(aG.getDefaultConfig().getAisVersion());
            }
            if (aG.getLoginResponse() != null) {
                ApplicationGlobals.getInstance().setLoginResponse(new LoginResponse());
                ApplicationGlobals.getInstance().getLoginResponse().setJasserver(aG.getLoginResponse().getJasserver());
                ApplicationGlobals.getInstance().getLoginResponse().setEnvironment(aG.getLoginResponse().getEnvironment());
                ApplicationGlobals.getInstance().getLoginResponse().setRole(aG.getLoginResponse().getRole());
                if (aG.getLoginResponse().getUserInfo() != null) {
                    ApplicationGlobals.getInstance().getLoginResponse().setUserInfo(new UserInfo());
                    ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().setAlphaName(aG.getLoginResponse().getUserInfo().getAlphaName());
                    ApplicationGlobals.getInstance().getLoginResponse().getUserInfo().setSimpleDateFormat(aG.getLoginResponse().getUserInfo().getSimpleDateFormat());
                }
                ApplicationGlobals.getInstance().getLoginResponse().setVersion(aG.getLoginResponse().getVersion());
            }
        } catch (Exception ex) {
            Utility.ApplicationLogger.severe(ex.getMessage());
            ex.printStackTrace();
        }
    } */

    public void logout() {
        DBConnectionFactory.closeConnection();
        if (ApplicationGlobals.getInstance().isDisconnectedApp() &&
            AdfmfJavaUtilities.getELValue("#{applicationScope.connected}").toString().equalsIgnoreCase("true")) {
            try {
                if (this.url != null && this.url.trim().length() > 0) {
                    E1Connect.jdeRestServiceCallConnectionCheck(this.url, "", "GET", "defaultconfig", "StartApp");
                    AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "true");
                }
            } catch (CapabilityException ce) {
                AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
            } catch (Exception e) {
                AdfmfJavaUtilities.setELValue("#{applicationScope.connected}", "false");
            }
        }
        if (AdfmfJavaUtilities.getELValue("#{applicationScope.connected}").toString().equalsIgnoreCase("true") &&
            ApplicationGlobals.getInstance().isLoginSuccess()) {
            /*  JDEmfUtilities.logout();
        } else { */
            AdfmfJavaUtilities.setELValue("#{applicationScope.logout}", "1");
            AdfmfContainerUtilities.resetFeature("StartApp");
            AdfmfJavaUtilities.setELValue("#{applicationScope.startBean.aliasname}", "");

        }
    }

    public void timeoutBackToLogin() {
        AdfmfJavaUtilities.setELValue("#{applicationScope.serviceError}", null);
        this.loadDefaultConfig();
    }
    
     /*******************************************************/
     /****************** SETTERS & GETTERS ******************/
     /*******************************************************/

    public void setDefaultConfig(DefaultConfig defaultConfig) {
        this.defaultConfig = defaultConfig;
    }

    public DefaultConfig getDefaultConfig() {
        return this.defaultConfig;
    }

    public void setLoginRequest(LoginRequest loginRequest) {
        this.loginRequest = loginRequest;
    }

    public LoginRequest getLoginRequest() {
        return this.loginRequest;
    }

    public void setLoginResponse(LoginResponse loginResponse) {
        this.loginResponse = loginResponse;
    }

    public LoginResponse getLoginResponse() {
        return this.loginResponse;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUsername(String username) {
        String oldUsername = this.username;
        this.username = username;
        this.propertyChangeSupport.firePropertyChange("username", (Object) oldUsername, (Object) username);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        this.propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        this.propertyChangeSupport.removePropertyChangeListener(l);
    }

    public String getUsername() {
        return this.username;
    }

    public void setPassword(String password) {
        String oldPassword = this.password;
        this.password = password;
        this.propertyChangeSupport.firePropertyChange("password", (Object) oldPassword, (Object) password);
    }

    public String getPassword() {
        return this.password;
    }

    public void setEnvironment(String environment) {
        String oldEnvironment = this.environment;
        this.environment = environment;
        this.propertyChangeSupport.firePropertyChange("environment", (Object) oldEnvironment, (Object) environment);
    }

    public String getEnvironment() {
        return this.environment;
    }

    public void setRole(String role) {
        String oldRole = this.role;
        this.role = role;
        this.propertyChangeSupport.firePropertyChange("role", (Object) oldRole, (Object) role);
    }

    public String getRole() {
        return this.role;
    }

    public void setJasserver(String jasserver) {
        String oldJasserver = this.jasserver;
        this.jasserver = jasserver;
        this.propertyChangeSupport.firePropertyChange("jasserver", (Object) oldJasserver, (Object) jasserver);
    }

    public String getJasserver() {
        return this.jasserver;
    }

    public void setDisplayEnvironment(boolean displayEnvironment) {
        boolean oldDisplayEnvironment = this.displayEnvironment;
        this.displayEnvironment = displayEnvironment;
        this.propertyChangeSupport.firePropertyChange("displayEnvironment", oldDisplayEnvironment, displayEnvironment);
    }

    public boolean isDisplayEnvironment() {
        return this.displayEnvironment;
    }

    public void setDisplayRole(boolean displayRole) {
        boolean oldDisplayRole = this.displayRole;
        this.displayRole = displayRole;
        this.propertyChangeSupport.firePropertyChange("displayRole", oldDisplayRole, displayRole);
    }

    public boolean isDisplayRole() {
        return this.displayRole;
    }

    public void setDisplayJas(boolean displayJas) {
        boolean oldDisplayJas = this.displayJas;
        this.displayJas = displayJas;
        this.propertyChangeSupport.firePropertyChange("displayJas", oldDisplayJas, displayJas);
    }

    public boolean isDisplayJas() {
        return this.displayJas;
    }

    public void setPropertyChangeSupport(PropertyChangeSupport propertyChangeSupport) {
        this.propertyChangeSupport = propertyChangeSupport;
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return this.propertyChangeSupport;
    }

    public void setSsoEnabled(boolean ssoEnabled) {
        boolean oldSsoEnabled = this.ssoEnabled;
        this.ssoEnabled = ssoEnabled;
        this.propertyChangeSupport.firePropertyChange("ssoEnabled", oldSsoEnabled, ssoEnabled);
    }

    public boolean isSsoEnabled() {
        return this.ssoEnabled;
    }

    public void setSsoServerSetting(boolean ssoServerSetting) {
        boolean oldSsoServerSetting = this.ssoServerSetting;
        this.ssoServerSetting = ssoServerSetting;
        this.propertyChangeSupport.firePropertyChange("ssoServerSetting", oldSsoServerSetting, ssoServerSetting);
    }

    public boolean isSsoServerSetting() {
        return this.ssoServerSetting;
    }
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
}
