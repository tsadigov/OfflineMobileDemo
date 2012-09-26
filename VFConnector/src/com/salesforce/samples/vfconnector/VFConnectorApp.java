/*
 * Copyright (c) 2011, salesforce.com, inc.
 * All rights reserved.
 * Redistribution and use of this software in source and binary forms, with or
 * without modification, are permitted provided that the following conditions
 * are met:
 * - Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 * - Neither the name of salesforce.com, inc. nor the names of its contributors
 * may be used to endorse or promote products derived from this software without
 * specific prior written permission of salesforce.com, inc.
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.salesforce.samples.vfconnector;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import android.app.Activity;
import android.content.SharedPreferences;

import com.salesforce.androidsdk.app.ForceApp;
import com.salesforce.androidsdk.phonegap.CredentialStoragePlugin;
import com.salesforce.androidsdk.phonegap.MyMainActivity;
import com.salesforce.androidsdk.ui.SalesforceDroidGapActivity;
import com.salesforce.androidsdk.ui.SalesforceR;
import android.content.*;
import android.preference.*;

/**
 * Application class 
 * All Salesforce mobile apps must extend ForceApp. 
 * ForceApp takes care of intializing the network http clients (among other things).x
 */
public class VFConnectorApp extends ForceApp {

	private SalesforceR salesforceR = new SalesforceRImpl();
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		SharedPreferences preferences=PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
		CredentialStoragePlugin.s_pref=preferences;
		
		/*
	    //--------------------------------------------
		 
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{
		    new X509TrustManager() {
		        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
		            return null;
		        }
		        public void checkClientTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		        public void checkServerTrusted(
		            java.security.cert.X509Certificate[] certs, String authType) {
		        }
		    }
		};

		// Install the all-trusting trust manager
		try {
		    SSLContext sc = SSLContext.getInstance("SSL");
		    sc.init(null, trustAllCerts, new java.security.SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		}
		*/
		//--------------------------
	}
	
	@Override
	public Class<? extends Activity> getMainActivityClass() {		
		return MyMainActivity.class;
	}
	
	@Override
	protected String getKey(String name) {
		return null; 
	}

	@Override
	public SalesforceR getSalesforceR() {
		return salesforceR;
	}
}
