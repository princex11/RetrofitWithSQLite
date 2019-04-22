package com.example.retrofitwithsqlite.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.model.ProductModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageViewPagerAdapter extends PagerAdapter {

    private ProductModel productModel;
    private Context context;
    private LayoutInflater inflater;
    @BindView(R.id.img_item)
    ImageView imgItem;

    public ImageViewPagerAdapter(ProductModel productModel, Context context) {
        this.productModel = productModel;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productModel.getImages().size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return object==view;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_image, container, false);
        ButterKnife.bind(this, itemView);
            Glide.with(context)
                    .load(productModel.getImages().get(position))
                    .placeholder(R.drawable.default_image_thumbnail)
                    .into(imgItem);
            container.addView(itemView);
        return itemView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(imgItem);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
