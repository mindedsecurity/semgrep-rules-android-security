public class WebAppInterface {
    Context mContext;
    public void test4(){
        MSTG_ENV_008_JS_Interface jsInterface = new MSTG_ENV_008_JS_Interface(this);

        myWebView.addJavascriptInterface(jsInterface, "Android");
    }
}