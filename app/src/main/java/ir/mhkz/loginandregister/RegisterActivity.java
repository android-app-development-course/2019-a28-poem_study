package ir.mhkz.loginandregister;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sdsmdg.tastytoast.TastyToast;

import ir.mhkz.loginandsignup.R;

public class RegisterActivity extends AppCompatActivity {

    Button register;
    EditText et_username,et_password,et_passwordagain;
    String username,password,passwordagain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
    }
    private void initView() {
        register=findViewById(R.id.reg_register);
        et_username=findViewById(R.id.reg_username);
        et_password=findViewById(R.id.reg_password);
        et_passwordagain=findViewById(R.id.reg_comfirmpassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //获取输入在相应控件中的字符串
                getEditString();
                //判断输入框内容
                if(TextUtils.isEmpty(username)){
                    TastyToast.makeText(getApplicationContext(), "请输入用户名", TastyToast.LENGTH_SHORT, TastyToast.WARNING);
                    return;
                }else if(TextUtils.isEmpty(password)){
                    TastyToast.makeText(getApplicationContext(), "请输入密码", TastyToast.LENGTH_SHORT, TastyToast.DEFAULT);
                    return;
                }else if(TextUtils.isEmpty(passwordagain)){
                    TastyToast.makeText(getApplicationContext(), "请再次输入密码", TastyToast.LENGTH_SHORT, TastyToast.INFO);
                    return;
                }else if(!password.equals(passwordagain)){
                    TastyToast.makeText(getApplicationContext(), "两次输入的密码不一致", TastyToast.LENGTH_SHORT, TastyToast.CONFUSING);
                    return;
                    /**
                     *从SharedPreferences中读取输入的用户名，判断SharedPreferences中是否有此用户名
                     */
                }else if(isExistUserName(username)){
                    TastyToast.makeText(getApplicationContext(), "此账户名已经存在", TastyToast.LENGTH_SHORT, TastyToast.ERROR);
                    return;
                }else{
                    TastyToast.makeText(getApplicationContext(), "注册成功", TastyToast.LENGTH_SHORT, TastyToast.SUCCESS);
                    //把账号、密码和账号标识保存到sp里面
                    /**
                     * 保存账号和密码到SharedPreferences中
                     */
                    saveRegisterInfo(username, password);
                    //注册成功后把账号传递到LoginActivity.java中
                    // 返回值到loginActivity显示
                    Intent data = new Intent();
                    data.putExtra("userName", username);
                    setResult(RESULT_OK, data);
                    //RESULT_OK为Activity系统常量，状态码为-1，
                    // 表示此页面下的内容操作成功将data返回到上一页面，如果是用back返回过去的则不存在用setResult传递data值
                    RegisterActivity.this.finish();
                }
            }
        });
    }

    /**
     * 获取控件中的字符串
     */
    private void getEditString(){
        username=et_username.getText().toString().trim();
        password=et_password.getText().toString().trim();
        passwordagain=et_passwordagain.getText().toString().trim();
    }

    /**
     * 从SharedPreferences中读取输入的用户名，判断SharedPreferences中是否有此用户名
     */
    private boolean isExistUserName(String userName){
        boolean has_userName=false;
        //mode_private SharedPreferences sp = getSharedPreferences( );
        // "loginInfo", MODE_PRIVATE
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取密码
        String spPsw=sp.getString(userName, "");//传入用户名获取密码
        //如果密码不为空则确实保存过这个用户名
        if(!TextUtils.isEmpty(spPsw)) {
            has_userName=true;
        }
        return has_userName;
    }

    /**
     * 保存账号和密码到SharedPreferences中SharedPreferences
     */
    private void saveRegisterInfo(String userName,String psw){
        String md5Psw = MD5Utils.md5(psw);//把密码用MD5加密
        //loginInfo表示文件名, mode_private SharedPreferences sp = getSharedPreferences( );
        SharedPreferences sp=getSharedPreferences("loginInfo", MODE_PRIVATE);
        //获取编辑器， SharedPreferences.Editor  editor -> sp.edit();
        SharedPreferences.Editor editor=sp.edit();
        //以用户名为key，密码为value保存在SharedPreferences中
        //key,value,如键值对，editor.putString(用户名，密码）;
        editor.putString(userName, md5Psw);
        //提交修改 editor.commit();
        editor.commit();
    }
}
