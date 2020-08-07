package com.example.jiekezuopinapp;

import java.io.Serializable;

public class BookInfo implements Serializable {
    /**
     * id : 1
     * name : 西游记
     * info : 测试1
     * img : xiyou.jpg
     */

    private int id;
    private String name;
    private String info;
    private String img;

    public BookInfo() {
    }

    public BookInfo(int id, String name, String info, String img) {
        this.id = id;
        this.name = name;
        this.info = info;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
