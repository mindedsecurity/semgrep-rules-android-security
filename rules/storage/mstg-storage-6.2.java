public class MainActivity extends AppCompatActivity {
    private void test(){
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText("simple secret", "Hello, World!");

        clipboard.setPrimaryClip(clip);
    }
}
