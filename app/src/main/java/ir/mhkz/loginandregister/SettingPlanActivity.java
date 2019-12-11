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
    private String str1,str2,str3,str4;

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
        typespinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                str1=item;
            }
        });
        MaterialSpinner sumspinner = findViewById(R.id.SumSpinner);
        sumspinner.setItems("30", "60", "90");
        sumspinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                str4=item;
            }
        });
        MaterialSpinner dayspinner = findViewById(R.id.DaySpinner);
        dayspinner.setItems("15", "30", "60");
        dayspinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                str2=item;
            }
        });
        MaterialSpinner numberspinner = findViewById(R.id.NumberSpinner);
        numberspinner.setItems("5", "10", "20");
        numberspinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override
            public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                str3=item;
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(SettingPlanActivity.this, BottomNavigationActivity.class);
                intent.putExtra("type", str1);
                intent.putExtra("day", str2);
                intent.putExtra("number", str3);
                intent.putExtra("sum", str4);
                startActivity(intent);
                finish();
            }
        });
    }
}
