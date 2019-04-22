package com.example.retrofitwithsqlite.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.retrofitwithsqlite.utils.MyWebViewClient;
import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.model.ProductModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductWebFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductWebFragment extends Fragment {

    private ProductModel productModel;
    public static final String ARG_MAP = "products";
    @BindView(R.id.wv_product_web_fragment)
    WebView wv_product;

    public ProductWebFragment() {
        // Required empty public constructor
    }

       public static ProductWebFragment newInstance(ProductModel productModel) {
        ProductWebFragment fragment = new ProductWebFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_MAP, productModel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
         productModel = getArguments().getParcelable(ARG_MAP);
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_product_web, container, false);
        ButterKnife.bind(this, view);

        wv_product.getSettings().setLoadsImagesAutomatically(true);
        wv_product.getSettings().setJavaScriptEnabled(true);
        wv_product.getSettings().setBuiltInZoomControls(true);
        wv_product.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        wv_product.setWebViewClient(new MyWebViewClient());
        wv_product.loadUrl(productModel.getWeb());
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        wv_product.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if(event.getAction()==KeyEvent.ACTION_DOWN){
                    switch (keyCode){
                        case KeyEvent.KEYCODE_BACK:
                            if(wv_product.canGoBack()){
                                wv_product.goBack();
                            }return true;
                    }
                }
                return false;
            }
        });
    }
}
