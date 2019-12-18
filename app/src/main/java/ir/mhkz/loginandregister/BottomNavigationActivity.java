package ir.mhkz.loginandregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import ir.mhkz.loginandsignup.R;


public class BottomNavigationActivity extends AppCompatActivity {
    public class Data
    {
        public String Poemname;//诗词名称
        public String Dynasty;//朝代
        public String PoetName;//诗人名字
        public String Content;//诗的内容
        public String IsCollection;//是否收藏标记
        public String Blank;//缺空位置
        public String OptionA;//选项A
        public String OptionB;//选项B
        public String OptionC;//选项C
        public String OptionD;//选项D
        public Data(String poemname,String dynasty,String poetname,String content,String iscollection,String blank,String optiona,String optionb,String optionc,String optiond)
        {
            this.Poemname = poemname;
            this.Dynasty = dynasty;
            this.PoetName = poetname;
            this.Content = content;
            this.IsCollection = iscollection;
            this.Blank = blank;
            this.OptionA = optiona;
            this.OptionB = optionb;
            this.OptionC = optionc;
            this.OptionD = optiond;
        }
    }
    public class MySqLiteHelper extends SQLiteOpenHelper {
        public MySqLiteHelper(Context context) {
            super(context, "poem.db", null, 1);
        }
        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE poem(_ID INTEGER PRIMARY KEY AUTOINCREMENT,PoemName NVARCHAR(20),Dynasty NCHAR(1),PoetName NVARCHAR(10),Content NVARCHAR(400),IsCollection NCHAR(1),Blank NVARCHAR(5),OptionA NVARCHAR(5),OptionB NVARCHAR(5),OptionC NVARCHAR(5),OptionD NVARCHAR(5))" );
            String []PoemName = {"天净沙 秋思","赤壁","渔家傲·塞下秋来风景异","春望","早春呈水部张十八员外"};
            String []Dynasty = {"元","唐","宋","唐","唐"};
            String []PoetName = {" 马致远","杜牧","范仲淹","杜甫","韩愈"};
            String []Content = {"枯藤老树昏鸦，小桥流水人家。古道西风瘦马，夕阳西下，断肠人在天涯。"
                    ,"折戟沉沙铁未销，自将磨洗认前朝。东风不与周郎便，铜雀春深锁二乔。",
                    "塞下秋来风景异，衡阳雁去无留意。四面边声连角起。千嶂里，长烟落日孤城闭。浊酒一杯家万里，燕然未勒归无计，羌管悠悠霜满地。人不寐，将军白发征夫泪。",
                    "国破山河在，城春草木深。感时花溅泪，恨别鸟惊心。烽火连三月，家书抵万金。白头搔更短，浑欲不胜簪。",
                    "天街小雨润如酥，草色遥看近却无。最是一年春好处，绝胜烟柳满皇都。"};
            String []IsCollection = {"0","0","0","0","0"};
            String []Blank = {"夕阳西下，____人在天涯。",
                    "____沉沙铁未销，自将磨洗认前朝",
                    "浊酒一杯家万里，燕然____归无计。",
                    "白头搔更短，浑欲不胜__。",
                    "天街小雨润如__，草色遥看近却无。"};
            String []OptionA = {"断肠","折刀","未还","簪","苏"};
            String []OptionB = {"断魂","折箭","未勒","錾","稣"};
            String []OptionC = {"梦断","折戟","未行","毡","粟"};
            String []OptionD = {"肠断","折剑","未归","粘","酥"};
            for(int i=0;i<5;++i)
            {
                Data data = new Data(PoemName[i],Dynasty[i],PoetName[i],Content[i],IsCollection[i],
                        Blank[i],OptionA[i],OptionB[i],OptionC[i],OptionD[i]);
                ContentValues values = new ContentValues();
                values.put("PoemName",data.Poemname);
                values.put("Dynasty",data.Dynasty);
                values.put("PoetName",data.PoetName);
                values.put("Content",data.Content);
                values.put("IsCollection",data.IsCollection);
                values.put("Blank",data.Blank);
                values.put("OptionA",data.OptionA);
                values.put("OptionB",data.OptionB);
                values.put("OptionC",data.OptionC);
                values.put("OptionD",data.OptionD);
                long id = db.insert("poem",null,values);
            }
        }
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            //当数据库升级时调用此方法
        }
    }
    MySqLiteHelper mysqlite;
    BottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        mysqlite = new MySqLiteHelper(this);
        initView();
    }
    public void initView(){
        BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                FragmentTransaction transaction = null;
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new MainFragment());
                        break;
                    case R.id.tab_explode:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new ExplodeFragment());
                        break;
                    case R.id.tab_me:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new MeFragment());
                        break;
                }
                transaction.commit();
            }
        });
    }
    /*增加一首诗词
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
        SQLiteDatabase db = mysqlite.getWritableDatabase();
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
        db.close();
    }
    /*作用：收藏某首诗词，修改收藏标记
      参数列表：String poemname——修改诗词的诗词名称
                String iscollection——是否收藏的标记，"1"为收藏，"0"为不收藏
    */
    public void Update(String poemname,String iscollection)
    {
        SQLiteDatabase db = mysqlite.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("IsCollection",iscollection);
        int number = db.update("poem",values,"PoemName=?",new String[]{poemname});
        db.close();
    }
    /*作用：根据朝代查询已经收藏的诗词
      参数列表：String dynasty——要查询的朝代
      可修改部分，返回参数可为Cursor类型，将对Cursor数据的操作独立出QueryDynasty函数
    */
    public Cursor QueryDynasty(String Dynasty)
    {
        SQLiteDatabase db = mysqlite.getReadableDatabase();
        Cursor cursor = db.query("poem",null,"Dynasty=? and IsCollection=?",new String[]{Dynasty,"1"},null,null,null);

        //以下为使用代码
        if(cursor==null)//查询为空
        {
            return null;
        }
        while(cursor.moveToNext())//根据列名获取列索引遍历读取列数据
        {
            int poemnameColumnIndex = cursor.getColumnIndex("PoemName");
            String poemname = cursor.getString(poemnameColumnIndex);

            int dynastyColumnIndex = cursor.getColumnIndex("Dynasty");
            String dynasty = cursor.getString(dynastyColumnIndex);

            int poetnameColumnIndex = cursor.getColumnIndex("PoetName");
            String poetname = cursor.getString(poetnameColumnIndex);

            int contentColumnIndex = cursor.getColumnIndex("Content");
            String content = cursor.getString(contentColumnIndex);

            int blankColumnIndex = cursor.getColumnIndex("Blank");
            String blank = cursor.getString(blankColumnIndex);

            int optionaColumnIndex = cursor.getColumnIndex("OptionA");
            String optiona = cursor.getString(optionaColumnIndex);

            int optionbColumnIndex = cursor.getColumnIndex("OptionB");
            String optionb = cursor.getString(optionbColumnIndex);

            int optioncColumnIndex = cursor.getColumnIndex("OptionC");
            String optionc = cursor.getString(optioncColumnIndex);

            int optiondColumnIndex = cursor.getColumnIndex("OptionD");
            String optiond = cursor.getString(optiondColumnIndex);
        }
        //以上为使用代码

        cursor.close();
        db.close();
        return cursor;
    }

    /*作用：根据诗人查询诗词
     参数列表：String dynasty——要查询的诗人名字
     可修改部分，返回参数可为Cursor类型，将对Cursor数据的操作独立出QueryPoetName函数
   */
    public Cursor QueryPoetName(String Poetname)
    {
        SQLiteDatabase db = mysqlite.getReadableDatabase();
        Cursor cursor = db.query("poem",null,"PoetName=?",new String[]{Poetname},null,null,null);


        //以下为使用代码
//        if(cursor == null)//查询为空
//        {
//            return null;
//        }
//        while(cursor.moveToNext())//根据列名获取列索引遍历读取列数据
//        {
//            int poemnameColumnIndex = cursor.getColumnIndex("PoemName");
//            String poemname = cursor.getString(poemnameColumnIndex);
//
//            int dynastyColumnIndex = cursor.getColumnIndex("Dynasty");
//            String dynasty = cursor.getString(dynastyColumnIndex);
//
//            int poetnameColumnIndex = cursor.getColumnIndex("PoetName");
//            String poetname = cursor.getString(poetnameColumnIndex);
//
//            int contentColumnIndex = cursor.getColumnIndex("Content");
//            String content = cursor.getString(contentColumnIndex);
//
//            int blankColumnIndex = cursor.getColumnIndex("Blank");
//            String blank = cursor.getString(blankColumnIndex);
//
//            int optionaColumnIndex = cursor.getColumnIndex("OptionA");
//            String optiona = cursor.getString(optionaColumnIndex);
//
//            int optionbColumnIndex = cursor.getColumnIndex("OptionB");
//            String optionb = cursor.getString(optionbColumnIndex);
//
//            int optioncColumnIndex = cursor.getColumnIndex("OptionC");
//            String optionc = cursor.getString(optioncColumnIndex);
//
//            int optiondColumnIndex = cursor.getColumnIndex("OptionD");
//            String optiond = cursor.getString(optiondColumnIndex);
//        }
        //以上为使用代码
        cursor.close();
        db.close();
        return cursor;
    }
}