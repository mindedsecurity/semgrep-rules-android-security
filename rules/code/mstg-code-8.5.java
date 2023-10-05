public class ThreadReferenceLeakActivity extends AppCompatActivity {    
    private static LeakyThread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        createThread();
        redirectToNewScreen();
    }

    private void createThread() {
        thread = new LeakyThread();
        thread.start();
    }

    private void redirectToNewScreen() {
        startActivity(new Intent(this, SecondActivity.class));
    }
    // ruleid: MSTG-CODE-8.5
    private class LeakyThread extends Thread {
        @Override
        public void run() {
            while (true) {
            }
        }
    }
