package com.wcarmona.cordova.plugin;

// Vibrator API
import android.os.Vibrator;
// Cordova-required packages
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;

public class VibrationPlugin extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) {
        try {
            if (action.equals("vibrate")) {
                String vibrationType = args.getString(0);
                this.vibrate(vibrationType, callbackContext);
                return true;
            } else {
                callbackContext.error("\"" + action + "\" is not a recognized action.");
                return false;
            }
        } catch (JSONException e) {
            callbackContext.error("Error encountered: " + e.getMessage());
            return false;
        }
    }

    private void vibrate(String vibrationType, CallbackContext callbackContext) {
        Vibrator vibrator = (Vibrator) cordova.getActivity().getSystemService(cordova.getActivity().VIBRATOR_SERVICE);
        long[] pattern = new long[0];

        switch (vibrationType) {
            case "error":
                pattern = new long[]{0, 100, 100, 100, 100, 100};
                break;
            case "success":
                pattern = new long[]{0, 200, 100, 200};
                break;
            case "warning":
                pattern = new long[]{0, 300, 150, 300};
                break;
            case "info":
                pattern = new long[]{0, 50, 50, 50};
                break;
        }

        if (vibrator != null) {
            vibrator.vibrate(pattern, -1); // -1: no repeat
        }
        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK);
        callbackContext.sendPluginResult(pluginResult);
    }
}
