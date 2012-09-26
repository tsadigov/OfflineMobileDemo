package com.salesforce.androidsdk.phonegap;

import org.json.JSONArray;

import android.util.Log;

import com.phonegap.CameraLauncher;
import com.phonegap.api.PluginResult;

public class MyCameraLauncher extends CameraLauncher {
	@Override
	public PluginResult execute(String actionStr, JSONArray args, String callbackId) {
		try{
			return super.execute(actionStr, args, callbackId);
		}catch(Exception exp){
			Log.e("MyCameraLauncher:", "error when executing camera plugin : "+exp.getMessage());
		}
		return null;
	}

}
