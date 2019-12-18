package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class fifthActivity extends AppCompatActivity {
    private TextView tv_question;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    public int g5=0;
    public int g55=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        init();
    }
    private void init(){
        tv_question=findViewById(R.id.question);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_c=findViewById(R.id.btn_c);
        btn_d=findViewById(R.id.btn_d);

        tv_question.setText("5.落红不是无情物\n  化作__ __更护花");
        btn_a.setText("A.          冬雨");
        btn_b.setText("B.          秋香");
        btn_c.setText("C.          夏花");
        btn_d.setText("D.          春泥");

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g55=intent1.getIntExtra("grade",0);
                g5+=g55;

                Intent intent2=new Intent();
                intent2.setClass(fifthActivity.this,gradeActivity.class);
                intent2.putExtra("grade",g5);
                startActivity(intent2);
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g55=intent1.getIntExtra("grade",0);
                g5+=g55;

                Intent intent2=new Intent();
                intent2.setClass(fifthActivity.this,gradeActivity.class);
                intent2.putExtra("grade",g5);
                startActivity(intent2);
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g55=intent1.getIntExtra("grade",0);
                g5+=g55;

                Intent intent2=new Intent();
                intent2.setClass(fifthActivity.this,gradeActivity.class);
                intent2.putExtra("grade",g5);
                startActivity(intent2);
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g55=intent1.getIntExtra("grade",0);
                g5=10;
                g5+=g55;

                Intent intent2=new Intent();
                intent2.setClass(fifthActivity.this,gradeActivity.class);
                intent2.putExtra("grade",g5);
                startActivity(intent2);
            }
        });
    }
}
