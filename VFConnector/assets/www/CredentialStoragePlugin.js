var CredentialStoragePlugin = {

    getAuthCredentials: function(success, fail) {
        return PhoneGap.exec(success, fail, "credentialStorage","getAuthCredentials",[]);
    },
    setAuthCredentials: function(success, fail,credentials) {
        PhoneGap.exec(success, fail, "credentialStorage","setAuthCredentials",credentials);
    }    
};
