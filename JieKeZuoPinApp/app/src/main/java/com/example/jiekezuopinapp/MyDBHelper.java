package com.example.jiekezuopinapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {

    private Context context;
    public MyDBHelper(@Nullable Context context) {
        super(context, "MyUserInfoDB", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE userinfo(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "username VARCHAR(20),password VARCHAR(50) )");//建表

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    //插入注册信息
    public long insert(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", username);
        values.put("password", password);
        long id = db.insert("userinfo", null, values);
        Toast.makeText(context, "插入成功！", Toast.LENGTH_SHORT).show();
        return id;
    }

    public String queryByName(String username)
    {
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.query("userinfo",null,
                "username=?",new String[]{username},null,null,"username");//selection是while子句
        if(cursor.getCount()==0)
        {
            cursor.close();
            db.close();
            return "NULL";
        }
        else
        {
            cursor.moveToFirst();
            String password=cursor.getString(2);
            cursor.close();
            db.close();
            return password;
        }
    }

    //查询注册信息
    public String queryAll() {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("userinfo", null,
                null, null, null, null, "name");
        if (cursor.getCount() == 0) {
            cursor.close();
            db.close();

            return "NULL";
        } else {
            StringBuilder infos = new StringBuilder();
            while (cursor.moveToNext()) {
                infos.append("用户名：" + cursor.getString(1) + " , " + "密码：" + cursor.getString(2) + "\n");
            }
            cursor.close();
            db.close();
            return infos.toString();
        }
    }
}
