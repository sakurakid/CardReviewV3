package com.example.hasee.cardreviewv3.UtilsClass;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hasee on 2018/4/26.
 */

public class AdPageInfo implements Parcelable {
    public String title;    // 广告标题
    public String picUrl;   // 广告图片url
    public String clickUlr; // 图片点击url
    public int order;       // 顺序

    protected AdPageInfo(Parcel in) {
        title = in.readString();
        picUrl = in.readString();
        clickUlr = in.readString();
        order = in.readInt();
    }

    public static final Creator<AdPageInfo> CREATOR = new Creator<AdPageInfo>() {
        @Override
        public AdPageInfo createFromParcel(Parcel in) {
            return new AdPageInfo(in);
        }

        @Override
        public AdPageInfo[] newArray(int size) {
            return new AdPageInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(picUrl);
        dest.writeString(clickUlr);
        dest.writeInt(order);
    }
}
