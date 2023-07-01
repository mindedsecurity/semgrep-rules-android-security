public class MainActivity extends WebView {
  
    protected void test() {        
        String url = "https://://127.0.0.1";
        getSettings().setAllowUniversalAccessFromFileURLs(false);
        getSettings().setJavaScriptEnabled(true);        
        getSettings().setAllowFileAccess(false);
        this.getSettings().setAllowContentAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(false);
        this.loadUrl(url); 
    }
}