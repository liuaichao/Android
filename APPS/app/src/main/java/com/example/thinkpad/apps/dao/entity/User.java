package com.example.thinkpad.apps.dao.entity;

public class User {
    private String name;
    private String pwd;
    private String tel;
    private String sex;
    private String birth;
    private int headImg;
    private boolean checked;

    public User(String name,String pwd,String tel,String sex,String birth,int headImg) {
        this.name = name;
        this.pwd=pwd;
        this.tel=tel;
        this.sex=sex;
        this.birth=birth;
        this.headImg=headImg;
    }

    public User(){

    }

    public String getName() {
        return name;
    }

    public String gettel() {
        return tel;
    }

    public String getsex() {
        return sex;
    }

    public int getHeadImg() {
        return headImg;
    }

    public String getBirth() {
        return birth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setHeadImg(int headImg) {
        this.headImg = headImg;
    }

   public void setBirth(String birth){
        this.birth=birth;
    
   }
   public boolean isChecked(){
        return checked;
   }
   public void setChecked(boolean checked){
        this.checked=checked;
   }

    public String getPwd() {
        return pwd;
    }
}