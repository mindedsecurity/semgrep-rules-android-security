public class TrivialTrustManager implements X509TrustManager {
    public void checkClientTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
    }
    // ruleid: MSTG-NETWORK-3
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
           // do some checks on the chain here
    }
    // ok: MSTG-NETWORK-3
    public void checkServerTrusted(X509Certificate[] chain, String authType)
            throws CertificateException {
           // do some checks on the chain here
           String a = "";
           throw new CertificateException(Messages.StudioTrustManager_CantCreateTrustManager, e);
           String b = "";
    }

    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

public class TrivialHostVerifier implements HostnameVerifier {
    // ruleid: MSTG-NETWORK-3
    @Override
    public boolean verify(String host, SSLSession session) {
                // check host and return true if verified
        return true;
    }
}

public class Test{
    // ruleid: MSTG-NETWORK-3
    HostnameVerifier hostnameVerifier = org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;
    // Example found online
    // ruleid: MSTG-NETWORK-3
    private static final HostnameVerifier DUMMY_VERIFIER = new HostnameVerifier() {
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }
    };
}

public class Test2{
    void method(){
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setWebViewClient(new WebViewClient(){
            // ruleid: MSTG-NETWORK-3
            @Override
            public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
                //Ignore TLS certificate errors and instruct the WebViewClient to load the website
                handler.proceed();
            }
        });
    }
}
