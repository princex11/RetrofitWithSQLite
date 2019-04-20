package com.example.retrofitwithsqlite.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.adapter.RecyclerViewAdapter;
import com.example.retrofitwithsqlite.internet.APIInterface;
import com.example.retrofitwithsqlite.internet.RetrofitAPIClient;
import com.example.retrofitwithsqlite.model.ProductModel;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DashBoardActivity extends AppCompatActivity {

    private static String BASE_URL = "https://my-json-server.typicode.com";
    @BindView(R.id.rv_dashboard)
    RecyclerView rvDashboard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind(this);

        APIInterface apiInterface = RetrofitAPIClient.getRetrofit(BASE_URL)
                .create(APIInterface.class);

        Call<ArrayList<ProductModel>> productModelCall = apiInterface.getProductModel();
        productModelCall.enqueue(new Callback<ArrayList<ProductModel>>() {
            @Override
            public void onResponse(Call<ArrayList<ProductModel>> call, Response<ArrayList<ProductModel>> response) {
                ArrayList<ProductModel> productModels = response.body();
                rvDashboard.setLayoutManager(new LinearLayoutManager(DashBoardActivity.this));
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(DashBoardActivity.this, productModels);
                rvDashboard.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<ArrayList<ProductModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });




    }
}
