package com.example.hasee.cardreviewv3.db;

/**
 * 卡包的实体类
 */
public class CardPackage {
    //卡包的id
    private int id;

    //卡包的userId
    private int userId;

    //卡包的描述
    private String name;

    //卡包的封面url
    private String cover;

    //卡包的卡片数目
    private String cardNum;

    //卡包的类型
    private int type;

    //卡包的createdAt
    private int createdAt;

    //卡包的updatedAt
    private int updatedAt;

    public CardPackage(String name,String cover){
        this.cover = cover;
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getName() {
        return name;
    }

    public String getCover() {
        return cover;
    }

    public int getUserId() {
        return userId;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
