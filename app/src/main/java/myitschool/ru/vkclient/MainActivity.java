package myitschool.ru.vkclient;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView)findViewById(R.id.webView);
        mWebView.loadUrl(
                "https://oauth.vk.com/authorize" +
                "?client_id=5410808" +
                "&redirect_uri=https://oauth.vk.com/blank.html" +
                "&display=mobile" +
                "&scope=friends,messages,offline" +
                "&response_type=token" +
                "&v=5.50");
    }
}
