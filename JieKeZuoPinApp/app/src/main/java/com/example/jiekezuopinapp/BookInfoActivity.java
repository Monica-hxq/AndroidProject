package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jiekezuopinapp.image.SmartImageView;

public class BookInfoActivity extends AppCompatActivity {

    private TextView textViewTitle;
    private TextView textViewdetail;
    //private ImageView imageViewBill;
    private SmartImageView imageViewBill;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
        textViewTitle=findViewById(R.id.textViewTitle);
        textViewdetail=findViewById(R.id.textViewdetail);
        imageViewBill=findViewById(R.id.imageViewBill);

        Intent intent=getIntent();
        BookInfo bookinfo=(BookInfo) intent.getSerializableExtra("bookinfo");
        textViewTitle.setText(bookinfo.getName());
        textViewdetail.setText(bookinfo.getInfo());
        imageViewBill.setImageUrl("http://192.168.31.23:8080/drawable/"+bookinfo.getImg());
    }
}
