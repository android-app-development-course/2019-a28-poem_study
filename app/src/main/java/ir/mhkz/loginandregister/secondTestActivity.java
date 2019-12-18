package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class secondTestActivity extends AppCompatActivity {
    private TextView tv_question;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    public int g2=0;
    public int g22=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_test);
        init();
    }
    private void init(){
        tv_question=findViewById(R.id.question);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_c=findViewById(R.id.btn_c);
        btn_d=findViewById(R.id.btn_d);

        tv_question.setText("2.庄生晓梦迷蝴蝶\n  望帝__ __托杜鹃");
        btn_a.setText("A.          花心");
        btn_b.setText("B.          春心");
        btn_c.setText("C.          芳心");
        btn_d.setText("D.          归心");

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g22=intent1.getIntExtra("grade",0);
                g2+=g22;

                Intent intent2=new Intent();
                intent2.setClass(secondTestActivity.this,thirdTestActivity.class);
                intent2.putExtra("grade",g2);
                startActivity(intent2);
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g22=intent1.getIntExtra("grade",0);
                g2=10;
                g2+=g22;

                Intent intent2=new Intent();
                intent2.setClass(secondTestActivity.this,thirdTestActivity.class);
                intent2.putExtra("grade",g2);
                startActivity(intent2);
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g22=intent1.getIntExtra("grade",0);
                g2+=g22;

                Intent intent2=new Intent();
                intent2.setClass(secondTestActivity.this,thirdTestActivity.class);
                intent2.putExtra("grade",g2);
                startActivity(intent2);
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g22=intent1.getIntExtra("grade",0);
                g2+=g22;

                Intent intent2=new Intent();
                intent2.setClass(secondTestActivity.this,thirdTestActivity.class);
                intent2.putExtra("grade",g2);
                startActivity(intent2);
            }
        });
    }
}
