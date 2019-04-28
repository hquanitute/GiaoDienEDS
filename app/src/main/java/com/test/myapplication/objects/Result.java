package com.test.myapplication.objects;

public class Result {
    int idResult;
    int idUser;
    int idTopic;
    int point;

    public Result() {
    }

    public Result(int idResult, int idUser, int idTopic, int point) {
        this.idResult = idResult;
        this.idUser = idUser;
        this.idTopic = idTopic;
        this.point = point;
    }

    public int getIdResult() {
        return idResult;
    }

    public void setIdResult(int idResult) {
        this.idResult = idResult;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
