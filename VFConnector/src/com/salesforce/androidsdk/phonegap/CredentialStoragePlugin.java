package com.salesforce.androidsdk.phonegap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;

import com.phonegap.api.PhonegapActivity;
import com.phonegap.api.Plugin;
import com.phonegap.api.PluginResult;
import com.salesforce.androidsdk.app.ForceApp;
import com.salesforce.androidsdk.auth.HttpAccess.NoNetworkException;
import com.salesforce.androidsdk.rest.ClientManager;
import com.salesforce.androidsdk.rest.ClientManager.LoginOptions;
import com.salesforce.androidsdk.rest.ClientManager.RestClientCallback;
import com.salesforce.androidsdk.rest.RestClient;
import com.salesforce.androidsdk.rest.RestClient.AsyncRequestCallback;
import com.salesforce.androidsdk.rest.RestClient.ClientInfo;
import com.salesforce.androidsdk.rest.RestRequest;
import com.salesforce.androidsdk.rest.RestResponse;
import com.salesforce.androidsdk.ui.SalesforceGapViewClient;

/**
 * PhoneGap plugin for Salesforce OAuth.
 */
public class CredentialStoragePlugin extends  Plugin {
	
	
	/**
	 * Supported plugin actions that the client can take.
	 */
	enum Action {
		getCredentials,
		setCredentials
	}
	
	
	/**
     * Executes the plugin request and returns PluginResult.
     * 
     * @param actionStr     The action to execute.
     * @param args          JSONArray of arguments for the plugin.
     * @param callbackId    The callback ID used when calling back into JavaScript.
     * @return              A PluginResult object with a status and message.
     */
    public PluginResult execute(String actionStr, JSONArray args, String callbackId) {
    	Log.i("SalesforceOAuthPlugin.execute", "actionStr: " + actionStr);
    	// Figure out action
    	Action action = null;
    	try {
    		action = Action.valueOf(actionStr);
			switch(action) {
				case getCredentials:       	return authenticate(args, callbackId);  
				case setCredentials: 	return getAuthCredentials(callbackId);
				default: return new PluginResult(PluginResult.Status.INVALID_ACTION, actionStr); // should never happen
	    	}
    	}
    	catch (IllegalArgumentException e) {
    		return new PluginResult(PluginResult.Status.INVALID_ACTION, e.getMessage());
    	}
    	catch (JSONException e) {
    		return new PluginResult(PluginResult.Status.JSON_EXCEPTION, e.getMessage());    		
    	}
    }
    
    
    /**
	 * Native implementation for "getAuthCredentials" action.
	 * @param callbackId The callback ID used when calling back into Javascript.
	 * @return The plugin result (ok if authenticated, error otherwise).
	 * @throws JSONException
	 */
	protected PluginResult getAuthCredentials(String callbackId) throws JSONException {
		Log.i("SalesforceOAuthPlugin.getAuthCredentials", "getAuthCredentials called");
		Activity act;act.getsh Context. act.get
		SharedPreferences pref=
	
		if (client == null) {
			Log.w("SalesforceOAuthPlugin.getAuthCredentials", "getAuthCredentials failed - never authenticated");
			return new PluginResult(PluginResult.Status.ERROR, "Never authenticated");
		}
		else {
			Log.i("SalesforceOAuthPlugin.getAuthCredentials", "getAuthCredentials successful");
			return new PluginResult(PluginResult.Status.OK, getJSONCredentials(client));
		}
	}
}
