package com.salesforce.androidsdk.phonegap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
  //
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
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
import com.salesforce.androidsdk.security.Encryptor;
import com.salesforce.androidsdk.ui.SalesforceGapViewClient;

/**
 * PhoneGap plugin for Salesforce OAuth.
 */
public class CredentialStoragePlugin extends  Plugin {
	public static SharedPreferences s_pref;
	
	String Key="D/rwdMPEQbfq/eeKlzVkTw==";
	
	/**
	 * Supported plugin actions that the client can take.
	 */
	enum Action {
		getAuthCredentials,
		setAuthCredentials
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
				case setAuthCredentials:    return setAuthCredentials(args, callbackId);  
				case getAuthCredentials: 	return getAuthCredentials(callbackId);
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
		
		//String username=Encryptor.decrypt(s_pref.getString("username", ""),Key);
		String username=s_pref.getString("username", "");
		//String password=Encryptor.decrypt(s_pref.getString("password", ""),Key);
		String password=s_pref.getString("password", "");
		
		if (username == null || password==null) {
			Log.w("SalesforceOAuthPlugin.getAuthCredentials", "getAuthCredentials failed - never authenticated");
			return new PluginResult(PluginResult.Status.ERROR, "Never authenticated");
		}
		else {
			Log.i("SalesforceOAuthPlugin.getAuthCredentials", "getAuthCredentials successful");
			return new PluginResult(PluginResult.Status.OK, getJSONCredentials(username,password));
		}
	}
	
	private static JSONObject getJSONCredentials(String username,String password) {
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", username);
		data.put("password", password);
	
		return new JSONObject(data);
    }

	/**
	 * Native implementation for "authenticate" action
	 * @param args The arguments used for authentication.
	 * @param callbackId The callback ID used when calling back into Javascript.
	 * @return NO_RESULT since authentication is asynchronous.
	 * @throws JSONException 
	 */
	protected PluginResult setAuthCredentials(JSONArray args, final String callbackId) throws JSONException {
		Log.i("SalesforceOAuthPlugin.authenticate", "authenticate called");
		JSONObject oauthProperties = (JSONObject)args.get(0);
		//Credentials credentials= parseCredentials(oauthProperties);
		
		//String username = Encryptor.encrypt(oauthProperties.getString("username"),Key);
		String username = oauthProperties.getString("username");
		//String password = Encryptor.encrypt(oauthProperties.getString("password"), Key);
		String password = oauthProperties.getString("password");
		
		Editor editor=s_pref.edit();
		editor.putString("username", username);
		editor.putString("password", password);
		editor.commit();
		
		
		////yyyyyyyyyyyyyyySA
		
		PluginResult noop = new PluginResult(PluginResult.Status.NO_RESULT,"ttt");
		noop.setKeepCallback(true);
		return noop;
	}

	private static JSONObject getJSONCredentials() {
		String username;
		String password;
		
		
		username=s_pref.getString("username","");
		password=s_pref.getString("password","");
		
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", username);
		data.put("password", password);
		return new JSONObject(data);
    }
}
