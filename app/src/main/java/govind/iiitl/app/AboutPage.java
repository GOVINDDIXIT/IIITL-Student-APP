package govind.iiitl.app;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class AboutPage extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout fork;
    private LinearLayout GovindGithub;
    private LinearLayout email;
    private LinearLayout sendArticle;
    private LinearLayout website;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("About");
        setContentView(R.layout.activity_about_page);
        fork = findViewById(R.id.Star_on_github);
        GovindGithub = findViewById(R.id.Govind_about);
        email = findViewById(R.id.write_an_email);
        sendArticle=findViewById(R.id.Submit_article);
        website=findViewById(R.id.website);
        fork.setOnClickListener((View.OnClickListener) this::onClick);
        GovindGithub.setOnClickListener((View.OnClickListener) this::onClick);
        email.setOnClickListener((View.OnClickListener) this::onClick);
        sendArticle.setOnClickListener((View.OnClickListener) this::onClick);
        website.setOnClickListener((View.OnClickListener)this::onClick);
        }


    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.Star_on_github:
                openWebPage(getResources().getString(R.string.Star_on_github));
                break;
            case R.id.Govind_about:
                openWebPage(getResources().getString(R.string.Govind_github_link));
                break;
            case R.id.write_an_email:
                sendMail();
                break;
            case R.id.Submit_article:
                sendArticle();
                break;
            case R.id.website:
                 openWebPage(getResources().getString(R.string.Website));
                 break;
            default:
                break;
        }
    }

    private void sendMail() {

        String mailto = "mailto:developer8work@gmail.com";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }

    private void sendArticle() {

        String mailto = "mailto:developer8work@gmail.com?subject=Article Submission";

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse(mailto));
        try {
            startActivity(emailIntent);
        } catch (ActivityNotFoundException e) {
            //TODO: Handle case where no email app is available
        }
    }

    public void openWebPage(String url) {
        Toast.makeText(AboutPage.this, "Wait a while....", Toast.LENGTH_SHORT).show();
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(implicit);
    }
}