package myitschool.ru.vkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import myitschool.ru.vkclient.service.VK;
import myitschool.ru.vkclient.service.gson.FriendItem;
import myitschool.ru.vkclient.service.gson.FriendsGetResponse;
import myitschool.ru.vkclient.service.gson.ResponseWrapper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FriendsListActivity extends AppCompatActivity {
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        mListView = (ListView)findViewById(R.id.listView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        VK service = retrofit.create(VK.class);

        service.getFriends(getIntent().getStringExtra("access_token"), null).enqueue(new Callback<ResponseWrapper<FriendsGetResponse>>() {
            @Override
            public void onResponse(Call<ResponseWrapper<FriendsGetResponse>> call, Response<ResponseWrapper<FriendsGetResponse>> response) {
                Log.d("VK", "response.count " + response.body().getResponse().getCount());

                mListView.setAdapter(new ArrayAdapter<>(
                        FriendsListActivity.this,
                        android.R.layout.simple_list_item_1,
                        response.body().getResponse().getItems()
                ));
            }

            @Override
            public void onFailure(Call<ResponseWrapper<FriendsGetResponse>> call, Throwable t) {
                t.printStackTrace(System.err);
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FriendItem friend = (FriendItem) parent.getItemAtPosition(position);
                Intent intent = new Intent(FriendsListActivity.this, FriendActivity.class);
                intent.putExtra("access_token", FriendsListActivity.this.getIntent().getStringExtra("access_token"));
                intent.putExtra("user_id", friend.getId());
                FriendsListActivity.this.startActivity(intent);
            }
        });


    }
}
