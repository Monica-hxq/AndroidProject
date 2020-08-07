package com.example.jiekezuopinapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Request;

import java.lang.reflect.Type;
import java.util.List;

public class BookListActivity extends AppCompatActivity {

    private ListView listView;
    private List<Book> bookList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_list);
        listView=findViewById(R.id.listView);
        OkHttpClientManager.getAsyn("http://192.168.31.23:8080/BookServer/BookListServlet", new OkHttpClientManager.ResultCallback<String>() {
            @Override
            public void onError(Request request, Exception e) {
                Log.e("error",e.getMessage());
            }

            @Override
            public void onResponse(String response) {
                Type listType=new TypeToken<List<Book>>(){}.getType();
                Gson gson=new Gson();
                bookList=gson.fromJson(response,listType);
                BookAdapter movieAdapter=new BookAdapter(BookListActivity.this,R.layout.listview_item,bookList);
                listView.setAdapter(movieAdapter);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (bookList!=null){

                    Book book =bookList.get(position);
                    OkHttpClientManager.Param param1=new OkHttpClientManager.Param("id",book.getBookid()+"");
                    OkHttpClientManager.postAsyn("http://192.168.31.23:8080/BookServer/BookInfoServlet", new OkHttpClientManager.ResultCallback<BookInfo>() {
                        @Override
                        public void onError(Request request, Exception e) {
                            Log.e("error",e.getMessage());
                        }

                        @Override
                        public void onResponse(BookInfo response) {
                            Intent intent=new Intent(BookListActivity.this,BookInfoActivity.class);
                            intent.putExtra("bookinfo",response);
                            startActivity(intent);
                        }
                    },param1);

                }
            }
        });
    }
}
