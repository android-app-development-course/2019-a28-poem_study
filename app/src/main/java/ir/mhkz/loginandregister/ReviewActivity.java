package ir.mhkz.loginandregister;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;

import com.codemybrainsout.onboarder.utils.ShadowTransformer;

import ir.mhkz.loginandsignup.R;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener,
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
        setContentView(R.layout.activity_review);
        mViewPager = (ViewPager) findViewById(R.id.viewPager);

        mCardAdapter = new CardPagerAdapter();
        mCardAdapter.addCardItem(new CardItem("夜雨寄北\n\n唐 李商隐", "君问归期未有期\n\n巴山夜雨涨秋池\n\n何当共剪西窗烛\n\n却话巴山夜雨时"));
        mCardAdapter.addCardItem(new CardItem("送元二使安西\n\n唐 王维", "渭城朝雨悒轻尘\n\n客舍青青柳色新\n\n劝君更进一杯酒\n\n西出阳关无故人"));
        mCardAdapter.addCardItem(new CardItem("绝句\n\n唐 杜甫", "两个黄鹂鸣翠柳\n\n一行白鹭上青天\n\n窗含西岭千秋雪\n\n门泊东吴万里船"));
        mCardAdapter.addCardItem(new CardItem("乌衣巷\n\n唐 刘禹锡", "朱雀桥边野草花\n\n乌衣巷口夕阳斜\n\n旧时王谢堂前燕\n\n飞入寻常百姓家"));
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