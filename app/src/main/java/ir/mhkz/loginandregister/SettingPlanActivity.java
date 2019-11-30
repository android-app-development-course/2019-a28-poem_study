package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.spark.submitbutton.SubmitButton;

import ir.mhkz.loginandsignup.R;

public class SettingPlanActivity extends AppCompatActivity {
    private SubmitButton btn_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_plan);
        init();
    }
    public void init(){
        btn_sub=findViewById(R.id.submitButton);
        MaterialSpinner typespinner = findViewById(R.id.TypeSpinner);
        typespinner.setItems("小学", "初中", "高中");
        MaterialSpinner dayspinner = findViewById(R.id.DaySpinner);
        dayspinner.setItems("15天", "30天", "60天");
        MaterialSpinner numberspinner = findViewById(R.id.NumberSpinner);
        numberspinner.setItems("5首", "10首", "20首");
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SettingPlanActivity.this,BottomNavigationActivity.class);
                startActivity(intent);
            }
        });
    }
}
