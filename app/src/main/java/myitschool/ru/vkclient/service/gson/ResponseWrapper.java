package myitschool.ru.vkclient.service.gson;

/**
 * Created by sergey on 15/04/16.
 */
public class ResponseWrapper<T> {
    T response;

    public ResponseWrapper(T response) {
        this.response = response;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }
}
