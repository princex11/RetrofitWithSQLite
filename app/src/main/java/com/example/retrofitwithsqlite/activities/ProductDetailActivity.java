package com.example.retrofitwithsqlite.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.PagerTabStrip;
import androidx.viewpager.widget.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.adapter.ProductFragmentsAdapter;
import com.example.retrofitwithsqlite.model.ProductModel;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY = "products";

    @BindView(R.id.vp_product_detail_activity)
    ViewPager vpProductDetail;
    @BindView(R.id.pts_product_detail_activity)
    PagerTabStrip ptsProductDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        ProductModel productModel = intent.getParcelableExtra(BUNDLE_KEY);
        Log.d("product", ""+productModel.getName());

        ProductFragmentsAdapter adapter = new ProductFragmentsAdapter(getSupportFragmentManager(), productModel);
        vpProductDetail.setAdapter(adapter);
    }
}

