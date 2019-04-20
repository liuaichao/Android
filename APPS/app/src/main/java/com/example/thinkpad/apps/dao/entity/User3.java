package com.example.thinkpad.apps.dao.entity;

public class User3 {
    private String namer;
    private String start;
    private String fina;
    private String remark;
    private String time;
    private String state;
    private String tel;
    public User3(String namer, String start, String fina, String remark, String time, String state,String tel) {
        this.namer = namer;
        this.start = start;
        this.fina = fina;
        this.remark = remark;
        this.time = time;
        this.state = state;
        this.tel=tel;
    }
    public User3() {

    }

    public String getStart() {
        return start;
    }

    public String getFina() {
        return fina;
    }

    public String getRemark() {
        return remark;
    }

    public String getTime() {
        return time;
    }

    public String getState() {
        return state;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public void setFina(String fina) {
        this.fina = fina;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setState(String state) {

        this.state = state;
    }

    public void setNamer(String namer) {
        this.namer = namer;
    }

    public String getNamer() {
        return namer;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel){
        this.tel=tel;
    }
}
