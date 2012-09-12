     
     
//-----------------------------------------------------------------
// Replace the values below with your own app configuration values.
//-----------------------------------------------------------------

// When debugMode is true, logToConsole() messages will be written to a
// "debug console" section of the page.
var debugMode = true;

// The client ID value specified for your remote access object that defines
// your application in Salesforce.
var remoteAccessConsumerKey = "3MVG9y6x0357HlecUIiVeop.ptRVmE0nT9sRsaBJHU5i46RJcGltFoJcozsDca81rpTXX76l.bWJbp0UBdlRj";

// The redirect URI value specified for your remote access object that defines
// your application in Salesforce.
var oauthRedirectURI ="sfdc://succeess";// "onimobile:///mobilesdk/detect/oauth/done";

// The authorization/access scope(s) you wish to define for your application.
var oauthScopes = ["web", "api"];

//The start data associated with the application.  Use SFHybridApp.LocalAppStartData for a "local"
//PhoneGap-based application, and SFHybridApp.RemoteAppStartData for a Visualforce-based
//application.  The default representations are below, or you can look at the data
//classes in SFHybridApp.js to see how you can further customize your options.
//var startData = new SFHybridApp.LocalAppStartData();  // Used for local REST-based "index.html" PhoneGap apps.
var startData = new SFHybridApp.RemoteAppStartData("/apex/OfflineMobilePage","http://omni-developer-edition.na9.force.com",true); // Used for Visualforce-based apps.


// Whether the container app should automatically refresh our oauth session on app foreground:
// generally a good idea for Visualforce pages.  For REST-based apps we recommend using
// onAppResume to refresh if needed.
var autoRefreshOnForeground = true; //Use true for Visualforce-based apps

// Whether the container app should automatically refresh our oauth session periodically
var autoRefreshPeriodically = true; 

//-----------------------------------------------------------------
// End configuration block
//-----------------------------------------------------------------
        
            

