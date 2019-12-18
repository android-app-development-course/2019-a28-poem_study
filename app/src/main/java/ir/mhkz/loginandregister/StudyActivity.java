package ir.mhkz.loginandregister;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class StudyActivity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
    DbManager dbManager;
    Cursor cursor;
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private boolean mShowingFragments = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_study);
        dbManager = new DbManager(getApplicationContext());
        dbManager.open();
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        cursor = dbManager.QueryDynasty("唐");
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
////            int blankColumnIndex = cursor.getColumnIndex("Blank");
////            String blank = cursor.getString(blankColumnIndex);
////
////            int optionaColumnIndex = cursor.getColumnIndex("OptionA");
////            String optiona = cursor.getString(optionaColumnIndex);
////
////            int optionbColumnIndex = cursor.getColumnIndex("OptionB");
////            String optionb = cursor.getString(optionbColumnIndex);
////
////            int optioncColumnIndex = cursor.getColumnIndex("OptionC");
////            String optionc = cursor.getString(optioncColumnIndex);
////
////            int optiondColumnIndex = cursor.getColumnIndex("OptionD");
////            String optiond = cursor.getString(optiondColumnIndex);
//
//            mCardAdapter.addCardItem(new CardItem(poemname, content));//+"\n\n"+dynasty+' '+poetname
//        }
        cursor.close();

        //mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("夜雨寄北\n\n唐 李商隐", "君问归期未有期\n\n巴山夜雨涨秋池\n\n何当共剪西窗烛\n\n却话巴山夜雨时"));
        mCardAdapter.addCardItem(new CardItem("声声慢\n\n宋 李清照", "寻寻觅觅\n\n冷冷清清\n\n凄凄惨惨戚戚\n\n乍暖还寒时候\n\n最难将息"));
        mCardAdapter.addCardItem(new CardItem("天净沙·秋思\n\n元 马致远", "枯藤老树昏鸦\n\n小桥流水人家\n\n古道西风瘦马\n\n夕阳西下\n\n断肠人在天涯"));
        mCardAdapter.addCardItem(new CardItem("念奴娇·赤壁怀古\n\n宋 苏轼", "大江东去\n\n浪淘尽\n\n千古风流人物\n\n故垒西边\n\n人道是\n\n三国周郎赤壁"));
        mCardAdapter.addCardItem(new CardItem("静夜思\n\n唐 李白", "床前明月光\n\n疑是地上霜\n\n举头望明月\n\n低头思故乡"));
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));
        mCardShadowTransformer = new ShadowTransformer(mViewPager,mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager,mFragmentCardAdapter);
        mViewPager.setAdapter(mCardAdapter);
        mViewPager.setPageTransformer(false, mCardShadowTransformer);
        mViewPager.setOffscreenPageLimit(3);
    }
    @Override
    public void onClick(View view) {
        if (!mShowingFragments) {
            mViewPager.setAdapter(mFragmentCardAdapter);
            mViewPager.setPageTransformer(false, mFragmentCardShadowTransformer);
        } else {
            mViewPager.setAdapter(mCardAdapter);
            mViewPager.setPageTransformer(false, mCardShadowTransformer);
        }
        mShowingFragments = !mShowingFragments;
    }
    public static float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }
    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        mCardShadowTransformer.enableScaling(b);
        mFragmentCardShadowTransformer.enableScaling(b);
    }

}