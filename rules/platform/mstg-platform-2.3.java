import android.content.Intent;

class A extends Activity{
	static void method(){
		Intent i = getIntent();
		// ruleid: MSTG-PLATFORM-2.3
		db.query("SELECT "+i.getData());
	}
	@Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.getStringExtra("methodName").equals("myMethod"){
			// ruleid: MSTG-PLATFORM-2.3
			db.query("SELECT "+ this.getActivity().getIntent().getDataString());
            myMethod();
        }
    }
}

public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String data = intent.getStringExtra("extra");
		// ruleid: MSTG-PLATFORM-2.3
		db.query("SELECT "+data);
        Log.d("LOG", "My data: " + data);
    }
}

