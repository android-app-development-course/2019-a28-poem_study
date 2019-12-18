package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ir.mhkz.loginandsignup.R;

public class SettingActivity extends AppCompatActivity {
    private Button btn_switch;
    private Button btn_exit;
    private Button btn_about;
    private Button btn_join;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        init();
    }
    public void init(){
        btn_switch=findViewById(R.id.Switch);
        btn_exit=findViewById(R.id.exit);
        btn_about=findViewById(R.id.AboutMe_btn);
        btn_join=findViewById(R.id.JoinUs_btn);
        btn_switch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent1);
                finish();
            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent2);
                finish();
            }
        });
        btn_about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2=new Intent(SettingActivity.this,AboutActivity.class);
                startActivity(intent2);
            }
        });
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent3=new Intent(SettingActivity.this,JoinActivity.class);
                startActivity(intent3);
            }
        });
    }
}
