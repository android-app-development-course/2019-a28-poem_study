package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class ExaminationActivity extends AppCompatActivity implements View.OnClickListener,
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
        setContentView(R.layout.activity_examination);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("1.小时不识月\n\n   呼作白__ __", "A.          玉环\n\nB.          玉盘\n\nC.          玉屏\n\nD.          浴帘"));
        mCardAdapter.addCardItem(new CardItem("2.谁知盘中餐\n\n   __ __皆辛苦", "A.          颗颗\n\nB.          点点\n\nC.          粒粒\n\nD.          滴滴"));
        mCardAdapter.addCardItem(new CardItem("3.白毛浮绿水\n\n   红掌拨__ __", "A.          涟漪\n\nB.          清波\n\nC.          波纹\n\nD.          水花"));
        mCardAdapter.addCardItem(new CardItem("4.__ __潭水深千尺\n\n   不及汪伦送我情", "A.          梅花\n\nB.          桃花\n\nC.          杏花\n\nD.          兰花"));
        mCardAdapter.addCardItem(new CardItem("5.停车坐爱枫林晚\n\n   霜叶红于__ __花", "A.          一月\n\nB.          二月\n\nC.          三月\n\nD.          四月"));
        mFragmentCardAdapter = new CardFragmentPagerAdapter(getSupportFragmentManager(),
                dpToPixels(2, this));
        mCardShadowTransformer = new ShadowTransformer(mViewPager, mCardAdapter);
        mFragmentCardShadowTransformer = new ShadowTransformer(mViewPager, mFragmentCardAdapter);
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

