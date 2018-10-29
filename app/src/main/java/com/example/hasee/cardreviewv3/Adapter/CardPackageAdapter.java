package com.example.hasee.cardreviewv3.Adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hasee.cardreviewv3.R;
import com.example.hasee.cardreviewv3.db.CardPackage;

import java.util.List;

/**
 * 展示用户卡包的适配器
 */
public class CardPackageAdapter extends RecyclerView.Adapter <CardPackageAdapter.ViewHolder>{
    private Context mContext;
    private List<CardPackage> mCardPackageList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View cardView;
        ImageView cardPackageCore;
        TextView cardPackageName;
        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView)itemView;
            cardPackageName = (TextView)itemView.findViewById(R.id.tv_bagshow_name);
            cardPackageCore = (ImageView)itemView.findViewById(R.id.iv_bagshow_image);

        }
    }
    public CardPackageAdapter(List<CardPackage> cardPackageList){
        mCardPackageList = cardPackageList;
    }
    @Override
    public CardPackageAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null){
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.bagshow_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CardPackageAdapter.ViewHolder holder, int position) {
        CardPackage cardPackage = mCardPackageList.get(position);
        holder.cardPackageName.setText(cardPackage.getDescription());
        Glide.with(mContext)
                .load(cardPackage.getCover())
                .into(holder.cardPackageCore);

    }

    @Override
    public int getItemCount() {
        return mCardPackageList.size();
    }
}
