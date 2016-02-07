package mobile;


import oracle.adfmf.amx.event.ActionEvent;
import oracle.adfmf.framework.FeatureContext;
import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;

public class StartBean {
    private String soType;
    boolean isPopupOpen = true;

    public void setIsPopupOpen(boolean isPopupOpen) {
        this.isPopupOpen = isPopupOpen;
    }

    public boolean isIsPopupOpen() {
        return isPopupOpen;
    }

    public void setSoType(String soType) {
        this.soType = soType;
    }

    public String getSoType() {
        return soType;
    }
    
    public StartBean() {
    }

    
    /*================== =========== ==================*/
    /*================== NAVIGATION  ==================*/
    /*================== =========== ==================*/
    
    public String gotoLogin() {
        AdfmfJavaUtilities.setELValue((String)"#{applicationScope.logout}", (Object)"1");
        AdfmfJavaUtilities.setELValue((String)"#{preferenceScope.feature.com.oracle.e1.jdemf.login.Connection.URL}", (Object)"http://201.161.1.59:87");
        AdfmfContainerUtilities.resetFeature((String)"com.oracle.e1.jdemf.login");
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
}
