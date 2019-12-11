package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import ir.mhkz.loginandsignup.R;

public class MeFragment extends Fragment implements View.OnClickListener{
    private View mView;
    private ImageButton primary_btn;
    private ImageButton juniormiddle_btn;
    private ImageButton high_btn;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView=inflater.inflate(R.layout.activity_me_fragment,container,false);
        setView();
        return mView;
    }
    public void setView(){
        primary_btn = mView.findViewById(R.id.Primary_btn);
        juniormiddle_btn = mView.findViewById(R.id.JuniorMiddle_btn);
        high_btn = mView.findViewById(R.id.High_btn);
        primary_btn.setOnClickListener(this);
        juniormiddle_btn.setOnClickListener(this);
        high_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.Primary_btn:
                Intent intent1 = new Intent(getActivity(),ExaminationActivity.class);
                startActivity(intent1);
                break;
            case R.id.JuniorMiddle_btn:
                Intent intent2 = new Intent(getActivity(),ExaminationActivity.class);
                startActivity(intent2);
                break;
            case R.id.High_btn:
                Intent intent3 = new Intent(getActivity(),ExaminationActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
