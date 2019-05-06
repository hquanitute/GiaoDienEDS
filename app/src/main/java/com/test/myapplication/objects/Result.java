package com.test.myapplication.objects;

import java.io.Serializable;
import java.util.Calendar;

public class Result implements Serializable {
    String id;
    String textResult;
    String idUser;
    String idEnemy;
    String idTopic;
    double pointUser;
    double pointEnemy;

    public Result() {
    }

    public Result(String id,String idResult, String idUser, String idEnemy, String idTopic, double pointUser, double pointEnemy) {
        this.id=id;
        this.textResult = idResult;
        this.idUser = idUser;
        this.idEnemy = idEnemy;
        this.idTopic = idTopic;
        this.pointUser = pointUser;
        this.pointEnemy = pointEnemy;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextResult() {
        return textResult;
    }

    public void setTextResult(String idResult) {
        this.textResult = idResult;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdEnemy() {
        return idEnemy;
    }

    public void setIdEnemy(String idEnemy) {
        this.idEnemy = idEnemy;
    }

    public String getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(String idTopic) {
        this.idTopic = idTopic;
    }

    public double getPointUser() {
        return pointUser;
    }

    public void setPointUser(double pointUser) {
        this.pointUser = pointUser;
    }

    public double getPointEnemy() {
        return pointEnemy;
    }

    public void setPointEnemy(double pointEnemy) {
        this.pointEnemy = pointEnemy;
    }
}
