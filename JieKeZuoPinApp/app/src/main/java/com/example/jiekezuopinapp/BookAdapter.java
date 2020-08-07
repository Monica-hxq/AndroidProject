package com.example.jiekezuopinapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.jiekezuopinapp.image.SmartImageView;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    private int listItemID;

    public BookAdapter(@NonNull Context context, int resource, @NonNull List<Book> objects) {
        super(context, resource, objects);
        listItemID=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Book book = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(listItemID,null);
        SmartImageView imageView = view.findViewById(R.id.imageView4);
        TextView textView = view.findViewById(R.id.textView3);
        imageView.setImageUrl("http://192.168.31.23:8080/drawable/"+book.getIcon());
        textView.setText(book.getTitle());
        return view;
    }
}
