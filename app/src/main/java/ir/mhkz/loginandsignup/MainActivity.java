package ir.mhkz.loginandsignup;

import android.content.Intent;
import android.os.Bundle;

import com.codemybrainsout.onboarder.AhoyOnboarderActivity;
import com.codemybrainsout.onboarder.AhoyOnboarderCard;

import java.util.ArrayList;
import java.util.List;

import ir.mhkz.loginandregister.LoginActivity;

public class MainActivity extends AhoyOnboarderActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AhoyOnboarderCard ahoyOnboarderCard1 = new AhoyOnboarderCard("诗人说",
                "诗是一瞬临风落泪\n\n对月伤心\n\n倾一尊薄酒\n\n吟一首黯然销魂断魂篇",
                R.drawable.intro1);
        AhoyOnboarderCard ahoyOnboarderCard2 = new AhoyOnboarderCard("乐师说",
                "诗是一刹心如止水\n\n倏然弦惊\n\n挑一丝清弦\n\n奏一曲离合悲欢错杂弹",
                R.drawable.intro2);
        AhoyOnboarderCard ahoyOnboarderCard3 = new AhoyOnboarderCard("画者说" ,
                "诗是一眼万水千山\n\n回眸成卷\n\n云一滴墨染\n\n临一副水墨嫣然点睛乱",
                R.drawable.intro3);
        AhoyOnboarderCard ahoyOnboarderCard4 = new AhoyOnboarderCard("剑客说" ,
                "诗是一世天涯为伴\n\n地炉穹背\n\n挽一朵剑花\n\n斩一段红尘牵绊姻因缘",
                R.drawable.intro4);

        ahoyOnboarderCard1.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard2.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard3.setBackgroundColor(R.color.black_transparent);
        ahoyOnboarderCard4.setBackgroundColor(R.color.black_transparent);

        List<AhoyOnboarderCard> pages = new ArrayList<>();
        pages.add(ahoyOnboarderCard1);
        pages.add(ahoyOnboarderCard2);
        pages.add(ahoyOnboarderCard3);
        pages.add(ahoyOnboarderCard4);

        for (AhoyOnboarderCard page : pages) {
            page.setTitleColor(R.color.white);
            page.setDescriptionColor(R.color.grey_200);
        }

        setFinishButtonTitle("敬启");
        showNavigationControls(true);

        setImageBackground(R.drawable.introbg);

        setInactiveIndicatorColor(R.color.grey_600);
        setActiveIndicatorColor(R.color.white);

        setOnboardPages(pages);
    }

    @Override
    public void onFinishButtonPressed() {
        Intent intent=new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
