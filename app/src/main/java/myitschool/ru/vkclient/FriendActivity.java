package myitschool.ru.vkclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import myitschool.ru.vkclient.service.VK;
import myitschool.ru.vkclient.service.gson.ResponseWrapper;
import myitschool.ru.vkclient.service.gson.UserItem;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class FriendActivity extends AppCompatActivity {
    VK service;
    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend);

        mTextView = (TextView)findViewById(R.id.textView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(VK.class);

        service.getUser(getIntent().getStringExtra("access_token"), getIntent().getIntExtra("user_id", 0))
                .enqueue(new Callback<ResponseWrapper<List<UserItem>>>() {
                    @Override
                    public void onResponse(Call<ResponseWrapper<List<UserItem>>> call, Response<ResponseWrapper<List<UserItem>>> response) {
                        UserItem user = response.body().getResponse().get(0);
                        mTextView.setText(user.getFirstName() + " " + user.getLastName());
                    }

                    @Override
                    public void onFailure(Call<ResponseWrapper<List<UserItem>>> call, Throwable t) {
                        t.printStackTrace(System.err);
                    }
                });

    }
}
