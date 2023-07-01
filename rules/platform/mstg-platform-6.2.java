public class TestClass {

    protected boolean getBoolean() {

        return false;

    }
  
    protected void test() {

        
        WebView webview2 = new WebView(this);
        String url = "ftp://127.0.0.1";
        webview2.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webview2.getSettings().setAllowFileAccess(true);
        webview2.getSettings().setAllowContentAccess(true);
        webview2.getSettings().setAllowFileAccessFromFileURLs(this.getBoolean());
        webview2.loadUrl(url);
 
    }

    protected void test2() {

        
        WebView webview2 = new WebView(this);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        String url = "ftp://127.0.0.1";
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccessFromFileURLs(this.getBoolean());
        webview2.loadUrl(url);
 
    }
}