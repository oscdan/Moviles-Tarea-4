package com.iteso.test;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.iteso.test.Beans.ItemProduct;

import java.util.ArrayList;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder>{
    private ArrayList<ItemProduct> mDataSet;
    private Context context;

    public AdapterProduct(ArrayList<ItemProduct> mDataSet, Context context) {
        this.mDataSet = mDataSet;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_product, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterProduct.ViewHolder holder, final int position) {
        holder.mProductTitle.setText(mDataSet.get(position).getTitle());
        holder.mProductStore.setText(mDataSet.get(position).getStore());
        holder.mProductLocation.setText(mDataSet.get(position).getLocation());
        holder.mProductPhone.setText(mDataSet.get(position).getPhone());
        switch(mDataSet.get(position).getImage()){
            case 0:
                holder.mProductImage.setImageResource(R.drawable.mac);
                break;
            case 1:
                holder.mProductImage.setImageResource(R.drawable.alienware);
                break;
        }
        Bitmap bitmap = ((BitmapDrawable)holder.mProductThumbnail.getDrawable()).getBitmap();
        holder.mProductThumbnail.setImageBitmap(bitmap);

        holder.mDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, mDataSet.get(position).toString(),
                        Toast.LENGTH_LONG).show();
            }
        });

        holder.mProductPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL,
                        Uri.parse("tel:" + mDataSet.get(position).getPhone()));
                context.startActivity(intent);
            }
        });

        holder.mEventLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItemProduct item = mDataSet.get(position);
                Intent edit = new Intent(context, ActivityEditProduct.class);
                edit.putExtra("PRODUCT", item);
                ((ActivityMain)context).startActivityForResult(edit, 1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button mDetail;
        public TextView mProductTitle;
        public TextView mProductStore;
        public TextView mProductLocation;
        public TextView mProductPhone;
        public ImageView mProductImage;
        public ImageView mProductThumbnail;
        public RelativeLayout mEventLayout;

        public ViewHolder(View v) {
            super(v);
            mEventLayout = v.findViewById(R.id.item_product_layout);
            mDetail = v.findViewById(R.id.item_product_detail);
            mProductTitle = v.findViewById(R.id.item_product_title);
            mProductStore = v.findViewById(R.id.item_product_store);
            mProductLocation = v.findViewById(R.id.item_product_location);
            mProductPhone = v.findViewById(R.id.item_product_phone);
            mProductImage = v.findViewById(R.id.item_product_image);
            mProductThumbnail = v.findViewById(R.id.item_product_thumbnail);
        }
    }
}
