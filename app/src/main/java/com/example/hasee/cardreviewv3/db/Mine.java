package com.example.hasee.cardreviewv3.db;

import java.util.Date;

/**
 * 用户类 单例模式
 */
public class Mine {
    private Mine instance;
    private String name="";
    private String number="";
    private boolean isLoginIn=false;
    private boolean isVIP=false;
    private Date firstUsedtime=null;
    private Date becomedVIP=null;
    private Date endVIP=null;
    public Mine getInstance(){
        if (instance==null) {
            synchronized (Mine.class) {
                if (instance == null) {
                    instance = new Mine();
                }
            }
        }
        return instance;
    }
    private Mine()
    {
        firstUsedtime=new Date();
    }

    public boolean isLoginIn() {
        return isLoginIn;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public void setLoginIn(boolean loginIn) {
        isLoginIn = loginIn;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getBecomedVIP() {
        return becomedVIP;
    }

    public Date getFirstUsedtime() {
        return firstUsedtime;
    }

    public void setBecomedVIP(Date becomedVIP) {
        this.becomedVIP = becomedVIP;
    }

    public boolean isVIP() {
        return isVIP;
    }

    public void setVIP(boolean VIP) {
        isVIP = VIP;
    }

}
