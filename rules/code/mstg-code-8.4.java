public class MainActivity extends Activity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      Context context = getApplicationContext();
      // KO
      Toast.makeText(this, message, Toast.LENGTH_LONG).show();
      // OK
      Toast.makeText(context, message, Toast.LENGTH_LONG).show();
   }
}