package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //定义组件
    private ImageView imageView;
    private EditText editTextName;
    private EditText editTextPassword;
    private TextView textView_TiShi;
    private Button btn_DengLu;
    private Button btn_ZhuCe;
    private  MyDBHelper myDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化组件
        imageView = findViewById(R.id.imageView);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        textView_TiShi = findViewById(R.id.textView_TiShi);
        btn_DengLu = findViewById(R.id.btn_DengLu);
        btn_ZhuCe = findViewById(R.id.btn_ZhuCe);
        myDBHelper =new MyDBHelper(this);

        readUserInfo();

        //未登录按钮注册单击事件
        btn_DengLu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String password = myDBHelper.queryByName(editTextName.getText().toString());
                if (password.equals(editTextPassword.getText().toString())) {
                    //跳转到主页面
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    intent.putExtra("userName", editTextName.getText().toString());
                    saveUserInfo();
                    startActivityForResult(intent, 1);
                    textView_TiShi.setText("登陆成功！");
                }else {
                    textView_TiShi.setText("请先注册！");
                }
            }
        });

        //未注册按钮添加单击事件
        btn_ZhuCe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(MainActivity.this,ZhuCeActivity.class);
                //startActivityForResult(intent,1);
                startActivity(intent);

            }
        });
    }

    private void saveUserInfo()
    {
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();
        editor.putString("userName",editTextName.getText().toString());
        editor.putString("userPwd",editTextPassword.getText().toString());
        editor.apply();
        Toast.makeText(this,"用户信息保存成功！",Toast.LENGTH_SHORT).show();

    }

    private void readUserInfo()
    {
        SharedPreferences sp=getSharedPreferences("userInfo",MODE_PRIVATE);
        String name=sp.getString("userName","请输入用户名！");
        String pwd=sp.getString("userPwd","");
        editTextName.setText(name);
        editTextPassword.setText(pwd);

    }
}
