public class MainActivity extends Activity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Context context = getApplicationContext();
      // ruleid: MSTG-CODE-8.4
      Toast.makeText(this, message, Toast.LENGTH_LONG).show();
      // ok: MSTG-CODE-8.4
      Toast.makeText(context, message, Toast.LENGTH_LONG).show();
   }
}
