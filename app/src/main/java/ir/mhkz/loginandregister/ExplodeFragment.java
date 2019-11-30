package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import ir.mhkz.loginandsignup.R;

public class ExplodeFragment extends Fragment implements View.OnClickListener{
    private Button tang_btn;
    private Button song_btn;
    private Button yuan_btn;
    private Button examination_btn;
    private Button banked_cloze_btn;
    private View mView;
    private ViewPager mViewPaper;
    private List<ImageView> images;
    private List<View> dots;
    private int currentItem;
    //记录上一次点的位置
    private int oldPosition = 0;
    //存放图片的id
    private int[] imageIds = new int[]{
            R.drawable.imag1,
            R.drawable.imag2,
            R.drawable.imag3,
            R.drawable.imag4,
    };
    //存放图片的标题
    private String[] titles = new String[]{
            "两个黄鹂鸣翠柳 一行白鹭上青天",
            "千里莺啼绿映红 水村山郭酒旗风",
            "隐隐飞桥隔野炊 石矶西畔问渔船",
            "冰雪林中著此身 不同桃李混芳尘",
    };
    private TextView title;
    private ViewPagerAdapter adapter;
    private ScheduledExecutorService scheduledExecutorService;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.activity_explode_fragment,container,false);
        setView();
        return mView;
    }
    public void setView(){
        mViewPaper = (ViewPager)mView.findViewById(R.id.vp);
        tang_btn = (Button)mView.findViewById(R.id.Tang_btn);
        song_btn = (Button)mView.findViewById(R.id.Song_btn);
        yuan_btn = (Button)mView.findViewById(R.id.Yuan_btn);
        examination_btn = (Button)mView.findViewById(R.id.Examination_btn);
        banked_cloze_btn = (Button)mView.findViewById(R.id.Banked_cloze_btn);
        tang_btn.setOnClickListener(this);
        song_btn.setOnClickListener(this);
        yuan_btn.setOnClickListener(this);
        examination_btn.setOnClickListener(this);
        banked_cloze_btn.setOnClickListener(this);

        //显示的图片
        images = new ArrayList<ImageView>();
        for(int i = 0; i < imageIds.length; i++){
            ImageView imageView = new ImageView(getActivity());
            imageView.setBackgroundResource(imageIds[i]);
            images.add(imageView);
        }
        //显示的小点
        dots = new ArrayList<View>();
        dots.add(mView.findViewById(R.id.dot_0));
        dots.add(mView.findViewById(R.id.dot_1));
        dots.add(mView.findViewById(R.id.dot_2));
        dots.add(mView.findViewById(R.id.dot_3));

        title = (TextView) mView.findViewById(R.id.title);
        title.setText(titles[0]);

        adapter = new ViewPagerAdapter();
        mViewPaper.setAdapter(adapter);

        mViewPaper.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageSelected(int position) {
                title.setText(titles[position]);
                dots.get(position).setBackgroundResource(R.drawable.gray_dot);
                dots.get(oldPosition).setBackgroundResource(R.drawable.white_dot);

                oldPosition = position;
                currentItem = position;
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Tang_btn:
                Intent intent1 = new Intent(getActivity(),ReviewActivity.class);
                startActivity(intent1);
                break;
            case R.id.Song_btn:
                Intent intent2 = new Intent(getActivity(),ReviewActivity.class);
                startActivity(intent2);
                break;
            case R.id.Yuan_btn:
                Intent intent3 = new Intent(getActivity(),ReviewActivity.class);
                startActivity(intent3);
                break;
            case R.id.Examination_btn:
                Intent intent4 = new Intent(getActivity(),ExaminationActivity.class);
                startActivity(intent4);
                break;
            case R.id.Banked_cloze_btn:
                Intent intent5 = new Intent(getActivity(),BankedCloze.class);
                startActivity(intent5);
                break;
        }

    }

    /*定义的适配器*/
    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return images.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(ViewGroup view, int position, Object object) {
            // TODO Auto-generated method stub
//          super.destroyItem(container, position, object);
//          view.removeView(view.getChildAt(position));
//          view.removeViewAt(position);
            view.removeView(images.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup view, int position) {
            // TODO Auto-generated method stub
            view.addView(images.get(position));
            return images.get(position);
        }

    }

    /**
     * 利用线程池定时执行动画轮播
     */
    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        scheduledExecutorService.scheduleWithFixedDelay(
                new ViewPageTask(),
                5,
                5,
                TimeUnit.SECONDS);
    }

    /**
     * 图片轮播任务
     * @author liuyazhuang
     *
     */
    private class ViewPageTask implements Runnable{

        @Override
        public void run() {
            currentItem = (currentItem + 1) % imageIds.length;
            mHandler.sendEmptyMessage(0);
        }
    }

    /**
     * 接收子线程传递过来的数据
     */
    private Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            mViewPaper.setCurrentItem(currentItem);
        };
    };

    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        super.onStop();
        if (scheduledExecutorService != null) {
            scheduledExecutorService.shutdown();
            scheduledExecutorService = null;
        }
    }
}
