package com.example.retrofitwithsqlite.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.activities.DashBoardActivity;
import com.example.retrofitwithsqlite.activities.ProductDetailActivity;
import com.example.retrofitwithsqlite.model.ProductModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private ArrayList<ProductModel> productModels;

    public RecyclerViewAdapter(Context context, ArrayList<ProductModel> productModels) {
        this.context = context;
        this.productModels = productModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtProductId.setText(productModels.get(position).getProductId());
        holder.txtProductName.setText(productModels.get(position).getName());

        Glide.with(context)
                .load(productModels.get(position).getImages().get(0))
                .placeholder(R.drawable.default_image_thumbnail)
                .into(holder.imgItem);


        holder.cvItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(context, ProductDetailActivity.class);
                    ProductModel productModel = productModels.get(position);
                    intent.putExtra(ProductDetailActivity.BUNDLE_KEY,productModel);
                    context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return productModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_item)
        ImageView imgItem;
        @BindView(R.id.txt_productId)
        TextView txtProductId;
        @BindView(R.id.txt_productName)
        TextView txtProductName;
        @BindView(R.id.cv_item)
        CardView cvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
