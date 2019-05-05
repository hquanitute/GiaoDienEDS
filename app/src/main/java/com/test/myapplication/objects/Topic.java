package com.test.myapplication.objects;

public class Topic {
    int id;
    int diem;
    int loai;
    String name;
    String text;

    public Topic() {
    }

    public Topic(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Topic(int id, int diem, int loai, String name, String text) {
        this.id = id;
        this.diem = diem;
        this.loai = loai;
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }
}
