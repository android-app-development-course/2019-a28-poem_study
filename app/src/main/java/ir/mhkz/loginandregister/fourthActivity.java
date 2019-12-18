package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import ir.mhkz.loginandsignup.R;

public class fourthActivity extends AppCompatActivity {
    private TextView tv_question;
    private Button btn_a;
    private Button btn_b;
    private Button btn_c;
    private Button btn_d;
    public int g4=0;
    public int g44=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        init();
    }
    private void init(){
        tv_question=findViewById(R.id.question);
        btn_a=findViewById(R.id.btn_a);
        btn_b=findViewById(R.id.btn_b);
        btn_c=findViewById(R.id.btn_c);
        btn_d=findViewById(R.id.btn_d);

        tv_question.setText("4.__ __才露尖尖角\n  早有蜻蜓立上头");
        btn_a.setText("A.          荷花");
        btn_b.setText("B.          莲花");
        btn_c.setText("C.          小荷");
        btn_d.setText("D.          小莲");

        btn_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g44=intent1.getIntExtra("grade",0);
                g4+=g44;

                Intent intent2=new Intent();
                intent2.setClass(fourthActivity.this,fifthActivity.class);
                intent2.putExtra("grade",g4);
                startActivity(intent2);
            }
        });

        btn_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g44=intent1.getIntExtra("grade",0);
                g4+=g44;

                Intent intent2=new Intent();
                intent2.setClass(fourthActivity.this,fifthActivity.class);
                intent2.putExtra("grade",g4);
                startActivity(intent2);
            }
        });

        btn_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g44=intent1.getIntExtra("grade",0);
                g4=10;
                g4+=g44;

                Intent intent2=new Intent();
                intent2.setClass(fourthActivity.this,fifthActivity.class);
                intent2.putExtra("grade",g4);
                startActivity(intent2);
            }
        });

        btn_d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=getIntent();
                g44=intent1.getIntExtra("grade",0);
                g4+=g44;

                Intent intent2=new Intent();
                intent2.setClass(fourthActivity.this,fifthActivity.class);
                intent2.putExtra("grade",g4);
                startActivity(intent2);
            }
        });
    }
}
