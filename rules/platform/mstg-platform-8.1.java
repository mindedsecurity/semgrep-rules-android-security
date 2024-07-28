import android.util.Xml;
import com.j256.dao;
import com.j256.*;
import com.j256.ormlite.cipher;

class TestSerializaion {

    public static void main(String[] args) {

        try  {  

            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            // ruleid: MSTG-PLATFORM-8.1
            out.writeObject(object);
             
            out.close();
            file.close();
 
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    public void test1() {

        // todoruleid: MSTG-PLATFORM-8.1
        JSONObject obj = new JSONObject("{\"b\":\"a\"}"); 

    }

    public void test2(Object obj, String jsonStr) {

        // ruleid: MSTG-PLATFORM-8.1
        String test = new Gson().toJson(obj)
        // ruleid: MSTG-PLATFORM-8.1
        SerClass sc = new Gson().fromJson(jsonStr, SerClass.class);

    }

    public void test3() {
        // ruleid: MSTG-PLATFORM-8.1
        ObjectMapper om = new ObjectMapper();
    }

    public void test4() {

        String json = "{\"b\":\"a\"}";

        Moshi moshi = new Moshi.Builder().build();
        // todoruleid: MSTG-PLATFORM-8.1
        JsonAdapter<TestObj> jsonAdapter = moshi.adapter(TestObj.class);

        TestObj testObj = jsonAdapter.fromJson(json);
        System.out.println(testObj);

    }

    // ruleid: MSTG-PLATFORM-8.1
    public class TestClassObjectOutputStream1 extends ObjectOutputStream {

        public void testMethod1() {

            String s = "Test";    

        }        

    }

    // ok: MSTG-PLATFORM-8.1
    public class TestClassObjectOutputStream2 extends ObjectOutputStream {

        public void testMethod1() {

            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            SecretKey secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedMessage = cipher.doFinal(message);

            String s = new String(encryptedMessage);

        }        

    }

    public static String CreateXMLString() {

        // ruleid: MSTG-PLATFORM-8.1
        XmlSerializer xmlSerializer = Xml.newSerializer();
        StringWriter writer = new StringWriter();

        xmlSerializer.setOutput(writer);
        xmlSerializer.endDocument();

        return writer.toString();
    }

    public String testXStream1() {

        XStream xstream = new XStream();        
        // ruleid: MSTG-PLATFORM-8.1
        String xml = xstream.toXML(myObject); // serialize to XML
        return xml;

    }

    public String testXStream2() {

        XStream xstream = new XStream();        
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        SecretKey secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedMessage = cipher.doFinal(message);
        // ok: MSTG-PLATFORM-8.1
        String xml = xstream.toXML(new String(encryptedMessage)); // serialize to XML
        return xml;

    }

    public void testGreenDao1() {
        
        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        // ruleid: MSTG-PLATFORM-8.1
        Database db = ENCRYPTED ? helper.getEncryptedWritableDb("super-secret") : helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public void testGreenDao2() {
        
        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        // ruleid: MSTG-PLATFORM-8.1
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public void testGreenDao3() {
        
        DevOpenHelper helper = new DevOpenHelper(this, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        // ok: MSTG-PLATFORM-8.1
        Database db = helper.getEncryptedWritableDb("super-secret");
        daoSession = new DaoMaster(db).newSession();
    }

    public class TestACtiveAndroid {
        @Override
        public void onCreate() {
            super.onCreate();
            // ruleid: MSTG-PLATFORM-8.1
            ActiveAndroid.initialize(this);
        }
    }

    public void testRealm1() {

        byte[] realmKey = getNewKey();
        // ok: MSTG-PLATFORM-8.1
        final SyncConfiguration realmConfig =
                new SyncConfiguration.Builder(user, PARTITION)
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .encryptionKey(realmKey)
                .build();
        // once we've used the key to generate a config, erase it in memory manually
        Arrays.fill(realmKey, (byte) 0);

    }

    public void testRealm2() {

        // ruleid: MSTG-PLATFORM-8.1
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("alternate-realm")
                .allowQueriesOnUiThread(true)
                .allowWritesOnUiThread(true)
                .compactOnLaunch()
                .build();
        Realm realm = Realm.getInstance(config);
        Log.v("EXAMPLE", "Successfully opened a realm at: " + realm.getPath());
        
    }


}