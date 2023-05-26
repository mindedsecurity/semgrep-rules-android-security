public class StaticReferenceLeakActivity extends AppCompatActivity {
    private static TextView textView;
    private static Activity activity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        
        textView = findViewById(R.id.activity_text);
        textView.setText("Bad Idea!");
           
        activity = this;
    }
}