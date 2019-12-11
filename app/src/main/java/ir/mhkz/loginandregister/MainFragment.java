package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> 15375368d072effab23c61aa0e97bb956470285b

import com.spark.submitbutton.SubmitButton;

import ir.mhkz.loginandsignup.R;

public class MainFragment extends Fragment {
    private View mView;
    private SubmitButton btn_submit;
    private Button btn_plan;
    private DrawerLayout mDrawerLayout = null ;
    private Button Head_btn;
<<<<<<< HEAD
    private TextView tv_type,tv_day,tv_number,tv_sum,tv_number1,tv_number2;
=======
>>>>>>> 15375368d072effab23c61aa0e97bb956470285b
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.activity_main_fragment,container,false);
        setView();
        return mView;
    }
    private void setView(){
        btn_submit=mView.findViewById(R.id.btn_sub);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(),StudyActivity.class);
                startActivity(intent1);
            }
        });
        btn_plan=mView.findViewById(R.id.btn_plan);
        btn_plan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(getActivity(),SettingPlanActivity.class);
                startActivity(intent2);
            }
        });

        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction ft=fragmentManager.beginTransaction();
        DrawerFragment  drawerFragment=new DrawerFragment();
        ft.add(R.id.fragment_layout, drawerFragment, "标签1");//将fragment绑定到已经占有位置的FrameLayout中
        ft.commit();
        mDrawerLayout = (DrawerLayout)mView.findViewById(R.id.drawer_layout);
        Button button = (Button) mView.findViewById(R.id.Head_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 按钮按下，将抽屉打开
                mDrawerLayout.openDrawer(Gravity. LEFT); //从左打开

            }
        });
<<<<<<< HEAD

        tv_type=mView.findViewById(R.id.type);
        tv_day=mView.findViewById(R.id.day);
        tv_number=mView.findViewById(R.id.number);
        tv_sum=mView.findViewById(R.id.textView5);
        tv_number1=mView.findViewById(R.id.textView6);
        tv_number2=mView.findViewById(R.id.textView7);
        Intent intent=getActivity().getIntent();
        String type=intent.getStringExtra("type");
        String day=intent.getStringExtra("day");
        String number=intent.getStringExtra("number");
        String sum=intent.getStringExtra("sum");
        tv_type.setText(type);
        tv_day.setText(day);
        tv_number.setText(number);
        tv_sum.setText(sum);
        tv_number1.setText(number);
        tv_number2.setText(number);
=======
>>>>>>> 15375368d072effab23c61aa0e97bb956470285b
    }
}
