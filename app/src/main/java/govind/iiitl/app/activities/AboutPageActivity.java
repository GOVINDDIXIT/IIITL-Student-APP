package govind.iiitl.app.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

import govind.iiitl.app.R;

public class AboutPageActivity extends AppCompatActivity implements View.OnClickListener {

    String versionName = "1.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);

        LinearLayout fork = findViewById(R.id.Star_on_github);
        LinearLayout developers = findViewById(R.id.developers);
        LinearLayout rateApp = findViewById(R.id.rate_the_app);
        LinearLayout sendMail = findViewById(R.id.send_mail);
        ImageView dsc_about = findViewById(R.id.dsc_about);
        TextView versionTextView = findViewById(R.id.app_version);

        fork.setOnClickListener(this);
        developers.setOnClickListener(this);
        rateApp.setOnClickListener(this);
        dsc_about.setOnClickListener(this);
        sendMail.setOnClickListener(this);

        try {
            versionName = getApplicationContext().getPackageManager()
                    .getPackageInfo(getApplicationContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        versionTextView.setText(versionName);
    }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.Star_on_github:
                chromeCustomTabs(getResources().getString(R.string.Star_on_github));
                break;
            case R.id.developers:
                chromeCustomTabs(getResources().getString(R.string.developers_github_link));
                break;
            case R.id.rate_the_app:
                rateApp();
                break;
            case R.id.dsc_about:
                chromeCustomTabs(getResources().getString(R.string.dsc_website));
                break;
            case R.id.send_mail:
                sendArticle();
                break;
            default:
                break;
        }
    }

    private void sendArticle() {
        String mailto = "mailto:dsc@iiitl.ac.in?subject=Question Paper submission";
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
        }
    }

    private void chromeCustomTabs(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.parseColor("#000000"));
        CustomTabsIntent intent = builder.build();
        intent.launchUrl(this, Uri.parse(url));
    }

    private void rateApp() {
        final String appPackageName = getPackageName();
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
}