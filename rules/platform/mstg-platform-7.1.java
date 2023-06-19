public class WebAppInterface {
    Context mContext;
    WebAppInterface(Context c) {
        mContext = c;
    }
    @JavascriptInterface
    public void showToast(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
    public void showToast2(String toast) {
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }
}