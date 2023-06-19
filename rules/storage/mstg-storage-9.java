public class MainActivity extends AppCompatActivity {
    private void test(){
        getWindow().setFlags(8192,
                8192);
    }
    private void test2(){
        Window window = activity.getWindow();
        window.setFlags(8192,
                8192);
        window.setFlags(1024,
                1024);
    }

}
