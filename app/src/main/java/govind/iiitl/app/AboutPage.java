package govind.iiitl.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;

public class AboutPage extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout fork;
    private LinearLayout developers;
    private LinearLayout email;
    private LinearLayout sendArticle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About");
        setContentView(R.layout.activity_about_page);
        fork = findViewById(R.id.Star_on_github);
        developers = findViewById(R.id.developers);
        email = findViewById(R.id.write_an_email);
        sendArticle = findViewById(R.id.Submit_article);
        fork.setOnClickListener(this);
        developers.setOnClickListener(this);
        email.setOnClickListener(this);
        sendArticle.setOnClickListener(this);
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
            case R.id.write_an_email:
                sendMail();
                break;
            case R.id.Submit_article:
                sendArticle();
                break;
            default:
                break;
        }
    }

    private void sendMail() {
        String mailto = "mailto:dsc@iiitl.ac.in?subject=Feedback Submission";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }

    private void sendArticle() {
        String mailto = "mailto:dsc@iiitl.ac.in?subject=Article submission for Student App";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }

    private void chromeCustomTabs(String url) {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setToolbarColor(Color.parseColor("#000000"));
        CustomTabsIntent intent = builder.build();
        intent.launchUrl(this, Uri.parse(url));
    }
}