package com.example.retrofitwithsqlite.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import butterknife.ButterKnife;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.model.ProductModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductWarehouseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductWarehouseFragment extends Fragment {
    private ProductModel productModel;
    public static final String ARG_WAREHOUSE = "products";

    public ProductWarehouseFragment() {
        // Required empty public constructor
    }

    public static ProductWarehouseFragment newInstance(ProductModel productModel) {
        ProductWarehouseFragment fragment = new ProductWarehouseFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_WAREHOUSE, productModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
           productModel = getArguments().getParcelable(ARG_WAREHOUSE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product_warehouse, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
