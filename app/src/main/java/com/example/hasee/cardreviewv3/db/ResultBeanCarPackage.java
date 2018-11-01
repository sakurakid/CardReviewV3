package com.example.hasee.cardreviewv3.db;

import java.util.List;

/**
 * 请求用户返回的卡包数据的json解析类
 */
public class ResultBeanCarPackage {
    private int code;
    private List<CardPackage> data;

    public int getCode() {
        return code;
    }

    public List<CardPackage> getData() {
        return data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(List<CardPackage> data) {
        this.data = data;
    }
}
