package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class Review2Activity extends AppCompatActivity implements View.OnClickListener,
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
        setContentView(R.layout.activity_review2);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("天净沙·秋思\n\n元 马致远", "枯藤老树昏鸦\n\n小桥流水人家\n\n古道西风瘦马\n\n夕阳西下\n\n断肠人在天涯"));
        mCardAdapter.addCardItem(new CardItem("摸鱼儿·雁丘词\n\n元 元好问", "问世间\n\n情为何物\n\n直教生死相许\n\n天南地北双飞客\n\n老翅几回寒暑"));
        mCardAdapter.addCardItem(new CardItem("端正好·碧云天\n\n元 王实甫", "碧云天\n\n黄花地\n\n西风紧\n\n北雁南飞\n\n晓来谁染霜林醉\n\n总是离人泪"));
        mCardAdapter.addCardItem(new CardItem("清江引·春思\n\n元 张可久", "黄莺乱啼门外柳\n\n雨细清明后\n\n能消几日春\n\n又是相思瘦\n\n梨花小窗人病酒"));
        mCardAdapter.addCardItem(new CardItem("双调·春闺怨\n\n元 乔吉", "不系雕鞍门前柳\n\n玉容寂寞见花羞\n\n冷风儿吹雨黄昏后\n\n帘控钩\n\n掩上珠楼\n\n风雨替花愁"));
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