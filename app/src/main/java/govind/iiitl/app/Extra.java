package govind.iiitl.app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Extra extends AppCompatActivity {
    Button btnIT, btnECE, btnGuide;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extra);
        btnGuide = findViewById(R.id.btnVisit);

          btnGuide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(Extra.this, Guide.class));

        }
        });
    }
    private void openWebPage(String url) {
        Toast.makeText(Extra.this, "Wait a while....", Toast.LENGTH_SHORT).show();
        Intent implicit = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(implicit);
    }
}
