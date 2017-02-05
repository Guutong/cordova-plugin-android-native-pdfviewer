package xyz.guutong.androidnativepdfviewer;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import xyz.guutong.androidpdfviewer.PdfViewActivity;
import android.content.Intent;

/**
 * This class echoes a string called from JavaScript.
 */
public class AndroidNativePdfViewer extends CordovaPlugin {
    private CallbackContext callbackContext;
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        
        if (action.equals("openPdfUrl")) {
            this.callbackContext = callbackContext;
            try {
                final String fileUrl = args.getString(0);
                final String title = args.getString(1);
                final JSONObject options = args.getJSONObject(2);
                String headerColor = "#1191d5";            
                boolean showScroll = false;            
                boolean swipeHorizontal = false;            
                boolean showShareButton = true;            
                boolean showCloseButton = true;            

                if (options.has("headerColor")) {
                    headerColor = options.getString("headerColor");    
                }
                
                if (options.has("showScroll")) {
                    showScroll = options.getBoolean("showScroll");
                }

                if (options.has("swipeHorizontal")) {
                    swipeHorizontal = options.getBoolean("swipeHorizontal");
                }

                if (options.has("showShareButton")) {
                    showShareButton = options.getBoolean("showShareButton");
                }

                if (options.has("showCloseButton")) {
                    showCloseButton = options.getBoolean("showCloseButton");
                }

                Intent intent = new Intent(cordova.getActivity(), PdfViewActivity.class);
                intent.putExtra(PdfViewActivity.EXTRA_PDF_URL, fileUrl);
                intent.putExtra(PdfViewActivity.EXTRA_PDF_TITLE, title);
                intent.putExtra(PdfViewActivity.EXTRA_TOOLBAR_COLOR, headerColor);
                intent.putExtra(PdfViewActivity.EXTRA_SHOW_SCROLL, showScroll);
                intent.putExtra(PdfViewActivity.EXTRA_SWIPE_HORIZONTAL, swipeHorizontal);
                intent.putExtra(PdfViewActivity.EXTRA_SHOW_SHARE_BUTTON, showShareButton);
                intent.putExtra(PdfViewActivity.EXTRA_SHOW_CLOSE_BUTTON, showCloseButton);

                cordova.startActivityForResult(this, intent, 0);
                callbackContext.success(fileUrl);
                return true;
            } catch (JSONException e) {
                callbackContext.error(e.getMessage());
            }
        } else {
            callbackContext.error("Invalid action: " + action);
            return false;
        }
        return false;
    }
}
