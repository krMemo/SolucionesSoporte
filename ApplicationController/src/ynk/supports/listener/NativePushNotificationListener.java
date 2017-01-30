package ynk.supports.listener;

import application.RecoveryDC;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.Clock;

import java.time.Instant;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;

import oracle.adfmf.framework.api.AdfmfContainerUtilities;
import oracle.adfmf.framework.event.Event;
import oracle.adfmf.framework.exception.AdfException;
import oracle.adfmf.framework.api.AdfmfJavaUtilities;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.framework.api.MafNativeLocalNotificationOptions;
import oracle.adfmf.framework.event.NativeLocalNotificationEvent;

import oracle.adfmf.json.JSONObject;
import oracle.adfmf.framework.api.JSONBeanSerializationHelper;
import oracle.adfmf.util.BundleFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;


import oracle.adf.internal.model.rest.core.payload.json.JSONParserFactory;

import oracle.adfmf.framework.event.NativePushEvent;

import ynk.supports.response.PayloadServiceResponse;

public class NativePushNotificationListener implements oracle.adfmf.framework.event.EventListener {
    
    public final static String PUSH_MESSAGE             =   "#{applicationScope.push_message}";
    public final static String MCS_REGISTRATION_STRING  =   "#{applicationScope.mcsregistrationString}";
    public final static String PUSH_ERROR               =   "#{applicationScope.push_errorMessage}";
    public final static String PUSH_DEVICE_TOKEN         =   "#{applicationScope.deviceToken}";   
    protected LocalDateTime date;
       
    public NativePushNotificationListener() {
        super();
    }

    @Override
    public void onOpen(String id) {
        // TODO Implement this method
        System.out.println("on open push native notification id" + id);
        
        // Clear error in app scope
        AdfmfJavaUtilities.setELValue(PUSH_ERROR, null);        
       // Write the token into app scope        
        AdfmfJavaUtilities.setELValue(PUSH_DEVICE_TOKEN,id);
    }

    @Override
    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public void onMessage(Event event) {
        JSONBeanSerializationHelper jsonHelper = new JSONBeanSerializationHelper();
        Integer badgeNUm = AdfmfContainerUtilities.getApplicationIconBadgeNumber();
 
        System.out.println("on message push native notification " + event.getPayload());
               
        JSONObject payloadJson = null;
        PayloadServiceResponse serviceResponse =null;
            
        try{
           payloadJson =  new JSONObject(event.getPayload());          
           serviceResponse = (PayloadServiceResponse)jsonHelper.fromJSON(PayloadServiceResponse.class, payloadJson);
        }catch(Exception ex){
            System.err.println("There was a problem adding notification");
        }
        //set push message to application scope memory attribute for 
        //display in the view. 
        AdfmfJavaUtilities.setELValue(PUSH_MESSAGE, event.getPayload());  
        
        //ResourceBundle resourceBundle =
        //    BundleFactory.getBundle("com.oracle.e1.jdemf.bundle.jdemfResourceBundle", Locale.getDefault(),
        //                            NativePushNotificationListener.class.getClassLoader());
        
        //AdfmfJavaUtilities.setELValue( PUSH_MESSAGE, resourceBundle.getString("OK"));
        
        String appState = stringifyAppState(event.getApplicationState());
        
        /*
        try{
            AdfmfContainerUtilities.invokeContainerJavaScriptFunction(
                       AdfmfJavaUtilities.getFeatureName(),
                        "navigator.notification.alert",
                        new Object[] {event.getPayload(), "Support JBB"});
        }catch(Exception ex){
            System.out.println("error display message " + ex.toString() );
        }
       */
        
        try {
          // Configure local notification
          MafNativeLocalNotificationOptions options =
                        new MafNativeLocalNotificationOptions();
            
          options.setTitle("SSporte - Encuesta de Calidad");
          options.setAlert( "bg:" + badgeNUm + " " + payloadJson.getString("usuario") + "," + payloadJson.getString("msg"));
          //options.setAlert(serviceResponse.getCustomMessage());
          //options.setAlert("probando");
  
            if (date != null) {
                //date. setSeconds(0); // Clear the seconds component to fire on the minute
                ZonedDateTime zdt = date.atZone(ZoneOffset.UTC);
                LocalDateTime l = LocalDateTime.ofInstant(zdt.toInstant(),ZoneOffset.UTC);
                //options.setDate(date);
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                //notificationDate = dateFormat.format(date);
          }
            // Set the application badge to be '1' everytime notification is triggered
          //options.setBadge(1);
          // Play the default system sound when notification triggers
          options.setSound(MafNativeLocalNotificationOptions.SOUND_DEFAULT_SYSTEM);
          // Vibrate using default system vibration motion when notification triggers
          options.setVibration(
                     MafNativeLocalNotificationOptions.VIBRATION_DEFAULT_SYSTEM);

          // Add custom payload that is to be delivered through the local notification
          
          
          HashMap<String,Object> payload = new HashMap<String, Object>();

          payload.put("somenumber", 1);
          payload.put("somestring", "value2");
          payload.put("someboolean", true);
          options.setPayload(payload);
          
          // Schedule local notification
          String notificationID = AdfmfContainerUtilities.
                                  addLocalNotification(options); 
            
          
          //System.out.println("Notification added successfully. ID is "+notificationID);
            
          //AdfmfContainerUtilities.gotoFeature("encuestacalidad");
          
        }
        catch(Exception e) {
          System.err.println("There was a problem adding notification");
        }
        
    }
    
    private String stringifyAppState(int appState) {
        switch(appState) {
            case Event.APPLICATION_STATE_FOREGROUND: return "FOREGROUND";
            case Event.APPLICATION_STATE_BACKGROUND: return "BACKGROUND";
            case Event.APPLICATION_STATE_NOT_RUNNING: return "NOT RUNNING";
        }
        return "UNKNOWN";
    }

    @Override
    public void onError(AdfException error) {
        // TODO Implement this method
        System.out.println("on error push native notification error " + error);
        
       System.out.println(this.getClass().getSimpleName() + "PushHandler::onError"+
          "Message = " + error.getMessage() + "\nSeverity = " +
          error.getSeverity() + "\nType = " + error.getType());
        
       AdfmfJavaUtilities.setELValue(PUSH_ERROR, error.toString());
    }
}
