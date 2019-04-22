package com.example.retrofitwithsqlite.adapter;

import android.view.ViewGroup;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.fragments.ProductDetailedFragment;
import com.example.retrofitwithsqlite.fragments.ProductWarehouseFragment;
import com.example.retrofitwithsqlite.fragments.ProductWebFragment;
import com.example.retrofitwithsqlite.model.ProductModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ProductFragmentsAdapter extends FragmentStatePagerAdapter {
    private ProductModel productModel;

    public ProductFragmentsAdapter(FragmentManager fm, ProductModel productModel) {
        super(fm);
        this.productModel = productModel;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return ProductDetailedFragment.newInstance(productModel);
            case 1:
                return ProductWarehouseFragment.newInstance(productModel);
            case 2:
                return ProductWebFragment.newInstance(productModel);
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Details";

            case 1:
                return "Warehouse";

            case 2:
                return "WebFragment";
        }
        return super.getPageTitle(position);
    }
}
