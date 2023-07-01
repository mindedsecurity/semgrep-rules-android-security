public class MainActivity extends AppCompatActivity {
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        
        WebView webview2 = new WebView(this);
        setContentView(webview2);
        String url = "ftp://127.0.0.1";
        webview2.getSettings().setAllowUniversalAccessFromFileURLs(false);
        webview2.getSettings().setJavaScriptEnabled(true);
        
        webview2.getSettings().setAllowFileAccess(false);
        webview2.getSettings().setAllowContentAccess(false);
        webview2.getSettings().setAllowFileAccessFromFileURLs(false);
        webview2.loadUrl(url);
 
    }
}

