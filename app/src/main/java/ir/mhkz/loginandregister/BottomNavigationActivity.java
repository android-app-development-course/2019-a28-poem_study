package ir.mhkz.loginandregister;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ss.bottomnavigation.BottomNavigation;
import com.ss.bottomnavigation.events.OnSelectedItemChangeListener;

import ir.mhkz.loginandsignup.R;

public class BottomNavigationActivity extends AppCompatActivity {

    BottomNavigation bottomNavigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        initView();
    }
    public void initView(){
        BottomNavigation bottomNavigation=(BottomNavigation)findViewById(R.id.bottom_navigation);
        bottomNavigation.setOnSelectedItemChangeListener(new OnSelectedItemChangeListener() {
            @Override
            public void onSelectedItemChanged(int itemId) {
                FragmentTransaction transaction = null;
                switch (itemId){
                    case R.id.tab_home:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new MainFragment());
                        break;
                    case R.id.tab_explode:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new ExplodeFragment());
                        break;
                    case R.id.tab_me:
                        transaction=getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.fragment_vp,new MeFragment());
                        break;
                }
                transaction.commit();
            }
        });
    }
}