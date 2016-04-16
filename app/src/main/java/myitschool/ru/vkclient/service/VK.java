package myitschool.ru.vkclient.service;

import myitschool.ru.vkclient.service.gson.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by sergey on 15/04/16.
 */
public interface VK {
    @GET("method/friends.get?v=5.50&order=name&fields=user_name")
    Call<ResponseWrapper<FriendsGetResponse>> getFriends(
            @Query("access_token") String access_token,
            @Query("user_id") Integer user_id);
}
