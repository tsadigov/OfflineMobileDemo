package com.salesforce.androidsdk.phonegap;

import android.net.http.SslError;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;

import com.phonegap.DroidGap;
import com.salesforce.androidsdk.ui.SalesforceGapViewClient;

public class MyViewClient extends SalesforceGapViewClient {
	public MyViewClient(DroidGap droidGap, DroidGap ctx) {
		super(droidGap,ctx);
	}
	
	 @Override
	    public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
	        // testing against getPrimaryError() or hasErrors() will fail on Honeycomb or older.
	        // You might check for something different, such as specific info in the certificate,
	        //if (error.getPrimaryError() == SslError.SSL_IDMISMATCH) {
		 		Log.e(TAG,"SSL error in myViewClient : "+error.getPrimaryError());
	            handler.proceed();
	        //} else {
	        //    super.onReceivedSslError(view, handler, error);
	        //}
	    }
}
