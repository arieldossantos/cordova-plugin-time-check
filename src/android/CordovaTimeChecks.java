package io.github.arieldossantos;

import android.os.Build;
import android.provider.Settings;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

public class CordovaTimeChecks extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        boolean ret = false;
        if(action.equals("isAutomaticTimeZone")) {
                ret = isAutomaticTimeZone(callbackContext);
        }
        return ret;
    }

    private boolean isAutomaticTimeZone(CallbackContext cb) {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if(Settings.Global.getInt(this.cordova.getActivity().getContentResolver(), Settings.Global.AUTO_TIME, 0) == 1) {
                    cb.success("true");
                } else {
                    cb.error("false");
                }
                return true;
            } else {
                if(android.provider.Settings.System.getInt(this.cordova.getActivity().getContentResolver(), android.provider.Settings.System.AUTO_TIME, 0) == 1) {
                    cb.success("true");
                } else {
                    cb.error("false");
                }
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
