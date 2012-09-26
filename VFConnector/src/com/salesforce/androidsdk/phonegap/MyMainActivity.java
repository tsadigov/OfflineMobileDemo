package com.salesforce.androidsdk.phonegap;

import com.phonegap.DroidGap.GapViewClient;
import com.salesforce.androidsdk.ui.SalesforceDroidGapActivity;
import com.salesforce.androidsdk.ui.SalesforceGapViewClient;

public class MyMainActivity extends SalesforceDroidGapActivity {
	@Override
    protected GapViewClient createWebViewClient() {
		MyViewClient result = new MyViewClient(this,this);
    	return result;
    }

}
