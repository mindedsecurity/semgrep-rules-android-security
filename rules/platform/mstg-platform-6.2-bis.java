public class WebAppInterface extends WebView {
    Context mContext;
    public void test4(){
        getSettings().setAllowUniversalAccessFromFileURLs(true);     
        getSettings().setAllowFileAccess(false);
        getSettings().setAllowContentAccess(true);
        getSettings().setAllowFileAccessFromFileURLs(false);
    }

}
