package mobile;

import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.FeatureContext;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.java.beans.PropertyChangeListener;
import oracle.adfmf.java.beans.PropertyChangeSupport;

@SuppressWarnings("oracle.jdeveloper.java.tag-is-missing")
public class StartBean {
    private Boolean manager = true;
    private String soType;
    private String aliasname;
    private String recoveryUser;
    private String recoveryMail;
    boolean isPopupOpen = true;
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private String alias;

    public void setIsPopupOpen(boolean isPopupOpen) {
        this.isPopupOpen = isPopupOpen;
    }
    
    public boolean isIsPopupOpen() {
        return isPopupOpen;
    }


    public void setManager(Boolean manager) {
        this.manager = manager;
    }

    public Boolean getManager() {
        return manager;
    }

    public void setSoType(String soType) {
        String oldSoType = this.soType;
        this.soType = soType;
        propertyChangeSupport.firePropertyChange("soType", oldSoType, soType);
    }

    public String getSoType() {
        return soType;
    }


    public void setAliasname(String aliasname) {
        String oldAliasname = this.aliasname;
        this.aliasname = aliasname;
        propertyChangeSupport.firePropertyChange("aliasname", oldAliasname, aliasname);
    }

    public String getAliasname() {
        return aliasname;
    }


    public void setRecoveryUser(String recoveryUser) {
        this.recoveryUser = recoveryUser;
    }

    public String getRecoveryUser() {
        return recoveryUser;
    }

    public void setRecoveryMail(String recoveryMail) {
        this.recoveryMail = recoveryMail;
    }

    public String getRecoveryMail() {
        return recoveryMail;
    }

    public StartBean() {
    }

    
    /*================== =========== ==================*/
    /*================== NAVIGATION  ==================*/
    /*================== =========== ==================*/
    
    public String gotoLogin() {
        AdfmfJavaUtilities.setELValue("#{applicationScope.logout}", "1");
        AdfmfJavaUtilities.setELValue("#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}",
                                      "http://201.161.1.59:87");
        AdfmfContainerUtilities.resetFeature("com.oracle.e1.jdemf.login");
        AdfmfJavaUtilities.setELValue("#{bindings.username1.inputValue}", "84002");
        return null;
    }
    
    public void handleNavigation() {
        //Code to naviagte within task flows programmatically
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Customers", "adf.mf.api.amx.doNavigation", new Object[]{"__back"});
    }
    
    /*================== =========== ==================*/
    /*================== POPUPHANDLE ==================*/
    /*================== =========== ==================*/

    @SuppressWarnings("unused")
    public void onPopupShowHideAction(ActionEvent actionEvent) {
        Object errorMsg =
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                      "popupUtilsShowPopup", new Object[] {
                                                                      "_popShowId" });
    }

    @SuppressWarnings("unused")
    public void closePopup(ActionEvent actionEvent) {
        Object errorMsg =
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                      "popupUtilsHidePopup", new Object[] {
                                                                      "_popCloseId" });
        AdfmfContainerUtilities.gotoFeature("MainMenu");
    }

    @SuppressWarnings("unused")
    public void closePopupRecovery(ActionEvent actionEvent) {
        Object errorMsg =
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                      "popupUtilsHidePopup", new Object[] {
                                                                      "_popCloseId" });
        AdfmfContainerUtilities.resetFeature("LoginDicipa");
        AdfmfContainerUtilities.gotoFeature("LoginDicipa");
    }

    /*================== =========== ==================*/
    /*================== SPRINGBOARD ==================*/
    /*================== =========== ==================*/
    Boolean springboardVisible;

    public void setSpringboardVisible(Boolean springboardVisible) {
        this.springboardVisible = springboardVisible;
    }

    public Boolean getSpringboardVisible() {
        return springboardVisible;
    }

    public String showCustomSpringboard() {
        AdfmfContainerUtilities.showSpringboard();
        setSpringboardVisible(true);
        return null;
    }

    public String hideCustomSpringboard() {
        AdfmfContainerUtilities.hideSpringboard();
        setSpringboardVisible(false);
        return null;
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }
}
