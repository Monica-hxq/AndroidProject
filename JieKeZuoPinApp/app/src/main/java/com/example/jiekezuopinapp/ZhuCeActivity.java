package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ZhuCeActivity extends AppCompatActivity {

    private EditText eT_Zhuce_Name;
    private EditText eT_Zhuce_Pwd;
    private Button btn_ZhuCe2;
    private MyDBHelper myDBHelper1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_ce);
        eT_Zhuce_Name = findViewById(R.id.eT_Zhuce_Name);
        eT_Zhuce_Pwd = findViewById(R.id.eT_Zhuce_Pwd);
        btn_ZhuCe2 = findViewById(R.id.btn_ZhuCe2);
        myDBHelper1 = new MyDBHelper(this);

        btn_ZhuCe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myDBHelper1.insert(eT_Zhuce_Name.getText().toString(),eT_Zhuce_Pwd.getText().toString());

            }
        });
    }
}
