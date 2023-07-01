public class WebAppInterface extends WebView {
    Context mContext;
    public void test4(){
        addJavascriptInterface(new MSTG_ENV_008_JS_Interface(this), "Android");
    }
}