public class SplashScreen extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        test();
    }
    private void test(){
        //AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(context);
        //appUpdateManager.startUpdateFlowForResult(appUpdateInfo,AppUpdateType.IMMEDIATE,this,MY_REQUEST_CODE);
    }
}

public class SplashScreen extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        test();
    }
    private void test(){
        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(context);
        appUpdateManager.startUpdateFlowForResult(appUpdateInfo,AppUpdateType.IMMEDIATE,this,MY_REQUEST_CODE);
    }
 
}
