package ir.mhkz.loginandregister;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DbManager {
//    public static final String DB_NAME = "poem.db"; //数据库名字
//    public static final String PACKAGE_NAME ="com.example.pc.sqltest";//包名
//    public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/" + PACKAGE_NAME + "/database/" + DB_NAME ;   //数据库的绝对路径( /data/data/com.*.*(package name)/database/poem.db)
    private SQLiteDatabase db;
    private Context context;
    private MySqLiteHelper helper;
    public DbManager(Context context)
    {
        this.context = context.getApplicationContext();
        helper = new MySqLiteHelper(context.getApplicationContext());
        db = helper.getWritableDatabase();
    }
    public void open()//打开数据库，在程序运行之初调用它
    {
        db=helper.getWritableDatabase();
    }

    public void close()//关闭数据库，在程序结束之前调用它
    {
        db.close();
    }

    /*作用：收藏某首诗词，修改收藏标记
         参数列表：String poemname——修改诗词的诗词名称
                   String iscollection——是否收藏的标记，"1"为收藏，"0"为不收藏
    */
    public void Update(String poemname,String iscollection)
    {
        ContentValues values = new ContentValues();
        values.put("IsCollection",iscollection);
        int number = db.update("poem",values,"PoemName=?",new String[]{poemname});
    }/*增加一首诗词
      参数列表：String poemname——新增诗词名称
                String dynasty——新增诗词朝代
                String poetname——新增诗人名字
                String content——新增诗词内容
                String iscollection——是否收藏
                String blank——新增诗词缺空位置
                String optiona——新增诗词选项A
                String optionb——新增诗词选项B
                String optionc——新增诗词选项C
                String optiond——新增诗词选项D
    */
    public void Insert(String poemname,String dynasty,String poetname,String content,String iscollection,String blank,String optiona,String optionb,String optionc,String optiond)
    {
        ContentValues values = new ContentValues();
        values.put("PoemName",poemname);
        values.put("Dynasty",dynasty);
        values.put("PoetName",poetname);
        values.put("Content",content);
        values.put("IsCollection",iscollection);
        values.put("Blank",blank);
        values.put("OptionA",optiona);
        values.put("OptionB",optionb);
        values.put("OptionC",optionc);
        values.put("OptionD",optiond);
        long id = db.insert("poem",null,values);
    }
    /*作用：根据朝代查询已经收藏的诗词
      参数列表：String dynasty——要查询的朝代
      可修改部分，返回参数可为Cursor类型，将对Cursor数据的操作独立出QueryDynasty函数
    */
    public Cursor QueryDynasty(String Dynasty)
    {
        Cursor cursor = db.query("poem",null,"Dynasty=? and IsCollection=?",new String[]{Dynasty,"1"},null,null,null);
        return cursor;
    }

    /*作用：根据诗人查询诗词
     参数列表：String dynasty——要查询的诗人名字
     可修改部分，返回参数可为Cursor类型，将对Cursor数据的操作独立出QueryPoetName函数
   */
    public Cursor QueryPoetName(String Poetname)
    {
        Cursor cursor = db.query("poem",null,"PoetName=?",new String[]{Poetname},null,null,null);
        return cursor;
    }
}
