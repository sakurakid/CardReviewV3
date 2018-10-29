package com.example.hasee.cardreviewv3.db;

/**
 * 卡包的实体类
 */
public class CardPackage {
    //卡包的描述
    private String description;

    //卡包的封面url
    private String cover;

    //卡包的类型
    private int type;

    //卡包的id
    private int id;

    //卡包的userId
    private int userId;

    //卡包的createdAt
    private int createdAt;

    //卡包的updatedAt
    private int updatedAt;

    public CardPackage(String description,String cover){
        this.cover = cover;
        this.description = description;
    }

    public int getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public int getType() {
        return type;
    }

    public int getUpdatedAt() {
        return updatedAt;
    }

    public int getUserId() {
        return userId;
    }

    public String getCover() {
        return cover;
    }

    public String getDescription() {
        return description;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setCreatedAt(int createdAt) {
        this.createdAt = createdAt;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUpdatedAt(int updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
