package myitschool.ru.vkclient.service.gson;

import java.util.List;

/**
 * Created by sergey on 15/04/16.
 */
public class FriendsGetResponse {
    Integer count;
    List<FriendItem> items;

    public FriendsGetResponse(Integer count, List<FriendItem> items) {
        this.count = count;
        this.items = items;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<FriendItem> getItems() {
        return items;
    }

    public void setItems(List<FriendItem> items) {
        this.items = items;
    }
}
