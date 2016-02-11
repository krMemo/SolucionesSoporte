//This is an event that fires when the user presses the device back button 
document.addEventListener("deviceready", onDeviceReady, false); 

function onDeviceReady() { 
    document.addEventListener("backbutton", backKeyDown, true); 
};

function backKeyDown() { 
    //Check the device back button action happened in Employee.amx
    //Call the java method in managed bean 
    adf.mf.api.invokeMethod("mobile.StartBean", "handleNavigation", onInvokeSuccess, onFail); 
};

function onInvokeSuccess(param) { 
    //To do code after success 
}; 

function onFail() { 
    //To do code after failure 
};