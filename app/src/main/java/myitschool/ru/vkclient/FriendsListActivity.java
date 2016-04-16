package myitschool.ru.vkclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import myitschool.ru.vkclient.service.VK;
import myitschool.ru.vkclient.service.gson.FriendsGetResponse;
import myitschool.ru.vkclient.service.gson.ResponseWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendsListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VK service = retrofit.create(VK.class);

        service.getFriends(getIntent().getStringExtra("access_token"), null).enqueue(new Callback<ResponseWrapper<FriendsGetResponse>>() {
            @Override
            public void onResponse(Call<ResponseWrapper<FriendsGetResponse>> call, Response<ResponseWrapper<FriendsGetResponse>> response) {
                Log.d("VK", "response.count " + response.body().getResponse().getCount());
            }

            @Override
            public void onFailure(Call<ResponseWrapper<FriendsGetResponse>> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });


    }
}
