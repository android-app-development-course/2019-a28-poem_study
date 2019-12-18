package ir.mhkz.loginandregister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import ir.mhkz.loginandsignup.R;

public class FeedbackActivity extends AppCompatActivity {
    private Button btn_feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        btn_feedback=findViewById(R.id.feedback);
        btn_feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FeedbackActivity.this,BottomNavigationActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
