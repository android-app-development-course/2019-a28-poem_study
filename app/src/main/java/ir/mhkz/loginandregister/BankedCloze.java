package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class BankedCloze extends AppCompatActivity implements View.OnClickListener,
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
        setContentView(R.layout.activity_banked_cloze);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("1.落红不是无情物，化作__ __更护花", "A. 春泥\n\nB. 夏花\n\nC. 秋霜\n\nD.冬雪"));
        mCardAdapter.addCardItem(new CardItem("1.落红不是无情物，化作__ __更护花", "A. 春泥\n\nB. 夏花\n\nC. 秋霜\n\nD.冬雪"));
        mCardAdapter.addCardItem(new CardItem("1.落红不是无情物，化作__ __更护花", "A. 春泥\n\nB. 夏花\n\nC. 秋霜\n\nD.冬雪"));
        mCardAdapter.addCardItem(new CardItem("1.落红不是无情物，化作__ __更护花", "A. 春泥\n\nB. 夏花\n\nC. 秋霜\n\nD.冬雪"));
        mCardAdapter.addCardItem(new CardItem("1.落红不是无情物，化作__ __更护花", "A. 春泥\n\nB. 夏花\n\nC. 秋霜\n\nD.冬雪"));
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