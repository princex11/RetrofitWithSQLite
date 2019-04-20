package com.example.retrofitwithsqlite.activities;

import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.retrofitwithsqlite.Prefernces.PreferenceHelper;
import com.example.retrofitwithsqlite.internet.APIInterface;
import com.example.retrofitwithsqlite.internet.RetrofitAPIClient;
import com.example.retrofitwithsqlite.R;
import com.example.retrofitwithsqlite.model.LoginToken;

public class LoginActivity extends AppCompatActivity {

    private static String BASE_URL = "https://reqres.in/";

    @BindView(R.id.etx_username)
    EditText etxUserName;
    @BindView(R.id.etx_password)
    EditText etxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public void login(View view) {
        String userName = etxUserName.getText().toString();
        String password = etxPassword.getText().toString();

        APIInterface apiInterface = RetrofitAPIClient.getRetrofit(BASE_URL)
                .create(APIInterface.class);
        Call<LoginToken> call = apiInterface.logInUser(userName, password);
        if (!userName.isEmpty() && !password.isEmpty()) {
            call.enqueue(new Callback<LoginToken>() {
                @Override
                public void onResponse(Call<LoginToken> call, Response<LoginToken> response) {
                    String loginToken = response.body().getToken();
                    PreferenceHelper.getInstance(LoginActivity.this)
                            .setString(PreferenceHelper.KEY_TOKEN, loginToken);
                    Log.d("login status: ", "code: " + response.code() + " token: " + loginToken);
                    Intent intent = new Intent(LoginActivity.this, DashBoardActivity.class);
                    startActivity(intent);
                    finish();
                }

                @Override
                public void onFailure(Call<LoginToken> call, Throwable t) {
                    t.printStackTrace();
                }
            });
        } else if (!userName.isEmpty() && password.isEmpty()) {
            Toast.makeText(this, "Requires Password", Toast.LENGTH_SHORT)
                    .show();
        } else if (userName.isEmpty() && !password.isEmpty()) {
            Toast.makeText(this, "Requires UserName", Toast.LENGTH_SHORT)
                    .show();
        } else {
            Toast.makeText(this, "Requires UserName and Password", Toast.LENGTH_SHORT)
                    .show();
        }
    }
}
