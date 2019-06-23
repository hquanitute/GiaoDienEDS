package com.test.myapplication.objects;

public class resulttest {
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    private String Email;

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    private int Score;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private String img;

    public resulttest(String email, int score, String img) {
        Email = email;
        Score = score;
        this.img = img;
    }
}
