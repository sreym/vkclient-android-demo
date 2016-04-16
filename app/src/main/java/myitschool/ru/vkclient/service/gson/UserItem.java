package myitschool.ru.vkclient.service.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sergey on 16/04/16.
 */
public class UserItem {
    Integer id;
    @SerializedName("first_name") String firstName;
    @SerializedName("last_name") String lastName;
    @SerializedName("photo_400_orig") String photoOrig400;

    public UserItem(Integer id, String firstName, String lastName, String photoOrig400) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photoOrig400 = photoOrig400;
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

    public String getPhotoOrig400() {
        return photoOrig400;
    }

    public void setPhotoOrig400(String photoOrig400) {
        this.photoOrig400 = photoOrig400;
    }
}
