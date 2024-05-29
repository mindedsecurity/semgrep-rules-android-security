public class MyActivity extends FragmentActivity {
    @Override
    protected void onCreate(Bundle savedInstance) {
                String fragmentName = this.getActivity().getIntent().getDataString();
                // ruleid: MSTG-PLATFORM-2.6
                getFragmentManager().beginTransaction().replace(com.android.internal.R.id.prefs, Fragment.instantiate(this, fragmentName, null)).commit();
                // ok: MSTG-PLATFORM-2.6
                getFragmentManager().beginTransaction().replace(com.android.internal.R.id.prefs, Fragment.instantiate(this, anotherName, null)).commit();
            }
}
