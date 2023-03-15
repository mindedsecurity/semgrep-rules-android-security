import java.io.BufferedWriter;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        test();
    }
    private void test(){
        Log.v("tag", "key: " + variable);
        Log.i("tag", "key: " + password_secret_key + sec);
        Log.w("tag", "test: " + IV);
        Log.d("tag", "test: " + iv);
        Log.e("tag", "test: " + variable);
        Log.wtf("tag", "test: " + variable);
        System.out.print("key");
        System.err.print("key");

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
        FileOutputStream(FileDescriptor.out), "ASCII"), 512);
        out.write("key string");
        out.write('\n');
        out.flush();

        Logger x = new Logger();
        x.severe("key");
    }
}
