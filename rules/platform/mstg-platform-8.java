import org.codehaus.jackson.test;

public class MainActivity extends AppCompatActivity {

    static final Version VERSION = VersionUtil.parseVersion("2.0.1", "com.fasterxml.jackson.core", "jackson-databind");
    @Override
    public void onCreate(Bundle savedInstanceState) {
        test();
    }
    private void test(){
        x.getSerializable("key_test");
        x.putSerializable("my_pwd", "test");
        x.putSerializable("abc", "test");

        JSONObject root = new JSONObject(json_string);
        String val = root.getString("title");
        String val2 = root.getString("pwd_test");
        String val3 = root.put("title");
    }
    public Version version() {
        return VersionUtil.parseVersion("0.0.1", "com.fasterxml.jackson.core", "jackson-databind");
    }
}
// OrmLite
@DatabaseTable(tableName = "libkeyraries")
public class Library {	
 
    @DatabaseField(generatedId = true)
    private long libraryId;

    @DatabaseField(canBeNull = false)
    private String mypassword;

    @DatabaseField(canBeNull = false)
    private String mykey = "test";

    public Library() {
    }
    
}
// SugarORM
public class Author extends SugarRecord<Author> {
    String fullName;
    int age=3;
    String pwd_test= "ciao";

    public Author(Context context) {
        super(context);
    }

    public Author(Context context, String fullName, int age) {
        super(context);
        this.fullName = fullName;
        this.age = age;
        String key = "abc";
    }
}

// GreenDAO
@Entity(indexes = {
    @Index(value = "text, date DESC", unique = true)
})
public class Note {

    @Id
    private Long id;

    @NotNull
    private String textpwd;
    private String comment;
    private java.util.Date date;
}

public class AppController extends Application {

    public static final boolean ENCRYPTED = true;
    private DaoSession daoSession;

    public void test1() {

        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db"); //The users-db here is the name of our database. 
        Database db = helper.getWritableDb(); 
        daoSession = new DaoMaster(db).newSession();
    }
    public void test2(){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"users-db-encrypted");
        Database db = helper.getEncryptedWritableDb("super-secret");
        daoSession = new DaoMaster(db).newSession();
    }
}


// ActiveAndroid
@Table(name = "Inventory") 
public class Inventory extends Model {
    
    //The table consist only one field name 
    @Column(name = "name_key")
    public String name_key;

}

// Realm
public class Task extends RealmObject {
    @PrimaryKey private String name_key;
    @Required private String status = TaskStatus.Open.name();
    public void setStatus(TaskStatus status) { this.status = status.name(); }
    public String getStatus() { return this.status; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Task(String _name) { this.name = _name; }
    public Task() {}

}

// Parcelable
public class User implements Parcelable {
    private String name;
    private int IV;
  
}

// Serializable
public class Employee implements Serializable {
	private String name_pwd;
	private int id;
	transient private int salary;

}
// Serializable
public class Employee implements Serializable {
	private String name_pwd;
	private int id;
	transient private int salary;
    public void x(){
        Cipher s;
        s.doFinal();
    }
}

