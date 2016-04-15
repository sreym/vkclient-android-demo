package myitschool.ru.vkclient;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                Matcher m = Pattern.compile("access_token=([a-f0-9]+)").matcher(url);
                if (m.find()) {
                    Intent intent = new Intent(MainActivity.this, FriendsListActivity.class);
                    intent.putExtra("access_token", m.group(1));
                    MainActivity.this.startActivity(intent);
                }
            }
        });
    }
}
