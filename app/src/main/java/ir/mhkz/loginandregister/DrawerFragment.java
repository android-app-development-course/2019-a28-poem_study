package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ir.mhkz.loginandsignup.R;


public class DrawerFragment extends Fragment implements View.OnClickListener {
    private Button plan_btn;
    private Button save_btn;
    private Button feedback_btn;
    private Button setting_btn;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.drawer,container,false);//将布局文件绑定到Fragment中
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super .onViewCreated(view, savedInstanceState);
        plan_btn =(Button)view.findViewById(R.id.Plan_btn);
        save_btn =(Button)view.findViewById(R.id.Save_btn);
        feedback_btn =(Button)view.findViewById(R.id.FeedBack_btn);
        setting_btn =(Button)view.findViewById(R.id.Setting_btn);
        plan_btn.setOnClickListener(this);
        save_btn.setOnClickListener(this);
        feedback_btn.setOnClickListener(this);
        setting_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Plan_btn:
                Intent intent1 = new Intent(getActivity(),SettingPlanActivity.class);
                startActivity(intent1);
                break;
            case R.id.Save_btn:

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_vp, new ExplodeFragment(), null)
                        .commit();
                break;
            case R.id.FeedBack_btn:
                Intent intent2 = new Intent(getActivity(),FeedbackActivity.class);
                startActivity(intent2);
                break;
            case R.id.Setting_btn:
                Intent intent3 = new Intent(getActivity(),SettingActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
