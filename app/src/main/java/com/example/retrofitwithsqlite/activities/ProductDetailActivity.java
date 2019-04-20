package com.example.retrofitwithsqlite.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.model.ProductModel;

public class ProductDetailActivity extends AppCompatActivity {

    public static final String BUNDLE_KEY = "bundle key";
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        ProductModel productModel = intent.getParcelableExtra(BUNDLE_KEY);
        txtProductId.setText(productModel.getProductId());
        txtProductName.setText(productModel.getName());
        txtDescription.setText(productModel.getDescription());
        tags = productModel.getTags().get(0)+", "+ productModel.getTags().get(1);
        txtTags.setText(tags);
        txtWeight.setText(productModel.getWeight());
        txtPhone.setText(productModel.getPhone());
        Log.d("Phone: ",""+txtPhone.getText().toString());

        txtPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber(txtPhone.getText().toString());
            }
        });

    }
    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}

