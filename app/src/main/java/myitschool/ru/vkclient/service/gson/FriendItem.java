package myitschool.ru.vkclient.service.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sergey on 15/04/16.
 */
public class FriendItem {
    private Integer id;
    @SerializedName("first_name") private String firstName;
    @SerializedName("last_name") private String lastName;

    public FriendItem(Integer id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
