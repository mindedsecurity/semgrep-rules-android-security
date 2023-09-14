public class MainActivity extends AppCompatActivity {
    private void test(){
        // ok: MSTG-STORAGE-9
        getWindow().setFlags(8192,
                8192);
    }
    private void test2(){
        Window window = activity.getWindow();
        // ok: MSTG-STORAGE-9
        window.setFlags(8192,
                8192);
        // ruleid: MSTG-STORAGE-9
        window.setFlags(1024,
                1024);
    }
}
