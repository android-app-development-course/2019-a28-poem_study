package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class firstTestActivity extends AppCompatActivity {
    private TextView tv_question;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    public int g1=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_test);
        init();
    }
    private void init(){
        tv_question=findViewById(R.id.question);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_c=findViewById(R.id.btn_c);
        btn_d=findViewById(R.id.btn_d);

        tv_question.setText("1.不知细叶谁裁出\n  二月__ __似剪刀");
        btn_a.setText("A.          春风");
        btn_b.setText("B.          春雨");
        btn_c.setText("C.          春眠");
        btn_d.setText("D.          春晚");

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                g1=10;
                Intent intent=new Intent();
                intent.setClass(firstTestActivity.this,secondTestActivity.class);
                intent.putExtra("grade",g1);
                startActivity(intent);
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(firstTestActivity.this,secondTestActivity.class);
                intent.putExtra("grade",g1);
                startActivity(intent);
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(firstTestActivity.this,secondTestActivity.class);
                intent.putExtra("grade",g1);
                startActivity(intent);
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent();
                intent.setClass(firstTestActivity.this,secondTestActivity.class);
                intent.putExtra("grade",g1);
                startActivity(intent);
            }
        });
    }
}
