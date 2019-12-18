package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class gradeActivity extends AppCompatActivity {
    private TextView tv_grade;
    private Button btn_back;
    public int g4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        init();
    }
    private void init(){
        tv_grade=findViewById(R.id.grade);
        btn_back=findViewById(R.id.back);
        Intent intent=getIntent();
        g4=intent.getIntExtra("grade",0);
        tv_grade.setText(String.valueOf(g4));
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(gradeActivity.this,BottomNavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}
