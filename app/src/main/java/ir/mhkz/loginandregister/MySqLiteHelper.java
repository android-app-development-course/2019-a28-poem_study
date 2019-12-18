package ir.mhkz.loginandregister;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class Data
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
        db.execSQL("CREATE TABLE poem(_ID INTEGER PRIMARY KEY AUTOINCREMENT,PoemName NVARCHAR(20),Dynasty NCHAR(1),PoetName NVARCHAR(10),Content NVARCHAR(400),IsCollection INTEGER,Blank NVARCHAR(5),OptionA NVARCHAR(5),OptionB NVARCHAR(5),OptionC NVARCHAR(5),OptionD NVARCHAR(5))" );
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