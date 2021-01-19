package cordovaPluginCookieFlush;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.webkit.CookieManager;
import android.os.Build.VERSION;

/**
* Ensures all cookies currently accessible through the getCookie API are written to persistent storage.
* This call will block the caller until it is done and may perform I/O.
*/
public class CookieFlush extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
    if (action.equals("flush")) {
      this.flush(callbackContext);
      return true;
    }
    return false;
  }

  private void flush(CallbackContext callbackContext) {
    if (VERSION.SDK_INT < 21) {
      callbackContext.error("[CookieFlush]: Unsupported API Level. Required v21");
    } else {
      CookieManager.getInstance().flush();
      callbackContext.success();
    }
  }
}
