package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class Review1Activity extends AppCompatActivity implements View.OnClickListener,
        CompoundButton.OnCheckedChangeListener {
    private ViewPager mViewPager;
    private CardPagerAdapter mCardAdapter;
    private ShadowTransformer mCardShadowTransformer;
    private CardFragmentPagerAdapter mFragmentCardAdapter;
    private ShadowTransformer mFragmentCardShadowTransformer;
    private boolean mShowingFragments = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review1);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("青玉案·元夕\n\n宋 辛弃疾", "众里寻他千百度\n\n蓦然回首\n\n那人却在\n\n灯火阑珊处"));
        mCardAdapter.addCardItem(new CardItem("鹊桥仙\n\n宋 秦观", "金凤玉露一相逢\n\n便胜却人间无数\n\n两情若是长久时\n\n又岂在朝朝暮暮"));
        mCardAdapter.addCardItem(new CardItem("满江红\n\n宋 岳飞", "三十功名尘与土\n\n八千里路云和月\n\n莫等闲\n\n白了少年头\n\n空悲切"));
        mCardAdapter.addCardItem(new CardItem("一剪梅\n\n宋 李清照", "一种相思\n\n两处闲愁\n\n此情无计可消除\n\n才下眉头\n\n却上心头"));
        mCardAdapter.addCardItem(new CardItem("蝶恋花\n\n宋 晏殊", "昨夜西风凋碧树\n\n独上高楼\n\n望尽天涯路\n\n欲寄彩笺兼尺素\n\n山长水阔知何处"));
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