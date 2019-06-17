package govind.iiitl.app.Labels;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import govind.iiitl.app.R;

public class Gymkhana extends AppCompatActivity {
    WebView myWebView;
    String URL ="https://gymkhana.iiita.ac.in/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gymkhana);

        final ProgressBar progressBar = findViewById(R.id.gymkhana_progressbar); // Final so we can access it from the other thread
        progressBar.setVisibility(View.VISIBLE);

// Create a Handler instance on the main thread
        Handler handler = new Handler();

// Create and start a new Thread
        new Thread(new Runnable() {
            public void run() {
                try{
                    Thread.sleep(2000);
                }
                catch (Exception e) { } // Just catch the InterruptedException

                // Now we use the Handler to post back to the main thread
                handler.post(new Runnable() {
                    public void run() {
                        // Set the View's visibility back on the main UI Thread
                        progressBar.setVisibility(View.INVISIBLE);
                    }
                });
            }
        }).start();

        myWebView = (WebView)findViewById(R.id.webviewGymkhana);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView.loadUrl(URL);
        myWebView.setWebViewClient(new WebViewClient());
    }
}
