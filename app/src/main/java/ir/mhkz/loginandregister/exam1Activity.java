package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class exam1Activity extends AppCompatActivity implements View.OnClickListener,
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
        setContentView(R.layout.activity_exam1);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("1.__ __生残夜\n\n   江春入旧年", "A.          海天\n\nB.          海日\n\nC.          海风\n\nD.          海浪"));
        mCardAdapter.addCardItem(new CardItem("2.乱花渐欲迷人眼\n\n   __ __才能没马蹄", "A.          野草\n\nB.          杂草\n\nC.          浅草\n\nD.          除草"));
        mCardAdapter.addCardItem(new CardItem("3.曲径通幽处\n\n   禅房__ __深", "A.          花木\n\nB.          草木\n\nC.          草本\n\nD.          木本"));
        mCardAdapter.addCardItem(new CardItem("4.我寄愁心与__ __\n\n   随风直到夜郎西", "A.          清风\n\nB.          明月\n\nC.          星辰\n\nD.          月光"));
        mCardAdapter.addCardItem(new CardItem("5.问渠那得清如许\n\n   唯有源头__ __来", "A.          清水\n\nB.          白水\n\nC.          雨水\n\nD.          活水"));
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

