// ruleid: MSTG-PLATFORM-2.5
public class MyPreferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
	// The default implementation of isValidFragment returns true.
}

public class OtherPreferences extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    // ruleid: MSTG-PLATFORM-2.5
	@Override
    protected boolean isValidFragment(String fragmentName) {
        return true;
    }
}
