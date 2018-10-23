package com.example.hasee.cardreviewv3.db;

import org.litepal.crud.DataSupport;

/**
 * 保存登陆后的Token
 */
public class Token extends DataSupport{
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
