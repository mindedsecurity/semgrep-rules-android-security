public class BroadcastReceiverLeakActivity extends AppCompatActivity {

    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
    }

    private void registerBroadCastReceiver() {
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                //your receiver code goes here!
            }
        };
        registerReceiver(broadcastReceiver, new IntentFilter("SmsMessage.intent.MAIN"));
    }
    
    @Override
    protected void onStart() {
        super.onStart();
        registerBroadCastReceiver();
    }    

    @Override
    protected void onStop() {
        super.onStop();

        if(broadcastReceiver != null) {
            //unregisterReceiver(broadcastReceiver);
        }
    }
}