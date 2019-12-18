package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class thirdTestActivity extends AppCompatActivity {
    private TextView tv_question;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    public int g3=0;
    public int g33=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_test);
        init();
    }
    private void init(){
        tv_question=findViewById(R.id.question);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_c=findViewById(R.id.btn_c);
        btn_d=findViewById(R.id.btn_d);

        tv_question.setText("3.莫愁前路无__ __\n  天下谁人不识君");
        btn_a.setText("A.          朋友");
        btn_b.setText("B.          手足");
        btn_c.setText("C.          知己");
        btn_d.setText("D.          兄弟");

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g33=intent1.getIntExtra("grade",0);
                g3+=g33;

                Intent intent2=new Intent();
                intent2.setClass(thirdTestActivity.this,fourthActivity.class);
                intent2.putExtra("grade",g3);
                startActivity(intent2);
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g33=intent1.getIntExtra("grade",0);
                g3+=g33;

                Intent intent2=new Intent();
                intent2.setClass(thirdTestActivity.this,fourthActivity.class);
                intent2.putExtra("grade",g3);
                startActivity(intent2);
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g33=intent1.getIntExtra("grade",0);
                g3=10;
                g3+=g33;

                Intent intent2=new Intent();
                intent2.setClass(thirdTestActivity.this,fourthActivity.class);
                intent2.putExtra("grade",g3);
                startActivity(intent2);
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g33=intent1.getIntExtra("grade",0);
                g3+=g33;

                Intent intent2=new Intent();
                intent2.setClass(thirdTestActivity.this,fourthActivity.class);
                intent2.putExtra("grade",g3);
                startActivity(intent2);
            }
        });
    }
}
