package govind.iiitl.app;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class Extra extends AppCompatActivity {
    Button btnGuide;
    String URL = "https://medium.com/@thelittlewonder/dear-junior-6d78a13048cb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        btnGuide = findViewById(R.id.btnVisit);

        btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                CustomTabsIntent customTabsIntent = builder.build();
                customTabsIntent.launchUrl(getApplicationContext(), Uri.parse(URL));
            }
        });
    }
}
