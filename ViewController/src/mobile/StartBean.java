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
    private String user;
    private String pass;

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
    public void handleNavigation() {
        //Code to naviagte within task flows programmatically
        try {
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction("Customers", "adf.mf.api.amx.doNavigation", new Object[] {
                                                                      "__back" });
        } catch (Exception e) {
            this.logout();
        }
    }

    public String gotoMenu() {
        AdfmfContainerUtilities.resetFeature("Customers", true);
        hideCustomSpringboard();
        return null;
    }

    public String gotoEula() {
        AdfmfContainerUtilities.gotoFeature("EULA");
        return null;
    }

    public String logout() {
        AdfmfContainerUtilities.resetFeature("Customers");
        AdfmfContainerUtilities.resetFeature("StartApp", true);
        return null;
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
        AdfmfContainerUtilities.resetFeature("Customers", true);
    }

    @SuppressWarnings("unused")
    public void closePopupRecovery(ActionEvent actionEvent) {
        Object errorMsg =
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(FeatureContext.getCurrentFeatureId(),
                                                                      "popupUtilsHidePopup", new Object[] {
                                                                      "_popCloseId" });
        AdfmfContainerUtilities.resetFeature("StartApp", true);
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

    public void setUser(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    /*================== =========== ==================*/
    /*==================   BARCODE   ==================*/
    /*================== =========== ==================*/

    private String barcodeError = "";
    private String barcodeResult = "";
    private String barcodeFormat = "";
    private String barcodeCancelled = "";

    public void scanBarcode(ActionEvent event) {
        // Our AMX page includes a small JavaScript function which wraps the Cordova
        // barcode scanning function in a manner that makes it more suitable for invocation
        // from Java bean code. This is the function we are invoking below:
        AdfmfContainerUtilities.invokeContainerJavaScriptFunction(AdfmfJavaUtilities.getFeatureId(),
                                                                  "scanBarcodeFromJavaBean", new Object[] { });
    }


    public void setBarcodeError(String barcodeError) {
        String oldBarcodeError = this.barcodeError;
        this.barcodeError = barcodeError;
        propertyChangeSupport.firePropertyChange("barcodeError", oldBarcodeError, barcodeError);
    }

    public String getBarcodeError() {
        return barcodeError;
    }

    public void setBarcodeResult(String barcodeResult) {
        String oldBarcodeResult = this.barcodeResult;
        this.barcodeResult = barcodeResult;
        propertyChangeSupport.firePropertyChange("barcodeResult", oldBarcodeResult, barcodeResult);
    }

    public String getBarcodeResult() {
        return barcodeResult;
    }

    public void setBarcodeFormat(String barcodeFormat) {
        String oldBarcodeFormat = this.barcodeFormat;
        this.barcodeFormat = barcodeFormat;
        propertyChangeSupport.firePropertyChange("barcodeFormat", oldBarcodeFormat, barcodeFormat);
    }

    public String getBarcodeFormat() {
        return barcodeFormat;
    }

    public void setBarcodeCancelled(String barcodeCancelled) {
        String oldBarcodeCancelled = this.barcodeCancelled;
        this.barcodeCancelled = barcodeCancelled;
        propertyChangeSupport.firePropertyChange("barcodeCancelled", oldBarcodeCancelled, barcodeCancelled);
    }

    public String getBarcodeCancelled() {
        return barcodeCancelled;
    }
}
