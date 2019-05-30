package govind.iiita.app.Labels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import govind.iiita.app.R;

public class Album extends AppCompatActivity {

    WebView myWebView;
    String URL ="https://www.flickr.com/photos/ams_iiita/sets/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        myWebView = findViewById(R.id.webviewAlbum);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(URL);
        myWebView.setWebViewClient(new WebViewClient());
    }
}
