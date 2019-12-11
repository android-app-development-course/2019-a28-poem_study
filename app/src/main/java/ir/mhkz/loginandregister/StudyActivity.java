package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import ir.mhkz.loginandsignup.R;

public class StudyActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("出塞 王昌龄" ,
                "秦时明月汉时关\n\n万里长征人未还\n\n但使龙城飞将在\n\n不教胡马度阴山",
                R.drawable.chusai);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("夜雨寄北 李商隐" ,
                "君问归期未有期\n\n巴山夜雨涨秋池\n\n何当共剪西窗烛\n\n却话巴山夜雨时",
                R.drawable.yeyujibei);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("江雪 柳宗元" ,
                "千山鸟飞绝\n\n万径人踪灭\n\n孤舟蓑笠翁\n\n独钓寒江雪",
                R.drawable.jiangxue);
        AhoyOnboarderCard ahoyOnboarderCard4 = new AhoyOnboarderCard("登幽州台歌 陈子昂" ,
                "前不见古人\n\n后不见来者\n\n念天地之悠悠\n\n独怆然而涕下",
                R.drawable.dengyouzhoutaige);
        AhoyOnboarderCard ahoyOnboarderCard5 = new AhoyOnboarderCard("离思 元稹" ,
                "曾经沧海难为水\n\n除却巫山不是云\n\n取次花丛懒回顾\n\n半缘修道半缘君",
                R.drawable.lisi);

        ahoyOnboarderCard1.setBackgroundColor(R.color.white);
        ahoyOnboarderCard2.setBackgroundColor(R.color.white);
        ahoyOnboarderCard3.setBackgroundColor(R.color.white);
        ahoyOnboarderCard4.setBackgroundColor(R.color.white);
        ahoyOnboarderCard5.setBackgroundColor(R.color.white);

        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);
        pages.add(ahoyOnboarderCard4);
        pages.add(ahoyOnboarderCard5);


        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.black);
            page.setDescriptionColor(R.color.grey);
        }

        setFinishButtonTitle("完成");
        showNavigationControls(true);

        List<Integer> colorList = new ArrayList<>();

        colorList.add(R.color.solid_one);
        colorList.add(R.color.solid_two);
        colorList.add(R.color.solid_three);
        colorList.add(R.color.solid_four);
        colorList.add(R.color.solid_five);
        setColorBackground(colorList);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent intent=new Intent(StudyActivity.this, BottomNavigationActivity.class);
<<<<<<< HEAD
        finish();
=======
>>>>>>> 15375368d072effab23c61aa0e97bb956470285b
        startActivity(intent);
    }
}
