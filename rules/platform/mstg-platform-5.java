public class MainActivity extends AppCompatActivity {
  
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WebView webview = new WebView(this);
        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        setContentView(webview);
        
        WebView webview2 = new WebView(this);
        setContentView(webview2);
        webview2.getSettings().setJavaScriptEnabled(true);
 
    }
}

