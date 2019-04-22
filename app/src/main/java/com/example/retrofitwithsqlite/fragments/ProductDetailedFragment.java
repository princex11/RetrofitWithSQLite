package com.example.retrofitwithsqlite.fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.relex.circleindicator.CircleIndicator;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.adapter.ImageViewPagerAdapter;
import com.example.retrofitwithsqlite.model.ProductModel;

import java.util.ArrayList;


public class ProductDetailedFragment extends Fragment {

    public static final String ARG_PRODUCTS = "products";
    private ProductModel productModel;
    private ArrayList<ProductModel> productModels;

    private String tags;
    @BindView(R.id.txt_product_id_value)
    TextView txtProductId;
    @BindView(R.id.txt_product_name_value)
    TextView txtProductName;
    @BindView(R.id.txt_description_value)
    TextView txtDescription;
    @BindView(R.id.txt_tags_value)
    TextView txtTags;
    @BindView(R.id.txt_weight_value)
    TextView txtWeight;
    @BindView(R.id.txt_phone_value)
    TextView txtPhone;
    @BindView(R.id.vp_product_detail_fragment)
    ViewPager vpProductDetailFragment;
    @BindView(R.id.vp_circle_indicator)
    CircleIndicator circleIndicator;


    public ProductDetailedFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static ProductDetailedFragment newInstance(ProductModel productModel) {
        ProductDetailedFragment fragment = new ProductDetailedFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_PRODUCTS, productModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            productModel = getArguments().getParcelable(ARG_PRODUCTS);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product_detailed, container, false);
        ButterKnife.bind(this, view);

        txtProductId.setText(productModel.getProductId());
        txtProductName.setText(productModel.getName());
        txtDescription.setText(productModel.getDescription());
        tags = productModel.getTags().get(0) + ", " + productModel.getTags().get(1);
        txtTags.setText(tags);
        txtWeight.setText(productModel.getWeight());
        txtPhone.setText(productModel.getPhone());
        Log.d("Phone: ", "" + txtPhone.getText().toString());

        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(txtPhone.getText().toString());
            }
        });

        ImageViewPagerAdapter imageViewPagerAdapter = new ImageViewPagerAdapter(productModel, getContext());
        vpProductDetailFragment.setAdapter(imageViewPagerAdapter);
        circleIndicator.setViewPager(vpProductDetailFragment);

        return view;

    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
            startActivity(intent);
        }
    }

