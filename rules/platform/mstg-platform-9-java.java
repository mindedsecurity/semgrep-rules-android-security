import java.io.BufferedWriter;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      test();
   }

   @Override
   public boolean onFilterTouchEventForSecurity(MotionEvent event) {
      if ((event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) == MotionEvent.FLAG_WINDOW_IS_OBSCURED){
         // show error message
         return false;
      }
      return super.onFilterTouchEventForSecurity(event);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // get the root view and activate touch filtering to prevent tap jacking
      View v = findViewById(android.R.id.content);
      v.setFilterTouchesWhenObscured(true);
   }
}


public class Activity extends AppCompatActivity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      test();
   }

   @Override
   public boolean asdf(MotionEvent event) {
      if ((event.getFlags() & MotionEvent.FLAG_WINDOW_IS_OBSCURED) == MotionEvent.FLAG_WINDOW_IS_OBSCURED){
         v.setFilterTouchesWhenObscured(false);
         // show error message
         return false;
      }
      return super.onFilterTouchEventForSecurity(event);
   }
}

